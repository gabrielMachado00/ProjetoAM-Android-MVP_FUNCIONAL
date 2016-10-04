package am.fiap.com.br.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import am.fiap.com.br.myapplication.dao.LojistaDAOHttp;
import am.fiap.com.br.myapplication.dao.UsuarioDAOHttp;
import am.fiap.com.br.myapplication.model.LojistaTO;
import am.fiap.com.br.myapplication.model.UsuarioTO;
import am.fiap.com.br.myapplication.util.PersistenciaLojistaHelper;

public class LojistaActivity extends AppCompatActivity {

    private EditText edtID;
    private PersistenciaLojistaHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lojista);

        helper = new PersistenciaLojistaHelper(this);

        edtID = (EditText)findViewById(R.id.edtID);

        Intent intent = getIntent();

        LojistaTO lojista = (LojistaTO)intent.getSerializableExtra("Lojista");
        if(lojista != null){
            helper.preencheEdit(lojista);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_formulario_ok:
                //ProdutoDAO produtoDAO = new ProdutoDAO(this);
                LojistaDAOHttp lojistaDAO = new LojistaDAOHttp();
                LojistaTO lojistaTO = new LojistaTO();
                //Pega o ID do Edit edtId
                String strId = edtID.getText().toString().trim();
                lojistaTO = helper.pegaLojistas();
                Log.e("prod", lojistaTO.toString());


                //Valida se os campos estão preenchidos
                if(helper.validaCampos()){
                    //Se o ID for vazio
                    if(TextUtils.isEmpty(strId))
                        lojistaDAO.inserir(lojistaTO);

                        Toast.makeText(LojistaActivity.this, "Produto " + lojistaTO.getRazaoSocial() + " salvo!",
                                Toast.LENGTH_SHORT).show();


                }else{
                    Toast.makeText(this, "Todos os campos são obrigatórios", Toast.LENGTH_LONG).show();
                }
                    finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
