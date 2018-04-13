package br.edu.eteczl.testeconexao.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.edu.eteczl.testeconexao.model.Comissionado;

public class ComissionadoJdbcDao {

private Connection conn;
	
	public ComissionadoJdbcDao(Connection conn) throws Exception {
		if(conn == null) {
				throw new Exception("Conexao nao pode ser nula");
		}else {
			this.conn = conn;
		}
	}
	
	public void salvar(Comissionado com) throws Exception {
		String sql = "insert into Comissionado (id, totalVenda, taxa) values ('"+com.getId()+"','"+com.getTotalVenda()+"','"+com.getTaxa()+"')";
		System.out.println(sql);
		PreparedStatement pstm = (PreparedStatement) this.conn.prepareStatement(sql);
		pstm.executeUpdate();
		pstm.close();
	}
	
	public void alterar (Comissionado com) {
		String sql = "update Comissionado set totalVenda='"+com.getTotalVenda()+"', taxa ='"+com.getTaxa()+"' where id='"+com.getId()+"';";
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
		String sql = "delete from Comissionado where id='"+id+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = (PreparedStatement) this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}
	
	public List<Comissionado> listar() {
		String sql = "select * from Comissionado";
        System.out.println(sql);		
        List<Comissionado> comissionados = new ArrayList<Comissionado>();
		try {
			PreparedStatement prepareStatement = (PreparedStatement) this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				float totalVenda = rs.getFloat("totalVenda");
				float taxa = rs.getFloat("taxa");
				Comissionado com = new Comissionado();
				com.setId(id);
				com.setTotalVenda(totalVenda);
				com.setTaxa(taxa);
				comissionados.add(com);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comissionados;
	}
	
}
