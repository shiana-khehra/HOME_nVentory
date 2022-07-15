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
public class ManageCategoriesServlet extends HttpServlet {

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
        CategoryService cservive = new CategoryService();
        String email = (String) session.getAttribute("email");
        List<Category> categories = null;
        User user = null;
        
        if(email != null) {
        try {
            user = userservice.get(email);
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            
            request.setAttribute("firstname", firstName);
            request.setAttribute("lastname", lastName);
            
            categories = cservive.getAll();
            request.setAttribute("categories", categories);
            } catch (Exception ex) {
            Logger.getLogger(ManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/category.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        UserService userservice = new UserService();
        CategoryService cservive = new CategoryService();
        String action = request.getParameter("action");
        String email = (String) session.getAttribute("email");
        List<Category> categories = null;
        
        try {
            User user = userservice.get(email);
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            
            request.setAttribute("firstname", firstName);
            request.setAttribute("lastname", lastName);
            
            categories = cservive.getAll();
            request.setAttribute("categories", categories);
        } catch (Exception ex) {
            Logger.getLogger(ManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (action != null && action.equals("add")) {
            try {
                String name = request.getParameter("name");
            
                if(cservive.insert(0, name)) {
                categories = cservive.getAll();
                request.setAttribute("categories", categories);
                request.setAttribute("msg", "New category created");
                }
            } catch (Exception ex) {
                Logger.getLogger(ManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (action != null && action.equals("edit")) {
            try {
                int id = Integer.parseInt(request.getParameter("ID"));
                String name = request.getParameter("name");
            
                if(cservive.update(id, name)) {
                categories = cservive.getAll();
                request.setAttribute("categories", categories);
                request.setAttribute("msg", "Update successful");
                }
            } catch (Exception ex) {
                Logger.getLogger(ManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/category.jsp").forward(request, response);
    }

}
