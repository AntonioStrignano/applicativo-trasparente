package it.trasp.app.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.trasp.app.model.AnnoScolastico;
import it.trasp.app.model.GruppoCategoria;
import it.trasp.app.repository.GruppoCategoriaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/gruppi-categorie")
public class GruppoCategoriaController {

	@Autowired GruppoCategoriaRepository gruppoCatRepo;
	
	//create
	@PostMapping("/create")
	public String gruppoCreate(@Valid @ModelAttribute("newGruppo") GruppoCategoria newGruppo, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "/gruppi/index";
		} else {
			gruppoCatRepo.save(newGruppo);
			return "redirect:/gruppi-categorie";
		}
	}
	
	//read
	@GetMapping("")
	public String readGruppi(Model model) {
		


		List<GruppoCategoria> listaGruppi = gruppoCatRepo.findAll();
		listaGruppi.sort(Comparator.comparing(GruppoCategoria::getPosizione));
		model.addAttribute("listaGruppi", listaGruppi);
		model.addAttribute("newGruppo", new GruppoCategoria());
		
		return"/gruppi/index";
	}
	
	
	//update
	
	
	//delete
	
	
}
