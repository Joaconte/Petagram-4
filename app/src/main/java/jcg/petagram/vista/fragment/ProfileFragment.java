package jcg.petagram.vista.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jcg.petagram.R;
import jcg.petagram.adapter.FotoAdaptador;
import jcg.petagram.pojo.Foto;
import jcg.petagram.pojo.Mascota;
import jcg.petagram.restApi.IEndpointsApi;
import jcg.petagram.restApi.adapter.RestApiAdapter;
import jcg.petagram.restApi.model.FotoResponse;
import jcg.petagram.restApi.model.PerfilResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    ArrayList<Foto> fotos = new ArrayList<>();
    private RecyclerView listaFotos;
    private Context context = getContext();


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        getInfoPerfil(v);

        listaFotos = v.findViewById(R.id.rvProfileFragment);

        getMedia();

        return v;
    }

    public void getMedia() {

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMedia = restApiAdapter.construyeGsonDeserializadorMedia();
        IEndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMedia);
        Call<FotoResponse> fotoResponseCall = endpointsApi.getMedia();

        fotoResponseCall.enqueue(new Callback<FotoResponse>() {
            @Override
            public void onResponse(Call<FotoResponse> call, Response<FotoResponse> response) {
                FotoResponse fotoResponse = response.body();
                fotos = fotoResponse.getFotos();
                mostrarFotos();
            }

            @Override
            public void onFailure(Call<FotoResponse> call, Throwable t) {
                Toast.makeText(context, "Algo paso en la conexión! Intenta de vuelta", Toast.LENGTH_SHORT).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }

    public void mostrarFotos(){

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        listaFotos.setLayoutManager(glm);
        inicializarAdaptador();
    }


    public void getInfoPerfil(View v) {

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMedia = restApiAdapter.construyeGsonDeserializadorPerfil();
        IEndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMedia);
        Call<PerfilResponse> perfilResponseCall = endpointsApi.getInfoPerfil();

        perfilResponseCall.enqueue(new Callback<PerfilResponse>() {
            @Override
            public void onResponse(Call<PerfilResponse> call, Response<PerfilResponse> response) {
                PerfilResponse perfilResponse = response.body();

                Mascota mascota = perfilResponse.getMascota();
                Foto foto = perfilResponse.getFoto();

                mostrarPerfil(v, mascota, foto);
            }

            @Override
            public void onFailure(Call<PerfilResponse> call, Throwable t) {
                Toast.makeText(context, "Algo paso en la conexión! Intenta de vuelta", Toast.LENGTH_SHORT).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }


    private void mostrarPerfil(View v, Mascota mascota, Foto foto){

        CircularImageView imgFoto = v.findViewById(R.id.civFotoPerfil);
        Picasso.get()
                .load(foto.getFoto())
                .placeholder(R.drawable.vaca)
                .into(imgFoto);

        TextView tvNombrePerfil = v.findViewById(R.id.tvNombrePerfil);
        tvNombrePerfil.setText(mascota.getNombre());
    }

    public void inicializarAdaptador(){

        FotoAdaptador adaptador = new FotoAdaptador(fotos, getActivity());
        listaFotos.setAdapter(adaptador);

    }

}