package am.fiap.com.br.myapplication.model;

import java.io.Serializable;
import java.util.Calendar;



public class Promocao implements Serializable{
	
	
	
	



	private Integer codigo;
	
	private String _id;

	private String dataIncio;
	

	private String dataFim;
	

	private Integer pontos;

	private String descricao;




//private LojistaTO lojista;

	
	
	public Promocao() {
		super();
	}

	public String get_id() {
		return _id;
	}

	public Promocao set_id(String _id) {
		this._id = _id;
		return null;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDataIncio() {
		return dataIncio;
	}

	public void setDataIncio(String dataIncio) {
		this.dataIncio = dataIncio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
/*
	public LojistaTO getLojista() {
		return lojista;
	}

	public void setLojista(LojistaTO lojista) {
		this.lojista = lojista;
	}
*/


	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	@Override
	public String toString() {
		return descricao + "\n" + pontos;
	}
}
