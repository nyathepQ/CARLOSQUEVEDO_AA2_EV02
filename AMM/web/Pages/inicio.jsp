<%-- 
    Document   : inicio
    Created on : 15/04/2025, 10:42:06 p. m.
    Author     : nyath
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio</title>
    <link rel="stylesheet" href="../Estilos/styles.css"> <!-- Estilos -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"> <!-- Iconos -->
</head>
<body>
    <header class="header_pages">
        <img src="../Img/Logo.jpeg" alt="Logo ALF" class="logo_pages">
        <div class="list_pages">
            <ul>
                <li><a href="agenda.html">Agenda</a></li>
                <li><a href="empleados.html">Empleados</a></li>
                <li><a href="equipos.html">Equipo de trabajo</a></li>
                <li><a href="clientes.html">Clientes</a></li>
                <li><a href="valores.html">Varios</a></li>
            </ul>            
        </div>
        <a href="https://wa.me/573212300716" target="_blank">
            <i class="fa-solid fa-circle-question fa-3x question_icon" style="color: black;"></i>
        </a>
    </header>
    <div id="inicio_primero">
        <div class="start_data">
            <div class="title_star">
                <h1>Limpieza en curso</h1>
            </div>
            <div class="colum_star" id="en_curso">
                <div>
                    <p>Lorem ipsum dolor sit amet, consectetur</p>
                    <p>fecha</p>
                </div>
            </div>            
        </div>
        <div class="start_data">
            <div class="title_star">
                <h1>Próxima limpieza</h1>
            </div>
            <div class="colum_star" id="proxima">
                <div><p>fecha</p></div>
            </div> 
        </div>
        <div class="start_data">
            <div class="title_star">
                <h1>Finalización pendiente</h1>
            </div>
            <div class="colum_star" id="finalizar">
                <div><p>fecha</p></div>
            </div> 
        </div>
    </div>
</body>
<!--<script src="../Js/inicio.js"></script>-->
</html>
