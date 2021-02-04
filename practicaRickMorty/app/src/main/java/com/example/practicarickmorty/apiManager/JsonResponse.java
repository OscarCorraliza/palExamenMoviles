package com.example.practicarickmorty.apiManager;

import com.example.practicarickmorty.common.Personaje;
import com.example.practicarickmorty.common.SiguienPag;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class JsonResponse {

    /*@SerializedName("info")
    @Expose
    public final ArrayList<SiguienPag> next = null;*/

    @SerializedName("results")
    @Expose
    public final List<Personaje> listaPersonaje= null;


}
