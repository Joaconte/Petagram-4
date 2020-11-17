package jcg.petagram.vista.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jcg.petagram.R;
import jcg.petagram.adapter.MascotaAdaptador;
import jcg.petagram.pojo.Mascota;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    MascotaAdaptador adaptador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        listaMascotas = v.findViewById(R.id.rvActivityMain);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        return v;
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Cerdo", R.drawable.cerdo, 1, 0));
        mascotas.add(new Mascota("Conejo", R.drawable.conejo, 2, 1));
        mascotas.add(new Mascota("Elefante", R.drawable.elefante, 3, 2));
        mascotas.add(new Mascota("Gallo", R.drawable.gallo, 4, 3));
        mascotas.add(new Mascota("Gato", R.drawable.gato, 5,4 ));
        mascotas.add(new Mascota("Mono", R.drawable.mono, 6,5 ));
        mascotas.add(new Mascota("Oso", R.drawable.oso, 7, 6));
        mascotas.add(new Mascota("Oveja", R.drawable.oveja, 8, 7));
        mascotas.add(new Mascota("Perro", R.drawable.perro, 9, 8));
    }

    public void inicializarAdaptador(){

        adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);

    }

    public ArrayList<Mascota> getMascotasFavoritas(){

        return adaptador.getMascotasFavoritas();
    }

}