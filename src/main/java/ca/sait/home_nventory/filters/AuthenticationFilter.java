package ca.sait.home_nventory.filters;

import ca.sait.home_nventory.models.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shiana Khehra
 */
public class AuthenticationFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

            // code that is executed before the servlet
            HttpServletRequest httpRequest = (HttpServletRequest)request;
            HttpServletResponse httpResponse = (HttpServletResponse)response;
            HttpSession session = httpRequest.getSession();
            //String email = (String)session.getAttribute("email");
            
            User user = (User)session.getAttribute("user");
            
            if (user == null) {
                httpResponse.sendRedirect("login");
                return;
            }
            
            if(user.getRole().getId() != 1) {
                chain.doFilter(request, response);
            } else {
                httpResponse.sendRedirect("manageuser");
            }
            //chain.doFilter(request, response); // execute the servlet
            
            // code that is executed after the servlet
            
        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void destroy() {
       
    }
    
}
