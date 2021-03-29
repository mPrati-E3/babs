package it.polito.tdp.esempioSQL.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeggiBABS {
	
	public void run() {
		
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=root";
		
		//FACTORY: creo un oggetto si una clsse senza sapere il tipo della classe
		//(non uso new perchè non so il nome della classe)
		//uso un metodo fornito da un'altra clsse che internamente fa new e riconoscerà
		//il tipo di classe effettivo
		try {
			
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			//query con template paramentrico (nelle stringhe, no apici)
			String sql = "SELECT NAME FROM station WHERE landmark=?";
			
			//veicolo per passare e ricevere le query al database
			PreparedStatement st = conn.prepareStatement(sql);
			
			//setto il template paramentrico della query
			st.setString(1, "Palo Alto");
			
			//salvo il modo per ottenere il risultato della query fatta e passata tramite lo Statement
			ResultSet res = st.executeQuery();
			//per modificare il database: executeUpdate()
			//per roba generica: execute()
			
			//itero la tabella a cui res punta tramite next
			while (res.next()) {
				//estraggo NAME per ogni riga
				String nome_staz = res.getString("NAME");
				System.out.println(nome_staz);
			}
			
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main (String args[]) {
		
		LeggiBABS babs = new LeggiBABS();
		babs.run();
		
	}
	


}
