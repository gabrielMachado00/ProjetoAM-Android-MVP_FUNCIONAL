/*package am.fiap.com.br.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        switch (item.getItemId()) {


            //items do toolbar...

//nome da activity futura que seta de configuracoes no qual vao ter o usuario
            case R.id.action_settings:
                Toast.makeText(MenuActivity.this, "Option 1 clicked!", Toast.LENGTH_SHORT).show();
                break;

            //activiy de pesquisar



            case R.id.action_cadastrar:

                startActivity(new Intent(this,Cadastro_promocoes.class));


            case  R.id.action_pesquisar:

                startActivity(new Intent(this,ListaPromocao.class));

        }


        return super.onOptionsItemSelected(item);
    }
}


*/
