package com.innovagenesis.aplicaciones.android.interfacelistfragment;



import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Alexis on 11/10/2016.
 * Listfragment que administra el contenido del fragment
 */

public class ListaCertificadosFragment extends ListFragment {

    /*Atributo de tipo ICertificados*/

    private ICertificadosSelecionado implementacion;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            implementacion = (ICertificadosSelecionado) context;
        } catch (ClassCastException ex) {
            throw new ClassCastException(context.toString() +
                    "Debe implementar ICertificacionesSelecionado");

        }
    }

    public interface ICertificadosSelecionado {

        /**
         * Interface que comunica los fragmentos
         */
        void certificadoSelecionado(int position);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** Trae la lista de certificados del array-string*/
        String[] certificados = getResources().getStringArray(R.array.certificados);
        /** Se utliza un template para cargar el listFragment*/
        setListAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, certificados));

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {


        /** Envia el item selecionado al otro fragment*/
        implementacion.certificadoSelecionado(position);
        getListView().setItemChecked(position, true); // Le dice a las tabletas que fue selecionado
    }
}
