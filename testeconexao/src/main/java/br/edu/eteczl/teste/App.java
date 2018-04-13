package br.edu.eteczl.teste;



import java.sql.Connection;
import java.sql.SQLException;

import br.edu.eteczl.testeconexao.model.Assalariado;
import br.edu.eteczl.testeconexao.model.Comissionado;
import br.edu.eteczl.testeconexao.model.Empregado;
import br.edu.eteczl.testeconexao.model.Horista;
import br.edu.eteczl.testeconexao.persistence.AssalariadoJdbcDao;
import br.edu.eteczl.testeconexao.persistence.ComissionadoJdbcDao;
import br.edu.eteczl.testeconexao.persistence.EmpregadoJdbcDao;
import br.edu.eteczl.testeconexao.persistence.HoristaJdbcDao;
import br.edu.eteczl.testeconexao.persistence.JdbcUtil;

/**
 * Hello world!
 * mysql_upgrade -u root -p --force
 * restartar o banco
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
        	//Horista hor = new Horista();
        	//hor.setId(1);
        	//hor.setPrecoHora(200);
        	//hor.setHorasTrabalhadas(20);
        	//Comissionado com = new Comissionado();
        	//com.setId(1);
        	//com.setTotalVenda(100);
        	//com.setTaxa(20);
        	//Assalariado ass = new Assalariado();
        	//ass.setId(1);
        	//ass.setSalario(300);
        	//Empregado emp = new Empregado();
        	//emp.setNome("Daniel");
        	//emp.setSobrenome("Lira");
        	//emp.setCpf("1111111");
        	//String cpf = "1111111";
			Connection conn = JdbcUtil.getConnection();
			//HoristaJdbcDao horDAO = new HoristaJdbcDao(conn);
			//horDAO.salvar(hor);
			//horDAO.excluir(1);
			//horDAO.alterar(hor);
			//horDAO.listar();
			//ComissionadoJdbcDao comDAO = new ComissionadoJdbcDao(conn);
			//comDAO.salvar(com);
			//comDAO.excluir(1);
			//comDAO.alterar(com);
			//comDAO.listar();
			//AssalariadoJdbcDao assDAO = new AssalariadoJdbcDao(conn);
			//assDAO.salvar(ass);
			//assDAO.excluir(1);
			//assDAO.alterar(ass);
			//assDAO.listar();
			//EmpregadoJdbcDao empregadoDAO = new EmpregadoJdbcDao(conn);
			//empregadoDAO.salvar(emp);
			//empregadoDAO.alterar(emp);
			//empregadoDAO.excluir(cpf);
			//empregadoDAO.listar();
			System.out.println(conn);
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		} catch (SQLException e) {		
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
