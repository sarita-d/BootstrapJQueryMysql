package pe.edu.upeu.pw001.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.pw001.dao.UsuarioDao;
import pe.edu.upeu.pw001.entity.Usuario;
import pe.edu.upeu.pw001.utils.Conexion;

public class UsuarioDaoImp implements UsuarioDao{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conex;
	@Override
	public int validarUsuario(String user, String clave) {
		// TODO Auto-generated method stub
		int x = 0;
		try {
			conex = Conexion.getConex();
			ps = conex.prepareStatement("select *from usuario where nomuser=? and clave=?");
			ps.setString(1, user);
			ps.setString(2, clave);
			rs = ps.executeQuery();
			while(rs.next()) {
				x = 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		List<Usuario> lista = new ArrayList<>();
		try {
			conex = Conexion.getConex();
			ps = conex.prepareStatement("SELECT * FROM usuario");
			rs = ps.executeQuery();
			while(rs.next()) {
				Usuario user = new Usuario();
				user.setIdusuario(rs.getInt("idusuario"));
				user.setNomuser(rs.getString("nomuser"));
				user.setClave(rs.getString("clave"));
				lista.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return lista;
	}

	@Override
	public int createUser(Usuario u) {
		// TODO Auto-generated method stub
		int x = 0;
		try {
			conex = Conexion.getConex();
			ps = conex.prepareStatement("INSERT INTO usuario (nomuser, clave) VALUES (?,?)");
			ps.setString(1, u.getNomuser());
			ps.setString(2, u.getClave());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public Usuario buscarUser(String name) {
		// TODO Auto-generated method stub
		Usuario u = new Usuario();
		try {
			conex = Conexion.getConex();
			ps = conex.prepareStatement("SELECT * FROM usuario where nomuser=?");
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {				
				u.setIdusuario(rs.getInt("idusuario"));
				u.setNomuser(rs.getString("nomuser"));
				u.setClave(rs.getString("clave"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return u;
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
