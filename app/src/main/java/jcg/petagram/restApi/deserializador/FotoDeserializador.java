package jcg.petagram.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import jcg.petagram.pojo.Foto;
import jcg.petagram.restApi.model.FotoResponse;

public class FotoDeserializador implements JsonDeserializer<FotoResponse> {

    @Override
    public FotoResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();
        FotoResponse fotoResponse = gson.fromJson(json, FotoResponse.class);
        JsonArray fotoResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        fotoResponse.setFotos(deserializarFotosDeJson(fotoResponseData));
        return fotoResponse;
    }

    private ArrayList<Foto> deserializarFotosDeJson(JsonArray fotoResponseData){

        ArrayList<Foto> fotos = new ArrayList<>();
        for (int i = 0; i < fotoResponseData.size() ; i++) {

            JsonObject fotoResponseDataObject = fotoResponseData.get(i).getAsJsonObject();

            String urlFoto = fotoResponseDataObject.get(JsonKeys.MEDIA_URL).getAsString();
            int likes = fotoResponseDataObject.get(JsonKeys.MEDIA_LIKES).getAsInt();

            Foto fotoActual = new Foto(urlFoto, likes);
            fotos.add(fotoActual);

        }
        return fotos;
    }
}
