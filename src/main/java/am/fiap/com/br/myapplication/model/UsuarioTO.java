package am.fiap.com.br.myapplication.model;

import java.io.Serializable;



public class UsuarioTO implements Serializable {
	
	




	private String _id;
	

	private String primeiroNome;
	

	private String ultimoNome;
	


	
	//Relacionamento 1:N Cliente e cidade;
	

	private Endereco endereco;
	

	private int idade;

	private String rg;
	
	String _rev;

	private String cpf;
	

	private String sexo;

	private Integer qtdPontos;

	public Integer getQtdPontos() {
		return qtdPontos;
	}

	public String get_rev() {
		return _rev;
	}

	public void set_rev(String _rev) {
		this._rev = _rev;
	}

	public void setQtdPontos(Integer qtdPontos) {
		this.qtdPontos = qtdPontos;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}



	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public UsuarioTO() {
		super();
	}
	
	
	
	
	

}
