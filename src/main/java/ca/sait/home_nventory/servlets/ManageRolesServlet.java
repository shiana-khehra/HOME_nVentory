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
public class ManageRolesServlet extends HttpServlet {

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
        RoleService roleservice = new RoleService();
        String email = (String) session.getAttribute("email");
        List<Role> roles = null;
        User user = null;
        
        if(email != null) {
        try {
            user = userservice.get(email);
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            
            request.setAttribute("firstname", firstName);
            request.setAttribute("lastname", lastName);
            
            roles = roleservice.getAll();
            request.setAttribute("roles", roles);
            } catch (Exception ex) {
            Logger.getLogger(ManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/role.jsp").forward(request, response);
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
        RoleService roleservice = new RoleService();
        String email = (String) session.getAttribute("email");
        List<Role> roles = null;
        List<User> users = null;
        User user = null;
        
        if(email != null) {
        try {
            user = userservice.get(email);
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            
            request.setAttribute("firstname", firstName);
            request.setAttribute("lastname", lastName);
            
            roles = roleservice.getAll();
            request.setAttribute("roles", roles);
            
            String emaill = request.getParameter("emaill");
            
            if(emaill.equals(email)) {
                request.setAttribute("warn", "You cannot change your own role.");
                getServletContext().getRequestDispatcher("/WEB-INF/role.jsp").forward(request, response);
            }
            
            User changedUser = userservice.get(emaill);
            
            String roleName = request.getParameter("role");
            int roleId = roleservice.getRoleID(roleName);
            Role role = new Role(roleId, roleName);
            
            if(userservice.update(emaill, changedUser.isActive(), changedUser.getFirstName(), changedUser.getLastName(), changedUser.getPassword(), role)) {
                request.setAttribute("msg", "Changes saved successfully");
            }
            
            users = userservice.getAll();
            request.setAttribute("users", users);
            
            } catch (Exception ex) {
            Logger.getLogger(ManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
    }
}