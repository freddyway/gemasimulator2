package es.redsys.configuracion;

import es.redsys.configuracion.services.GemaOroService;

public class TestGema {
	
	public TestGema() {
		String msg = "0049?0001?P?31390?000000000000000000000000?00000000000000?00000000000000?XXXXX?5163830108684749?201910?202410?0000000000?NF?48989382A?0?1720?0?00? ?0000000000000000? ? ?0?0000?724?978?DEB49EST?0?0000000?0000000?1?1?0000000?2?978?201?0?0?1?111?0?0000000000?0049";
		GemaOroService gemaOroService = new GemaOroService();
		 
		try {
			String[] response = gemaOroService.enviarTandem(msg);
			
			for (int i = 0; i < response.length; i++) {
				System.out.println(response[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		 new TestGema();
	}

}
