package main.webapp.java.controller.services;

import java.util.List;

import main.webapp.java.model.Studente;

public interface StudentService {
	
	public Studente getStudentById(int id);
	public List<Studente> getStudentsByName(String name);
	public List<Studente> getStudentsBySurname(String surname);
	
	public boolean insertStudent(Studente s);
	public boolean updateStudent(Studente s);
	public Studente dropStudent(Studente s);
	
	
	
	
}
