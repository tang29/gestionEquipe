package com.fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.entity.Equipe;
import com.fr.adaming.service.IEquipeService;


@RestController
@RequestMapping(path ="api")
public class EquipeRestController {

	@Autowired
	private IEquipeService service;

	@RequestMapping(path = "/equipe",method = RequestMethod.POST)
	public void create(@RequestBody Equipe equipe) {
		service.create(equipe);
	}
	@RequestMapping(path = "/equipe/{id}",method = RequestMethod.GET)
	public Equipe readById(@PathVariable Long id) {
		Equipe e =service.readById(id);
		return e;
	}
	@RequestMapping(path = "/equipe",method = RequestMethod.GET)
	public List<Equipe> realAll() {
		List<Equipe> list = service.realAll();
		return list;
	}
	@RequestMapping(path = "/equipe",method = RequestMethod.PUT)
	public Equipe update(Equipe equipe) {
	Equipe e =service.update(equipe);
		return e;
	}
	@RequestMapping(path = "/equipe",method = RequestMethod.DELETE)
	public String delete(Long id) {
		service.deleteById(id);
		return "team delete";
	}
	
	
	
}
