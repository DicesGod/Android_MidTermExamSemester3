package com.minhle.midtermquestion2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyFragment.DataPasser {

    EditText sendDataEditText;
    Button sendDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize(){
        sendDataEditText = findViewById(R.id.sendDataEditText);
        sendDataButton = findViewById(R.id.addFragment);
        sendDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("keyString",sendDataEditText.getText().toString());
                MyFragment myFragment = new MyFragment();
                myFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragmentContainer,myFragment,"key");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }


    @Override
    public void onPassingData(String data) {
        Log.i("DATAPASSER", data);
        Toast.makeText(getApplicationContext(),"Transaction Confirmed",Toast.LENGTH_LONG).show();
    }
}