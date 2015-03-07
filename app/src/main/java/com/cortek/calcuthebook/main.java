package com.cortek.calcuthebook;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import java.math.BigDecimal;

public class main extends Activity {

    BigDecimal totalPrice = new BigDecimal(0);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final CheckBox cb1 = (CheckBox)findViewById(R.id.cb1);
        final CheckBox cb2 = (CheckBox)findViewById(R.id.cb2);
        final CheckBox cb3 = (CheckBox)findViewById(R.id.cb3);
        final CheckBox cb4 = (CheckBox)findViewById(R.id.cb4);
        final CheckBox cb5 = (CheckBox)findViewById(R.id.cb5);
        final CheckBox cb6 = (CheckBox)findViewById(R.id.cb6);
        final CheckBox cb7 = (CheckBox)findViewById(R.id.cb7);
        final CheckBox cb8 = (CheckBox)findViewById(R.id.cb8);
        final CheckBox cb9 = (CheckBox)findViewById(R.id.cb9);
        final CheckBox cb10 = (CheckBox)findViewById(R.id.cb10);
        final CheckBox cb11 = (CheckBox)findViewById(R.id.cb11);
        final CheckBox cb12 = (CheckBox)findViewById(R.id.cb12);
        final CheckBox cb13 = (CheckBox)findViewById(R.id.cb13);
        final CheckBox cb14 = (CheckBox)findViewById(R.id.cb14);
        final CheckBox cb15 = (CheckBox)findViewById(R.id.cb15);
        final CheckBox cb16 = (CheckBox)findViewById(R.id.cb16);
        final CheckBox cb17 = (CheckBox)findViewById(R.id.cb17);
        final CheckBox cb18 = (CheckBox)findViewById(R.id.cb18);
        final CheckBox cb19 = (CheckBox)findViewById(R.id.cb19);
        final CheckBox cb20 = (CheckBox)findViewById(R.id.cb20);


