/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ca.servlets.models.*;

/**
 *
 * @author Barsha
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username=(String) request.getSession().getAttribute("username");

if(username==null){
	response.sendRedirect("login");
	return;
}

String action=request.getParameter("action");
if(action!=null && action.equals("logout")){
	request.getSession().invalidate();
	response.sendRedirect("login");
	return;
}

this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
    }
 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);

}
}
