package ca.sait.home_nventory.servlets;

import ca.sait.home_nventory.models.*;
import ca.sait.home_nventory.services.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shiana Khehra
 */
public class ManageUserAccountServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserService us = new UserService();
        RoleService rs = new RoleService();
        String email = (String) session.getAttribute("email");
        User user = null;
        
        if(email != null) {
        try {
            user = us.get(email);
        } catch (Exception ex) {
            Logger.getLogger(ManageUserAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(user != null) {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        
        request.setAttribute("firstname", firstName);
        request.setAttribute("lastname", lastName);
        
        String query = request.getQueryString();
        
        if(query != null && query.contains("edit")) {
            getServletContext().getRequestDispatcher("/WEB-INF/editUser.jsp").forward(request, response);
        }
        
        if(query != null && query.contains("home")) {
            getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
        }
        }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userservice = new UserService();
        
        try {
                String email = request.getParameter("email");
            
                String firstname = request.getParameter("fname");
            
                String lastname = request.getParameter("lname");
                
                String password = request.getParameter("passwd");
                
                boolean status = userservice.update(email, true, firstname, lastname, password, new Role(2, "regular user"));
                if(status) {
                    request.setAttribute("message", "Account successfully updated.");
                } else {
                    request.setAttribute("warn", "Account not found. Make sure you enter the email regitered in your account.");
                }
            } catch (Exception ex) {
                Logger.getLogger(ManageUserAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        getServletContext().getRequestDispatcher("/WEB-INF/editUser.jsp").forward(request, response);
        }
}
