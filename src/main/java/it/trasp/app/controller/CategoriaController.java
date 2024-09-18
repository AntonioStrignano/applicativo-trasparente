package it.trasp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.trasp.app.model.Categoria;
import it.trasp.app.repository.CategoriaRepository;
import it.trasp.app.repository.GruppoCategoriaRepository;

@Controller
@RequestMapping("/categorie")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository cateRepo;
	
	@Autowired
	GruppoCategoriaRepository gruppoCateRepo;
	
	//create
	@PostMapping("/create")
	public String categCreate (Model model) {
		
		Categoria newCate = new Categoria();
		model.addAttribute("newCate", newCate);
		cateRepo.save(newCate);
		
		return "redirect:/categorie";
	}
	
	
	//read
	@GetMapping("")
	public String cateIndex() {
		
		return "/categorie/index";
	}
	
	//update
	
	
	//delete

}
