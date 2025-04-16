package Servicios;

import javax.swing.JOptionPane;
import Clases.*;
import Servicios.*;
import Utils.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author nyath
 */
public class MenuManager {
    ClienteManager cl_manager = new ClienteManager();
    EquipoTrabajoManager eq_manager = new EquipoTrabajoManager();
    ServicioManager serv_manager = new ServicioManager();
    UsuarioManager user_manager = new UsuarioManager();
    VariosManager tipos_manager = new VariosManager();
    MostrarUtils mensajesUtil = new MostrarUtils();
    TimeUtils timeUtils = new TimeUtils();
    
    public void mostrarMenu(){
        //opciones
        String texto_interno = "Elige una opción";
        Object[] opciones = {"Servicios", "Clientes", "Usuarios", "Equipos", "Tipos", "Cerrar"};
        Object[] opciones_estandar = {"Crear", "Editar", "Eliminar", "Volver"};
        Object[] opciones_tipos = {"Tipo documento", "Tipo servicio", "Ver tipos de usuario", "Volver"};
        
        int seleccion = mensajesUtil.mostrarOpciones(opciones, texto_interno, "Menu");
        switch (seleccion) {
            case 0:
                int select_servicio = mensajesUtil.mostrarOpciones(opciones_estandar, texto_interno, "Servicio");
                switch (select_servicio) {
                    case 0:
                        creaEditOpt(seleccion, false, 0);
                        break;
                    case 1:
                        editarOpt(seleccion);
                        break;
                    case 2:
                        eliminarOpt(seleccion);
                        break;
                    case 3:
                        mostrarMenu();
                    default:
                        break;
                }
                break;
            case 1:
                int select_cliente = mensajesUtil.mostrarOpciones(opciones_estandar, texto_interno, "Cliente");
                switch (select_cliente) {
                    case 0:
                        creaEditOpt(seleccion, false, 0);
                        break;
                    case 1:
                        editarOpt(seleccion);
                        break;
                    case 2:
                        eliminarOpt(seleccion);
                        break;
                    case 3:
                        mostrarMenu();
                    default:
                        break;
                }
                break;
            case 2:
                int select_usuario = mensajesUtil.mostrarOpciones(opciones_estandar, texto_interno, "Usuario");
                switch (select_usuario) {
                    case 0:
                        creaEditOpt(seleccion, false, 0);
                        break;
                    case 1:
                        editarOpt(seleccion);
                        break;
                    case 2:
                        eliminarOpt(seleccion);
                        break;
                    case 3:
                        mostrarMenu();
                    default:
                        break;
                }
                break;
            case 3:
                int select_equipo = mensajesUtil.mostrarOpciones(opciones_estandar, texto_interno, "Equipo");
                switch (select_equipo) {
                    case 0:
                        creaEditOpt(seleccion, false, 0);
                        break;
                    case 1:
                        editarOpt(seleccion);
                        break;
                    case 2:
                        eliminarOpt(seleccion);
                        break;
                    case 3:
                        mostrarMenu();
                    default:
                        break;
                }
                break;
            case 4:
                int select_tipos = mensajesUtil.mostrarOpciones(opciones_tipos, texto_interno, "Tipos");
                switch (select_tipos) {
                    case 0: //documento
                        int select_tipo_doc = mensajesUtil.mostrarOpciones(opciones_estandar, texto_interno, "Tipo Documento");
                        if(select_tipo_doc == 0){ //crear
                            creaEditTipo(select_tipos, false, 0);
                            break;
                        } else if (select_tipo_doc == 1) { //editar
                            editarTipo(select_tipos);
                            break;
                        } else if (select_tipo_doc == 2) { //eliminar
                            eliminarTipo(select_tipos);
                            break;
                        } else if (select_tipo_doc == 3) { //regresar
                            mostrarMenu();
                        } else { //cerrar
                            break;
                        }
                    case 1: //servicio
                        int select_tipo_serv = mensajesUtil.mostrarOpciones(opciones_estandar, texto_interno, "Tipo Servicio");
                        if(select_tipo_serv == 0){ //crear
                            creaEditTipo(select_tipos, false, 0);
                            break;
                        } else if (select_tipo_serv == 1) { //editar
                            editarTipo(select_tipos);
                            break;
                        } else if (select_tipo_serv == 2) { //eliminar
                            eliminarTipo(select_tipos);
                            break;
                        } else if (select_tipo_serv == 3) { //regresar
                            mostrarMenu();
                        } else { //cerrar
                            break;
                        }                    
                    case 2: //empleado
                        mostrarTipoEmpleado();
                        break;
                    case 3:
                        mostrarMenu();
                    default:
                        break;
                }
                break;
            case 5:
                int exit_conf = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir?");
                if (exit_conf == JOptionPane.OK_OPTION){
                    break;
                } else {
                    mostrarMenu();
                }
            default:
                break;
        }
    }
    
