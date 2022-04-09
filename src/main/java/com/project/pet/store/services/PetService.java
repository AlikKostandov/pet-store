package com.project.pet.store.services;

import com.project.pet.store.entities.Pet;
import com.project.pet.store.exceptions.ResourceNotFoundException;
import com.project.pet.store.repositories.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
@AllArgsConstructor
public class PetService {
    PetRepository petRepository;

    public Page<Pet> findAll(Specification<Pet> spec, int page, int size) {
        return petRepository.findAll(spec, PageRequest.of(page, size));
    }


    public void saveOrUpdate(String type, String gender, String name, int age, String description, MultipartFile image) throws IOException {
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        Pet pet = new Pet();
        pet.setType(type);
        pet.setGender(gender);
        pet.setName(name);
        pet.setAge(age);
        pet.setDescription(description);
        if(fileName.contains(".."))
        {
            System.out.println("not a valid file");
        }
        try {
            pet.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        petRepository.save(pet);
    }

    public void removeById(Long id){
        petRepository.deleteById(id);
    }

    public Pet findById(Long id){
        return petRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pet not found!"));
    }


}
