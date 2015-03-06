package com.cortek.calcuthebook;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class main extends Activity {

    double totalPrice=0;
    float tpf=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_order) {
            Intent intent=new Intent(main.this,order.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.action_about) {
            Intent intent=new Intent(main.this,About.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void resetPrice(View view) {
        TextView textview = (TextView)findViewById(R.id.textView);
        textview.setText("--- 价格已重置 ---");
        totalPrice=0;
    }
    public void startOrdering(View view){
        Intent intent=new Intent(main.this,order.class);
        startActivity(intent);
    }
    public void buy1(View view) {
        SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(this) ;
        TextView textview = (TextView)findViewById(R.id.textView);
        totalPrice=totalPrice+ Double.parseDouble(prefs.getString("book_cost_1", "0"));
        textview.setText("金额："+ totalPrice + "元");
    }
    public void buy2(View view) {
        SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(this) ;
        TextView textview = (TextView)findViewById(R.id.textView);
        totalPrice=totalPrice+Double.parseDouble(prefs.getString("book_cost_2","0"));
        textview.setText("金额：" + totalPrice + "元");
    }
    public void buy3(View view) {
        SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(this) ;
        TextView textview = (TextView)findViewById(R.id.textView);
        totalPrice=totalPrice+Double.parseDouble(prefs.getString("book_cost_3","0"));
        textview.setText("金额：" + totalPrice + "元");
    }
    public void buy4(View view) {
        SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(this) ;
        TextView textview = (TextView)findViewById(R.id.textView);
        totalPrice=totalPrice+Double.parseDouble(prefs.getString("book_cost_4","0"));
        textview.setText("金额：" + totalPrice + "元");
    }
    public void buy5(View view) {
        SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(this) ;
        TextView textview = (TextView)findViewById(R.id.textView);
        totalPrice=totalPrice+Double.parseDouble(prefs.getString("book_cost_5","0"));
        textview.setText("金额：" + totalPrice + "元");
    }
    public void buy6(View view) {
        SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(this) ;
        TextView textview = (TextView)findViewById(R.id.textView);
        totalPrice=totalPrice+Double.parseDouble(prefs.getString("book_cost_6","0"));
        textview.setText("金额：" + totalPrice + "元");
    }
    public void buy7(View view) {
        SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(this) ;
        TextView textview = (TextView)findViewById(R.id.textView);
        totalPrice=totalPrice+Double.parseDouble(prefs.getString("book_cost_7","0"));
        textview.setText("金额：" + totalPrice + "元");
    }
    public void buy8(View view) {
        SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(this) ;
        TextView textview = (TextView)findViewById(R.id.textView);
        totalPrice=totalPrice+Double.parseDouble(prefs.getString("book_cost_8","0"));
        textview.setText("金额：" + totalPrice + "元");
    }
    public void buy9(View view) {
        SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(this) ;
        TextView textview = (TextView)findViewById(R.id.textView);
        totalPrice=totalPrice+Double.parseDouble(prefs.getString("book_cost_9","0"));
        textview.setText("金额：" + totalPrice + "元");
    }
    public void buy10(View view) {
        SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(this) ;
        TextView textview = (TextView)findViewById(R.id.textView);
        totalPrice=totalPrice+Double.parseDouble(prefs.getString("book_cost_10","0"));
        textview.setText("金额：" + totalPrice + "元");
    }
    public void buy11(View view) {
        SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(this) ;
        TextView textview = (TextView)findViewById(R.id.textView);
        totalPrice=totalPrice+Double.parseDouble(prefs.getString("book_cost_11","0"));
        textview.setText("金额：" + totalPrice + "元");
    }

}
