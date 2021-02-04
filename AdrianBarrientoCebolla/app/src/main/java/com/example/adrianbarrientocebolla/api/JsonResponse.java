package com.example.adrianbarrientocebolla.api;
import com.example.adrianbarrientocebolla.model.Pokemon;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResponse {
    @SerializedName("results")
    @Expose
    public final List<Pokemon> results=null;

    @SerializedName("pokemon_species")
    @Expose
    public final List<Pokemon> pokemon_species=null;
}
