package ca.sait.home_nventory.servlets;

import ca.sait.home_nventory.models.User;
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
public class AuthenticationServlet extends HttpServlet {

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
        UserService userservice = new UserService();
        if(session.getAttribute("email") != null) {
            String query = request.getQueryString();
        
            if(query != null && query.contains("logout")) {
                session.setAttribute("email", null);
                session.invalidate();
                
                request.setAttribute("logout", "You are logged out.");
            } else if (query != null && query.contains("deactivate")) {
                try {
                    List<User> users =userservice.getAll();
                    request.setAttribute("users", users);
                    String email = (String) session.getAttribute("email");
                    email = email.replace(" ","+");
                    userservice.deactivate(email);
                    users = userservice.getAll();
                    request.setAttribute("users", users);
                    request.setAttribute("successMsg", "Account deactivated!");
                    request.setAttribute("submitted", "We are sorry to see you go. Hope to see you soon.");
                } catch (Exception ex) {
                    Logger.getLogger(AuthenticationServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                response.sendRedirect("user");
                return;
            }
        }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/authentication.jsp").forward(request, response);
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
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if(email == null || email.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("message", "Username or password is missing.");
            getServletContext().getRequestDispatcher("/WEB-INF/authentication.jsp").forward(request, response);
            return;
        }
        
        AccountService as = new AccountService();
        User user = as.login(email, password);
        
        if (user == null) {
            request.setAttribute("message", "Username or password is invalid.");
            getServletContext().getRequestDispatcher("/WEB-INF/authentication.jsp").forward(request, response);
            return;
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("user", user);
        
        if(user.isActive() && user.getRole().getId() == 1) {
            response.sendRedirect("manageuser");
        } else if(user.isActive() && user.getRole().getId() != 1) {
            response.sendRedirect("user");
        } else {
            request.setAttribute("message", "Account does not exist.");
            getServletContext().getRequestDispatcher("/WEB-INF/authentication.jsp").forward(request, response);
        }
    }

}