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
 * Servlet implementation class SupprimerFormation
 */
@WebServlet("/SupprimerFormation")
public class SupprimerFormation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservice service= new ServiceImpl();  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerFormation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idFormation= Integer.parseInt(request.getParameter("idFormation"));
		   service.supprimerFormation(idFormation);
		   
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
