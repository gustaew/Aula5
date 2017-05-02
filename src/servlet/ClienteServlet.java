package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Cliete;
import Service.ClienteService;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/crudClientes")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String botao = request.getParameter("botao");
		ClienteService servico = new ClienteService();
		Cliente cliente = new Cliente();
		PrintWriter saida = response.getWriter();
		response.setContentType("text/html");

			switch (botao) {

			case "Cadastrar": {

				String nome = request.getParameter("nomeCliente");
				String email = request.getParameter("emailCliente");

				cliente.setNome(nome);
				cliente.setEmail(email);
				cliente.setId(servico.cadastrarCliente(cliente));
				
				saida.println("<!DOCTYPE html>"
						+"<html>"
						+"<head>"
						+"<meta charset=ISO-8859-1>"
						+"<title>Cadastro Cliente</title>"
						+"  <script>"
						+"	function voltar(){"
						+"		window.history.back();"
						+"	}"
						+" </script>"
						+"</head>"
						+"<body>"
						+"	<br>"
						+"	<br>"
						+"	<div>Cliente cadastrado com sucesso</div>"
						+"	<br>"
						+"	<br>"
						+"	<div>Id do Cliente: " + cliente.getId() + "</div>"
						+"	<br>"
						+"	<br>"
						+"	<button type='button' onClick='voltar()'>Voltar</button>"
						+"</body>"
						+"</html>");	
				break;
			}

			case "Consultar": {

				
				if(!request.getParameter("idCliente").isEmpty()){
					int id = Integer.parseInt(request.getParameter("idCliente"));
					cliente = servico.consultarCliente(id);
				}
					
					if(!cliente.verificaCliente()){
						
						saida.println("<!DOCTYPE html>"
								+"<html>"
								+"<head>"
								+"<meta charset=ISO-8859-1>"
								+"<title>Consultar Cliente</title>"
								+"  <script>"
								+"	function voltar(){"
								+"		window.history.back();"
								+"	}"
								+" </script>"
								+"</head>"
								+"<body>"
								+"	<br>"
								+"	<br>"
								+"	<div>Dados do Cliente: </div>"
								+"	<br>"
								+"	<br>"
								+"	<div>ID: " + cliente.getId() + " Nome: " + cliente.getNome() + " Email: " + cliente.getEmail() + "</div>"
								+"	<br>"
								+"	<br>"
								+"	<button type='button' onClick='voltar()'>Voltar</button>"
								+"</body>"
								+"</html>");		
					} else {

						saida.println("<!DOCTYPE html>"
								+"<html>"
								+"<head>"
								+"<meta charset=ISO-8859-1>"
								+"<title>Consultar Cliente</title>"
								+"  <script>"
								+"	function voltar(){"
								+"		window.history.back();"
								+"	}"
								+" </script>"
								+"</head>"
								+"<body>"
								+"	<br>"
								+"	<br>"
								+"	<div>Dados do Cliente não encontrado! </div>"
								+"	<br>"
								+"	<br>"
								+"	<button type='button' onClick='voltar()'>Voltar</button>"
								+"</body>"
								+"</html>");	
					}
					
				break;
			}

			case "Excluir": {
				
				if(!request.getParameter("idCliente").isEmpty()){
					int id = Integer.parseInt(request.getParameter("idCliente"));
					
					if(servico.excluirCliente(id)){
						

						saida.println("<!DOCTYPE html>"
								+"<html>"
								+"<head>"
								+"<meta charset=ISO-8859-1>"
								+"<title>Consultar Cliente</title>"
								+"  <script>"
								+"	function voltar(){"
								+"		window.history.back();"
								+"	}"
								+" </script>"
								+"</head>"
								+"<body>"
								+"	<br>"
								+"	<br>"
								+"	<div>Cliente com ID: " + id + " removido com sucesso!</div>"
								+"	<br>"
								+"	<br>"
								+"	<button type='button' onClick='voltar()'>Voltar</button>"
								+"</body>"
								+"</html>");
						
					} else {

						saida.println("<!DOCTYPE html>"
								+"<html>"
								+"<head>"
								+"<meta charset=ISO-8859-1>"
								+"<title>Consultar Cliente</title>"
								+"  <script>"
								+"	function voltar(){"
								+"		window.history.back();"
								+"	}"
								+" </script>"
								+"</head>"
								+"<body>"
								+"	<br>"
								+"	<br>"
								+"	<div>Cliente com ID: " + id +" não existe! </div>"
								+"	<br>"
								+"	<br>"
								+"	<button type='button' onClick='voltar()'>Voltar</button>"
								+"</body>"
								+"</html>");
					}
					
				} else {
					
					saida.println("<!DOCTYPE html>"
							+"<html>"
							+"<head>"
							+"<meta charset=ISO-8859-1>"
							+"<title>Consultar Cliente</title>"
							+"  <script>"
							+"	function voltar(){"
							+"		window.history.back();"
							+"	}"
							+" </script>"
							+"</head>"
							+"<body>"
							+"	<br>"
							+"	<br>"
							+"	<div>Preencha os campos! </div>"
							+"	<br>"
							+"	<br>"
							+"	<button type='button' onClick='voltar()'>Voltar</button>"
							+"</body>"
							+"</html>");
				}
				
				break;
			}

			case "Atualizar": {
				
				int id = Integer.parseInt(request.getParameter("idCliente"));
				String nome = request.getParameter("nomeCliente");
				String email = request.getParameter("emailCliente");
				
				cliente = new Cliente();
				
				cliente.setId(id);
				cliente.setNome(nome);
				cliente.setEmail(email);
				
				if(servico.atualizarCliente(cliente)){
				
				
				cliente = servico.consultarCliente(id);
				
				saida.println("<!DOCTYPE html>"
						+"<html>"
						+"<head>"
						+"<meta charset=ISO-8859-1>"
						+"<title>Consultar Cliente</title>"
						+"  <script>"
						+"	function voltar(){"
						+"		window.history.back();"
						+"	}"
						+" </script>"
						+"</head>"
						+"<body>"
						+"	<br>"
						+"	<br>"
						+"	<div>Dados do cliente atualizados: </div>"
						+"	<br>"
						+"	<br>"
						+"	<div>ID: " + cliente.getId() + " Nome: " + cliente.getNome() + " Email: " + cliente.getEmail() + "</div>"
						+"	<br>"
						+"	<br>"
						+"	<button type='button' onClick='voltar()'>Voltar</button>"
						+"</body>"
						+"</html>");		
				} else {
					
					saida.println("<!DOCTYPE html>"
							+"<html>"
							+"<head>"
							+"<meta charset=ISO-8859-1>"
							+"<title>Consultar Cliente</title>"
							+"  <script>"
							+"	function voltar(){"
							+"		window.history.back();"
							+"	}"
							+" </script>"
							+"</head>"
							+"<body>"
							+"	<br>"
							+"	<br>"
							+"	<div>Não foi possível atualizar o Cliente</div>"
							+"	<br>"
							+"	<br>"
							+"	<button type='button' onClick='voltar()'>Voltar</button>"
							+"</body>"
							+"</html>");	
					
				}
				
				break;
			}
		}
	}

}