package com.fr.adaming.service;

import java.util.List;

import com.fr.adaming.entity.Equipe;


public interface IEquipeService {

	public void create(Equipe equipe); 
	public Equipe readById(Long id); 
	public List<Equipe> realAll();
	public Equipe update(Equipe equipe);
	public String deleteById(Long id);
	
	
}
