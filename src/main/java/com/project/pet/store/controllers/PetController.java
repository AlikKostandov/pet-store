package com.project.pet.store.controllers;


import com.project.pet.store.entities.Pet;
import com.project.pet.store.entities.User;
import com.project.pet.store.services.PetService;
import com.project.pet.store.services.UserService;
import com.project.pet.store.utils.PetFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class PetController {
    private PetService petService;


    @GetMapping("/home")
    public String showHome(){
        return "home_page";
    }


    @GetMapping("/pets")
    public String showAllPets(Model model,
                           @RequestParam(name = "p", defaultValue = "1") Integer pageIndex,
                           @RequestParam Map<String, String> params)
    {
        PetFilter petFilter = new PetFilter(params);
        Page<Pet> page = petService.findAll(petFilter.getSpec(), pageIndex - 1, 9);
        model.addAttribute("pets", page.getContent());
        return "pets_page";
    }

    @GetMapping("/pet")
    public String showGivePage(){
        return "add_page";
    }


    @GetMapping("pet/remove/{id}")
    public String removePet(@PathVariable Long id){
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
                           @RequestParam("image") MultipartFile image)throws IOException {

        petService.saveOrUpdate(type, gender, name, age, description, image);
        return "redirect:/pets";
    }
}
