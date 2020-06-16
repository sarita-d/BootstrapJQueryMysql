package pe.edu.upeu.pw001.dao;

import java.util.List;

import pe.edu.upeu.pw001.entity.Usuario;



public interface UsuarioDao {
	int validarUsuario(String user, String clave);
	List<Usuario> readAll();
	int createUser(Usuario u);
	Usuario buscarUser(String name);
	int deleteUser(int id);
}
