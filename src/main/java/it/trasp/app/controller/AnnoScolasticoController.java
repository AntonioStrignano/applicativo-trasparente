package it.trasp.app.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;
import it.trasp.app.model.AnnoScolastico;
import it.trasp.app.repository.AnnoScolasticoRepository;

@Controller
@RequestMapping("/anno-scolastico")
public class AnnoScolasticoController {

	@Autowired
	private AnnoScolasticoRepository annoScolRepo;

	// ----- aggiungi anno scolastico

	// post
	@PostMapping("/create")
	public String createAnno(@Valid @ModelAttribute("annoNew") AnnoScolastico annoNew,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "/annoscol/index";
		} else {
			annoScolRepo.save(annoNew);
			return "redirect:/anno-scolastico";
		}
	}

	// ----- lista anni scolastici
	@GetMapping("")
	public String readAnno(Model model) {
		List<AnnoScolastico> listaAnni = annoScolRepo.findAll();
		listaAnni.sort(Comparator.comparing(AnnoScolastico::getAnnoScolastico));
		model.addAttribute("listaAnni", listaAnni);
		model.addAttribute("annoNew", new AnnoScolastico());

		return "/annoscol/index";
	}

	// ----- modifica anno scolastico
	@GetMapping("{id}/update")
	public String editAnno(Model model, @PathVariable ("id") Integer id) {
		
		model.addAttribute("anno", annoScolRepo.getReferenceById(id));
		
		return "/annoscol/edit";
	}

	@PostMapping("{id}/update")
	public String updateAnno(@Valid @ModelAttribute("anno") AnnoScolastico anno,  BindingResult bindingResult) {
		
		
		if (bindingResult.hasErrors()) {
			return "/annoscol/edit";
		}
		
		annoScolRepo.save(anno);

		return "redirect:/anno-scolastico";
	}

	// ----- elimina anno scolastico
	@PostMapping("{id}/delete")
	public String deleteAnno(@PathVariable("id") Integer id) {
		
		annoScolRepo.getReferenceById(id).setDocumenti(null);
		annoScolRepo.deleteById(id);
		
		return "redirect:/anno-scolastico";
	}

}