    private void creaEditOpt (int type, boolean esEditar, int idEdit){
        if(type == 0){ //servicio
            Servicio serv = new Servicio();
            
            //id_cliente
            Cliente[] cl = cl_manager.getAllCliente();
            Object[] listaCl = new Object[cl.length];
            for(int i = 0; i < cl.length; i++){
                listaCl[i] = cl_manager.ClienteToString(cl[i]);
            }
            String seleccion_cliente = mensajesUtil.mostrarCombo(listaCl, "Cliente");
            for(int i = 0; i < cl.length; i++){
                if(seleccion_cliente.equals(cl_manager.ClienteToString(cl[i]))){
                    int cod = Integer.valueOf(cl[i].getCodigo());
                    serv.setId_cliente(cod);
                    break;
                }
            }
            //id_equipo
            EquipoTrabajo[] eq = eq_manager.getAllEquipo();
            Object[] listaEqTr = new Object[eq.length];
            for(int i = 0; i < eq.length; i++){
                listaEqTr[i] = eq[i].getNombre_equipo();
            }
            String seleccion_equipo = mensajesUtil.mostrarCombo(listaEqTr, "Equipo");
            for(int i = 0; i < eq.length; i++) {
                if(seleccion_equipo.equals(eq[i].getNombre_equipo())){
                    serv.setId_equipo(eq[i].getCodigo());
                    break;
                }
            }
            //id_tipoLimp
            Varios[] ti_li = tipos_manager.getAllTipoVarios("tipo_limpieza", "id_tipoLimp");
            Object[] listaTiLi = new Object[ti_li.length];
            for(int i = 0; i < ti_li.length; i++){
               listaTiLi[i] = ti_li[i].getNombre();
            }
            String seleccion_tipoLimp = mensajesUtil.mostrarCombo(listaTiLi, "Tipo Limpieza");
            for(int i = 0; i < ti_li.length; i++){
                if(seleccion_tipoLimp.equals(ti_li[i].getNombre())){
                    serv.setId_tipo_limp(ti_li[i].getCodigo());
                    break;
                }
            }
            //fecha
            DateTimeFormatter formato_fecha = DateTimeFormatter.ofPattern("dd/mm/yyyy");
            LocalDate fecha = null;
            
            while (fecha == null) {
                String input_date = JOptionPane.showInputDialog(null, "Ingrese la fecha del servicio");
                
                if(input_date == null) {
                    JOptionPane.showMessageDialog(null, "Cancelado");
                    mostrarMenu();
                }
                
                try {
                    fecha = LocalDate.parse(input_date, formato_fecha);
                    serv.setFecha(fecha);
                } catch (DateTimeParseException e){
                    JOptionPane.showMessageDialog(null, "Fecha invalida, intente de nuevo");
                }                
            }
            //hora
            DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime hora = null;
            
            while (hora == null){
                String input_hora = JOptionPane.showInputDialog(null, "Ingrese la hora del servicio");
                
                if(input_hora == null){
                    JOptionPane.showMessageDialog(null, "Cancelado");
                    mostrarMenu();
                }
                
                try {
                    hora = LocalTime.parse(input_hora, formatoHora);
                    serv.setHora(hora);
                } catch (DateTimeParseException e){
                    JOptionPane.showMessageDialog(null, "Hora invalida, intente de nuevo");
                }
            }
            //tiempo_estimado
            LocalTime hora_estimada = null;
            
            while (hora_estimada == null){
                String input_estimado = JOptionPane.showInputDialog(null, "Ingrese la hora del servicio");
                
                if(input_estimado == null){
                    JOptionPane.showMessageDialog(null, "Cancelado");
                    mostrarMenu();
                }
                
                try {
                    hora = LocalTime.parse(input_estimado, formatoHora);
                    serv.setTiempo_estimado(hora);
                } catch (DateTimeParseException e){
                    JOptionPane.showMessageDialog(null, "Hora invalida, intente de nuevo");
                }
            }
            //tiempo_finalizacion
            LocalTime hora_finalizacion = timeUtils.calcHoraFinalizacion(hora, hora_estimada);
            serv.setTiempo_finalizacion(hora_finalizacion);
            //precio
            int precio = -1;
            
            while (precio == -1){
                String preciotxt = JOptionPane.showInputDialog(null, "Ingrese el precio a pagar");
                
                if(preciotxt == null){
                    JOptionPane.showMessageDialog(null, "Cancelado");
                    mostrarMenu();
                }
                
                precio = Integer.parseInt(preciotxt);
                if (precio >= 0){                    
                    serv.setPrecio(precio);
                } else {
                    JOptionPane.showMessageDialog(null, "Precio invalido, intente de nuevo");
                    precio = -1;
                }                
            }
            //observacion
            String observacion = JOptionPane.showInputDialog(null, "Ingrese observaciones");
            
            if(observacion.isEmpty() || observacion == ""){
                serv.setObservacion("");
            } else {
                serv.setObservacion(observacion);
            }
            
            //crear - editar
            if(!esEditar){
                //user_crea
                serv.setUser_crea("Admin");

                //insertar
                boolean crea_serv = serv_manager.insertServicio(serv);
                if(crea_serv){
                    JOptionPane.showMessageDialog(null, "Creado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear");
                    mostrarMenu();
                }
            } else {
                //id
                serv.setId_servicio(idEdit);
                //user_modifica
                serv.setUser_modifica("Admin");
                //modificado_el
                serv.setModificado_el(timeUtils.getNowTime());
                
                //editar
                boolean edit_serv = serv_manager.modificarServicio(serv);
                if(edit_serv){
                    JOptionPane.showMessageDialog(null, "Editado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear");
                    mostrarMenu();
                }
            }
            
        } else if (type == 1) { //cliente
            Cliente cliente = new Cliente();
            
            //nombre_cliente
            String nombre_cliente = JOptionPane.showInputDialog(null, "Nombres del cliente");
            if (nombre_cliente == null){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            }
            cliente.setNombres(nombre_cliente);
            //apellido_cliente
            String apellidos_cliente = JOptionPane.showInputDialog(null, "Apellidos del cliente");
            if (apellidos_cliente == null){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            }
            cliente.setApellidos(apellidos_cliente);
            //direccion_cliente
            String direccion_cliente = JOptionPane.showInputDialog(null, "Direccion del cliente");
            if (direccion_cliente == null){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            }
            cliente.setDireccion(direccion_cliente);
            //telefono_cliente
            String telefono_cliente = JOptionPane.showInputDialog(null, "Telefono del cliente");
            if (telefono_cliente == null){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            }
            cliente.setTelefono(telefono_cliente);
            //correo_cliente
            String correo_cliente = JOptionPane.showInputDialog(null, "Correo electronico del cliente");
            if (correo_cliente == null){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            }
            cliente.setEmail(correo_cliente);
            //observacion_cliente
            String observacion_cliente = JOptionPane.showInputDialog(null, "Observaciones del cliente");
            if (observacion_cliente == null){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            }
            cliente.setObservaciones(observacion_cliente);
            
            //crear - editar
            if(!esEditar){
                //user_crea
                cliente.setUser_crea("Admin");

                //insertar
                boolean crea_cl = cl_manager.insertCliente(cliente);
                if(crea_cl){
                    JOptionPane.showMessageDialog(null, "Creado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear");
                    mostrarMenu();
                }            
            } else {
                //id
                cliente.setCodigo(String.valueOf(idEdit));
                //user modifica
                cliente.setUser_modifica("Admin");
                //modificado el
                cliente.setModificado_el(timeUtils.getNowTime());
                
                //editar
                boolean edit_cl = cl_manager.modificarCliente(cliente);
                if(edit_cl) {
                    JOptionPane.showMessageDialog(null, "Editado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear");
                    mostrarMenu();
                }
            }
            
        } else if (type == 2) { //usuarios
            Usuario user = new Usuario();
            
            //id_tipoUsua
            Varios[] ti_us = tipos_manager.getAllTipoVarios("tipo_usuario", "id_tipoUsua");
            Object[] listaTi_us = new Object[ti_us.length];
            for(int i = 0; i < ti_us.length; i++){
               listaTi_us[i] = ti_us[i].getNombre();
            }
            String seleccion_tipoUser = mensajesUtil.mostrarCombo(listaTi_us, "Tipo Usuario");
            for(int i = 0; i < ti_us.length; i++){
                if(seleccion_tipoUser.equals(ti_us[i].getNombre())){
                    user.setTipo_user(ti_us[i].getCodigo());
                    break;
                }
            }
            //nombre_usuario
            String user_name = JOptionPane.showInputDialog(null, "Usuario");
            if (user_name == null){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            }
            user.setUser(user_name);
            //contraseña
            String pass_user = JOptionPane.showInputDialog(null, "Contraseña del usuario");
            if (pass_user == null){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            }
            user.setPassword(pass_user);
            //id_tipoDocu
            Varios[] ti_do = tipos_manager.getAllTipoVarios("tipo_documento", "id_tipoDocu");
            Object[] listaTi_do = new Object[ti_do.length];
            for(int i = 0; i < ti_do.length; i++){
               listaTi_do[i] = ti_do[i].getNombre();
            }
            String seleccion_tipoDocu = mensajesUtil.mostrarCombo(listaTi_do, "Tipo Documento");
            for(int i = 0; i < ti_do.length; i++){
                if(seleccion_tipoDocu.equals(ti_do[i].getNombre())){
                    user.setTipo_docu(ti_do[i].getCodigo());
                    break;
                }
            }
            //documento_usuario
            String documento = JOptionPane.showInputDialog(null, "Documento del usuario");
            if (documento == null){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            }
            user.setDocumento(documento);
            //nombres
            String nombres = JOptionPane.showInputDialog(null, "Nombres del usuario");
            if (nombres == null){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            }
            user.setNombres(nombres);
            //apellidos
            String apellidos = JOptionPane.showInputDialog(null, "Apellidos del usuario");
            if (apellidos == null){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            }
            user.setApellidos(apellidos);
            //telefono_usuario
            String telefono_usuario = JOptionPane.showInputDialog(null, "Telefono del usuario");
            if (telefono_usuario == null){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            }
            user.setTelefono(telefono_usuario);
            //correo_usuario
            String correo_usuario = JOptionPane.showInputDialog(null, "Correo electronico del usuario");
            if (correo_usuario == null){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            }
            user.setEmail(correo_usuario);
            
            //crear - editar
            if(!esEditar) {
                //user_crea
                user.setUser("Admin");            
            
                boolean crea_user = user_manager.insertUsuario(user);
                if (crea_user) {
                    JOptionPane.showMessageDialog(null, "Creado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear");
                    mostrarMenu();
                }
            } else {
                //id
                user.setCodigo(String.valueOf(idEdit));
                //user_modifica
                user.setUser_modifica("Admin");
                //modificado_el
                user.setModificado_el(timeUtils.getNowTime());
                
                //editar
                boolean edit_user = user_manager.modificarUsuario(user);
                if (edit_user) {
                    JOptionPane.showMessageDialog(null, "Editado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear");
                    mostrarMenu();
                }                
            }
            
        } else if (type == 3) { //equipo
            EquipoTrabajo equi = new EquipoTrabajo();
            
            //nombre_equipo
            String nombre_equipo = JOptionPane.showInputDialog(null, "Nombre del equipo");
            if (nombre_equipo == null){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            }
            equi.setNombre_equipo(nombre_equipo);
            
            if(!esEditar){
                //user_crea
                equi.setUser_crea("Admin");
            } else {
                //user_modifica
                equi.setUser_modifica("Admin");
                //modificado_el
                equi.setModificado_el(timeUtils.getNowTime());
            }
            
            //lider
            Usuario[] usuarios = user_manager.getAllUsuario();
            Object[] listaUsuario = new Object[usuarios.length];
            for(int i = 0; i < listaUsuario.length; i++){
               listaUsuario[i] = user_manager.UsuarioToString(usuarios[i]);
            }
            String select_lider = mensajesUtil.mostrarCombo(listaUsuario, "Lider");
            for(int i = 0; i < listaUsuario.length; i++){
                if(select_lider.equals(user_manager.UsuarioToString(usuarios[i]))){
                    equi.setLider(usuarios[i].getCodigo());
                    break;
                }
            }
            //miembro1
            String select_miembro1 = mensajesUtil.mostrarCombo(listaUsuario, "Miembro 1");
            for(int i = 0; i < listaUsuario.length; i++){
                if(select_miembro1.equals(user_manager.UsuarioToString(usuarios[i]))){
                    equi.setMiembro1(usuarios[i].getCodigo());
                    break;
                }
            }
            //miembro2
            String select_miembro2 = mensajesUtil.mostrarCombo(listaUsuario, "Miembro 2");
            for(int i = 0; i < listaUsuario.length; i++){
                if(select_miembro2.equals(user_manager.UsuarioToString(usuarios[i]))){
                    equi.setMiembro1(usuarios[i].getCodigo());
                    break;
                }
            }
            
            //crear - editar
            if(!esEditar){
                boolean crea_equipo = eq_manager.insertEquipo(equi);
                if (crea_equipo) {
                    JOptionPane.showMessageDialog(null, "Creado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear");
                    mostrarMenu();
                }
            } else {
                boolean edit_equipo = eq_manager.modificarEquipo(equi);
                if (edit_equipo) {
                    JOptionPane.showMessageDialog(null, "Editado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear");
                    mostrarMenu();
                }
            }
        }
    }
    
