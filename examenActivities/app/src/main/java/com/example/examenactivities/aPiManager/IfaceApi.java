package com.example.examenactivities.aPiManager;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import static com.example.examenactivities.common.Constants.HABITAT;
import static com.example.examenactivities.common.Constants.TIPO;

public interface IfaceApi {
    @Headers({"Accept: application/json , Content-Type: application/json"})
    @GET(HABITAT)
    Call<JsonResponse> getHabitats();

    @Headers({"Accept: application/json , Content-Type: application/json"})
    @GET(TIPO)
    Call<JsonResponse> getTipos();

    @Headers({"Accept: application/json , Content-Type: application/json"})
    @GET(HABITAT + "{id}")
    Call<JsonResponse> getHabitatsPorId(@Path("id") int id);

    @Headers({"Accept: application/json , Content-Type: application/json"})
    @GET(TIPO + "{id}")
    Call<JsonResponse> getTiposPorId(@Path("id") int id);
}
