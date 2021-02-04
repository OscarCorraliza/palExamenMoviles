package com.example.practicarickmorty.common;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.practicarickmorty.R;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Context context;
    private List<Personaje> personajeList;

    public Adapter(Context context, List<Personaje> personajeList) {
        this.context = context;
        this.personajeList = personajeList;
    }

    @Override
    public int getCount() {
        return personajeList.size();
    }

    @Override
    public Object getItem(int position) {
        return personajeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list, null);
        }
        TextView txt = convertView.findViewById(R.id.txtFila);
        txt.setText(personajeList.get(position).getName());

        return convertView;
    }
}
