package com.minhle.midtermquestion2;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MyFragment extends Fragment {

    public  interface DataPasser{
        public void onPassingData(String data);
    }

    Button confirmButton;
    TextView textView;

    DataPasser dataPasser;

    //public static int count;

    private String data;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        dataPasser = (DataPasser) context;
    }

    @Override
    public void onCreate(@Nullable Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        assert this.getArguments() != null;
        this.data = this.getArguments().getString("keyString");
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
          assert this.getArguments() != null;
          String test = data;
//        Log.i("keyString",test);
//        count++;
        return inflater.inflate(R.layout.my_fragment, container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initialize();

    }

    public void initialize(){

        textView = getActivity().findViewById(R.id.textView);
        textView.setText(data);

        confirmButton = getActivity().findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                dataPasser.onPassingData("onPassingData: Hello!!!");
                getActivity().onBackPressed();
            }
        });


    }

}

