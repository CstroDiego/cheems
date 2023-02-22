package mx.itson.cheems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public int ubicacion = 0;
    public int intentos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();

        Button btnReiniciar = (Button) findViewById(R.id.btnReiniciar);
        btnReiniciar.setOnClickListener(this);

        for (int i = 1; i <= 12; i++) {
            ImageButton btnSeleccion = (ImageButton) findViewById(getResources().getIdentifier("opcion" + i, "id", this.getPackageName()));
            btnSeleccion.setOnClickListener(this);
        }
    }

    public void iniciar() {
        (findViewById(R.id.opcion1)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion2)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion3)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion4)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion5)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion6)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion7)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion8)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion9)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion10)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion11)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion12)).setBackgroundResource(R.drawable.icon_pregunta);


        Random random = new Random();
        ubicacion = random.nextInt(11) + 1;
        Toast.makeText(this, "ubicacion " + ubicacion, Toast.LENGTH_LONG).show();

    }

    public void destapar(int opcion) {
        if (opcion == ubicacion) {

            for (int i = 1; i <= 12; i++) {
                ImageButton btnSeleccion = (ImageButton) findViewById(getResources().getIdentifier("opcion" + i, "id", this.getPackageName()));
                if (i == opcion) {
                    btnSeleccion.setBackgroundResource(R.drawable.icon_cheems_llora);
                    Toast.makeText(this, "¡PERMDISTE!", Toast.LENGTH_LONG).show();
                    intentos = 0;
                } else {
                    btnSeleccion.setBackgroundResource(R.drawable.icon_cheems);
                }
            }
        } else {
            ImageButton btnSeleccion = (ImageButton) findViewById(getResources().getIdentifier("opcion" + opcion, "id", this.getPackageName()));
            btnSeleccion.setBackgroundResource(R.drawable.icon_cheems);
            intentos++;
            if (intentos == 11) {
                Toast.makeText(this, "¡GAMNASTE!", Toast.LENGTH_LONG).show();
                ImageButton btnGanador = (ImageButton) findViewById(getResources().getIdentifier("opcion" + ubicacion, "id", this.getPackageName()));
                btnGanador.setBackgroundResource(R.drawable.icon_cheems_ganador);
                intentos = 0;
            }
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnReiniciar:
                iniciar();
                break;
            case R.id.opcion1:
                destapar(1);
                break;
            case R.id.opcion2:
                destapar(2);
                break;
            case R.id.opcion3:
                destapar(3);
                break;
            case R.id.opcion4:
                destapar(4);
                break;
            case R.id.opcion5:
                destapar(5);
                break;
            case R.id.opcion6:
                destapar(6);
                break;
            case R.id.opcion7:
                destapar(7);
                break;
            case R.id.opcion8:
                destapar(8);
                break;
            case R.id.opcion9:
                destapar(9);
                break;
            case R.id.opcion10:
                destapar(10);
                break;
            case R.id.opcion11:
                destapar(11);
                break;
            case R.id.opcion12:
                destapar(12);
                break;
        }
    }
}