package am.fiap.com.br.myapplication.util;

import android.text.TextUtils;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import am.fiap.com.br.myapplication.Cadastro_promocoes;
import am.fiap.com.br.myapplication.ConfirmaDoacao;
import am.fiap.com.br.myapplication.R;
import am.fiap.com.br.myapplication.model.Promocao;

/**
 * Created by Monteiro on 24/09/16.
 */
public class PersistenciaPromocaoHelper {

    private Promocao promocao;

    private  ConfirmaDoacao conf;

    private final EditText id,dtInicio,dataEncerra,descricao,pontos;


    public PersistenciaPromocaoHelper(Cadastro_promocoes formulario) {

        id = (EditText)formulario.findViewById(R.id.editID);
        dtInicio = (EditText)formulario.findViewById(R.id.edtDataInicio);
        dataEncerra = (EditText)formulario.findViewById(R.id.edtDataEncerramento);
        descricao = (EditText)formulario.findViewById(R.id.edtDescricao);
        pontos = (EditText)formulario.findViewById(R.id.edtPontos);

        promocao = new Promocao();

}



    public Promocao pegaPromocao(){


        if(id.getText().length()> 0)
            promocao.set_id(id.getText().toString());
            promocao.setDataIncio(dtInicio.getText().toString());
            promocao.setDataFim(dataEncerra.getText().toString());
            promocao.setPontos(Integer.parseInt(pontos.getText().toString()));
            promocao.setDescricao(descricao.getText().toString());

        return promocao;

    }

    public void preencheEdit(Promocao promocao){

        if(promocao != null)

            id.setText(promocao.get_id().toString());
            dtInicio.setText(promocao.getDataIncio().toString());
            dataEncerra.setText(promocao.getDataFim().toString());
            pontos.setText(promocao.getPontos().toString());
        descricao.setText(promocao.getDescricao());
            this.promocao = promocao;

    }

    public boolean validaCampos(){

        String dataInio = dtInicio.getText().toString();
        String dtEncerra = dataEncerra.getText().toString();
        String desc = descricao.getText().toString();
        Integer pts = Integer.parseInt(pontos.getText().toString());

        return (!TextUtils.isEmpty(dataInio) && !TextUtils.isEmpty(dtEncerra) &&
                !TextUtils.isEmpty(desc)   && !TextUtils.isEmpty((String.valueOf(pts))));
    }
}
