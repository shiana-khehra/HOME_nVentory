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
public class ManageInventoryServlet extends HttpServlet {

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
        ItemService is = new ItemService();
        CategoryService cs = new CategoryService();
        UserService us = new UserService();
        String action = request.getParameter("action");
        String email = (String) session.getAttribute("email");
        int id = 0;
        
        if(email != null) {
        try {
            User user = us.get(email);
            String firstName = user.getFirstName();
            String lastName = user.getLastName();

            request.setAttribute("firstname", firstName);
            request.setAttribute("lastname", lastName);
            List<Item> items= is.get(email);
            List<Category> categories = cs.getAll();
            request.setAttribute("items", items);
            request.setAttribute("categories", categories);
            
            if(action!= null && action.equals("deleteButton")) {
            id = Integer.parseInt(request.getParameter("id"));
            if(is.delete(id)) {
            request.setAttribute("msg", "1 item deleted");
            items = is.get(email);
            request.setAttribute("items", items);
            }
            }
            
            if(action!= null && action.equals("editButton")) {
                id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("IdItem", id);
                getServletContext().getRequestDispatcher("/WEB-INF/editItem.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageInventoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
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
        ItemService iservice = new ItemService();
        CategoryService cservice = new CategoryService();
        UserService us = new UserService();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String email = (String) session.getAttribute("email");
        List<Item> items = null;
        
        if(action != null) {
            try {    
                User user = us.get(email);
                String firstName = user.getFirstName();
                String lastName = user.getLastName();
            
                request.setAttribute("firstname", firstName);
                request.setAttribute("lastname", lastName);
            
                items= iservice.get(email);
                List<Category> categories = cservice.getAll();
                request.setAttribute("items", items);
                request.setAttribute("categories", categories);
            
                if(action.equals("add")) {
                String category = request.getParameter("category");
                int category_id = cservice.getCategoryId(category);

                String item_name = request.getParameter("name");

                int price = Integer.parseInt(request.getParameter("price"));

                iservice.insert(0, category_id, item_name, price, email);
                items = iservice.get(email);
                request.setAttribute("items", items);
                request.setAttribute("msg", "Item successfully added");
                } else if (action.equals("editItem")) {
                int id = Integer.parseInt(request.getParameter("iId"));

                String category = request.getParameter("icategory");
                int category_id = cservice.getCategoryId(category);

                String item_name = request.getParameter("iname");

                int price = Integer.parseInt(request.getParameter("iprice"));

                iservice.update(id, category_id, item_name, price, email);

                items = iservice.get(email);
                request.setAttribute("items", items);
                request.setAttribute("msg", "Item successfully updated");
                }
            } catch (Exception ex) {
                Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
    }

}
