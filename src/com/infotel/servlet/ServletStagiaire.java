package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Stagiaire;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

/**
 * Servlet implementation class ServletStagiaire
 */
@WebServlet("/ServletStagiaire")
public class ServletStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservice service= new ServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletStagiaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1-récuperation des infos
		
		String nom;
		String prenom;
		int age;
		int idStagiaire;
		
		  if(request.getParameter("nom")!=null) 
			  
		  {  
			 
			  age = Integer.parseInt(request.getParameter("age"));           
			  nom = request.getParameter("nom");           
			  prenom = request.getParameter("prenom");
		  
		//2- envoyer à la couche service
		Stagiaire s = new Stagiaire();
		
		s.setAge(age);
		s.setNom(nom);// set=écrire
		s.setPrenom(prenom);
		
	 if(request.getParameter("ajouter")!=null) {
		
		service.ajouterStagiaire(s);//appeler la couche service
         }
		  
		 }		
		  
		  
			//preparation à l'envoi
			request.setAttribute("stagiaires", service.FindAll());
			
		//appel de la JSP
			request.getRequestDispatcher("stagiaire.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
