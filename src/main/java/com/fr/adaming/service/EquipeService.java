package com.fr.adaming.service;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fr.adaming.dao.IEquipeDao;

import com.fr.adaming.entity.Equipe;


@Service
@RequestMapping(path ="api/equipes")
public class EquipeService implements IEquipeService{
	
	@Autowired
	private IEquipeDao dao;
	Logger log = Logger.getLogger(EquipeService.class);
	
	@Override
	public void create(Equipe equipe) {
	
		// TODO Auto-generated method stub
		dao.save(equipe);
	}
	
	
	
	@Override
	public Equipe readById(Long id) {
		// TODO Auto-generated method stub
		
		return dao.findById(id).get();
	}

	@Override
	public List<Equipe> realAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Equipe update(Equipe equipe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(Long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);;
		return "team delete";
	}


	

}
