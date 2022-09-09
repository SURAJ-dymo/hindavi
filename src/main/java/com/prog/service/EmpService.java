package com.prog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entity.Employe;
import com.prog.repository.EmpRepo;
@Service
public class EmpService {
	@Autowired
	private EmpRepo repo;

	public void addEmp(Employe e) {

		repo.save(e);

	}
	public List<Employe> getAllEmploy() {

		return repo.findAll();
		
	}
	public Employe getEmployById(int id) {
		
		
		Optional <Employe> e=repo.findById(id);
		if(e.isPresent()) {
			
			return e.get();
		}
		return null;
	}
	
	public void deleEmp(Employe e) {
		
		
		repo.delete(e);
	}
}
