package it.polito.tdp.esempioSQL.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.esempioSQL.model.Station;

public class BabsDAO {
	
	public List<Station> listStation(){
		
		List<Station> ListStat = new ArrayList<Station>();
		
		String sql = "SELECT station_id, name, dockcount, landmark FROM STATION";
		
		//FACTORY: creo un oggetto si una clsse senza sapere il tipo della classe
		//(non uso new perchè non so il nome della classe)
		//uso un metodo fornito da un'altra clsse che internamente fa new e riconoscerà
		//il tipo di classe effettivo
		try {
			
			Connection conn = DBConnect.getConnection();
			
			//veicolo per passare e ricevere le query al database
			PreparedStatement st = conn.prepareStatement(sql);
			
			//salvo il modo per ottenere il risultato della query fatta e passata tramite lo Statement
			ResultSet res = st.executeQuery();
			//per modificare il database: executeUpdate()
			//per roba generica: execute()
			
			//itero la tabella a cui res punta tramite next
			while (res.next()) {
				
				Station S = new Station(
						res.getInt("station_id"), 
						res.getString("name"), 
						res.getInt("dockcount"), 
						res.getString("landmark"));
				
				ListStat.add(S);

			}
			
			st.close();
			conn.close();
			
			return ListStat;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public List<Station> listStationByLandmark(String land){
		
		List<Station> ListStat = new ArrayList<Station>();
		
		String sql = "SELECT station_id, name, dockcount, landmark FROM STATION WHERE landmark = ?";
		
		//FACTORY: creo un oggetto si una clsse senza sapere il tipo della classe
		//(non uso new perchè non so il nome della classe)
		//uso un metodo fornito da un'altra clsse che internamente fa new e riconoscerà
		//il tipo di classe effettivo
		try {
			
			Connection conn = DBConnect.getConnection();
			
			//veicolo per passare e ricevere le query al database
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, land);
			
			//salvo il modo per ottenere il risultato della query fatta e passata tramite lo Statement
			ResultSet res = st.executeQuery();
			//per modificare il database: executeUpdate()
			//per roba generica: execute()
			
			//itero la tabella a cui res punta tramite next
			while (res.next()) {
				
				Station S = new Station(
						res.getInt("station_id"), 
						res.getString("name"), 
						res.getInt("dockcount"), 
						res.getString("landmark"));
				
				ListStat.add(S);

			}
			
			st.close();
			conn.close();
			
			return ListStat;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}
