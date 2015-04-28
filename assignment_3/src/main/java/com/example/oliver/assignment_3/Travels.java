package com.example.oliver.assignment_3;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.os.AsyncTask;
import android.view.MenuItem;
import android.widget.Spinner;

import java.util.ArrayList;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class Travels extends Fragment implements AdapterView.OnItemSelectedListener {

    ArrayList<Journey> journeyList = new ArrayList<Journey>();

        private Spinner spinnerFrom;
        private Spinner spinnerTo;
        private Adapter adapter;

    public Travels() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_travels, container, false);

        spinnerFrom = (Spinner) view.findViewById(R.id.spinner);
        spinnerTo = (Spinner) view.findViewById(R.id.spinner2);

        ExpandableListView expl = (ExpandableListView) view.findViewById(R.id.expandableListView);
        adapter = new Adapter(getActivity(),journeyList);
        expl.setAdapter(adapter);

        spinnerFrom.setSelection(1);
        spinnerFrom.setOnItemSelectedListener(this);
        spinnerTo.setOnItemSelectedListener(this);

        setHasOptionsMenu(true);

        return view;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_search) {
            Log.i("action_search", "started");

            int fromStation = spinnerFrom.getSelectedItemPosition();
            int toStation = spinnerTo.getSelectedItemPosition();


            String[] stationNo = getResources().getStringArray(R.array.stationNumbers);
            String searchURL = Constants.getURL(stationNo[fromStation], stationNo[toStation], 5);
            journeyList.clear();

            new DoInBackground().execute(searchURL);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        int fromStation = spinnerFrom.getSelectedItemPosition();
        int toStation = spinnerTo.getSelectedItemPosition();

        String[] stationNo = getResources().getStringArray(R.array.stationNumbers);
        String searchURL = Constants.getURL( stationNo[fromStation], stationNo[toStation], 5);
        new DoInBackground().execute(searchURL);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private class DoInBackground extends AsyncTask<String, Void, Long> {
        @Override
        protected Long doInBackground(String... params){
            Journeys journeys =Parser.getJourneys(params[0]);
            journeyList.clear();
            journeyList.addAll(journeys.getJourneys());
            return null;
        }

        @Override
        protected void onPostExecute (Long result){

            adapter.notifyDataSetChanged();
            for (Journey si :journeyList){
                Log.i("ExpFragment", "moment" + si.getStartStation().getStationName());

            }

        }
    }
}
