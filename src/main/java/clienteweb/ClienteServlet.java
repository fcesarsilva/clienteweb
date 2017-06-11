package clienteweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadesistemas.model.Cliente;


@WebServlet(urlPatterns={"/cliente", "/clienteServlet", "/clienteController"})
public class ClienteServlet extends HttpServlet {
	
	List<Cliente> lista = new ArrayList<>();
	
	public ClienteServlet() {
		System.out.println("Construindo construtor...");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamando o Servlet");
		super.service(req, resp);
	}
	
	
	@Override
	public void init() throws ServletException {
		System.out.println("Inicializando o Servlet...");
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp"); //Encaminha a requisi��o a p�gina .jsp que est� como par�metro.
		
		req.setAttribute("lista", lista);
		
		dispatcher.forward(req, resp);//Faz o encaminhamento do fluxo, o request e o response
		resp.setCharacterEncoding("UTF-8");
		
		
		//System.out.println("Chamou pelo m�todo GET");// Para ter certeza que a requisi��o estava chegando at� este ponto.
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Recebendo email
		String email = req.getParameter("email"); //A vari�vel email recebe as informa��es passadas pela vari�vel email enviada pelo http request
		//System.out.println("Chamou pelo m�todo POST");
		
		//Associando o email ao cliente
		Cliente cli = new Cliente();
		cli.setEmail(email);
		
		//Lista de clientes
		lista.add(cli);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp"); //Encaminha a requisi��o a p�gina .jsp que est� como par�metro.
		req.setAttribute("msg", "Salvo com sucesso!");
		req.setAttribute("lista", lista);
		
		dispatcher.forward(req, resp);//Faz o encaminhamento do fluxo, o request e o response
		
		//resp.sendRedirect("cliente"); //Redireciona o browser � solicitar uma nova p�gina pelo doGET.
		
		//resp.setCharacterEncoding("UTF-8"); //Modifica a codifica��o de caracteres para reconhecer o acento ortogr�fico
		//resp.getWriter().print("Chamou pelo m�todo POST enviando o e-mail: " + email + "!"); //Esse m�todo envia mensagem de texto para o navegador do cliente.
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet Destruido...");
		super.destroy();
	}
	
	

}
