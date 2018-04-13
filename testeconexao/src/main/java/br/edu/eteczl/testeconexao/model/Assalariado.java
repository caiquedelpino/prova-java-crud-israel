package br.edu.eteczl.testeconexao.model;

import javax.swing.JOptionPane;

public class Assalariado {

	private int id;
	private float salario;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public float vencimento() {
		float vencimento = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o vencimento?"));
		return vencimento;
	}
	
}
