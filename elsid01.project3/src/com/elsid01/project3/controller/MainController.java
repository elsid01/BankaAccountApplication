package com.elsid01.project3.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elsid01.project3.entities.Users;
@Controller
public class MainController {
	//Handles	
	
	
	@RequestMapping("")
	public String showIndex() throws ClassNotFoundException, SQLException {
		//connectMariaDB();
       testJpa();
		String viewName="index";
		return viewName;
	}

	private void testJpa() {
		//add to the users table
		Users users =new Users(5,"Baba", "Dembele");
		
//		users.setUserName("bob");
//		users.setPassword("dylan");
		
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("elsid01.project3");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(users);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

	private void connectMariaDB() throws ClassNotFoundException, SQLException {
		
		
		Class.forName("org.mariadb.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sampledb01","root","");
		
		
		if(connection.isValid(0)) {
			System.out.println("CONNECTION IS READY");
			connection.close();
		}
	}
}

//package com.elsid01.project3.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@RequestMapping("/")
//public class MainController {
//	//Handles	
//@RequestMapping("/")
//	public ModelAndView showIndex() {
//		ModelAndView modelAndView = new ModelAndView("index");
//		return modelAndView;
//	}
//}

