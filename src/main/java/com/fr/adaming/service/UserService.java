package com.fr.adaming.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fr.adaming.dao.IUserDao;
import com.fr.adaming.entity.Equipe;
import com.fr.adaming.entity.User;

@Service
@RequestMapping(path = "api/users")
public class UserService implements IUserService {

	@Autowired
	private IUserDao dao;

	Logger log = Logger.getLogger(UserService.class);

//	@Override
//	public void create(User user) {
//
//		if (user.getId() == null || user.getId() ==0) {
//			dao.save(user);
//			System.out.println("DEBUG: id non existant/user crée");
//
//		} else {
//			if (dao.existsById(user.getId())) {
//				System.out.println("DEBUG: id deja existant");
//			} else {
//				dao.save(user);
//				System.out.println("DEBUG: User crée");
//			}
//		}
//	}

	@Override
	public User create(User user) {
		if (user.getId() == 0) {
			try {
				dao.save(user);
				log.info("ID non existant");
				return user;
			} catch (Exception e) {
				if (e instanceof DataIntegrityViolationException) {
					log.info("Email doit etre different");
					return null;
				} else {
					log.error(e.getStackTrace());
					return null;
				}
			}
		} else {
			if (dao.existsById(user.getId())) {
				log.debug("L'objet User a un ID différent de null");
				return null;
			} else {
				try {
					dao.save(user);
					return user;
				} catch (Exception e) {
					if (e instanceof DataIntegrityViolationException) {
						log.info("Email doit etre different");
						return null;
					} else {
						log.error(e.getStackTrace());
						return null;

					}
				}
			}
		}

	}

//	@Override
//	public User readById(Long id) {
//		// TODO Auto-generated method stub
//		return dao.findById(id).get();
//	}

	@Override
	public User readById(Long id) {
		User user = null;
		try {
			user = dao.findById(id).get();

		} catch (Exception e) {
			if (e instanceof DataIntegrityViolationException) { // a verifier
				log.debug("ID est null! Operation non effectuée");
			} else {
				log.error(e.getStackTrace());
			}

		}
		return user;
	}

//	@Override
//	public List<User> realAll() {
//		// TODO Auto-generated method stub
//		return dao.findAll();
//	}

//	@Override
//	public List<User> realAll() {
//		// TODO Auto-generated method stub
//		List<User> list = null;
//
//		try {
//			list = dao.findAll();
//		} catch (Exception e) {
//			// TODO: handle exception
//			if (e instanceof IllegalArgumentException) {
//				log.debug("List est null! Operation non effectuée");
//			} else {
//				log.error(e.getStackTrace());
//			}
//
//		}
//		return list;
//	}

	@Override
	public List<User> realAll() {
		// TODO Auto-generated method stub
		List<User> list = dao.findAll();
		if (list.isEmpty()) {
			log.info("List est null! Operation non effectuée");
			return null;
		} else {
			list = dao.findAll();
			log.info(" Operation  effectuée");
			return list;
		}
	}

//	@Override
//	public void update(User user) {
//		// TODO Auto-generated method stub
//
//		if (user.getId() == null) {
//			System.out.println("DEBUG : id non existant");
//
//		} else {
//			if (dao.existsById(user.getId())) {
//				dao.save(user);
//				System.out.println("DEBUG :MAJ user");
//
//			} else {
//				System.out.println("DEBUG :MAJ non possible");
//			}
//		}
//	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub

		if (user.getId() == null || user.getId() == 0) {

			log.debug("ID non existant");
			return null;
		} else {
			if (dao.existsById(user.getId())) {
				dao.save(user);				
				log.info("Update effectuée");
				return user;
			} else {

				log.debug("Update impossible");
				return null;
			}
		}
		
	}

//	@Override
//	public String deleteById(Long id) {
//		// TODO Auto-generated method stub
//		dao.deleteById(id);
//		return "user delete";
//
//	}
//
//}

	@Override
	public boolean deleteById(Long id) {
		if (id != null && dao.existsById(id) == true) {
			dao.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	
}
	
	
	
//	@Override
//	public boolean deleteById(Long id) {
//		// TODO Auto-generated method stub
//		if (id == null) {
//			try {
//				dao.deleteById(id);
//				return true;
//			} catch (Exception e) {
//				// TODO: handle exception
//				if (e instanceof InvalidDataAccessApiUsageException) {
//					log.info("id null! Operation non effectuée");
//					return false;
//				} else {
//					log.error(e.getStackTrace());
//					return false;
//				}
//			}
//		}
//		if (dao.existsById(id)) {
//			dao.deleteById(id);
//			return true;
//		} else {
//			try {
//				dao.deleteById(id);
//				return true;
//			} catch (Exception e) {
//				if (e instanceof EmptyResultDataAccessException) {
//					log.info("ID inconnue! Operation non effectuée");
//					return false;
//				} else {
//					log.error(e.getStackTrace());
//					return false;
//				}
//			}
//		}
//
//	}
//}
