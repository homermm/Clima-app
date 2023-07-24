package com.app.clima.entities;

public class Clima {
	private String ciudad;
	private double temperatura;
	
	
	public Clima() {
		super();
	}

	public Clima(String ciudad, double temperatura) {
		this.ciudad = ciudad;
		this.temperatura = temperatura;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String toString() {
		return "Clima [ciudad=" + ciudad + ", temperatura=" + temperatura + "]";
	}
	
	
}
