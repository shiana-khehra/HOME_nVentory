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

/**
 *
 * @author Shiana Khehra
 */
public class RegistrationServlet extends HttpServlet {

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
        this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(request, response);
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
        RoleService roleservice = new RoleService();
        
        try {
            String email = request.getParameter("email");

            String firstname = request.getParameter("fname");

            String lastname = request.getParameter("lname");

            Role role = new Role(2, "regular user");

            String password = request.getParameter("passwd");

            userservice.insert(email, true, firstname, lastname, password, role);
            List<User> users = userservice.getAll();
            request.setAttribute("users", users);
            request.setAttribute("successMsg", "Conratz! You are successfully registered.");
            request.setAttribute("submitted", "Login to start managing your inventory.");
        } catch (Exception ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/authentication.jsp").forward(request, response);
    }

}