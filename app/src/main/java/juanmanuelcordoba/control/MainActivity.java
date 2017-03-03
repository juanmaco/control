package juanmanuelcordoba.control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {

    ImageButton izquierda;
    ImageButton derecha;
    Comunicacion com;
    String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        izquierda = (ImageButton) findViewById(R.id.izquierda);
        derecha = (ImageButton) findViewById(R.id.derecha);
        com = new Comunicacion();
        Thread hilo = new Thread(com);
        izquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == izquierda.getId()) {
                     mensaje = "left";

                    com.enviar(mensaje);
                    System.out.println("holil");
                }
            }
        });
        derecha.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(view.getId()== derecha.getId()) {
                     mensaje = "right";
                    com.enviar(mensaje);
                }
            }
        });
    }
}
