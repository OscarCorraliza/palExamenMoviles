package com.example.adrianbarrientocebolla.api;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.example.adrianbarrientocebolla.common.Constantes.HABITAT;
import static com.example.adrianbarrientocebolla.common.Constantes.TIPO;


public interface PokeApi {

    @Headers({"Accept: application/json , Content-Type: application/json"})
    @GET(HABITAT)
    Call<JsonResponse> getHabitats();

    @Headers({"Accept: application/json , Content-Type: application/json"})
    @GET(TIPO)
    Call<JsonResponse> getTipos();

    @Headers({"Accept: application/json , Content-Type: application/json"})
    @GET(HABITAT+"{id}")
    Call<JsonResponse> getPokemonsByHabitats(@Path("id") int id);

    @Headers({"Accept: application/json , Content-Type: application/json"})
    @GET(TIPO+"{id}")
    Call<JsonResponse> getPokemonsByTipo(@Path("id") int id);

}
