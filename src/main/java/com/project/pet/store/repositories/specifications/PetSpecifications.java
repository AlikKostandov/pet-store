package com.project.pet.store.repositories.specifications;

import com.project.pet.store.entities.Pet;
import org.springframework.data.jpa.domain.Specification;

public class PetSpecifications {

    public static Specification<Pet> typeLike(String typePart) {
        return (Specification<Pet>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("type"), String.format("%%%s%%", typePart));
    }
}
