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

import com.example.tp4.entity.Categorie;
import com.example.tp4.service.CategorieService;
import com.example.tp4.service.LivreService;

@Controller
@RequestMapping("/categories")
public class CategorieController {
@Autowired
private CategorieService categorieService;
@Autowired
private LivreService livreService;
@GetMapping
public String viewCategoriesPage(Model model) {
model.addAttribute("listCategories", categorieService.getAllCategories());
return "categories";
}
@GetMapping("/new")
public String showNewCategorieForm(Model model) {
Categorie categorie = new Categorie();
model.addAttribute("categorie", categorie);
model.addAttribute("livres", livreService.getAllLivres());
return "new_categorie";
}
@PostMapping("/save")
public String saveCategorie(@ModelAttribute("categorie") Categorie categorie) {
categorieService.saveCategorie(categorie);
return "redirect:/categories";
}
@GetMapping("/edit/{id}")
public String showEditCategorieForm(@PathVariable("id") Long id, Model model) {
Optional<Categorie> categorie = categorieService.getCategorieById(id);
model.addAttribute("categorie", categorie.orElse(new Categorie()));
model.addAttribute("categories", categorieService.getAllCategories());
return "edit_categorie";
}
@PostMapping("/update")
public String updateCategorie(@ModelAttribute("categorie") Categorie categorie) {
    categorieService.updateCategorie(categorie);
    return "redirect:/categories";
}
@GetMapping("/delete/{id}")
public String deleteCategorie(@PathVariable("id") Long id) {
categorieService.deleteCategorie(id);
return "redirect:/categories";
}

}
