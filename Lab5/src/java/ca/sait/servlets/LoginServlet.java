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
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username=(String) request.getSession().getAttribute("username");

        if(username!=null){
            response.sendRedirect("home");
            return;
              }


        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }
 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username= request.getParameter("username");
        String password= request.getParameter("password");

        AccountService account = new AccountService();
        User user = account.login(username,password);

if (user !=null){
	//user is not null
	//store username is session
	//redirect to home page
	request.getSession().setAttribute("username",username);
	response.sendRedirect("home");
	return;
}else{
	//user is null
	//display error msg in login.jsp
	String message="Username or Password is invalid";
	request.setAttribute("message",message);

}

this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
return;
}
}
