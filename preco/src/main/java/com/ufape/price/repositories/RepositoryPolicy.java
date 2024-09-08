package com.ufape.price.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufape.price.models.Policy;

public interface RepositoryPolicy extends JpaRepository<Policy,Long>{
    List<Policy> findByNameContainingIgnoreCase(String name);
    List<Policy> findByDescriptionContainingIgnoreCase(String description);
    List<Policy> findByDiscount(double discount);
}
