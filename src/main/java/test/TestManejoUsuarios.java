
package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;

public class TestManejoUsuarios {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        //insert
        //Usuario usuarioNueva = new Usuario("angel", "1234");
        //usuarioDAO.insertar(usuarioNueva);
        
        //modificar 
        //Usuario usuarioActualizar = new Usuario(1, "Erick1 Donaldo", "324534");
        //usuarioDAO.actualizar(usuarioActualizar);
        //ELIMINAR
        Usuario usuarioEliminar = new Usuario(1);
        usuarioDAO.eliminar(usuarioEliminar);
        List<Usuario> usuarios = usuarioDAO.seleccionar();
        /*
        for (Usuario persona:personas){
            System.err.println(persona.toString());
        }
         */
        usuarios.forEach(usuario -> {
            System.out.println("Usuario: " + usuario.toString());
        });
    }
}
