package com.sumithra.demo.service;

import com.sumithra.demo.entity.Pastes;
import com.sumithra.demo.exception.PastesException;
import com.sumithra.demo.repository.PastesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PastesService {
   @Autowired
    private PastesRepository pastesRepository;

   public List<Pastes> getAll(){
       return pastesRepository.findAll();
   }

   public Pastes viewById(String id){
       Pastes paste=pastesRepository.findById(id).orElse(null);
       if(paste==null){
          throw new PastesException("pastes does not exist");
       }
       if (paste.getExpiresAt() != null &&
               paste.getExpiresAt().isBefore(LocalDateTime.now())) {
           throw new PastesException("Time expired");
       }

       if(paste.getMaxViews()>=(paste.getViewCount())){
           throw new PastesException("Maximum views reached");
       }
       paste.setViewCount(paste.getViewCount()+1);
       pastesRepository.save(paste);
       return paste;
   }

    public void deletePaste(Pastes paste) {
        pastesRepository.delete(paste);
    }

    public void deleteExpiredOrMaxedPastes() {
        List<Pastes> allPastes = pastesRepository.findAll();
        LocalDateTime now = LocalDateTime.now();

        for (Pastes paste : allPastes) {
            if ((paste.getMaxViews() > 0 && paste.getViewCount() >= paste.getMaxViews()) ||
                    (paste.getExpiresAt() != null && paste.getExpiresAt().isBefore(now))) {
                pastesRepository.delete(paste);
            }
        }
    }
}
