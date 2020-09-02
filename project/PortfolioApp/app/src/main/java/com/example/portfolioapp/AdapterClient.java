package com.example.portfolioapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterClient extends BaseAdapter {
    Context context;
    List<ClientModel> clientModels;

    public AdapterClient(Context context, List<ClientModel> clientModels) {
        this.context = context;
        this.clientModels = clientModels;
    }

    @Override
    public int getCount() {
        return clientModels.size();
    }

    @Override
    public Object getItem(int position) {
        return clientModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ClientModel clientModel = clientModels.get(position);
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.item_client,parent,false);

            viewHolder.certificate_imageView = convertView.findViewById(R.id.item_image);
            viewHolder.textView = convertView.findViewById(R.id.certificate_textview);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(clientModel.image).into(viewHolder.certificate_imageView);
        viewHolder.textView.setText(clientModel.name);
        return convertView;
    }

    private static class ViewHolder{
        ImageView certificate_imageView;
        TextView textView;
    }
}
