package am.fiap.com.br.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import am.fiap.com.br.myapplication.dao.UsuarioDAOHttp;
import am.fiap.com.br.myapplication.model.UsuarioTO;
import am.fiap.com.br.myapplication.util.PersistenciaHelper;



public class MainActivity extends AppCompatActivity {
    private EditText edtId;
    private PersistenciaHelper  helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      helper = new PersistenciaHelper(this);
        edtId = (EditText) findViewById(R.id.edtId);

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


                    case R.id.action_cadastrar:

                startActivity(new Intent(this,Cadastro_promocoes.class));

            case R.id.menu_formulario_ok:
                //ProdutoDAO produtoDAO = new ProdutoDAO(this);
                UsuarioDAOHttp produtoDAO = new UsuarioDAOHttp();
                UsuarioTO usuarioTO = new UsuarioTO();
                //Pega o ID do Edit edtId
                String strId = edtId.getText().toString().trim();
                usuarioTO = helper.pegaUsuario();
                Log.e("prod", usuarioTO.toString());
                //Valida se os campos estão preenchidos
                if(helper.validaCampos()){
                    //Se o ID for vazio
                    if(TextUtils.isEmpty(strId))
                        produtoDAO.inserir(usuarioTO);

                    Toast.makeText(MainActivity.this, "Produto " + usuarioTO.getPrimeiroNome() + " salvo!",
                            Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(this,ListaPromocao.class));
                }else{
                    Toast.makeText(this, "Todos os campos são obrigatórios", Toast.LENGTH_LONG).show();
                }
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}



