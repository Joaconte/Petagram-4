package jcg.petagram.restApi;

import jcg.petagram.restApi.model.FotoResponse;
import jcg.petagram.restApi.model.PerfilResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IEndpointsApi {

    @GET(ConstantesRestApi.URL_GET_MEDIA_USER)
    Call<FotoResponse> getMedia();

    @GET(ConstantesRestApi.URL_GET_INFORMATION_USER)
    Call<PerfilResponse> getInfoPerfil();

}
