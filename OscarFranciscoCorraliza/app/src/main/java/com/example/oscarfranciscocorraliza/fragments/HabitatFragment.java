package com.example.oscarfranciscocorraliza.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.oscarfranciscocorraliza.R;
import com.example.oscarfranciscocorraliza.apiManager.IfaceApi;
import com.example.oscarfranciscocorraliza.apiManager.JsonResponse;
import com.example.oscarfranciscocorraliza.commons.Adapter;
import com.example.oscarfranciscocorraliza.commons.Habitat;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.oscarfranciscocorraliza.commons.Constantes.ENTRY_POINT;

public class HabitatFragment extends Fragment implements Serializable {
    private ImageView img;
    private List<Habitat> habitatList;
    private ListView listView;
    private Adapter adapter;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentpokemons, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView =(ListView) getActivity().findViewById(R.id.fragmentPokemons);
        getHabitat();
    }

    public void getHabitat(){
        Log.d("TAG", "Entra");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENTRY_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IfaceApi ifaceApi = retrofit.create(IfaceApi.class);

        ifaceApi.getHabitat().enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if(response!=null && response.body() != null){
                    Log.d("TAG2", "Sigue entrando");
                    habitatList = response.body().habitatList;

                    adapter = new Adapter(getContext(), habitatList);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

            }
        });
    }
}
