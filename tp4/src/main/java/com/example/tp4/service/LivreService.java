package com.example.tp4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tp4.entity.Auteur;
import com.example.tp4.entity.Livre;
import com.example.tp4.repository.LivreRepository;

@Service
public class LivreService {
@Autowired
private LivreRepository livreRepository;
public List<Livre> getAllLivres() {
return livreRepository.findAll();
}
public Livre saveLivre(Livre livre) {
return livreRepository.save(livre);
}
public void deleteLivre(Long id) {
livreRepository.deleteById(id);
}
public Optional<Livre> getLivreById(Long id) {
return livreRepository.findById(id);
}
public void updateLivre(Livre livre) {
    livreRepository.save(livre);  // This will update the Livre if it already exists
}
}