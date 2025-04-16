<%-- 
    Document   : valores
    Created on : 15/04/2025, 10:42:55 p. m.
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
                <li><a href="agenda.html">Agenda</a></li>
                <li><a href="empleados.html">Empleados</a></li>
                <li><a href="equipos.html">Equipo de trabajo</a></li>
                <li><a href="clientes.html">Clientes</a></li>
                <li class = "actual_page"><a class = "a_actual_page">Varios</a></li>
            </ul>            
        </div>
        <a href="https://wa.me/573212300716" target="_blank">
            <i class="fa-solid fa-circle-question fa-3x question_icon" style="color: black;"></i>
        </a>
    </header>
    <div class="pages_div">
        <div>            
            <form class="form_pages" id="tipo_identificacion">                
                <h2>Tipo de identificación</h2>
                <div class="form_display">
                    <label for="id_tipo_identificacion">Código</label>
                    <input type="text" name="id_tipo_identificacion" id="id_tipo_identificacion">
                    <label for="nombre">Nombre</label>
                    <input type="text" name="nombre" id="nombre">
                </div>
                <div>
                    <button type="submit" value="buscar">Buscar</button>
                    <button type="submit" value="crear/modificar">Crear / Modificar</button>
                    <button type="submit" value="descargar">Mostrar registros</button>
                    <button type="submit" value="eliminar">Eliminar</button>
                </div>
            </form>
        </div>
        <div>            
            <form class="form_pages" id="cargo">                
                <h2>Cargo</h2>
                <div class="form_display">
                    <label for="id_cargo">Código</label>
                    <input type="text" name="id_cargo" id="id_cargo">
                    <label for="nombre">Nombre</label>
                    <input type="text" name="nombre" id="nombre">
                </div>
                <div>
                    <button type="submit" value="buscar">Buscar</button>
                    <button type="submit" value="crear/modificar">Crear / Modificar</button>
                    <button type="submit" value="descargar">Mostrar registros</button>
                    <button type="submit" value="eliminar">Eliminar</button>
                </div>
            </form>
        </div>
        <div>            
            <form class="form_pages" id="tipo_limpieza">                
                <h2>Tipo de Limpieza</h2>
                <div class="form_display">
                    <label for="id_tipo_limpieza">Código</label>
                    <input type="text" name="id_tipo_limpieza" id="id_tipo_limpieza">
                    <label for="nombre">Nombre</label>
                    <input type="text" name="nombre" id="nombre">
                </div>
                <div>
                    <button type="submit" value="buscar">Buscar</button>
                    <button type="submit" value="crear/modificar">Crear / Modificar</button>
                    <button type="submit" value="descargar">Mostrar registros</button>
                    <button type="submit" value="eliminar">Eliminar</button>
                </div>
            </form>
        </div>
        <div>            
            <form class="form_pages" id="medio_pago">                
                <h2>Medios de pago</h2>
                <div class="form_display">
                    <label for="id_medio_pago">Código</label>
                    <input type="text" name="id_medio_pago" id="id_medio_pago">
                    <label for="nombre">Nombre</label>
                    <input type="text" name="nombre" id="nombre">
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
<!--<script type="module" src="../Js/valores.js"></script>-->
</html>
