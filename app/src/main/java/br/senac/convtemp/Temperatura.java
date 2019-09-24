package br.senac.convtemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Temperatura extends AppCompatActivity {

    Button conversor = null;
    EditText quantidade = null;
    TextView resultado = null;
    Spinner spincl=null;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);
        conversor = (Button) findViewById(R.id.btntemp);
        quantidade = (EditText) findViewById(R.id.quant);
        resultado = (TextView) findViewById(R.id.Resultado);
        spincl = (Spinner) findViewById(R.id.spinla);


        String[]op={"Selecione uma opção","ºC para ºF","ºF para ºC"};

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, op);
        spincl.setAdapter(adapter);

        conversor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantidade.getText().toString().equals("")){
                    Toast msg=Toast.makeText(getApplicationContext(),"Digite uma temperatura", Toast.LENGTH_SHORT);
                    msg.show();

                } else {
                    Double c=Double.parseDouble(quantidade.getText().toString());
                    Double res=null;
                    int select=spincl.getSelectedItemPosition();

                    switch (select){
                        case 0:
                            res = 0.0;
                            Toast.makeText(getApplicationContext(),"Selecione uma opção",Toast.LENGTH_SHORT).show();
                            break;

                        case 1:
                            res=celsiusParaFehreint(c);
                            break;

                        case 2:
                            res=fahrentParaCelsius(c);
                            break;
                    }
                    resultado.setText(res.toString());
                }
            }
        });
    }

    public double celsiusParaFehreint(double valor){
        return 1.8 * valor + 32;

    }

    public double fahrentParaCelsius(double valor){
        return (valor - 32) / 1.8;

    }
}
