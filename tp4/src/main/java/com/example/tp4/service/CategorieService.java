package com.example.tp4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tp4.entity.Categorie;
import com.example.tp4.repository.CategorieRepository;

@Service
public class CategorieService {
@Autowired
private CategorieRepository categorieRepository;
public List<Categorie> getAllCategories(){
	return categorieRepository.findAll();
}
public Categorie saveCategorie(Categorie categorie) {
	return categorieRepository.save(categorie);
}
public void deleteCategorie(Long id) {
	categorieRepository.deleteById(id);
}
public Optional<Categorie> getCategorieById(Long id) {
return categorieRepository.findById(id);
}
public void updateCategorie(Categorie categorie) {
    categorieRepository.save(categorie);  // This will update the Categorie if it already exists
}
}