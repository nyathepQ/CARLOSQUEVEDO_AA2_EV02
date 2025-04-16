<%-- 
    Document   : empleados
    Created on : 15/04/2025, 10:39:35 p. m.
    Author     : nyath
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Empleados</title>
    <link rel="stylesheet" href="../Estilos/styles.css"> <!-- Estilos -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"> <!-- Iconos -->
</head>
<body>
    <header class="header_pages">
        <a href="inicio.html"><img src="../Img/Logo.jpeg" alt="Logo ALF" class="logo_pages"></a>
        <div class="list_pages">
            <ul>
                <li><a href="agenda.jsp">Agenda</a></li>
                <li class = "actual_page"><a class = "a_actual_page">Empleados</a></li>
                <li><a href="equipos.jsp">Equipo de trabajo</a></li>
                <li><a href="clientes.jsp">Clientes</a></li>
                <li><a href="valores.jsp">Varios</a></li>
            </ul>            
        </div>
        <a href="https://wa.me/573212300716" target="_blank">
            <i class="fa-solid fa-circle-question fa-3x question_icon" style="color: black;"></i>
        </a>
    </header>
    <div class="pages_div">
        <div>
            <form class="form_pages">                
                <div class="form_display">
                    <label for="id_user">Código</label>
                    <input type="text" name="id_user" id="id_user" disabled>
                    <label for="identificacion">Identificación</label>
                    <div id="div_identificacion">
                        <select name="tipo_identificacion" id="tipo_identificacion">                            
                        </select>
                        <input type="text" name="identificacion" id="identificacion">
                    </div>
                    <label for="nombres">Nombres</label>
                    <input type="text" name="nombres" id="nombres">
                    <label for="apellidos">Apellidos</label>
                    <input type="text" name="apellidos" id="apellidos">
                    <label for="cargo">Cargo</label>
                    <select name="cargo" id="cargo">
                    </select>                    
                    <label for="contacto">Contacto</label>
                    <input type="number" name="contacto" id="contacto">
                    <label for="user">Usuario</label>
                    <input type="text" name="user" id="user">
                    <label for="pass">Contraseña</label>
                    <input type="text" name="pass" id="pass">
                </div>
                <div>
                    <button type="submit" value="buscar">Buscar</button>
                    <button type="submit" value="crear/modificar">Crear / Modificar</button>
                    <button type="submit" value="descargar">Mostrar registros</button>
                    <button type="submit" value="eliminar">Eliminar</button>
                </div>
            </form>
        </div>
    </div>
</body>
<!--<script type="module" src="../Js/empleados.js"></script>-->
</html>
