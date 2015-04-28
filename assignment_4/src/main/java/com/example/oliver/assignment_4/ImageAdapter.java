package com.example.oliver.assignment_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ImageAdapter extends ArrayAdapter<Planet> {

    ArrayList<Planet>planets;

    private Context context;

    public ImageAdapter(Context c, ArrayList<Planet>p) {
        super(c, 0, p);
        context = c;
        planets = p;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ImageButton button;
        Planet p = planets.get(position);

        convertView = inflater.inflate(R.layout.list_item, null);
        ImageView i = (ImageView) convertView.findViewById(R.id.iv_planet);
        TextView t = (TextView) convertView.findViewById(R.id.iv_text);

        i.setImageDrawable(p.getImage());
        t.setText(p.getName());

        return convertView;
    }


}