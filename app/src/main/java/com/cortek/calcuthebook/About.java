package com.cortek.calcuthebook;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
        initActionBar();
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
        switch (id) {
            case R.id.action_feedback:
                feedback(); break;
            case R.id.action_theme:
                theme(); break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initActionBar() {
        Drawable theme;
        Resources res = this.getResources();
        ActionBar actionBar = getActionBar();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int resId = prefs.getInt("CurrentTheme",R.drawable.red);
        theme = res.getDrawable(resId);
        actionBar.setBackgroundDrawable(theme);
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

    public void theme(){
        ThemeDialogFragment dialog = new ThemeDialogFragment();
        dialog.show(getFragmentManager(),"themeDialog");
    }
    public void feedback(){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.feedback_subject));
        intent.putExtra(Intent.EXTRA_TEXT,getString(R.string.feedback_text));
        intent.setData(Uri.parse(getString(R.string.mailto)));
        startActivity(intent);
    }
}
