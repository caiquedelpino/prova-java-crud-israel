package br.edu.eteczl.testeconexao.model;



public class Comissionado {
	private int id;
	private float totalVenda;
	private float taxa;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getTotalVenda() {
		return totalVenda;
	}
	public void setTotalVenda(float totalVenda) {
		this.totalVenda = totalVenda;
	}
	public float getTaxa() {
		return taxa;
	}
	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
}
