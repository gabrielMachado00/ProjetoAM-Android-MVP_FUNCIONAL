package am.fiap.com.br.myapplication;

    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.os.Handler;



public class SplashLoginActivity extends AppCompatActivity {
       private static int SPLASH_TIME_OUT = 30000;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_login);

            new Handler().postDelayed(new Runnable() {
                /*
                 * Exibindo splash com um timer.
                 */
                @Override
                public void run() {
                    // Esse método será executado sempre que o timer acabar
                    // E inicia a activity principal
                    Intent i = new Intent(SplashLoginActivity.this, LoginDoador.class);
                    startActivity(i);

                    // Fecha esta activity
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
        }

