<%-- 
    Document   : clientes
    Created on : 15/04/2025, 10:39:07 p. m.
    Author     : nyath
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clientes</title>
    <link rel="stylesheet" href="../Estilos/styles.css"> <!-- Estilos -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"> <!-- Iconos -->
</head>
<body>
    <header class="header_pages">
        <a href="inicio.html"><img src="../Img/Logo.jpeg" alt="Logo ALF" class="logo_pages"></a>
        <div class="list_pages">
            <ul>
                <li><a href="agenda.jsp">Agenda</a></li>
                <li><a href="empleados.jsp">Empleados</a></li>
                <li><a href="equipos.jsp">Equipo de trabajo</a></li>
                <li class = "actual_page"><a class = "a_actual_page">Clientes</a></li>
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
                    <label for="id_cliente">Código</label>
                    <input type="text" name="id_cliente" id="id_cliente">                  
                    <label for="nombres">Nombre</label>
                    <input type="text" name="nombres" id="nombres">
                    <label for="apellidos">Apellido</label>
                    <input type="text" name="apellidos" id="apellidos">
                    <label for="direccion">Dirección</label>
                    <input type="text" name="direccion" id="direccion">
                    <label for="contacto">Contacto</label>
                    <input type="tel" name="contacto" id="contacto">                  
                    <label for="observaciones">Observaciones</label>
                    <input type="text" name="observaciones" id="observaciones">
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
<!--<script type="module" src="../Js/clientes.js"></script>-->
</html>
