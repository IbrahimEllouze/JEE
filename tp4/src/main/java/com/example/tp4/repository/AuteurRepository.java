package com.example.tp4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tp4.entity.Auteur;

public interface AuteurRepository
extends JpaRepository<Auteur,
Long> {
}