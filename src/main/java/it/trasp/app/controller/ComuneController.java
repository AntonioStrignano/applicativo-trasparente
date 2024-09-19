package it.trasp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import it.trasp.app.model.Comune;
import it.trasp.app.repository.ComuneRepository;
import it.trasp.app.repository.RegioneRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/comuni")
public class ComuneController {

	@Autowired
	ComuneRepository comuneRepo;
	
	@Autowired
	RegioneRepository regioRepo;
	
	@GetMapping("")
	public String comuneIndex(Model model) {
		
		model.addAttribute("listaComuni", comuneRepo.findAll());
		
		Comune nuovoComune = new Comune();
		model.addAttribute("nuovoComune", nuovoComune);
		model.addAttribute("listaRegioni", regioRepo.findAll());
		
		return "/comuni/index";
	}
	
	@PostMapping("/comuni/create")
	public String createComune(@Valid @ModelAttribute("nuovoComune") Comune nuovoComune) {
		
		return "";
	}
	
	
	
}
