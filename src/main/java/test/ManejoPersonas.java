package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.PersonaDTO;
import java.util.*;
import datos.PersonaDaoJDBC;
import java.sql.*;


public class ManejoPersonas {

    public static void main(String[] args) {

        //insert
        //Persona personaNueva = new PersonaDTO("Angel", "Lopez", "sfdksd@gmail.com", "765723673");
        //personaDAO.insertar(personaNueva);
        //modificar 
        //Persona personaActualizar = new PersonaDTO(1, "Erick1 Donaldo", "Manzano", "cronos@gmail.com", "765723673");
        //personaDAO.actualizar(personaActualizar);
        //ELIMINAR
        //Persona personaEliminar = new PersonaDTO(1);
        //personaDAO.eliminar(personaEliminar
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            PersonaDAO personaDAO = new PersonaDaoJDBC(conexion);
            /*
            PersonaDTO persona = new PersonaDTO();
            persona.setIdPersona(3);
            persona.setNombre("Juan");
            persona.setApellido("tavera");
            persona.setEmail("sfdksd@gmail.com");
            persona.setTelefono("34534534534");
            personaJDBC.update(persona);

            PersonaDTO personainsert = new PersonaDTO();
            personainsert.setNombre("Juan");
            personainsert.setApellido("manza");
            personainsert.setEmail("sfdksd@gmail.com");
            personainsert.setTelefono("34534534534");
            personaJDBC.insert(personainsert);
            conexion.commit();
             */
            List<PersonaDTO> personas = personaDAO.select();
            /*
                for (PersonaDTO persona:personas){
                    System.err.println(persona.toString());
                }
             */
            personas.forEach(persona -> {
                System.out.println("PersonaDTO: " + persona);
            });
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entra al rollback");
            try {
                conexion.rollback();

            } catch (SQLException ex2) {
                ex2.printStackTrace(System.out);
            }
        }

    }

}
