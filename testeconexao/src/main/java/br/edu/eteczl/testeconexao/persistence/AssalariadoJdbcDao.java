package br.edu.eteczl.testeconexao.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.edu.eteczl.testeconexao.model.Assalariado;


public class AssalariadoJdbcDao {

private Connection conn;
	
	public AssalariadoJdbcDao(Connection conn) throws Exception {
		if(conn == null) {
				throw new Exception("Conexao nao pode ser nula");
		}else {
			this.conn = conn;
		}
	}
	
	public void salvar(Assalariado ass) throws Exception {
		String sql = "insert into Assalariado (id, salario) values ('"+ass.getId()+"','"+ass.getSalario()+"')";
		System.out.println(sql);
		PreparedStatement pstm = (PreparedStatement) this.conn.prepareStatement(sql);
		pstm.executeUpdate();
		pstm.close();
	}
	
	public void alterar (Assalariado ass) {
		String sql = "update Assalariado set salario ='"+ass.getSalario()+"' where id='"+ass.getId()+"';";
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
	
	public void excluir(int id) {
		String sql = "delete from Assalariado where id='"+id+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = (PreparedStatement) this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}
	
	public List<Assalariado> listar() {
		String sql = "select * from Assalariado";
        System.out.println(sql);		
        List<Assalariado> assalariados = new ArrayList<Assalariado>();
		try {
			PreparedStatement prepareStatement = (PreparedStatement) this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				float salario = rs.getFloat("salario");
				Assalariado ass = new Assalariado();
				ass.setId(id);
				ass.setSalario(salario);
				assalariados.add(ass);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assalariados;
	}
	
}
