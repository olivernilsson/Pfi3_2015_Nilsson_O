package com.example.oliver.assignment_4;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_fragment extends Fragment implements AdapterView.OnItemClickListener {

    public static ArrayList<Planet> planets = new ArrayList<Planet>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        planets.clear();
        Drawable d = getResources().getDrawable(R.drawable.mercury);
        planets.add(new Planet(getResources().getString(R.string.mercuryName), d, getResources().getString(R.string.mercuryInfo)));
        d = getResources().getDrawable(R.drawable.venus);
        planets.add(new Planet(getResources().getString(R.string.venusName), d, getResources().getString(R.string.venusInfo)));
        d = getResources().getDrawable(R.drawable.earth);
        planets.add(new Planet(getResources().getString(R.string.earthName), d, getResources().getString(R.string.earthInfo)));
        d = getResources().getDrawable(R.drawable.mars);
        planets.add(new Planet(getResources().getString(R.string.marsName), d, getResources().getString(R.string.marsInfo)));
        d = getResources().getDrawable(R.drawable.jupiter);
        planets.add(new Planet(getResources().getString(R.string.jupiterName), d, getResources().getString(R.string.jupiterInfo)));
        d = getResources().getDrawable(R.drawable.saturn);
        planets.add(new Planet(getResources().getString(R.string.saturnName), d, getResources().getString(R.string.saturnInfo)));
        d = getResources().getDrawable(R.drawable.uranus);
        planets.add(new Planet(getResources().getString(R.string.uranusName), d, getResources().getString(R.string.uranusInfo)));
        d = getResources().getDrawable(R.drawable.neptune);
        planets.add(new Planet(getResources().getString(R.string.neptuneName), d, getResources().getString(R.string.neptuneInfo)));

    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.home_fragment, container, false);
        GridView gridview = (GridView) v.findViewById(R.id.gridView);


        gridview.setAdapter(new ImageAdapter(getActivity(), planets));

        gridview.setOnItemClickListener(this);

        return v;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {

        Info_fragment iF = new Info_fragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("planet",planets.get(position));
        iF.setArguments(bundle);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, iF);
        ft.addToBackStack(null);
        Log.i("BackStack","true");
        ft.commit();

    }
}
