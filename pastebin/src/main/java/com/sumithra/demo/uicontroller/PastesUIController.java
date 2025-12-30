package com.sumithra.demo.uicontroller;


import com.sumithra.demo.entity.Pastes;
import com.sumithra.demo.exception.PastesException;
import com.sumithra.demo.repository.PastesRepository;
import com.sumithra.demo.service.PastesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/api/pastes")
public class PastesUIController {
    @Autowired
    private PastesService pastesService;
    @Autowired
    private PastesRepository pastesRepository;
    @GetMapping("/create")
    public String createForm(Model model) {
        pastesService.deleteExpiredOrMaxedPastes();
        model.addAttribute("pastes", new Pastes());
        model.addAttribute("allPastes",pastesService.getAll());
        return "home";
    }

    @PostMapping("/create")
    public String createPastes(Model model,@ModelAttribute Pastes pastes) {
      if(pastes.getContent()==null || pastes.getContent().isBlank()){
          throw new PastesException("pastes can't be empty");
      }
      if(pastes.getMaxViews()==null || pastes.getMaxViews()<1){
          throw new PastesException("view count must be greater than one");
      }

      pastes.setId(UUID.randomUUID().toString());
      pastes.setViewCount(0);
      pastes.setCreatedAt(LocalDateTime.now());
      pastes.setExpiresAt(LocalDateTime.now().plusHours(1));
        pastesRepository.save(pastes);
      model.addAttribute("pastes",new Pastes());

        model.addAttribute("allPastes",pastesService.getAll());
        return "redirect:/api/pastes/create";
    }

    @GetMapping("/view/{id}")
    public String getById(@PathVariable String id,Model model){
       Pastes paste= pastesService.viewById(id);
       model.addAttribute("paste",paste);
        model.addAttribute("pastes",new Pastes());

        model.addAttribute("allPastes",pastesService.getAll());
        return "view";
    }

}
