package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

/**
 * Servlet implementation class SupprimerStagiaire
 */
@WebServlet("/SupprimerStagiaire")
public class SupprimerStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservice service= new ServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerStagiaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idStagiaire= Integer.parseInt(request.getParameter("idStagiaire"));
		   service.supprimerStagiaire(idStagiaire);
		   
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
