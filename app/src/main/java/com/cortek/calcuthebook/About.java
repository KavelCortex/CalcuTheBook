package com.cortek.calcuthebook;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class About extends Activity {

    int dogeClicked = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT)
            setContentView(R.layout.activity_about_portrait);
        else
            setContentView(R.layout.activity_about_landscape);
        /*doge.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                dogeClicked++;
                switch(dogeClicked/2) {
                    case 0:
                        doge.setImageDrawable(getResources().getDrawable(R.drawable.dogepic));break;
                    case 1:
                        doge.setImageDrawable(getResources().getDrawable(R.drawable.dogepicrev));break;
                }
            }
        });*/
    }

    public void dogeTurn(View v) {
        ImageView dogePortrait = (ImageView)findViewById(R.id.dogePortrait);
        ImageView dogeLandscape = (ImageView)findViewById(R.id.dogeLandscape);
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT)
            switch (dogeClicked) {
                case 0:
                    dogePortrait.setImageDrawable(getResources().getDrawable(R.drawable.dogepicrev));
                    dogeClicked = 1;
                    break;
                case 1:
                    dogePortrait.setImageDrawable(getResources().getDrawable(R.drawable.dogepic));
                    dogeClicked = 0;
                    break;
            }
        else
            switch (dogeClicked) {
                case 0:
                    dogeLandscape.setImageDrawable(getResources().getDrawable(R.drawable.dogepicrev));
                    dogeClicked = 1;
                    break;
                case 1:
                    dogeLandscape.setImageDrawable(getResources().getDrawable(R.drawable.dogepic));
                    dogeClicked = 0;
                    break;
            }
    }
}
