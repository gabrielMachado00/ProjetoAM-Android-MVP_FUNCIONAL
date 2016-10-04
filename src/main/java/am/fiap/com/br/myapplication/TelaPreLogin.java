package am.fiap.com.br.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaPreLogin extends AppCompatActivity {

    private Button lojista,doador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pre_login);

        lojista = (Button) findViewById(R.id.btnLojista);
        doador = (Button)findViewById(R.id.btnDoador);

        lojista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toLoginLojista = new Intent(TelaPreLogin.this,LoginLojista.class);
                startActivity(toLoginLojista);
            }
        });

        doador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toLoginDoador = new Intent(TelaPreLogin.this,LoginDoador.class);
                startActivity(toLoginDoador);
            }
        });
    }


}
