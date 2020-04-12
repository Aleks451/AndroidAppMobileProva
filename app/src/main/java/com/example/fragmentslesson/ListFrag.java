package com.example.fragmentslesson;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {

    ItemSelected activity;                  //MainActivity

    public interface ItemSelected{          //*** serve da tramite per comunicare tra i fragment
        void onItemSelected(int index);     // passando per MainActivity, spedisce index dell'item selezionato.
    }

    public ListFrag() { }

    @Override
    public void onAttach(Context context) {     //this method is called when fragment is associated
                                                // with an activity, context - is a link to our
        super.onAttach(context);                // activity that attaching to our fragment


    activity = (ItemSelected) context;      //context here refers to MainActivity
                                            //and casts MainActivity to interface ItemSelected
                                            //MainActivity should implement ItemSelected interface
    }

    //this method is called when the activity's onCreate method is finished, set other stuff after
    //we've made a connection to the activity
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String [] data = getResources().getStringArray(R.array.pieces);


        // imposta il contenuto della lista del fragment
        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data));

        if (this.getActivity().findViewById(R.id.layout_land) != null) {
            activity.onItemSelected(0); //imposta il testo iniziale della descrizione
        }
    }

    //

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        activity.onItemSelected(position); // spedisce alla MainActivity la posizione dell'item cliccato, usa il metodo dell'interfaccia

    }
}
