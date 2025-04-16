package controladores;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import Servicios.UsuarioManager;

/**
 *
 * @author nyath
 */
public class LoginServlet extends HttpServlet {
    
    UsuarioManager user_manager = new UsuarioManager();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("user");
        String password = request.getParameter("pass");
        
        boolean login_true = user_manager.verificarCredencial(usuario, password);
        
        if(login_true){
            //login exitoso
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("Pages/inicio.jsp");
        } else {
            //login fallido
            request.setAttribute("error", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
