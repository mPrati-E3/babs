package it.polito.tdp.esempioSQL.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.esempioSQL.db.BabsDAO;

public class LeggiBABS {
	
	public void run() {
		
		BabsDAO DAO = new BabsDAO();
		
		List<Station> tutte = DAO.listStation();
		
		for (Station S : tutte) {
			System.out.println(S.getName());
		}
		
		System.out.println(" --- ");
		
		List<Station> paloAlto = DAO.listStationByLandmark("Palo Alto");
		
		for (Station S : paloAlto) {
			System.out.println(S.getName());
		}
		
		
		
	}
	
	public static void main (String args[]) {
		
		LeggiBABS babs = new LeggiBABS();
		babs.run();
		
	}
	


}
