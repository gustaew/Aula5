package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Cliente;

public class ClienteDAO {

	public int cadastrar(Cliente cliente) {

		String sql = "insert into Cliente (nome, email) values ((?),(?))";
		Connection conn = null;
		PreparedStatement pm = null;
		ResultSet rs = null;
		int id = 0;

		try {

			conn = ConnectionFactory.getConnection();
			pm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pm.setString(1, cliente.getNome());
			pm.setString(2, cliente.getEmail());
			pm.execute();

			rs = pm.getGeneratedKeys();

			if (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {

				if (pm != null) {
					pm.close();
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return id;
	}

	public Cliente consultar(int id) {

		String sql = "select * from Cliente where idCliente = (?)";
		Connection conn = null;
		PreparedStatement pm = null;
		ResultSet rs = null;
		Cliente cliente = null;

		try {
			conn = ConnectionFactory.getConnection();
			pm = conn.prepareStatement(sql);
			pm.setInt(1, id);
			rs = pm.executeQuery();

			cliente = new Cliente();

			if (rs.next()) {

				cliente.setId(rs.getInt("idCliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				rs.close();
			}

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				pm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cliente;
	}

	public boolean atualizar(Cliente cliente) {

		String sql = "update Cliente set nome = (?) , email = (?) where idCliente = (?)";
		Connection conn = null;
		PreparedStatement pm = null;
		boolean saida = false;

		try { 
			conn = ConnectionFactory.getConnection();
			pm = conn.prepareStatement(sql);

			pm.setString(1, cliente.getNome());
			pm.setString(2, cliente.getEmail());
			pm.setInt(3, cliente.getId());
			pm.execute();
			saida = true;

		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			try {
				pm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return saida;
	}

	public boolean excluir(int id) {

		String sql = "delete from Cliente where idCliente = (?)";
		Connection conn = null;
		PreparedStatement pm = null;
		boolean saida = false;

		try {
			conn = ConnectionFactory.getConnection();
			pm = conn.prepareStatement(sql);
			pm.setInt(1, id);
			pm.execute();
			saida = true;

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				pm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return saida;
	}

}
