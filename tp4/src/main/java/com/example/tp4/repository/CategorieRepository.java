package com.example.tp4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tp4.entity.Categorie;

public interface
CategorieRepository extends
JpaRepository<Categorie, Long> {
}
