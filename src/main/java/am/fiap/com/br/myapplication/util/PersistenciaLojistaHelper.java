package am.fiap.com.br.myapplication.util;


import android.text.TextUtils;
import android.widget.EditText;


import am.fiap.com.br.myapplication.LojistaActivity;
import am.fiap.com.br.myapplication.R;
import am.fiap.com.br.myapplication.model.Endereco;
import am.fiap.com.br.myapplication.model.LojistaTO;

/**
 * Created by Monteiro on 19/09/16.
 */
public class PersistenciaLojistaHelper {

    private LojistaTO lojista;
    private Endereco endereco ;
    private final EditText razao,cnpj,logradouro,_id,cidade,estado;

    public PersistenciaLojistaHelper(LojistaActivity formulario){

        _id = (EditText)formulario.findViewById(R.id.edtID);
        razao = (EditText)formulario.findViewById(R.id.edtRazao);
        cnpj = (EditText)formulario.findViewById(R.id.edtCNPJ);
        logradouro = (EditText)formulario.findViewById(R.id.edtLogradouro);
       cidade = (EditText)formulario.findViewById(R.id.edtCidade);
        estado = (EditText)formulario.findViewById(R.id.edtEstado);

        endereco = new Endereco();
        lojista = new LojistaTO();

    }

    public LojistaTO pegaLojistas(){

        if(_id.getText().length()> 0 )
            lojista.set_id(_id.getText().toString());

            endereco.setLogradouro(logradouro.getText().toString());
            endereco.setCidade(cidade.getText().toString());
            endereco.setEstado(estado.getText().toString());

            lojista.setRazaoSocial(razao.getText().toString());
            lojista.setCnpj(cnpj.getText().toString());
            lojista.setEndereco(endereco);




        return lojista;
    }

    public void preencheEdit(LojistaTO lojista){
    if(lojista != null) {
        _id.setText(lojista.get_id().toString());
        razao.setText(lojista.getRazaoSocial().toString());
        logradouro.setText(lojista.getEndereco().getLogradouro().toString());
        cnpj.setText(lojista.getCnpj().toString());
        cidade.setText(lojista.getEndereco().getCidade().toString());
        estado.setText(lojista.getEndereco().getEstado().toString());

        this.lojista = lojista;
        }
    }

    public boolean validaCampos(){

        String raz = razao.getText().toString().trim();
        String log = logradouro.getText().toString().trim();
        String cnp = cnpj.getText().toString().trim();
        String cid = cidade.getText().toString().trim();
        String est = estado.getText().toString().trim();


        return (!TextUtils.isEmpty(raz) && !TextUtils.isEmpty(log) &&
                !TextUtils.isEmpty(cnp) && !TextUtils.isEmpty(cid) && !TextUtils.isEmpty(est));
    }


}
