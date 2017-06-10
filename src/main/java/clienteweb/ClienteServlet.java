package clienteweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns={"/cliente", "/clienteServlet", "/clienteController"})
public class ClienteServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Chamou pelo m�todo GET");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//System.out.println("Chamou pelo m�todo POST");
		resp.setCharacterEncoding("UTF-8");            //Modifica a codifica��o de caracteres para reconhecer o acento ortogr�fico
		resp.getWriter().print("Chamou pelo m�todo POST"); //Esse m�todo envia mensagem de texto para o navegador do cliente.
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
	}

}
