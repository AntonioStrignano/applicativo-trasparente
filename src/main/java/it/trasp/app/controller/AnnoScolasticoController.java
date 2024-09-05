package it.trasp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/anno-scolastico")
public class AnnoScolasticoController {

	// ----- aggiungi anno scolastico
	// get
	@GetMapping("/new")
	public String newAnno() {
		return "/annoscol/edit";
	}

	// post
	@PostMapping("/create")
	public String createAnno() {
		return "redirect:/anno-scolastico";
	}

	// ----- lista anni scolastici
	@GetMapping("")
	public String readAnno() {
		return "/annoscol/index";
	}

	// ----- modifica anno scolastico
	@GetMapping("/update")
	public String editAnno() {
		return "/annoscol/edit";
	}

	@PostMapping("/update")
	public String updateAnno() {
		return "redirect:/anno-scolastico";
	}

	// ----- elimina anno scolastico
	@PostMapping("/delete")
	public String deleteAnno() {
		return "redirect:/anno-scolastico";
	}

}
