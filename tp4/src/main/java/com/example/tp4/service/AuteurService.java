package com.example.tp4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tp4.entity.Auteur;
import com.example.tp4.repository.AuteurRepository;

@Service
public class AuteurService {
@Autowired
private AuteurRepository auteurRepository;
public List<Auteur> getAllAuteurs(){
	return auteurRepository.findAll();
}
public Auteur saveAuteur(Auteur auteur) {
	return auteurRepository.save(auteur);
}
public void deleteAuteur(Long id) {
	auteurRepository.deleteById(id);
}
public Optional<Auteur> getAuteurById(Long id) {
return auteurRepository.findById(id);
}
public void updateAuteur(Auteur auteur) {
    auteurRepository.save(auteur);  // This will update the Auteur if it already exists
}
}
