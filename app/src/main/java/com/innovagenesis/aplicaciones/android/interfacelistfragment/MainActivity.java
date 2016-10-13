package com.innovagenesis.aplicaciones.android.interfacelistfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements ListaCertificadosFragment.ICertificadosSelecionado {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Como la vista por defecto es la tablet el fragmento en modo telefono no es mostrado
         * por eso es necesario implemtar la logica*/

        if (findViewById(R.id.contenedor) != null) {
            if (savedInstanceState != null)
                return;

            /** Instancia el fragment */
            ListaCertificadosFragment fragment = new ListaCertificadosFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contenedor, fragment)
                    .commit();
        }
    }

    @Override
    public void certificadoSelecionado(int position) {
        Toast.makeText(this, "Position" + position, Toast.LENGTH_SHORT).show();
    }
}
