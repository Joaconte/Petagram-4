package jcg.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import jcg.petagram.R;
import jcg.petagram.pojo.Foto;


public class FotoAdaptador extends RecyclerView.Adapter<FotoAdaptador.FotoViewHolder> {

    ArrayList<Foto> fotos;
    Activity activity;

    public FotoAdaptador(ArrayList<Foto> fotos, Activity activity){
        this.fotos = fotos;
        this.activity = activity;
    }

    @NonNull
    @Override
    public FotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_foto, parent, false);
        return new FotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FotoViewHolder fotoViewHolder, int position) {
        final Foto foto = fotos.get(position);
        Picasso.get()
                .load(foto.getFoto())
                .placeholder(R.drawable.vaca)
                .into(fotoViewHolder.imgFoto);
        fotoViewHolder.tvLikes.setText(String.valueOf( foto.getCantidadDeMeGusta() ));

    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class FotoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvLikes;

        public FotoViewHolder(View itemView){
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvLikes = itemView.findViewById(R.id.tvLikes);
        }
    }

}
