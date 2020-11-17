package jcg.petagram.adapter;

import android.app.Activity;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jcg.petagram.db.ConstructorMascotas;
import jcg.petagram.pojo.ListaIdMascotasFavoritas;
import jcg.petagram.pojo.Mascota;
import jcg.petagram.R;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;
    ListaIdMascotasFavoritas listaIdMascotasFavoritas;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
        listaIdMascotasFavoritas = new ListaIdMascotasFavoritas();

        ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
        inicializarMascotasFavoritas(constructorMascotas.obtenerDatos());
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        String cantDeMeGusta = Integer.toString(mascota.getLikes());
        mascotaViewHolder.tvCantidadDeMeGusta.setText(cantDeMeGusta);


        mascotaViewHolder.ibtnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                mascota.agregarLike();
                listaIdMascotasFavoritas.agregarIdMascota(mascota.getId());

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.insertarMascotas(getMascotasFavoritas());
            }
        });

    }

    @Override
    public int getItemCount() {

        if (mascotas != null)
            return mascotas.size();
        else
            return 0;
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvCantidadDeMeGusta;
        private ImageButton ibtnLike;

        public MascotaViewHolder(View itemView){
            super(itemView);
            imgFoto             = itemView.findViewById(R.id.imgFoto);
            tvNombre            = itemView.findViewById(R.id.tvNombre);
            tvCantidadDeMeGusta = itemView.findViewById(R.id.tvCantidadDeMeGusta);
            ibtnLike            = itemView.findViewById(R.id.ibtnLike);
        }
    }

    public ArrayList<Mascota> getMascotasFavoritas(){

        ArrayList<Mascota> mascotasFavoritas = new ArrayList<>();

        for (int i = 0; i < listaIdMascotasFavoritas.size(); i++){

            Integer id = listaIdMascotasFavoritas.get(i);
            Mascota mascota = mascotas.get(id);
            mascotasFavoritas.add(mascota);

        }
        return mascotasFavoritas;
    }

    public void inicializarMascotasFavoritas(ArrayList<Mascota> mascotas){

        for (int i = 0; i < mascotas.size(); i++)
            listaIdMascotasFavoritas.agregarIdMascota(mascotas.get(i).getId());

    }
}
