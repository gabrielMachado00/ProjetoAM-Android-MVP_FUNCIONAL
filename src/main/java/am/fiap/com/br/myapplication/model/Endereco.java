package am.fiap.com.br.myapplication.model;

/**
 * Created by Monteiro on 22/09/16.
 */
public class Endereco {

    private String cidade;

    private String estado;

    private String logradouro;


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Endereco(String cidade, String estado, String logradouro) {
        this.cidade = cidade;
        this.estado = estado;
        this.logradouro = logradouro;
    }

    public Endereco() {

    }
}
