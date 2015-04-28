package com.example.oliver.assignment_4;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class Info_fragment extends Fragment {


    public Info_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate (Bundle savedInstanceStart){
        super.onCreate(savedInstanceStart);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Planet planet = (Planet)getArguments().getSerializable("planet");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.info_fragment, container, false);

        ImageView i = (ImageView) v.findViewById(R.id.planetFactImage);
        i.setImageDrawable(planet.getImage());

        TextView t1 = (TextView) v.findViewById(R.id.factTitle);
        t1.setText(planet.getName());

        TextView t2 = (TextView) v.findViewById(R.id.factDescription);
        t2.setText(planet.getInfo());

        return v;
    }


}
