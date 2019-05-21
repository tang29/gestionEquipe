package com.fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.entity.User;
import com.fr.adaming.service.IUserService;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(path ="api")
public class UserRestController {

	@Autowired
	private IUserService service;

//cree un dto sa	ns id pour préciser qu'il ne doit jamais avoir de id sans swagger
	@ApiOperation(notes="id must be null", value = "create" ) 
	@RequestMapping(path = "/users",method = RequestMethod.POST) //,consumes = "application/json", produces = "application/json"	
	public String create(@RequestBody User user) {
		service.create(user);
		System.out.println("DEBUG user:" +user);
		return "User create";
	}
	
//	{
//	 "nom": "nom5",
//	 "prenom":"prenom5",
//	"email":"email5",
//	 "pwd":"pwd5",
//	"equipe":{
//	  "id":"1"
//	}}
	
	
	
	@RequestMapping(path = "/users/{id}",method = RequestMethod.GET)
	public User readById(@PathVariable Long id) {
		User u = service.readById(id);
		return u;
	}
	@RequestMapping(path = "/users",method = RequestMethod.GET)
	public List<User> realAll() {
		List<User> list = service.realAll();
		return list;
	}
	@RequestMapping(path = "/users",method = RequestMethod.PUT)
	public void update(User user) {
	service.update(user);
		
	}
	@RequestMapping(path = "/users",method = RequestMethod.DELETE)
	public String deleteById(Long id) {
		service.deleteById(id);
		return "user delete";
	}




}
