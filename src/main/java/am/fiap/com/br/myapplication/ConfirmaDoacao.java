package am.fiap.com.br.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import am.fiap.com.br.myapplication.dao.PromocaoDAOHttp;
import am.fiap.com.br.myapplication.dao.UsuarioDAOHttp;
import am.fiap.com.br.myapplication.model.Promocao;
import am.fiap.com.br.myapplication.model.UsuarioTO;
import am.fiap.com.br.myapplication.util.PersistenciaPromocaoHelper;

public class ConfirmaDoacao extends AppCompatActivity {
    private EditText doador,pontos;
    private Button confirmar;
     private PersistenciaPromocaoHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_doacao);

        confirmar = (Button) findViewById(R.id.btnIdConfirmar);
        doador = (EditText)findViewById(R.id.editIdDoador);
        pontos = (EditText)findViewById(R.id.edtPontuacao);



        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UsuarioDAOHttp usuarioDAO = new UsuarioDAOHttp();
                    int ponto = Integer.parseInt(pontos.getText().toString());

                UsuarioTO usuario = usuarioDAO.findByID("b0b8f1e49772661d452638549de65041");


                    try{
                        usuarioDAO.atualizar(usuario,ponto);

                        Log.i("usuario",String.valueOf(usuario.getQtdPontos()));
                    }catch (Exception e){
                        e.printStackTrace();
                    }






            }
        });
        


    }







}
