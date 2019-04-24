package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Formation;
import com.infotel.metier.Stagiaire;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

/**
 * Servlet implementation class ServletFormation
 */
@WebServlet("/ServletFormation")
public class ServletFormation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservice service= new ServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFormation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1-récuperation des infos
		
				String nomFormation;
				
				int idFormation;
				
				  if(request.getParameter("nomFormation")!=null) 
					  
				  {  
					 
					         
					  nomFormation = request.getParameter("nomFormation");           
					
				  
				//2- envoyer à la couche service
				Formation f  = new Formation();
				
			
				f.setNomFormation(nomFormation);// set=écrire
				
				
			 if(request.getParameter("ajouter")!=null) {
				
				service.ajouterFormation(f);//appeler la couche service
		         }
				  
				 }		
				  
				  
					//preparation à l'envoi
					request.setAttribute("formations", service.FindAllFormation());
					
				//appel de la JSP
					request.getRequestDispatcher("Formation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
