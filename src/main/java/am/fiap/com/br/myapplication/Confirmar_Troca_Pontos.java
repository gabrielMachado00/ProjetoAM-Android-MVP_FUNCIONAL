package am.fiap.com.br.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import am.fiap.com.br.myapplication.dao.PromocaoDAOHttp;
import am.fiap.com.br.myapplication.dao.UsuarioDAOHttp;
import am.fiap.com.br.myapplication.model.Promocao;
import am.fiap.com.br.myapplication.model.UsuarioTO;


public class Confirmar_Troca_Pontos extends AppCompatActivity {

    private EditText doador,promocao;
    private Button confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar__troca__pontos);

        doador = (EditText)findViewById(R.id.edtDoadorCupom);
        promocao = (EditText)findViewById(R.id.edtPromocao_Cupom);
        confirmar = (Button)findViewById(R.id.btnConfirmaCupom);



        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UsuarioDAOHttp usuarioDAO = new UsuarioDAOHttp();
                    UsuarioTO usuarioTO = usuarioDAO.findByID("9e47684897664f4010de18f2874bc53b");

                PromocaoDAOHttp promocaoDAO = new PromocaoDAOHttp();
                Promocao promo = promocaoDAO.findPromocao("e27ae2169aa9afbcb432132f56388317");

                    Integer usuario = usuarioTO.getQtdPontos();
                    Integer promocao = promo.getPontos();
                    Integer resultado = 0;

                Log.i("doador" , String.valueOf(usuario));
                Log.i("promocao" , String.valueOf(promocao));

                if(usuario >= promocao){

                     resultado += (usuario - promocao);

                    usuarioDAO.atualizar(usuarioTO,resultado);
                    Log.i("resultado" , String.valueOf(resultado));


                }else{
                    Toast.makeText(Confirmar_Troca_Pontos.this, "Pontos insuficientes", Toast.LENGTH_SHORT).show();
                }




            }
        });
    }
}
