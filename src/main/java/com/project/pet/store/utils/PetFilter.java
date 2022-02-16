package com.project.pet.store.utils;

import com.project.pet.store.entities.Pet;
import com.project.pet.store.repositories.specifications.PetSpecifications;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

@Getter
public class PetFilter {

    private Specification<Pet> spec;
    private String filterParams;

    public PetFilter(Map<String, String> params) {
        spec = Specification.where(null);
        if (params.containsKey("typePart")) {
            spec = spec.and(PetSpecifications.typeLike(params.get("typePart")));
        }

    }
}
