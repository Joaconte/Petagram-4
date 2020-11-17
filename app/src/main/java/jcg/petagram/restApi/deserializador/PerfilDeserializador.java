package jcg.petagram.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import jcg.petagram.pojo.Foto;
import jcg.petagram.pojo.Mascota;
import jcg.petagram.restApi.model.PerfilResponse;

public class PerfilDeserializador implements JsonDeserializer<PerfilResponse> {

    @Override
    public PerfilResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();
        PerfilResponse perfilResponse = gson.fromJson(json, PerfilResponse.class);
        JsonObject perfilResponseDataObject = json.getAsJsonObject();

        String username = perfilResponseDataObject.get(JsonKeys.USER_NAME).getAsString();
        String urlFoto = perfilResponseDataObject.get(JsonKeys.USER_PROFILE_URL).getAsString();

        Mascota mascota = new Mascota(username);
        Foto foto = new Foto(urlFoto);

        perfilResponse.setMascota(mascota);
        perfilResponse.setFoto(foto);

        return perfilResponse;
    }
}
