package jcg.petagram.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jcg.petagram.restApi.ConstantesRestApi;
import jcg.petagram.restApi.IEndpointsApi;
import jcg.petagram.restApi.deserializador.FotoDeserializador;
import jcg.petagram.restApi.deserializador.PerfilDeserializador;
import jcg.petagram.restApi.model.FotoResponse;
import jcg.petagram.restApi.model.PerfilResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public IEndpointsApi establecerConexionRestApiInstagram(Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IEndpointsApi.class);
    }

    public Gson construyeGsonDeserializadorMedia(){

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(FotoResponse.class, new FotoDeserializador());
        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserializadorPerfil(){

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PerfilResponse.class, new PerfilDeserializador());
        return gsonBuilder.create();
    }



}
