package com.niec.gaurav.e_cellniec;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class OneFragment extends Fragment implements View.OnClickListener {

    TextView tvachie, tvcontact, tvupcoming,tvprevious;

    public OneFragment() {
        // Required empty public constructor
    }

    public void onChat() {
        Toast.makeText(getContext(), "Feature coming soon..", Toast.LENGTH_LONG).show();
    }

    public void ContactUs() {
        Intent intent = new Intent(getContext(), ContactUs.class);
        startActivity(intent);
    }

    public void onAchievements() {
        Intent intent = new Intent(getContext(), Work.class);
        startActivity(intent);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        tvachie = (TextView) getView().findViewById(R.id.tvAchievement);
        tvcontact = (TextView) getView().findViewById(R.id.tvcontact);
        tvupcoming = (TextView) getView().findViewById(R.id.tvUpcoming);
        tvprevious = (TextView) getView().findViewById(R.id.tvPrevious);

        tvachie.setOnClickListener(this);
        tvcontact.setOnClickListener(this);
        tvupcoming.setOnClickListener(this);
        tvprevious.setOnClickListener(this);



        super.onViewCreated(view, savedInstanceState);

    }


    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.tvAchievement: /** Start a new Activity MyCards.java */
                onAchievements();
                break;

            case R.id.tvcontact: /** AlerDialog when click on Exit */
                ContactUs();
                break;
            case R.id.tvUpcoming:
                Toast.makeText(getContext(),"Upcoming Events Selected",Toast.LENGTH_LONG).show();
                break;

            case R.id.tvPrevious:
                Toast.makeText(getContext(),"Previous Events Selected",Toast.LENGTH_LONG).show();
                break;
        }
    }


}