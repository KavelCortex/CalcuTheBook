package com.cortek.calcuthebook;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.about, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id == R.id.action_feedback) {
            feedback();
            return true;
        }
        return super.onOptionsItemSelected(item);
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

    public void feedback(){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.putExtra(Intent.EXTRA_SUBJECT,"关于课本价格计算器V1.5的一些建议");
        intent.putExtra(Intent.EXTRA_TEXT,"你好！关于这个版本的课本价格计算器，我有下面一些想法和建议：");
        intent.setData(Uri.parse("mailto:wjw_wwasd@qq.com"));
        startActivity(intent);
    }
}
