package br.edu.eteczl.testeconexao.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.edu.eteczl.testeconexao.model.Empregado;

public class EmpregadoJdbcDao {

private Connection conn;
	
	public EmpregadoJdbcDao(Connection conn) throws Exception {
		if(conn == null) {
				throw new Exception("Conexao nao pode ser nula");
		}else {
			this.conn = conn;
		}
	}
	
	public void salvar(Empregado emp) throws Exception {
		String sql = "insert into Empregado (nome, sobrenome, cpf) values ('"+emp.getNome()+"','"+emp.getSobrenome()+"','"+emp.getCpf()+"')";
		System.out.println(sql);
		PreparedStatement pstm = (PreparedStatement) this.conn.prepareStatement(sql);
		pstm.executeUpdate();
		pstm.close();
	}
	
	public void alterar (Empregado emp) {
		String sql = "update empregado set nome='"+emp.getNome()+"', sobrenome ='"+emp.getSobrenome()+"' where cpf='"+emp.getCpf()+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = (PreparedStatement) this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
            prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(String cpf) {
		String sql = "delete from Empregado where cpf='"+cpf+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = (PreparedStatement) this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}
	
	public List<Empregado> listar() {
		String sql = "select * from Empregado";
        System.out.println(sql);		
        List<Empregado> empregados = new ArrayList<Empregado>();
		try {
			PreparedStatement prepareStatement = (PreparedStatement) this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String cpf = rs.getString("cpf");
				Empregado emp = new Empregado();
				emp.setNome(nome);
				emp.setSobrenome(sobrenome);
				emp.setCpf(cpf);
				empregados.add(emp);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empregados;
	}
}
