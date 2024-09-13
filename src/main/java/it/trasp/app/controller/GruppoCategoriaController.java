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

import it.trasp.app.model.GruppoCategoria;
import it.trasp.app.repository.GruppoCategoriaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/gruppi-categorie")
public class GruppoCategoriaController {

	@Autowired
	GruppoCategoriaRepository gruppoCatRepo;

	// create
	@PostMapping("/create")
	public String gruppoCreate(@Valid @ModelAttribute("newGruppo") GruppoCategoria newGruppo,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "/gruppi/index";
		} else {

			gruppoCatRepo.save(newGruppo);
			return "redirect:/gruppi-categorie";
		}
	}

	// read
	@GetMapping("")
	public String readGruppi(Model model) {

		List<GruppoCategoria> listaGruppi = gruppoCatRepo.findAll();
		listaGruppi.sort(Comparator.comparing(GruppoCategoria::getPosizione));
		model.addAttribute("listaGruppi", listaGruppi);
		GruppoCategoria newGruppo = new GruppoCategoria();
		newGruppo.setPosizione(gruppoCatRepo.findAll().size() + 1);
		model.addAttribute("newGruppo", newGruppo);
		Integer nGruppi = gruppoCatRepo.findAll().size();
		model.addAttribute("nGruppi", nGruppi);

		return "/gruppi/index";
	}

	// update

	@PostMapping("{id}/update")
	public String gruppoUpdate(Model model, @ModelAttribute("nomeUpdate") String nomeUpdate, @PathVariable ("id") Integer id ,
			BindingResult bindingResult) {

		GruppoCategoria gruppoUpdate = gruppoCatRepo.findById(id).get();
		gruppoUpdate.setNomeGruppo(nomeUpdate);
		
		if (bindingResult.hasErrors()) {
			return "/gruppi/index";
		} else {
			
			gruppoCatRepo.save(gruppoUpdate);

			return "redirect:/gruppi-categoria";
		}
	}

	// up
	@PostMapping("/{id}/up")
	public String gruppoUp(@PathVariable("id") Integer id) {

		GruppoCategoria gruppoMove = gruppoCatRepo.findById(id).get();
		GruppoCategoria gruppoUp = new GruppoCategoria();

		for (GruppoCategoria gruppoFor : gruppoCatRepo.findAll()) {
			if (gruppoFor.getPosizione() == gruppoMove.getPosizione() - 1) {
				gruppoUp = gruppoFor;
				gruppoFor.setPosizione(null);
				gruppoCatRepo.save(gruppoFor);
				gruppoUp.setPosizione(gruppoMove.getPosizione());
				gruppoMove.setPosizione(gruppoMove.getPosizione() - 1);
				break;
			}
		}
		gruppoCatRepo.save(gruppoMove);
		gruppoCatRepo.save(gruppoUp);

		return "redirect:/gruppi-categorie";
	}

	// down
	@PostMapping("/{id}/down")
	public String gruppoDown(@PathVariable("id") Integer id) {
		GruppoCategoria gruppoMove = gruppoCatRepo.findById(id).get();
		GruppoCategoria gruppoDown = new GruppoCategoria();

		for (GruppoCategoria gruppoFor : gruppoCatRepo.findAll()) {
			if (gruppoFor.getPosizione() == gruppoMove.getPosizione() + 1) {
				gruppoDown = gruppoFor;
				gruppoFor.setPosizione(null);
				gruppoCatRepo.save(gruppoFor);
				gruppoDown.setPosizione(gruppoMove.getPosizione());
				gruppoMove.setPosizione(gruppoMove.getPosizione() + 1);
				break;
			}
		}
		gruppoCatRepo.save(gruppoMove);
		gruppoCatRepo.save(gruppoDown);

		return "redirect:/gruppi-categorie";
	}

	// delete

}
