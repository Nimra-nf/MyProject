package com.example.youmatter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static androidx.recyclerview.widget.RecyclerView.*;

public class CustomAdapter extends ArrayAdapter {

    ArrayList<String> image;
    ArrayList<String> foodname;
    Context myContext;

    public CustomAdapter(@NonNull Context context, ArrayList<String> imageid, ArrayList<String> name) {
        super(context, R.layout.foodlist_layout);
        this.image = imageid;
        this.foodname = name;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder VH = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) myContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.foodlist_layout, parent, false);
            VH.myimage = (ImageView) convertView.findViewById(R.id.foodimage);
            VH.myname = (TextView) convertView.findViewById(R.id.foodname);
            convertView.setTag(VH);
        } else {
            VH = (ViewHolder) convertView.getTag();
        }
        VH.myimage.setImageResource(Integer.parseInt(image.get(position)));
        VH.myname.setText(foodname.get(position));

        return convertView;
    }
    static class ViewHolder {
        ImageView myimage;
        TextView myname;
    }
}
