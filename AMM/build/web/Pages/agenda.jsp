<%-- 
    Document   : agenda
    Created on : 15/04/2025, 10:37:16 p. m.
    Author     : nyath
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agenda</title>
    <link rel="stylesheet" href="../Estilos/styles.css"> <!-- Estilos -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"> <!-- Iconos -->
</head>
<body>
    <header class="header_pages"> <!-- header con el logo y los enlaces a las demás paginas -->
        <a href="inicio.html"><img src="../Img/Logo.jpeg" alt="Logo ALF" class="logo_pages"></a>
        <div class="list_pages">
            <ul>
                <li class = "actual_page"><a class = "a_actual_page">Agenda</a></li>
                <li><a href="empleados.jsp">Empleados</a></li>
                <li><a href="equipos.jsp">Equipo de trabajo</a></li>
                <li><a href="clientes.jsp">Clientes</a></li>
                <li><a href="valores.jsp">Varios</a></li>
            </ul>            
        </div>
        <a href="https://wa.me/573212300716" target="_blank">
            <i class="fa-solid fa-circle-question fa-3x question_icon" style="color: black;"></i> <!-- botón que envía a whatsapp ante dudas -->
        </a>
    </header>
    <div class="pages_div">
        <div>
            <form class="form_pages"> <!-- form con todos los datos -->
                <div class="form_display">
                    <label for="id_servicio">Código</label>
                    <input type="text" name="id_servicio" id="id_servicio">
                    <label for="cliente">Cliente</label>
                    <select name="cliente" id="cliente"></select>
                    <label for="direccion">Direccion</label>
                    <select name="direccion" id="direccion" disabled></select>
                    <label for="equipo">Equipo</label>
                    <select name="equipo" id="equipo"></select>
                    <label for="fecha">Fecha</label>
                    <input type="date" name="fecha" id="fecha">
                    <label for="hora">Hora</label>
                    <input type="time" name="hora" id="hora">
                    <label for="tipo_limpieza">Limpieza</label>
                    <select name="tipo_limpieza" id="tipo_limpieza"></select>
                    <label for="habitaciones">Habitaciones</label>
                    <input type="number" name="habitaciones" id="habitaciones">
                    <label for="baños">Baños</label>
                    <input type="number" name="baños" id="baños">
                    <label for="pasillos">Pasillos</label>
                    <input type="number" name="pasillos" id="pasillos">
                    <label for="pago">Valor a pagar</label>
                    <input type="number" name="pago" id="pago">
                    <label for="medio_pago">Medio de pago</label>
                    <select name="medio_pago" id="medio_pago"></select>
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
    <div id="modal"> <!-- modal para pedir la fecha del archivo de descarga -->
        <div>
          <h3>Selecciona una fecha</h3>
          <input type="date" id="fecha_descarga" />
          <br><br>
          <button id="descargar_modal">Aceptar</button>
          <button id="cerrar_modal">Cancelar</button>
        </div>
      </div>
</body>
<!--<script type="module" src="../Js/agenda.js"></script> <!-- scritp tipo modulo para que funciones indexedDB -->
</html>
