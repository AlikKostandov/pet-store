package com.project.pet.store.repositories;

import com.project.pet.store.entities.Pet;
import com.project.pet.store.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
