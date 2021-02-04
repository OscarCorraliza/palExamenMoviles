package com.example.oscarfranciscocorraliza.apiManager;

import com.example.oscarfranciscocorraliza.commons.Habitat;
import com.example.oscarfranciscocorraliza.commons.Tipo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResponse {
    @SerializedName("results")
    @Expose
    public final List<Habitat> habitatList=null;

    @SerializedName("results")
    @Expose
    public final List<Tipo> tipoList = null;
}
