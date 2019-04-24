package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Promo;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

/**
 * Servlet implementation class ServletPromo
 */
@WebServlet("/ServletPromo")
public class ServletPromo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservice service= new ServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPromo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1-récuperation des infos
		
				String nomSession;
				
				int effectif;
				int idPromo;
				
				  if(request.getParameter("nomSession")!=null) 
					  
				  {  
					 
					  effectif = Integer.parseInt(request.getParameter("effectif"));           
					  nomSession = request.getParameter("nomSession");           
					 
				  
				//2- envoyer à la couche service
				Promo p = new Promo();
				
				p.setNomSession(nomSession);
				p.setEffectif(effectif);// set=écrire
			
				
			 if(request.getParameter("ajouter")!=null) {
				
				service.ajouterPromo(p);//appeler la couche service
		         }
				  
				 }		
				  
				  
					//preparation à l'envoi
					request.setAttribute("promos", service.FindAllPromo());
					
				//appel de la JSP
					request.getRequestDispatcher("Promo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
