package com.example.examen.ApiManager;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import static com.example.examen.Common.Constantes.END_POINT_HABITAT;
import static com.example.examen.Common.Constantes.END_POINT_TIPO;

public interface IfaceApi {
    @Headers({"Accept: application/json , Content-Type: application/json"})
    @GET(END_POINT_HABITAT)
    Call<JsonResponse> getHabitat();

    @Headers({"Accept: application/json , Content-Type: application/json"})
    @GET(END_POINT_TIPO)
    Call<JsonResponse> getTipo();


}
