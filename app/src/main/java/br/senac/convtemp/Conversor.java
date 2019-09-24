package br.senac.convtemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Conversor extends AppCompatActivity {
    Button temperatura = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatura = (Button) findViewById(R.id.btn1);

        temperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trocar = new Intent(getApplicationContext(), Temperatura.class);
                startActivity(trocar);
            }
        });
    }
}
