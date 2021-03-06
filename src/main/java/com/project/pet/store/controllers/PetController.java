package com.project.pet.store.controllers;


import com.project.pet.store.entities.Pet;
import com.project.pet.store.services.PetService;
import com.project.pet.store.utils.PetFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
@AllArgsConstructor
public class PetController {
    private PetService petService;


    @GetMapping("/home")
    public String showHome() {
        return "home_page";
    }


    @GetMapping("/pets")
    public String showAllPets(Model model,
                              @RequestParam(name = "p", defaultValue = "1") Integer pageIndex,
                              @RequestParam Map<String, String> params) {
        PetFilter petFilter = new PetFilter(params);
        Page<Pet> page = petService.findAll(petFilter.getSpec(), pageIndex - 1, 9);
        model.addAttribute("pets", page.getContent());
        return "pets_page";
    }

    @GetMapping("/pet")
    public String showGivePage() {
        return "add_page";
    }


    @GetMapping("pet/remove/{id}")
    public String removePet(@PathVariable Long id) {
        petService.removeById(id);
        return "redirect:/pets";
    }

//    @RequestParam("file") MultipartFile file

    @PostMapping("pet/add")
    public String savePet(
            @RequestParam("type") String type,
            @RequestParam("gender") String gender,
            @RequestParam("name") String name,
            @RequestParam("age") int age,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile image) throws IOException {

        petService.saveOrUpdate(type, gender, name, age, description, image);
        return "redirect:/pets";
    }

    @GetMapping("/help")
    public String showLostPets() {
        return "help_page";
    }

    @GetMapping("/about")
    public String showAboutUs() {
        return "about_page";
    }

    @GetMapping("pet/{id}")
    public String showPet(@PathVariable Long id, Model model, @RequestParam(name = "p", defaultValue = "1") Integer pageIndex,
                          @RequestParam Map<String, String> params) {
        PetFilter petFilter = new PetFilter(params);
        Page<Pet> page = petService.findAll(petFilter.getSpec(), pageIndex - 1, 3);
        model.addAttribute("pet", petService.findById(id));
        model.addAttribute("other_pets",  page.getContent());
        return "pet_page";
    }
}