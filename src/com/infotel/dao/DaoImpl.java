package com.infotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.infotel.metier.Formation;
import com.infotel.metier.Promo;
import com.infotel.metier.Stagiaire;

public class DaoImpl implements Idao {
	 private Connection connect;
	 private PreparedStatement st;
	 private ResultSet rs;

	@Override
	public int ajouterStagiaire(Stagiaire s) {
		
        try {
			
			//1- se connecter à la base des données
			
			connect= GestionConnexion.getInstance();
			
			// 2-préparer effectuer la requete
			
			st= connect.prepareStatement("INSERT INTO Stagiaire(nom,prenom,age) "
					+ "Values(?,?,?)");
			st.setString(1, s.getNom());
			st.setString(2, s.getPrenom());
			st.setInt(3, s.getAge());
			
			st.executeUpdate();
			
			//3- recuperer le resultat en cas de besoin
			
		} catch (Exception e) {
		e.printStackTrace();
			
		}
	
		return s.getIdStagiaire() ;
	}

	@Override
	public int supprimerStagiaire(int idStagiaire) {
		
        try {
			
			//1- se connecter à la base des données
			
			connect= GestionConnexion.getInstance();
			
			// 2-préparer effectuer la requete
			
			st= connect.prepareStatement("DELETE FROM Stagiaire where idStagiaire=?");
			st.setInt(1, idStagiaire);
			
			 st.executeUpdate();
					
			
			//3- recuperer le resultat en cas de besoin
			
			
			
		} catch (Exception e) {
	e.printStackTrace();
			
		}
		return 0;
	}

	@Override
	public List<Stagiaire> FindAll() {
		
		List<Stagiaire> list= new ArrayList<Stagiaire>();
		try {
					
					//1- se connecter à la base des données
					
					connect= GestionConnexion.getInstance();
					
					// 2-préparer effectuer la requete
					
					st= connect.prepareStatement("SELECT * FROM Stagiaire ");
							
					
					
					rs= st.executeQuery();
					
					//3- recuperer le resultat en cas de besoin
					while (rs.next())
					{
						Stagiaire s = new Stagiaire();
						s.setIdStagiaire(rs.getInt("idStagiaire"));
						s.setNom(rs.getString("nom"));
						s.setPrenom(rs.getString("prenom"));
						s.setAge(rs.getInt("age"));
						list.add(s);
					}
					
					
				} catch (Exception e) {
			System.out.println("ERREUR");
					
				}
			
				return list;
		
	}

	@Override
	public int ajouterPromo(Promo p) {
         try {
			
			//1- se connecter à la base des données
			
			connect= GestionConnexion.getInstance();
			
			// 2-préparer effectuer la requete
			
			st= connect.prepareStatement("INSERT INTO Promo(nomSession,effectif) "
					+ "Values(?,?)");
			st.setString(1, p.getNomSession());
			st.setInt(2, p.getEffectif());
			
			
			st.executeUpdate();
			
			//3- recuperer le resultat en cas de besoin
			
		} catch (Exception e) {
		e.printStackTrace();
			
		}
	
		return p.getIdPromo() ;
		
	}

	@Override
	public int supprimerPromo(int idPromo) {
		
		 try {
				
				//1- se connecter à la base des données
				
				connect= GestionConnexion.getInstance();
				
				// 2-préparer effectuer la requete
				
				st= connect.prepareStatement("DELETE FROM Promo where idPromo=?");
				st.setInt(1, idPromo);
				
				 st.executeUpdate();
						
				
				//3- recuperer le resultat en cas de besoin
				
				
				
			} catch (Exception e) {
		e.printStackTrace();
				
			}
		return 0;
	}

	@Override
	public List<Promo> FindAllPromo() {
		
		List<Promo> list= new ArrayList<Promo>();
		try {
					
					//1- se connecter à la base des données
					
					connect= GestionConnexion.getInstance();
					
					// 2-préparer effectuer la requete
					
					st= connect.prepareStatement("SELECT * FROM Promo ");
							
					
					
					rs= st.executeQuery();
					
					//3- recuperer le resultat en cas de besoin
					while (rs.next())
					{
						Promo p = new Promo();
						p.setIdPromo(rs.getInt("idPromo"));
						p.setNomSession (rs.getString("nomSession"));
						p.setEffectif (rs.getInt("effectif"));
						list.add(p);
					}
					
					
				} catch (Exception e) {
			System.out.println("ERREUR");
					
				}
			
				return list;
		
	}

	@Override
	public int ajouterFormation(Formation f) {
		 try {
				
				//1- se connecter à la base des données
				
				connect= GestionConnexion.getInstance();
				
				// 2-préparer effectuer la requete
				
				st= connect.prepareStatement("INSERT INTO Formation(nomFormation) "
						+ "Values(?)");
				st.setString(1, f.getNomFormation());
				
				
				st.executeUpdate();
				
				//3- recuperer le resultat en cas de besoin
				
			} catch (Exception e) {
			e.printStackTrace();
				
			}
		
			return f.getIdFormation() ;
	}

	@Override
	public int supprimerFormation(int idFormation) {
		// TODO Auto-generated method stub
		 try {
				
				//1- se connecter à la base des données
				
				connect= GestionConnexion.getInstance();
				
				// 2-préparer effectuer la requete
				
				st= connect.prepareStatement("DELETE FROM Formation where idFormation=?");
				st.setInt(1, idFormation);
				
				 st.executeUpdate();
						
				
				//3- recuperer le resultat en cas de besoin
				
				
				
			} catch (Exception e) {
		e.printStackTrace();
				
			}
		return 0;
	}

	@Override
	public List<Formation> FindAllFormation() {
		List<Formation> list= new ArrayList<Formation>();
		try {
					
					//1- se connecter à la base des données
					
					connect= GestionConnexion.getInstance();
					
					// 2-préparer effectuer la requete
					
					st= connect.prepareStatement("SELECT * FROM Formation ");
							
					
					
					rs= st.executeQuery();
					
					//3- recuperer le resultat en cas de besoin
					while (rs.next())
					{
						Formation f = new Formation();
						f.setIdFormation(rs.getInt("idFormation"));
						f.setNomFormation (rs.getString("nomFormation"));
						
						list.add(f);
					}
					
					
				} catch (Exception e) {
			System.out.println("ERREUR");
					
				}
			
				return list;
	}

	@Override
	public void attribuerPromoFormation(Promo p, Formation f) {
		// TODO Auto-generated method stub
		try {
			//1- se connecter à la base de données
			connect = GestionConnexion.getInstance();
			//2- préparer effectuer la requête
			st = connect.prepareStatement("UPDATE Promo set fformation=? Where IdPromo=?");
			st.setInt(1, f.getIdFormation());
			st.setInt(2, p.getIdPromo());
		    st.executeUpdate();
			//3- récupérer le résultat en cas de besoin
			
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void attribuerStagiairePromo(Stagiaire s, Promo p) {
		// TODO Auto-generated method stub
		try {
			//1- se connecter à la base de données
			connect = GestionConnexion.getInstance();
			//2- préparer effectuer la requête
			st = connect.prepareStatement("UPDATE Stagiaire set fpromo=? Where IdStagiaire=?");
			st.setInt(1, p.getIdPromo ());
			st.setInt(2, s.getIdStagiaire());
		    st.executeUpdate();
			//3- récupérer le résultat en cas de besoin
			
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
