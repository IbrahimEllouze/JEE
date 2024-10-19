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

import com.example.tp4.entity.Livre;
import com.example.tp4.service.AuteurService;
import com.example.tp4.service.CategorieService;
import com.example.tp4.service.LivreService;

@Controller
@RequestMapping("/livres")
public class LivreController {

    @Autowired
    private LivreService livreService;

    @Autowired
    private AuteurService auteurService;

    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public String viewLivresPage(Model model) {
        model.addAttribute("listLivres", livreService.getAllLivres());
        return "livres";
    }

    @GetMapping("/new")
    public String showNewLivreForm(Model model) {
        Livre livre = new Livre();
        model.addAttribute("livre", livre);
        model.addAttribute("auteurs", auteurService.getAllAuteurs());
        model.addAttribute("categories", categorieService.getAllCategories());
        return "new_livre";
    }

    @PostMapping("/save")
    public String saveLivre(@ModelAttribute("livre") Livre livre) {
        livreService.saveLivre(livre);
        return "redirect:/livres";
    }

    @GetMapping("/edit/{id}")
    public String showEditLivreForm(@PathVariable("id") Long id, Model model) {
        Optional<Livre> livre = livreService.getLivreById(id);
        model.addAttribute("livre", livre.orElse(new Livre()));
        model.addAttribute("auteurs", auteurService.getAllAuteurs());
        model.addAttribute("categories", categorieService.getAllCategories());
        return "edit_livre";
    }

    // Add this method to handle the update
    @PostMapping("/update")
    public String updateLivre(@ModelAttribute("livre") Livre livre) {
        livreService.updateLivre(livre);
        return "redirect:/livres";
    }

    @GetMapping("/delete/{id}")
    public String deleteLivre(@PathVariable("id") Long id) {
        livreService.deleteLivre(id);
        return "redirect:/livres";
    }
}
