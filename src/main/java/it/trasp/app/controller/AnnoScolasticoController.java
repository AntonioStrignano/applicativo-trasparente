package it.trasp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.trasp.app.model.AnnoScolastico;
import it.trasp.app.repository.AnnoScolasticoRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/anno-scolastico")
public class AnnoScolasticoController {

	@Autowired
	private AnnoScolasticoRepository annoScolRepo;

	// ----- aggiungi anno scolastico

	// post
	@PostMapping("/create")
	public String createAnno(@Valid @ModelAttribute("annoNew") AnnoScolastico annoNew, Model model,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "/annoscol/index";
		}
		annoScolRepo.save(annoNew);
		return "redirect:/anno-scolastico";
	}

	// ----- lista anni scolastici
	@GetMapping("")
	public String readAnno(Model model) {
		model.addAttribute("anni", annoScolRepo.findAll());
		model.addAttribute("annoNew", new AnnoScolastico());

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
