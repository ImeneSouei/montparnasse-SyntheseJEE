package com.infotel.dao;

import java.util.List;


import com.infotel.metier.Formation;
import com.infotel.metier.Promo;
import com.infotel.metier.Stagiaire;



public interface Idao {
	
	public int ajouterStagiaire(Stagiaire s );
	public int supprimerStagiaire(int idStagiaire );
	public List<Stagiaire> FindAll();
	
	public int ajouterPromo(Promo p );
	public int supprimerPromo(int idPromo );
	public List<Promo> FindAllPromo();
	
	public int ajouterFormation(Formation f );
	public int supprimerFormation(int idFormation );
	public List<Formation> FindAllFormation();
	
	public void attribuerPromoFormation (Promo p , Formation f);
	
	public void attribuerStagiairePromo (Stagiaire s , Promo p);

}
