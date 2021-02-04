package com.example.examenactivities.common;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.examenactivities.R;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Context context;
    private List<Pokemon> pokemonList;

    public Adapter(Context context, List<Pokemon> pokemonList) {
        this.context = context;
        this.pokemonList = pokemonList;
    }

    @Override
    public int getCount() {
        return pokemonList.size();
    }

    @Override
    public Object getItem(int position) {
        return pokemonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.fila, null);
        }
        TextView txt = convertView.findViewById(R.id.txtFila);
        Log.d("holaquetal", pokemonList.get(position).getName());
        txt.setText(pokemonList.get(position).getName());

        return convertView;
    }
}
