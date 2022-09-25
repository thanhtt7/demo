package com.faropay.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faropay.demo.entity.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findAll();

    Optional<Place> findByName(String name);
}