    private void editarOpt (int type){
        if(type == 0){//servicio
            Servicio[] servicio = serv_manager.getAllServicio();
            String[] Columnas = {"ID", "Cliente", "Equipo", "Tipo limpieza", "Fecha", "Hora", "Tiempo estimado", "Hora finalizacion", "Precio", "Observaciones", "Creado por", "Creado el", "Modificado por", "Modificado el"};
            Object[][] datos_tabla = serv_manager.toTableObject(servicio);
            Object editar = mensajesUtil.crearTabla(Columnas, datos_tabla, "Seleccione el item a editar", 900, 500);
            if(editar.equals(-1)){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            } else {
                creaEditOpt(type, true, Integer.parseInt((String)editar));
            }
        } else if (type == 1){ //cliente
            Cliente[] clientes = cl_manager.getAllCliente();
            String[] Columnas = {"ID", "Nombres", "Apellidos", "Direccion", "Telefono", "Correo electronico", "Observaciones", "Creado por", "Creado el", "Modificado por", "Modificado el"};
            Object[][] datos_tabla = cl_manager.toTableObject(clientes);
            Object editar = mensajesUtil.crearTabla(Columnas, datos_tabla, "Seleccione el item a editar", 900, 500);
            if(editar.equals(-1)){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            } else {
                creaEditOpt(type, true, Integer.parseInt((String)editar));
            }
        } else if (type == 2) { //usuarios
            Usuario[] usuarios = user_manager.getAllUsuario();
            String[] Columnas = {"ID", "Tipo Usuario", "Usuario", "Contraseña", "Tipo documento", "Documento", "Nombres", "Apellidos", "Telefono", "Correo electronico", "Creado por", "Creado el", "Modificado por", "Modificado el"};
            Object[][] datos_tabla = user_manager.toTableObject(usuarios);
            Object editar = mensajesUtil.crearTabla(Columnas, datos_tabla, "Seleccione el item a editar", 900, 500);
            if(editar.equals(-1)){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            } else {
                creaEditOpt(type, true, Integer.parseInt((String)editar));
            }
        } else if (type == 3) { //equipo
            EquipoTrabajo[] equipos = eq_manager.getAllEquipo();
            String[] Columnas = {"ID", "Nombre", "Lider", "Miembro", "Miembro", "Creado por", "Creado el", "Modificado por", "Modificado el"};
            Object[][] datos_tabla = eq_manager.toTableObject(equipos);
            Object editar = mensajesUtil.crearTabla(Columnas, datos_tabla, "Seleccione el item a editar", 900, 500);
            if(editar.equals(-1)){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            } else {
                creaEditOpt(type, true, Integer.parseInt((String)editar));
            }
        }
    }
    
