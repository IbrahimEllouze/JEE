package com.example.tp4.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tp4.entity.Auteur;
import com.example.tp4.service.AuteurService;
import com.example.tp4.service.LivreService;

@Controller
@RequestMapping("/auteurs")
public class AuteurController {
@Autowired
private AuteurService auteurService;
@Autowired
private LivreService livreService;
@GetMapping
public String viewAuteursPage(Model model) {
model.addAttribute("listAuteurs", auteurService.getAllAuteurs());
return "auteurs";
}
@GetMapping("/new")
public String showNewAuteurForm(Model model) {
Auteur auteur = new Auteur();
model.addAttribute("auteur", auteur);
model.addAttribute("livres", livreService.getAllLivres());
return "new_auteur";
}
@PostMapping("/save")
public String saveAuteur(@ModelAttribute("auteur") Auteur auteur) {
auteurService.saveAuteur(auteur);
return "redirect:/auteurs";
}
@GetMapping("/edit/{id}")
public String showEditAuteurForm(@PathVariable("id") Long id, Model model) {
    Optional<Auteur> auteur = auteurService.getAuteurById(id);
    model.addAttribute("auteur", auteur.orElse(new Auteur()));
    model.addAttribute("auteurs", auteurService.getAllAuteurs());
    return "edit_auteur";
}

// Add this method to handle the update
@PostMapping("/update")
public String updateAuteur(@ModelAttribute("auteur") Auteur auteur) {
    auteurService.updateAuteur(auteur);
    return "redirect:/auteurs";
}

@GetMapping("/delete/{id}")
public String deleteAuteur(@PathVariable("id") Long id) {
    auteurService.deleteAuteur(id);
    return "redirect:/auteurs";
}

}
