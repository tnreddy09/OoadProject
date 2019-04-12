package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LogInDAO;
import com.example.demo.model.Login;

@RestController
public class LogInController {
	
	@Autowired
	LogInDAO dao;

	@GetMapping("/users")
	public List<Login> getUsers() {
		
		List<Login> users = (List<Login>)dao.findAll(); 
		
        /*
        new ArrayList<User>();
		
		User u1 = new User();
		u1.setId(100);
		u1.setUsername("abc");
		u1.setPassword("123");
		

		User u2 = new User();
		u2.setId(101);
		u2.setUsername("xyz");
		u2.setPassword("999");
		
		users.add(u1);
		users.add(u2); */
		
		return users;
	}
	
	//@RequestMapping(path="users/{userid}",produces={"application/xml"})
	@GetMapping("/users/{userid}")
	public Optional<Login> getUsers(@PathVariable("userid") int userid) {
			return dao.findById(userid);	
	}
	
	@PostMapping(path="/users")//,consumes="{application/json}")
	public Login addUser(@RequestBody Login user) {
		dao.save(user);
		return user;
	}
	
	@PutMapping(path="/users")//,consumes="{application/json}")
	public Login saveOrAddUser(@RequestBody Login user) {
		dao.save(user);
		return user;
	}
	
	@DeleteMapping("/users/{userid}")
	public String deleteUser(@PathVariable("userid") int userid) {
		//return dao.findById(userid);
		Login user = dao.getOne(userid);
		dao.delete(user);		
		return "deleted";
	}
	
}
