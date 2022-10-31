package es.redsys.configuracion.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CopyClass {

	public CopyClass() {
		// TODO Auto-generated constructor stub
		
		Pepe pepe = new Pepe();
		pepe.setDos("DOS");
		pepe.setUno(1);
		
		ObjectMapper mapper = new ObjectMapper();
		
		Juan juan = mapper.convertValue(pepe, Juan.class);

		System.out.println(juan);
	}

	public static void main(String[] args) {
		
		new CopyClass();
	}
}
