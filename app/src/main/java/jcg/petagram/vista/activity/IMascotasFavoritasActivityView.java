package jcg.petagram.vista.activity;

import java.util.ArrayList;

import jcg.petagram.adapter.MascotaAdaptador;
import jcg.petagram.pojo.Mascota;

public interface IMascotasFavoritasActivityView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos);

    public void inicializarAdaptador(MascotaAdaptador adaptador);

}
