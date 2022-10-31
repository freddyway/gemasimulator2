package es.redsys.configuracion.util;

import java.io.Serializable;

public class Juan implements Serializable{
	int uno;		
	String dos;
	int tres;
	
	public Juan(){
		
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

	public int getTres() {
		return tres;
	}

	public void setTres(int tres) {
		this.tres = tres;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Juan [uno=");
		builder.append(uno);
		builder.append(", dos=");
		builder.append(dos);
		builder.append(", tres=");
		builder.append(tres);
		builder.append("]");
		return builder.toString();
	}
	
	
}
