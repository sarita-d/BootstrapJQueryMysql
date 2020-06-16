package pe.edu.upeu.pw001.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.pw001.dao.UsuarioDao;
import pe.edu.upeu.pw001.daoImp.UsuarioDaoImp;
import pe.edu.upeu.pw001.entity.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/uc")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson g = new Gson();
	private UsuarioDao udao = new UsuarioDaoImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int op = 0;
		String a = "0";
		if(request.getParameter("op")!=null) {
			try {
				a = request.getParameter("op");
				op = Integer.parseInt(a);
			
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Error: "+e);
			}
		}else {
			out.print("Error");
		}		
		switch (op) {
		case 1://registrar nuevo usuario
			String user = request.getParameter("nombre");
			String clave = request.getParameter("clave");
			if(udao.createUser(new Usuario(0,user,clave))>=1) {
				out.print("Usuario Creado...!");
			}else {
				out.print("Error al crear Usuario...!");
			}
			break;
		case 2://buscar usuario	
			Usuario s = udao.buscarUser(request.getParameter("nombre"));
			if(s.getIdusuario()>0) {
				out.print(g.toJson(udao.buscarUser(request.getParameter("nombre"))));
			}else {
				out.print(g.toJson("Usuario no existe"));
			}
			break;

		default:
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
