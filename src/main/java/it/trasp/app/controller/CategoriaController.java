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

import it.trasp.app.model.Categoria;
import it.trasp.app.model.FormText;
import it.trasp.app.model.GruppoCategoria;
import it.trasp.app.repository.CategoriaRepository;
import it.trasp.app.repository.DocumentoRepository;
import it.trasp.app.repository.GruppoCategoriaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/categorie")
public class CategoriaController {

	@Autowired
	CategoriaRepository cateRepo;

	@Autowired
	GruppoCategoriaRepository gruppoCateRepo;
	
	@Autowired
	DocumentoRepository docRepo;

	// create
	@PostMapping("/create")
	public String categCreate(@Valid @ModelAttribute("newCate") Categoria newCate,
	BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "/categorie/index";
		} else {

			cateRepo.save(newCate);
			return "redirect:/categorie";
		}
	}

	// read
	@GetMapping("")
	public String cateIndex(Model model) {

		List<GruppoCategoria> listaGruppi = gruppoCateRepo.findAll();
		listaGruppi.sort(Comparator.comparing(GruppoCategoria::getPosizione));
		model.addAttribute("listaGruppi", listaGruppi);

		Integer nGruppi = gruppoCateRepo.findAll().size();
		model.addAttribute("nGruppi", nGruppi);
		FormText nomeUpdate = new FormText();
		model.addAttribute("nomeUpdate", nomeUpdate);
		
		Categoria newCate = new Categoria();
		model.addAttribute("newCate", newCate);
		
		List<Categoria> listaCate = cateRepo.findAll();
		model.addAttribute("listaCate", listaCate);
		

		return "/categorie/index";
	}
	
	
	@GetMapping("/{id}")
	public String readCate(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("categoria", cateRepo.findById(id).get());
		model.addAttribute("listaDoc", docRepo.findAll());
		
		return"/categorie/dettaglio";
	}

	// update

	// delete

}
