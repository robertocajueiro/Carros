package br.com.livro.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	public BaseDAO() {
		try {
			// Necessario para utilizar o driver JDBC do MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// Erro de driver JDBC (adicione o driver .jar do MySQL em /WEB-INF/lib)
			e.printStackTrace();
		}
	}
	protected Connection getConnection() throws SQLException {
		
		// URL de conexao com o banco de dados
		String url = "jdbc:mysql://localhost/livro";
		
		// Conecta utilizando a URL usuário e senha
		Connection conn = DriverManager.getConnection(url, "livro", "livro123");
		return conn;
	}
	
	public static void main(String[] args) throws SQLException {
		BaseDAO db = new BaseDAO();
		
		//testa a conexão
		Connection conn = db.getConnection();
		System.out.println(conn);
	}

}
