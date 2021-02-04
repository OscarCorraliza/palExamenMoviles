package com.example.examen.ApiManager;

import com.example.examen.Common.Pokemon;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonResponse {
    @SerializedName("results")
    @Expose
    public final List<Pokemon> results= null;
}
