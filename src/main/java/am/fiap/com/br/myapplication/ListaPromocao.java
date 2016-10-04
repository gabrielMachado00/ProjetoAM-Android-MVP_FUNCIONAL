package am.fiap.com.br.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import am.fiap.com.br.myapplication.dao.PromocaoDAOHttp;
import am.fiap.com.br.myapplication.model.Promocao;

public class ListaPromocao extends AppCompatActivity {
        private ListView listaPromocoes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_promocao);

        listaPromocoes = (ListView)findViewById(R.id.editLista);


        listaPromocoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Promocao promo = (Promocao) listaPromocoes.getItemAtPosition(i);
                Intent chamaFormPreenchido = new Intent(ListaPromocao.this,Cadastro_promocoes.class);
                chamaFormPreenchido.putExtra("promocaoo",promo);
                startActivity(chamaFormPreenchido);
            }
        });

    }





    private void carregaLista(){

        List<Promocao> promocoes = new ArrayList<>();
        PromocaoDAOHttp promocaoDAOHttp = new PromocaoDAOHttp();
        promocoes = promocaoDAOHttp.listarTodas();

        //populando o listPromocoes
        ArrayAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,promocoes);
        listaPromocoes.setAdapter(adapter);
    }

    public void novoProduto(View v){
        Intent intentChamaFormulario = new Intent(ListaPromocao.this, Cadastro_promocoes.class);
        startActivity(intentChamaFormulario);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();


    }
}
