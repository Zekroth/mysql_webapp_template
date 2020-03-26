package main.webapp.java.controller.services;

import java.util.ArrayList;
import java.util.List;

import main.webapp.java.model.Studente;

public interface StudentServiceImpl extends StudentService {
	//PER SCOPI DI TEST
	static ArrayList<Studente> db = new ArrayList<Studente>();
	
	public default Studente getStudentById(int id) {
		Studente s = null;
		for (Studente s1 : db) {
			if(s1.getId() == (id)) {
				s = s1;
				break;
			}
		}
		return s;
	}
	
	public default Studente getStudentByName(String name) {
		Studente s = null;
		for (Studente s1 : db) {
			if(s1.getNome().equals(name)) {
				s = s1;
				break;
			}
		}
		return s;
	}
	
	public default Studente getStudentBySurname(String cognome) {
		Studente s = null;
		for (Studente s1 : db) {
			if(s1.getCognome() == (cognome)) {
				s = s1;
				break;
			}
		}
		return s;
	}
	
	@Override
	public default List<Studente> getStudentsByName(String name) {

		ArrayList<Studente> ss = new ArrayList<Studente>();
		
		db.forEach(s -> {
			if(s.getNome().equals(name)) {
				ss.add(s);
			}
		});
		
		return ss;
		
	}

	@Override
	public default List<Studente> getStudentsBySurname(String name) {

		ArrayList<Studente> ss = new ArrayList<Studente>();
		
		db.forEach(s -> {
			if(s.getCognome().equals(name)) {
				ss.add(s);
			}
		});
		
		return ss;
		
	}
	
	public default boolean insertStudent(Studente s) {
		
		boolean result = false;
		
		db.add(s); //Occupa il posto della logica del db
		
		return true; //Should be return resoult
		
	}
	public default Studente dropStudent(Studente s) {
		
		if( db.remove(s)) {
			return s;
		}else {
			return null;
		}
		
	}
	public default boolean updateStudent(Studente s) {
		
		boolean result = false;
		//WILL BE DONE WITH SQL QUERYs
		
		if(dropStudent(getStudentById(s.getId())) != null) {
			insertStudent(s);
			return true;
		}
		else {
			return false;
		}
	}
}
