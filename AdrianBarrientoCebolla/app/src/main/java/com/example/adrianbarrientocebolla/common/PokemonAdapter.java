package com.example.adrianbarrientocebolla.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adrianbarrientocebolla.R;
import com.example.adrianbarrientocebolla.model.Pokemon;

import java.util.List;

public class PokemonAdapter extends BaseAdapter {
    private Context context;
    private List<Pokemon> recursos;

    public PokemonAdapter(Context context, List<Pokemon> recursos) {
        this.context = context;
        this.recursos = recursos;
    }

    @Override
    public int getCount() {
        return recursos.size();
    }

    @Override
    public Object getItem(int position) {
        return recursos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.fila_lv, null);
        }
        TextView txt = convertView.findViewById(R.id.txtFila);
        txt.setText(recursos.get(position).getName());

        return convertView;
    }
}
