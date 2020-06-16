package pe.edu.upeu.pw001.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.upeu.pw001.dao.UsuarioDao;
import pe.edu.upeu.pw001.daoImp.UsuarioDaoImp;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/lc")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDao dao = new UsuarioDaoImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();		
		//out.print(request.getParameter("user")+"/"+request.getParameter("pass"));
		String user, pass;
		user = request.getParameter("user");
		pass = request.getParameter("pass");
		if(dao.validarUsuario(user, pass)==1) {
			//out.print("Bienvenido: "+user);
			out.print(1);
		}else {
			out.print(0);
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
