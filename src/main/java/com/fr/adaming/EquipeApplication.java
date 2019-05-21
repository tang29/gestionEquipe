package com.fr.adaming;

import org.apache.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fr.adaming.entity.Equipe;
import com.fr.adaming.entity.User;
import com.fr.adaming.service.IEquipeService;
import com.fr.adaming.service.IUserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EquipeApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EquipeApplication.class, args);
		
		
	User u = new User(55L, "user1", "user1", "user1", "user1", null);
	User p = new User(5L, "user2", "user2", "user2", "user2", null);
	User c = new User(21L, "user3", "user3", "user3@user3", "user3", null);
		
	context.getBean(IUserService.class).create(u);
	context.getBean(IUserService.class).create(p);
	context.getBean(IUserService.class).create(c);
	
	Equipe team1 = new Equipe(55L, "hard", "team1");
	Equipe team2 = new Equipe(5L, "easy", "team2");
	
	context.getBean(IEquipeService.class).create(team1);
	context.getBean(IEquipeService.class).create(team2);
	
	Logger log = Logger.getLogger(Equipe.class);
	
	log.trace("message log (TRACE)");
	log.debug("message log (DEBUG)");
	log.info("message log (INFO)");
	log.warn("message log (WARN)");
	log.error("message log (ERROR)");
	log.fatal("message log (FATAL)");
	
	}

}
