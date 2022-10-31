package es.redsys.configuracion.util;

import javax.ejb.EJB;

import es.redsys.configuracion.services.AltaCuentaService;
import es.redsys.configuracion.services.BajaCuentaService;

public class Masivo {

	@EJB
	AltaCuentaService altaCuentaService;
	
	
	
	public Masivo() {

		try {		
			altaCuentaService.findById("18");
			altaCuentaService.findById("20");
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new Masivo();

	}

}
