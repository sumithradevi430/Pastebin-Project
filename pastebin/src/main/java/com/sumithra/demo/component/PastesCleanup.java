package com.sumithra.demo.component;

import com.sumithra.demo.service.PastesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PastesCleanup {
   @Autowired
   private PastesService pastesService;

    @Scheduled(fixedRate = 60000)
    public void cleanPastes() {
        pastesService.deleteExpiredOrMaxedPastes();
    }
}
