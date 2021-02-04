package com.example.examen.Common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.examen.R;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Context mContext;
    private List<Pokemon> listPokemon;
    private FragmentActivity fragmentActivity;


    public Adapter(Context mContext, List<Pokemon> listPokemon, FragmentActivity fragmentActivity){
        this.mContext = mContext;
        this.listPokemon = listPokemon;
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public int getCount() {
        return listPokemon.size();
    }

    @Override
    public Object getItem(int position) {
        return listPokemon.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listpokemon, null);
        }
        TextView textView = convertView.findViewById(R.id.txtPokemon);
        textView.setText(listPokemon.get(position).getName());
        return convertView;
    }

}
