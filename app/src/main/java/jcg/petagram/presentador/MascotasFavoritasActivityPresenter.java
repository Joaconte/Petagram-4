package jcg.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import jcg.petagram.db.ConstructorMascotas;
import jcg.petagram.pojo.Mascota;
import jcg.petagram.vista.activity.IMascotasFavoritasActivityView;

public class MascotasFavoritasActivityPresenter implements IMascotasFavoritasActivityPresenter{

    private IMascotasFavoritasActivityView iMascotasFavoritasActivityView;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;


    public MascotasFavoritasActivityPresenter(IMascotasFavoritasActivityView iMascotasFavoritasActivityView, Context context, ArrayList<Mascota> mascotas) {

        this.iMascotasFavoritasActivityView = iMascotasFavoritasActivityView;
        constructorMascotas = new ConstructorMascotas(context);

        obtenerMascotasFavoritasBaseDatos();

    }

    @Override
    public void obtenerMascotasFavoritasBaseDatos() {

        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotas();

    }

    @Override
    public void mostrarMascotas() {

        iMascotasFavoritasActivityView.inicializarAdaptador(iMascotasFavoritasActivityView.crearAdaptador(mascotas));
        iMascotasFavoritasActivityView.generarLinearLayoutVertical();
    }

}
