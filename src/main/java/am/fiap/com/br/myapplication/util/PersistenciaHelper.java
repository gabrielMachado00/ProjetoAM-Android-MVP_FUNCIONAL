package am.fiap.com.br.myapplication.util;

import android.opengl.EGLSurface;
import android.text.TextUtils;
import android.widget.EditText;

import am.fiap.com.br.myapplication.MainActivity;
import am.fiap.com.br.myapplication.R;
import am.fiap.com.br.myapplication.model.Endereco;
import am.fiap.com.br.myapplication.model.UsuarioTO;

/**
 * Created by Victor on 08/09/2016.
 */
public class PersistenciaHelper {

    private  UsuarioTO usuario;
    private Endereco endereco;

    private final EditText nome,sobrenome,rg,cpf,idade,logradouro,id,cidade,estado;

    public PersistenciaHelper(MainActivity formulario) {
        id = (EditText)formulario.findViewById(R.id.edtId) ;
        nome = (EditText)formulario.findViewById(R.id.edtNome);
        sobrenome = (EditText)formulario.findViewById(R.id.edtSobrenome);
        rg = (EditText)formulario.findViewById(R.id.edtRg);
        cpf = (EditText)formulario.findViewById(R.id.edtCpf);
        idade = (EditText)formulario.findViewById(R.id.edtIdade);
        logradouro = (EditText)formulario.findViewById(R.id.edtLogradouro);
        cidade = (EditText)formulario.findViewById(R.id.edtCidade);
        estado = (EditText)formulario.findViewById(R.id.edtEstado);
        usuario = new UsuarioTO();
        endereco = new Endereco();


    }


    //Método que pega os valores dos EditTexts e retorna um objeto Produto
    public UsuarioTO pegaUsuario() {
        if(id.getText().length()>0)
            usuario.set_id(id.getText().toString());

            usuario.setPrimeiroNome(nome.getText().toString());
            usuario.setUltimoNome(sobrenome.getText().toString());
            usuario.setIdade(Integer.parseInt(idade.getText().toString()));
            usuario.setRg(rg.getText().toString());
            usuario.setCpf(cpf.getText().toString());

            endereco.setLogradouro(logradouro.getText().toString());
        endereco.setCidade(cidade.getText().toString());
        endereco.setEstado(estado.getText().toString());
        return usuario;
    }

    //Métodos que preenche o Edits com os valores de um objeto Produto
    public void preencheEdts(UsuarioTO usuario){
        if(usuario != null){
            nome.setText(usuario.getPrimeiroNome());
            sobrenome.setText(usuario.getUltimoNome());
            idade.setText(usuario.getIdade());
            rg.setText(usuario.getRg());
            cpf.setText(usuario.getCpf());
            logradouro.setText(usuario.getEndereco().getLogradouro());
            estado.setText(usuario.getEndereco().getEstado());
            cidade.setText(usuario.getEndereco().getCidade());
            id.setText(usuario.get_id());
            this.usuario = usuario;
        }
    }

    //Método que valida se os editTexts estão preenchidos
    public boolean validaCampos() {
        String nome1 = nome.getText().toString().trim();
        String sobrenome1 = sobrenome.getText().toString().trim();
        int idade1 = Integer.parseInt(idade.getText().toString().trim());
        String rg1 = rg.getText().toString().trim();
        String cpf1 = cpf.getText().toString().trim();
        String lograd = logradouro.getText().toString().trim();
        String cid = cidade.getText().toString().trim();
        String est = estado.getText().toString().trim();

        return (!TextUtils.isEmpty(nome1) && !TextUtils.isEmpty(sobrenome1) &&
        !TextUtils.isEmpty(rg1) && !TextUtils.isEmpty(cpf1)  && !TextUtils.isEmpty(lograd)

                && !TextUtils.isEmpty(est)  && !TextUtils.isEmpty(cid)  && !TextUtils.isEmpty(String.valueOf(idade1)));
    }

}
