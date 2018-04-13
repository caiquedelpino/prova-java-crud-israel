package br.edu.eteczl.testeconexao.persistence;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.edu.eteczl.testeconexao.model.Horista;

public class HoristaJdbcDao {
	
private Connection conn;
	
	public HoristaJdbcDao(Connection conn) throws Exception {
		if(conn == null) {
				throw new Exception("Conexao nao pode ser nula");
		}else {
			this.conn = conn;
		}
	}
	
	public void salvar(Horista hor) throws Exception {
		String sql = "insert into Horista (id, precoHora, horasTrabalhadas) values ('"+hor.getId()+"','"+hor.getPrecoHora()+"','"+hor.getHorasTrabalhadas()+"')";
		System.out.println(sql);
		PreparedStatement pstm = (PreparedStatement) this.conn.prepareStatement(sql);
		pstm.executeUpdate();
		pstm.close();
	}
	
	public void alterar (Horista hor) {
		String sql = "update Horista set precoHora='"+hor.getPrecoHora()+"', horasTrabalhadas ='"+hor.getHorasTrabalhadas()+"' where id='"+hor.getId()+"';";
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
		String sql = "delete from Horista where id='"+id+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = (PreparedStatement) this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}
	
	public List<Horista> listar() {
		String sql = "select * from Horista";
        System.out.println(sql);		
        List<Horista> horistas = new ArrayList<Horista>();
		try {
			PreparedStatement prepareStatement = (PreparedStatement) this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				float precoHora = rs.getFloat("precoHora");
				float horasTrabalhadas = rs.getFloat("horasTrabalhadas");
				Horista hor = new Horista();
				hor.setId(id);
				hor.setPrecoHora(precoHora);
				hor.setHorasTrabalhadas(horasTrabalhadas);;
				horistas.add(hor);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return horistas;
	}
}
