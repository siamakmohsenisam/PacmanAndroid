package com.example.siamakmohsenisam.project_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout myView;
    Button btnStart,btnStop;
    TextView txtCatch, txtScore, txtNoCatch;

    CustomView customView;
    Animation animation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inisialize();
    }

    private void inisialize() {

        myView = (LinearLayout) findViewById(R.id.myView);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);

        txtCatch = (TextView) findViewById(R.id.txtCatch);
        txtScore = (TextView) findViewById(R.id.txtScore);
        txtNoCatch = (TextView) findViewById(R.id.txtNoCatch);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        customView = new CustomView(this);
        myView.addView(customView);
        animation = new Animation(customView);

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnStart:
                animation.start();
                break;

            case R.id.btnStop:
                animation.stop();
                txtNoCatch.setText(String.format("%6.0f",Result.numNoCatch));
                txtCatch.setText(String.format("%6.0f",Result.numCatch));
                txtScore.setText(String.format("%6.2f",Result.score()));
                break;

        }
    }
}
