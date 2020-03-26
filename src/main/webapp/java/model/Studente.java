package main.webapp.java.model;

public class Studente {
	
	private int id;
	private String nome;
	private String cognome;
	
	private static int lastId = 0;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId() {
		this.id = lastId;
		lastId ++ ;//NON GARANTISCE MUTUA ESCLUSIONE
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	/**
	 * @param id
	 * @param nome
	 * @param cognome
	 */
	public Studente(int id, String nome, String cognome) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}
	/**
	 * 
	 * @param nome
	 * @param cognome
	 */
	public Studente(String nome, String cognome) {
		setId();
		this.nome = nome;
		this.cognome = cognome;
	}
	
	
}
