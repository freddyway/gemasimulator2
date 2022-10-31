package es.redsys.configuracion.util;

import java.io.Serializable;

public class Pepe implements Serializable{
	int uno;		
	String dos;
	
	public Pepe(){
		
	}
	
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getDos() {
		return dos;
	}
	public void setDos(String dos) {
		this.dos = dos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pepe [uno=");
		builder.append(uno);
		builder.append(", dos=");
		builder.append(dos);
		builder.append("]");
		return builder.toString();
	}
	
}
