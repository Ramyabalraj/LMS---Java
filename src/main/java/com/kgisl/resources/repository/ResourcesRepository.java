package com.kgisl.resources.repository;

import com.kgisl.resources.entity.Resources;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ResourcesRepository
 */
public interface ResourcesRepository extends JpaRepository<Resources,Long>{
    boolean existsByresName(String name);
}
