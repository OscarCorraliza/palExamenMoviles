package com.example.practicarickmorty.apiManager;

import com.example.practicarickmorty.MainActivity2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

import static com.example.practicarickmorty.common.Constantes.PERSONAJES;

public interface ifaceApi {

    @Headers({"Accept: application/json , Content-Type: application/json"})
    @GET
    Call<JsonResponse> getPersonajes(@Url String url);


}