    private void eliminarOpt (int type) {
        if(type == 0) {//servicio
            Servicio[] servicio = serv_manager.getAllServicio();
            String[] Columnas = {"ID", "Cliente", "Equipo", "Tipo limpieza", "Fecha", "Hora", "Tiempo estimado", "Hora finalizacion", "Precio", "Observaciones", "Creado por", "Creado el", "Modificado por", "Modificado el"};
            Object[][] datos_tabla = serv_manager.toTableObject(servicio);
            Object eliminar = mensajesUtil.crearTabla(Columnas, datos_tabla, "Seleccione el item a eliminar", 900, 500);
            if(eliminar.equals(-1)){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            } else {
                boolean elim = serv_manager.eliminarServicio(Integer.parseInt((String) eliminar));
                if (elim) {
                    JOptionPane.showMessageDialog(null, "Eliminado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                    mostrarMenu();
                }
            }
        } else if (type == 1){ //cliente
            Cliente[] clientes = cl_manager.getAllCliente();
            String[] Columnas = {"ID", "Nombres", "Apellidos", "Direccion", "Telefono", "Correo electronico", "Observaciones", "Creado por", "Creado el", "Modificado por", "Modificado el"};
            Object[][] datos_tabla = cl_manager.toTableObject(clientes);
            Object eliminar = mensajesUtil.crearTabla(Columnas, datos_tabla, "Seleccione el item a eliminar", 900, 500);
            if(eliminar.equals(-1)){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            } else {
                boolean elim = cl_manager.eliminarCliente(Integer.parseInt((String) eliminar));
                if (elim) {
                    JOptionPane.showMessageDialog(null, "Eliminado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                    mostrarMenu();
                }
            }
        } else if (type == 2) { //usuarios
            Usuario[] usuarios = user_manager.getAllUsuario();
            String[] Columnas = {"ID", "Tipo Usuario", "Usuario", "Contraseña", "Tipo documento", "Documento", "Nombres", "Apellidos", "Telefono", "Correo electronico", "Creado por", "Creado el", "Modificado por", "Modificado el"};
            Object[][] datos_tabla = user_manager.toTableObject(usuarios);
            Object eliminar = mensajesUtil.crearTabla(Columnas, datos_tabla, "Seleccione el item a eliminar", 900, 500);
            if(eliminar.equals(-1)){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            } else {
                boolean elim = user_manager.eliminarUsuario((String) eliminar);
                if (elim) {
                    JOptionPane.showMessageDialog(null, "Eliminado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                    mostrarMenu();
                }
            }
        } else if (type == 3) { //equipo
            EquipoTrabajo[] equipos = eq_manager.getAllEquipo();
            String[] Columnas = {"ID", "Nombre", "Lider", "Miembro", "Miembro", "Creado por", "Creado el", "Modificado por", "Modificado el"};
            Object[][] datos_tabla = eq_manager.toTableObject(equipos);
            Object eliminar = mensajesUtil.crearTabla(Columnas, datos_tabla, "Seleccione el item a editar", 900, 500);
            if(eliminar.equals(-1)){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            } else {
                boolean elim = eq_manager.eliminarEquipo(Integer.parseInt((String) eliminar));
                if (elim) {
                    JOptionPane.showMessageDialog(null, "Eliminado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                    mostrarMenu();
                }
            }
        }
    }
    
    private void creaEditTipo (int type, boolean esEditar, int idEdit){
        if(type == 0) { //tipo documento
            Varios tipo_docu = new Varios();
            String tabla_name = "tipo_documento";
            String id_name = "id_tipoDocu";
            //nombre tipo
            String nombre_tipo = JOptionPane.showInputDialog(null, "Nombre tipo de documento");
            if (nombre_tipo == null){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            }
            tipo_docu.setNombre(nombre_tipo);
            
            if(!esEditar){
                //user crea
                tipo_docu.setUser_crea("Admin");
                    
                //insertar
                boolean insert = tipos_manager.insertTipoVarios(tabla_name, tipo_docu);
                if(insert){
                    JOptionPane.showMessageDialog(null, "Creado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear");
                    mostrarMenu();
                }
            } else {
                //id
                tipo_docu.setCodigo(idEdit);
                //user modifica
                tipo_docu.setUser_modifica("Admin");
                //fecha modificado
                tipo_docu.setModificado_el(timeUtils.getNowTime());
                
                //editar
                boolean modify = tipos_manager.modificarTipoVarios(tabla_name, id_name, tipo_docu);
                if(modify){
                    JOptionPane.showMessageDialog(null, "Creado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear");
                    mostrarMenu();
                }
            }
            
        } else if (type == 1) { //tipo servicio
            Varios tipo_limpieza = new Varios();
            String tabla_name = "tipo_limpieza";
            String id_name = "id_tipoLimp";
            //nombre tipo
            String nombre_tipo = JOptionPane.showInputDialog(null, "Nombre tipo de servicio");
            if (nombre_tipo == null){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            }
            tipo_limpieza.setNombre(nombre_tipo);
            
            if(!esEditar){
                //user crea
                tipo_limpieza.setUser_crea("Admin");
                    
                //insertar
                boolean insert = tipos_manager.insertTipoVarios(tabla_name, tipo_limpieza);
                if(insert){
                    JOptionPane.showMessageDialog(null, "Creado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear");
                    mostrarMenu();
                }
            } else {
                //id
                tipo_limpieza.setCodigo(idEdit);
                //user modifica
                tipo_limpieza.setUser_modifica("Admin");
                //fecha modificado
                tipo_limpieza.setModificado_el(timeUtils.getNowTime());
                
                //editar
                boolean modify = tipos_manager.modificarTipoVarios(tabla_name, id_name, tipo_limpieza);
                if(modify){
                    JOptionPane.showMessageDialog(null, "Creado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear");
                    mostrarMenu();
                }
            }
        }
    }
    
    private void editarTipo (int type){
        if(type == 0) { //tipo documento
            String tabla_name = "tipo_documento";
            String id_name = "id_tipoDocu";
            String colum_name = "Tipo documento";
            Varios[] tipo_docu = tipos_manager.getAllTipoVarios(tabla_name, id_name);
            String[] Columnas = {"ID", colum_name, "Creado por", "Creado el", "Modificado por", "Modificado el"};
            Object[][] datos_tabla = tipos_manager.toTableObject(tipo_docu);
            Object editar = mensajesUtil.crearTabla(Columnas, datos_tabla, "Seleccione el item a editar", 900, 500);
            if(editar.equals(-1)){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            } else {
                creaEditTipo(type, true, Integer.parseInt((String)editar));
            }
        } else if (type == 1) { //tipo servicio
            String tabla_name = "tipo_limpieza";
            String id_name = "id_tipoLimp";
            String colum_name = "Tipo limpieza";
            Varios[] tipo_docu = tipos_manager.getAllTipoVarios(tabla_name, id_name);
            String[] Columnas = {"ID", colum_name, "Creado por", "Creado el", "Modificado por", "Modificado el"};
            Object[][] datos_tabla = tipos_manager.toTableObject(tipo_docu);
            Object editar = mensajesUtil.crearTabla(Columnas, datos_tabla, "Seleccione el item a editar", 900, 500);
            if(editar.equals(-1)){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            } else {
                creaEditTipo(type, true, Integer.parseInt((String)editar));
            }
        }
    }
    
    private void eliminarTipo (int type) {
        if(type == 0) { //tipo documento
            String tabla_name = "tipo_documento";
            String id_name = "id_tipoDocu";
            String colum_name = "Tipo documento";
            Varios[] tipo_docu = tipos_manager.getAllTipoVarios(tabla_name, id_name);
            String[] Columnas = {"ID", colum_name, "Creado por", "Creado el", "Modificado por", "Modificado el"};
            Object[][] datos_tabla = tipos_manager.toTableObject(tipo_docu);
            Object eliminar = mensajesUtil.crearTabla(Columnas, datos_tabla, "Seleccione el item a eliminar", 900, 500);
            if(eliminar.equals(-1)){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            } else {
                boolean elim = tipos_manager.eliminarTipoVarios(tabla_name, id_name, Integer.parseInt((String)eliminar));
                if(elim) {
                    JOptionPane.showMessageDialog(null, "Eliminado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                    mostrarMenu();
                }
            }
        } else if (type == 1) { //tipo servicio
            String tabla_name = "tipo_limpieza";
            String id_name = "id_tipoLimp";
            String colum_name = "Tipo limpieza";
            Varios[] tipo_docu = tipos_manager.getAllTipoVarios(tabla_name, id_name);
            String[] Columnas = {"ID", colum_name, "Creado por", "Creado el", "Modificado por", "Modificado el"};
            Object[][] datos_tabla = tipos_manager.toTableObject(tipo_docu);
            Object eliminar = mensajesUtil.crearTabla(Columnas, datos_tabla, "Seleccione el item a editar", 900, 500);
            if(eliminar.equals(-1)){
                JOptionPane.showMessageDialog(null, "Cancelado");
                mostrarMenu();
            } else {
                boolean elim = tipos_manager.eliminarTipoVarios(tabla_name, id_name, Integer.parseInt((String)eliminar));
                if(elim) {
                    JOptionPane.showMessageDialog(null, "Eliminado con exito");
                    mostrarMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                    mostrarMenu();
                }
            }
        }
    }
    
    private void mostrarTipoEmpleado () {
        Varios[] tipo_docu = tipos_manager.getAllTipoVarios("tipo_usuario", "id_tipoUsua");
        String[] Columnas = {"ID", "Tipo usuario", "Creado por", "Creado el", "Modificado por", "Modificado el"};
        Object[][] datos_tabla = tipos_manager.toTableObject(tipo_docu);
        Object mostrar = mensajesUtil.crearTabla(Columnas, datos_tabla, "Tipos de usuario", 900, 500);
        System.out.println(mostrar);
        mostrarMenu();
    }
}
