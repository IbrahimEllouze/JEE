package com.example.tp4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tp4.entity.Livre;

public interface LivreRepository
extends JpaRepository<Livre,
Long> {
}
