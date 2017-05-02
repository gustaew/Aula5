package Service;

import DAO.ClienteDAO;
import Model.Cliente;

public class ClienteService {
	public ClienteDAO dao;

	public ClienteService() {
		dao = new ClienteDAO();
	}

	public int cadastrarCliente(Cliente cliente) {
		return dao.cadastrar(cliente);
	}

	public Cliente consultarCliente(int id) {
		return dao.consultar(id);
	}

	public boolean atualizarCliente(Cliente cliente) {
		return dao.atualizar(cliente);
	}

	public boolean excluirCliente(int id) {

		if (consultarCliente(id) != null) {
			return dao.excluir(id);
		} else
			return false;
	}
}
