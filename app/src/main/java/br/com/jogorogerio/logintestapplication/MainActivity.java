package br.com.jogorogerio.logintestapplication;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int contadorLogin = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etLogin = (EditText) findViewById(R.id.main_loginName);
        final EditText etPassword = (EditText) findViewById(R.id.main_password);

        Button btLogIn = (Button) findViewById(R.id.main_buttonLogin);

        btLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(verificaCredenciaisLogin(etLogin.getText().toString(), etPassword.getText().toString())) {
                    //Activity in case login successful
                } else {
                    contadorLogin++;
                    String message;
                    switch (contadorLogin) {
                        case 1:
                            message = getResources().getString(R.string.invalidLoginFirstAttempt);
                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            message = getResources().getString(R.string.invalidLoginSecondAttempt);
                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                            break;
                        case 3:
                            message = getResources().getString(R.string.invalidLoginLastAttempt);
                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                            finish();
                            break;
                    }
                }
            }
        });

    }

    private boolean verificaCredenciaisLogin(String login, String password) {
        return false;
    }
}
