package model;

public class Runner {
	
	
	private String nombre;
	private int dorsal;
	private String sexo;
	private int edad;
	private String modalidad;
	
	
	public Runner(String nombre, int dorsal, String sexo, int edad, String modalidad) {
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.sexo = sexo;
		this.edad = edad;
		this.modalidad = modalidad;
	}


	public String getNombre() {
		return nombre;
	}


	public int getDorsal() {
		return dorsal;
	}


	public String getSexo() {
		return sexo;
	}


	public String getModalidad() {
		return modalidad;
	}


	public int getEdad() {
		return edad;
	}
	
	
	
	
	

}
