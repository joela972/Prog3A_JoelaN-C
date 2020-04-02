package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Random;

public class FirstFragment extends Fragment {

     int showCountTextView;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
       // View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        // Get the count text view
        //showCountTextView = fragmentFirstLayout.findViewById(R.id.textview_first);

        return inflater.inflate(R.layout.fragment_first, container, false);
       // return fragmentFirstLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Integer count = myArg;
        Random random = new java.util.Random();
        Integer randomNumber = 0;
        if (count > 0) {
            randomNumber = random.nextInt(count + 1);
        }
        Integer myArg = SecondFragmentArgs.fromBundle(getArguments()).getMyArg();
        TextView randomView = view.getRootView().findViewById(R.id.textview_random);
        randomView.setText(randomNumber.toString());
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView showCountTextView = view.getRootView().findViewById(R.id.textview_first);
                int currentCount = Integer.parseInt(showCountTextView.getText().toString());
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(getActivity(), "Hello toast!", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
        view.findViewById(R.id.count_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countMe(view);
            }
        });
    }
    private void countMe(View view) {
        // Get the value of the text view
        String countString = showCountTextView.getText().toString();
        // Convert value to a number and increment it
        Integer count = Integer.parseInt(countString);
        count++;
        // Display the new value in the text view.
        showCountTextView.setText(count.toString());
    }
}
