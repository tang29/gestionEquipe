package com.fr.adaming.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertNull;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // pour l'ordre des methodes
public class AuthServiceTests {
	@Autowired
	private IUserService service;

	private static User result;// mettre static

	private List<User> resultlist;

//	@Test // (expected=nullpointerexeception.class) on aura pas de assert et ça sera FAIL
//	public void createUserIdNull() { // methode avec retour User result
//		System.out.println("****************Start first test method************************");
//		User testUser = new User(null, "nom", "prenom", "email@email", "pwd", null);
//		result = service.create(testUser); // String retour dans userservice

	// if(result.equals(""));
	// SUCESS c'est le retour de la methode
//	String[] result2;
//	String[] asssertResult = ();
//	assertArrayEquals(expected)

	// String expected result = "SUCCESS"
//		assertEquals(null, result);
//	assertNotNull(result);
//	assertNull(result.getId()); ICI LE RESULT EST UN retour USER

//	}

	@Test
	public void createUserValid() {
		System.out.println("**************CreateUserValid************");
		result = new User(45L, "nomvalid", "prenom", "email", "pwd", null);
		assertNotNull(service.create(result));
		service.deleteById(4L);
	}

	@Test
	public void createUserIDEqualZero() {
		System.out.println("**********CreateUserid=0**************");
		result = new User(0L, "nomzero", "prenom", "email3@email", "pwd", null);
		result = service.create(result);
		assertNull(result);

	}

	@Test
	public void createUserEmailEqualZero() {
		System.out.println("*********createuseremail=0************");
		result = new User(55L, "nom", "prenom", "0", "pwd", null);
		result = service.create(result);
		assertNotNull(result);
		service.deleteById(1L);
	}

	@Test
	public void createUserEmailNull() {
		System.out.println("**********createuseremailnull***********");
		result = new User(55L, "nom", "prenom", null, "pwd", null);
		result = service.create(result);
		assertNotNull(result);
		service.deleteById(2L);
	}

	@Test
	public void createUserEmailexist() {
		System.out.println("**************createuseremailexist************");
		result = new User(55L, "nom", "prenom", "email3@email", "pwd", null);
		result = service.create(result);
		assertNotNull(result);

	}

	@Test
	public void readByIdNull() {
		System.out.println("*********readbyidnull**************");
		result = new User(null, "nom", "prenom", "email@email", "pwd", null);
		result = service.create(result);
		System.out.println("DEBUG readbyid null : " + result);
		result = service.readById(null);

		assertNotNull(result.getId());

	}
//
//	@Test
//	public void readByIdEqualZero() {
//		User testUser = new User(0L, "nom", "prenom", "email@email", "pwd", null);
//		result = service.create(testUser);
//		result = service.readById(0L);
//		assertNull(result.getId());
//
//	}
//
//	@Test
//	public void readByIdExist() {
//		result = service.readById(120L);
//		assertEquals(null, result.getId());
//
//	}

	@Test
	public void deleteUserExist() { // dans exemple retour boolean avec return dao.deleteById

		System.out.println("***********DeleteUserExist***************");
		User user = new User(60L, "nom1", "prenom", "pwd", "email", null);
		result = service.create(user);
		System.out.println("id delete: " + result.getId());
		boolean resultat = service.deleteById(5L);
		assertTrue(resultat);

	}

	@Test
	public void deleteUserIdNull() { // dans exemple retour boolean avec return dao.deleteById
		System.out.println("*************deletesuseridnull**************");
		result = new User(null, "nom", "prenom", "email", "pwd", null);
		boolean resultat = service.deleteById(null);
		assertFalse(resultat);

	}

//	@Test
//	public void deleteValid() {
//		System.out.println("***********DeleteValid***************");
//		User user = new User(32L, "nom1", "prenom", "pwd", "email8", null);
//		result = service.create(user);
//		System.out.println("id delete: "+result.getId());
//		assertTrue(service.deleteById(result.getId()));
//	}

	@Test
	public void deleteUserNull() {
		System.out.println("***********deleteusernull****************");
		boolean resultat = service.deleteById(null);
		assertNotNull(resultat);

	}

	@Test
	public void updateUserExist() {
		System.out.println("********updateuserexist**********");
		User testUser = new User(3L, "nom5", "prenom5", "5", "pwd5", null);
		result = service.create(testUser);
		result = service.update(testUser);
		assertNotNull(result);
	}

	@Test
	public void readAllValid() {
		System.out.println("****************readall***********");
		resultlist = service.realAll();
		assertNotNull(resultlist);

	}

//pas de test de dao
//pas de test controller car requette http
//mais possible pour ces couches également

//@Before
//public void beforeMethod() {
//	System.out.println("******************Before test method**********************");
//	
//	
//	
//}
//

	@After
	public void afterMethod() {
		System.out.println("******************After test method**********************");
		if (result != null && result.getId() != null) {
			System.out.println("DEBUG after :" + result.getId());
			service.deleteById(result.getId());
		}

	}

//@AfterClass
//public void afterClass() {
//	System.out.println("******************After test class**********************");
//
//}
//

}
