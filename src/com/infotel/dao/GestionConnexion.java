package com.infotel.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class GestionConnexion {
	// 2- preparer les elements de la connection
				private String url="jdbc:postgresql://localhost:5432/SyntheseJEE";
				private String user="postgres";
				private String pass= "220790";
				// objet connection
				
				private static  Connection connect;
				
				//constructeur privé
				// permet de creer une connexion
				
				private GestionConnexion() {
					try {
						//1-charger le pilote
						Class.forName("org.postgresql.Driver");
					connect = DriverManager.getConnection(url, user, pass);
					}  catch (Exception e) {
						// TODO: handle exception
						System.out.println("Erreur de connection ");
				}
				

}
  //méthode d'attribution de connection
  //permet de s'assurer de l'unicité de la connection
				
				public static Connection getInstance() {
					if (connect== null) {
						new GestionConnexion();
					}
					return connect;
				}
}