        //创建监听器
        cb1.setOnCheckedChangeListener(listener);
        cb2.setOnCheckedChangeListener(listener);
        cb3.setOnCheckedChangeListener(listener);
        cb4.setOnCheckedChangeListener(listener);
        cb5.setOnCheckedChangeListener(listener);
        cb6.setOnCheckedChangeListener(listener);
        cb7.setOnCheckedChangeListener(listener);
        cb8.setOnCheckedChangeListener(listener);
        cb9.setOnCheckedChangeListener(listener);
        cb10.setOnCheckedChangeListener(listener);
        cb11.setOnCheckedChangeListener(listener);
        cb12.setOnCheckedChangeListener(listener);
        cb13.setOnCheckedChangeListener(listener);
        cb14.setOnCheckedChangeListener(listener);
        cb15.setOnCheckedChangeListener(listener);
        cb16.setOnCheckedChangeListener(listener);
        cb17.setOnCheckedChangeListener(listener);
        cb18.setOnCheckedChangeListener(listener);
        cb19.setOnCheckedChangeListener(listener);
        cb20.setOnCheckedChangeListener(listener);

    }

    private OnCheckedChangeListener listener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            switch(compoundButton.getId())
            {
                case R.id.cb1:
                    buy1(isChecked);break;
                case R.id.cb2:
                    buy2(isChecked);break;
                case R.id.cb3:
                    buy3(isChecked);break;
                case R.id.cb4:
                    buy4(isChecked);break;
                case R.id.cb5:
                    buy5(isChecked);break;
                case R.id.cb6:
                    buy6(isChecked);break;
                case R.id.cb7:
                    buy7(isChecked);break;
                case R.id.cb8:
                    buy8(isChecked);break;
                case R.id.cb9:
                    buy9(isChecked);break;
                case R.id.cb10:
                    buy10(isChecked);break;
                case R.id.cb11:
                    buy11(isChecked);break;
                case R.id.cb12:
                    buy12(isChecked);break;
                case R.id.cb13:
                    buy13(isChecked);break;
                case R.id.cb14:
                    buy14(isChecked);break;
                case R.id.cb15:
                    buy15(isChecked);break;
                case R.id.cb16:
                    buy16(isChecked);break;
                case R.id.cb17:
                    buy17(isChecked);break;
                case R.id.cb18:
                    buy18(isChecked);break;
                case R.id.cb19:
                    buy19(isChecked);break;
                case R.id.cb20:
                    buy20(isChecked);break;

            }
        }
    };

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

        final CheckBox cb1 = (CheckBox)findViewById(R.id.cb1);
        final CheckBox cb2 = (CheckBox)findViewById(R.id.cb2);
        final CheckBox cb3 = (CheckBox)findViewById(R.id.cb3);
        final CheckBox cb4 = (CheckBox)findViewById(R.id.cb4);
        final CheckBox cb5 = (CheckBox)findViewById(R.id.cb5);
        final CheckBox cb6 = (CheckBox)findViewById(R.id.cb6);
        final CheckBox cb7 = (CheckBox)findViewById(R.id.cb7);
        final CheckBox cb8 = (CheckBox)findViewById(R.id.cb8);
        final CheckBox cb9 = (CheckBox)findViewById(R.id.cb9);
        final CheckBox cb10 = (CheckBox)findViewById(R.id.cb10);
        final CheckBox cb11 = (CheckBox)findViewById(R.id.cb11);
        final CheckBox cb12 = (CheckBox)findViewById(R.id.cb12);
        final CheckBox cb13 = (CheckBox)findViewById(R.id.cb13);
        final CheckBox cb14 = (CheckBox)findViewById(R.id.cb14);
        final CheckBox cb15 = (CheckBox)findViewById(R.id.cb15);
        final CheckBox cb16 = (CheckBox)findViewById(R.id.cb16);
        final CheckBox cb17 = (CheckBox)findViewById(R.id.cb17);
        final CheckBox cb18 = (CheckBox)findViewById(R.id.cb18);
        final CheckBox cb19 = (CheckBox)findViewById(R.id.cb19);
        final CheckBox cb20 = (CheckBox)findViewById(R.id.cb20);

        //取消全部复选框的选定状态
        cb1.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
        cb4.setChecked(false);
        cb5.setChecked(false);
        cb6.setChecked(false);
        cb7.setChecked(false);
        cb8.setChecked(false);
        cb9.setChecked(false);
        cb10.setChecked(false);
        cb11.setChecked(false);
        cb12.setChecked(false);
        cb13.setChecked(false);
        cb14.setChecked(false);
        cb15.setChecked(false);
        cb16.setChecked(false);
        cb17.setChecked(false);
        cb18.setChecked(false);
        cb19.setChecked(false);
        cb20.setChecked(false);


        TextView textview = (TextView)findViewById(R.id.textView);
        textview.setText("--- 价格已重置 ---");

        totalPrice =new BigDecimal(0);
    }
    public void startOrdering(View view){
        Intent intent=new Intent(main.this,order.class);
        startActivity(intent);
    }

    public void goCheckout(View view){}

    public void buy1(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_1", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy2(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_2", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy3(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_3", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy4(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_4", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy5(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_5", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy6(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_6", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy7(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_7", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy8(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_8", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy9(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_9", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy10(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_10", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy11(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_11", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy12(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_12", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy13(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_13", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy14(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_14", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy15(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_15", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy16(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_16", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy17(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_17", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy18(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_18", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy19(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_19", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }
    public void buy20(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        TextView textview = (TextView) findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_20", "0"));
        if(isChecked) {
            totalPrice = totalPrice.add(book);
            textview.setText("金额：" + totalPrice + "元");
        }else{
            totalPrice = totalPrice.subtract(book);
            textview.setText("金额：" + totalPrice + "元");
        }
    }

}
