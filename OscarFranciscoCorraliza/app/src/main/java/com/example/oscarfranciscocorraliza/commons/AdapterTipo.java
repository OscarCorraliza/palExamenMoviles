package com.example.oscarfranciscocorraliza.commons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oscarfranciscocorraliza.R;

import java.util.List;

public class AdapterTipo extends BaseAdapter {
    private Context mContext;
    private List<Tipo> tipoList;

    public AdapterTipo(Context mContext, List<Tipo> tipoList) {
        this.mContext = mContext;
        this.tipoList = tipoList;
    }

    @Override
    public int getCount() {
        return tipoList.size();
    }

    @Override
    public Object getItem(int position) {
        return tipoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listpokemon, null);
        }
        TextView textView=convertView.findViewById(R.id.txtPools);
        textView.setText(tipoList.get(position).getTipo());
        ImageView imagen = convertView.findViewById(R.id.pokeball);
        imagen.setImageResource(R.drawable.ic_pokeball);

        return convertView;
    }
}
