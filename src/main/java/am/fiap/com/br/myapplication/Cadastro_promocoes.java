package am.fiap.com.br.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import am.fiap.com.br.myapplication.dao.PromocaoDAOHttp;
import am.fiap.com.br.myapplication.dao.UsuarioDAOHttp;
import am.fiap.com.br.myapplication.model.Promocao;
import am.fiap.com.br.myapplication.model.UsuarioTO;
import am.fiap.com.br.myapplication.util.PersistenciaLojistaHelper;
import am.fiap.com.br.myapplication.util.PersistenciaPromocaoHelper;

public class Cadastro_promocoes extends AppCompatActivity {

    private EditText editID;
    private Button toConfirmaDocao;
    private PersistenciaPromocaoHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_promocoes);
        toConfirmaDocao = (Button)findViewById(R.id.btnToConfirmaDoacao);
        editID = (EditText)findViewById(R.id.editID);
        helper = new PersistenciaPromocaoHelper(this);

        Intent intent = getIntent();

       Promocao promo = (Promocao) intent.getSerializableExtra("promocaoo");

        final Promocao elvinPromos = (Promocao) promo;

        if(promo != null){
            helper.preencheEdit(promo);
        }

        editID.setEnabled(false);


        toConfirmaDocao.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent toConfirmaDoacao = new Intent(Cadastro_promocoes.this,ConfirmaDoacao.class);
                toConfirmaDoacao.putExtra("enviar", elvinPromos);

                startActivity(toConfirmaDoacao);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);


    }

    //Insere ou atualiza um produto na base utilizando um MenuItem
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_formulario_ok:
                //ProdutoDAO produtoDAO = new ProdutoDAO(this);
                PromocaoDAOHttp promocaoDAOHttp  = new PromocaoDAOHttp();
                Promocao promocao = new Promocao();
                //Pega o ID do Edit edtId
                String strId = editID.getText().toString().trim();
                promocao = helper.pegaPromocao();
                Log.e("prod", promocao.toString());
                //Valida se os campos estão preenchidos
                if(helper.validaCampos()){
                    //Se o ID for vazio
                    if(TextUtils.isEmpty(strId))
                        promocaoDAOHttp.inserir(promocao);

                    Toast.makeText(Cadastro_promocoes.this, "Promoção " + promocao.getDescricao() + " salvo!",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Todos os campos são obrigatórios", Toast.LENGTH_LONG).show();
                }
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();

        Promocao promo = (Promocao) intent.getSerializableExtra("promocao");

        if(promo != null){
            helper.preencheEdit(promo);
        }
    }

}
