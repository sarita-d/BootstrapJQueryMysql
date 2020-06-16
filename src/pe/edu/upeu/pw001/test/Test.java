package pe.edu.upeu.pw001.test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import pe.edu.upeu.pw001.dao.UsuarioDao;
import pe.edu.upeu.pw001.daoImp.UsuarioDaoImp;
import pe.edu.upeu.pw001.entity.Usuario;
import pe.edu.upeu.pw001.utils.Conexion;

public class Test {
	static List<Usuario> lista = new ArrayList<>();
	static UsuarioDao udao = new UsuarioDaoImp();
	static  Gson g = new Gson();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//conex();
		//lista();
		//crear();
		//buscar();
		validar();
	}
  static void conex() {
	  if(Conexion.getConex()!=null) {
		  System.out.println("Conectado");
	  }else {
		 System.out.println("Desconectado"); 
	  }	  
  }
  static void lista() {
	 
	  
	  lista = udao.readAll();
	  for(int i=0;i<lista.size();i++) {
		  System.out.println(lista.get(i).getIdusuario()+"\t"+lista.get(i).getNomuser()+"\t"+lista.get(i).getClave());
	  }
	  
	 System.out.println(g.toJson(udao.readAll()));
	  
  }
  static void crear() {
	  if(udao.createUser(new Usuario(0,"jonas","jonas"))>=1) {
		  System.out.println("usuario creado...!");
	  }else {
		  System.out.println("Error al crear usuario");
	  }
  }
  static void buscar() {
	  Usuario u = udao.buscarUser("josue");
	  System.out.println(g.toJson(u));
  }
  static void validar() {
	  if(udao.validarUsuario("sarita", "12345")==1) {
		  System.out.println(1);
	  }else {
		  System.out.println(0);
	  }
  }
}
