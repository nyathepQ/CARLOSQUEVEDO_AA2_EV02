<%-- 
    Document   : empleados
    Created on : 15/04/2025, 10:39:35 p. m.
    Author     : nyath
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Clases.Usuario"%>
<%@page import="Clases.Varios"%>
<%@page import="Servicios.UsuarioManager"%>
<%@page import="Servicios.VariosManager"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Empleados</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Estilos/styles.css"> <!-- Estilos -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"> <!-- Iconos -->
</head>
<body>
    <%
        Usuario user = (Usuario) session.getAttribute("usuario"); //obtener datos de sesión
        Usuario empleado = (Usuario) request.getAttribute("empleado");
        if(user == null){ //si no hay sesión iniciada regresar al index
            response.sendRedirect("../index.jsp");
            return;
        }
        UsuarioManager us_manager = new UsuarioManager();
        VariosManager tipos_manager = new VariosManager();
        Varios[] ti_do = tipos_manager.getAllTipoVarios("tipo_documento", "id_tipoDocu");
        Varios[] ti_us = tipos_manager.getAllTipoVarios("tipo_usuario", "id_tipoUsua");
        
        Varios td_empleado = new Varios();
        Varios tu_empleado = new Varios();
        
        if(empleado != null){
            td_empleado = tipos_manager.buscarTipoVarios("tipo_usuario", "id_tipoUsua", empleado.getTipo_user());
            tu_empleado = tipos_manager.buscarTipoVarios("tipo_documento", "id_tipoDocu", empleado.getTipo_docu());
        }
        
    %>
    <header class="header_pages">
        <div class="iconUserName">
            <a href="https://wa.me/573212300716" target="_blank">
                <i class="fa-solid fa-circle-question fa-2x question_icon" style="color: black;"></i>
            </a>
            <p class ="name_user_show">
                <%= user != null ? user.getUser() : "Invitado" %>
            </p>            
        </div>
        <div class="logo_list">
            <a href="<%= request.getContextPath() %>/Pages/inicio.jsp"><img src="<%= request.getContextPath() %>/Img/Logo.jpeg" alt="Logo ALF" class="logo_pages"></a>
            <div class="list_pages">
                <ul>
                    <li><a href="<%= request.getContextPath() %>/Pages/agenda.jsp">Agenda</a></li>
                    <li class = "actual_page"><a class = "a_actual_page">Empleados</a></li>
                    <li><a href="<%= request.getContextPath() %>/Pages/equipos.jsp">Equipo de trabajo</a></li>
                    <li><a href="<%= request.getContextPath() %>/Pages/clientes.jsp">Clientes</a></li>
                    <li><a href="<%= request.getContextPath() %>/Pages/valores.jsp">Varios</a></li>
                </ul>            
            </div>
        </div>
    </header>
    <div class="pages_div">
        <div>
            <form class="form_pages">  
                <% if (request.getAttribute("error") != null) { %>
                    <p style="color:darkblue;"><%= request.getAttribute("error") %></p>
                <% } %>
                <% if (request.getAttribute("mensaje") != null) { %>
                    <p style="color:grey;"><%= request.getAttribute("mensaje") %></p>
                <% } %>
                <div class="form_display" action="<%= request.getContextPath() %>/EmpleadoServlet" method="post">
                    <label for="id_usuario">Código</label>
                    <input type="text" name="id_usuario" id="id_usuario">
                    <label for="documento_usuario">Identificación</label>
                    <div id="div_identificacion">
                        <select name="id_tipoDocu" id="id_tipoDocu">
                            
                        </select>
                        <input type="text" name="documento_usuario" id="documento_usuario">
                    </div>
                    <label for="nombres">Nombres</label>
                    <input type="text" name="nombres" id="nombres">
                    <label for="apellidos">Apellidos</label>
                    <input type="text" name="apellidos" id="apellidos">
                    <label for="id_tipoUsua">Tipo de usuario</label>
                    <select name="id_tipoUsua" id="id_tipoUsua">
                        
                    </select>                    
                    <label for="telefono_usuario">Telefono</label>
                    <input type="text" name="telefono_usuario" id="telefono_usuario">
                    <label for="correo_usuario">Correo electronico</label>
                    <input type="text" name="correo_usuario" id="correo_usuario">
                    <label for="nombre_usuario">Usuario</label>
                    <input type="text" name="nombre_usuario" id="nombre_usuario">
                    <label for="contrasena_usuario">Contraseña</label>
                    <input type="text" name="contrasena_usuario" id="contrasena_usuario">
                </div>
                <div>
                    <button type="submit" name="accion" value="buscar">Buscar</button>
                    <button type="submit" name="accion" value="crear/modificar">Crear / Modificar</button>
                    <button type="submit" name="accion" value="mostrar">Mostrar registros</button>
                    <button type="submit" name="accion" value="eliminar">Eliminar</button>
                </div>
            </form>
        </div>
    </div>
</body>
<!--<script type="module" src="../Js/empleados.js"></script>-->
</html>
