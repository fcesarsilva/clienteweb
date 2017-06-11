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
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp"); //Encaminha a requisição a página .jsp que está como parâmetro.
		
		req.setAttribute("lista", lista);
		
		dispatcher.forward(req, resp);//Faz o encaminhamento do fluxo, o request e o response
		resp.setCharacterEncoding("UTF-8");
		
		
		//System.out.println("Chamou pelo método GET");// Para ter certeza que a requisição estava chegando até este ponto.
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Recebendo email
		String email = req.getParameter("email"); //A variável email recebe as informações passadas pela variável email enviada pelo http request
		//System.out.println("Chamou pelo método POST");
		
		//Associando o email ao cliente
		Cliente cli = new Cliente();
		cli.setEmail(email);
		
		//Lista de clientes
		lista.add(cli);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp"); //Encaminha a requisição a página .jsp que está como parâmetro.
		req.setAttribute("msg", "Salvo com sucesso!");
		req.setAttribute("lista", lista);
		
		dispatcher.forward(req, resp);//Faz o encaminhamento do fluxo, o request e o response
		
		//resp.sendRedirect("cliente"); //Redireciona o browser à solicitar uma nova página pelo doGET.
		
		//resp.setCharacterEncoding("UTF-8"); //Modifica a codificação de caracteres para reconhecer o acento ortográfico
		//resp.getWriter().print("Chamou pelo método POST enviando o e-mail: " + email + "!"); //Esse método envia mensagem de texto para o navegador do cliente.
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//???
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//???
		
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet Destruido...");
		super.destroy();
	}
	
	

}
