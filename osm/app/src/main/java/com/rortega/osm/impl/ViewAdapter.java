package com.rortega.osm.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rortega.osm.R;
import com.rortega.osm.domain.HttpLocation;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ViewAdapter extends BaseAdapter {

    private Context mContext;
    private int layout;
    private List<HttpLocation> mHttpLocations;

    @Builder
    public ViewAdapter(Context mContext, int layout, List<HttpLocation> mHttpLocations) {
        this.mContext = mContext;
        this.layout = layout;
        this.mHttpLocations = mHttpLocations;
    }


    @Override
    public int getCount() {
        return mHttpLocations.size();
    }

    @Override
    public Object getItem(int position) {
        return mHttpLocations.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_data,null);
        }

        ImageView mImageView = convertView.findViewById(R.id.imgView);
        TextView mTitle = convertView.findViewById(R.id.txtName);
        mImageView.setImageResource(R.drawable.moreinfo_arrow_pressed);
        mTitle.setText(mHttpLocations.get(position).getTitle());
        return convertView;
    }
}
