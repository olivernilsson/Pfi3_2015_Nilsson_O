package com.example.oliver.assignment_4;

import android.app.DialogFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Popup_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Popup_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Popup_fragment extends DialogFragment implements View.OnClickListener {
    public Popup_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.popup_fragment, container, false);
        int style = DialogFragment.STYLE_NO_TITLE, theme = 0;
        setStyle(style, theme);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        TextView t1 = (TextView) v.findViewById(R.id.popup_title);
        TextView t2 = (TextView) v.findViewById(R.id.text_madeby);
        ImageView iv = (ImageView) v.findViewById(R.id.popup_image);

        v.setOnClickListener(this);
        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        iv.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v){
        Popup_fragment.this.dismiss();
    }

}
