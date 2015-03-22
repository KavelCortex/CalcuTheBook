package com.cortek.calcuthebook;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PickBookFragment extends Fragment {

    BigDecimal totalPrice = new BigDecimal(0);
    int checkedBoxCount = 0;
    SimpleAdapter listAdapter;
    ArrayList<Map<String,Object>> mData= new ArrayList<>();
    ArrayList<Object> indexArray = new ArrayList<>();

    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pick_book, container, false);

        final CheckBox cb1 = (CheckBox) v.findViewById(R.id.cb1);
        final CheckBox cb2 = (CheckBox) v.findViewById(R.id.cb2);
        final CheckBox cb3 = (CheckBox) v.findViewById(R.id.cb3);
        final CheckBox cb4 = (CheckBox) v.findViewById(R.id.cb4);
        final CheckBox cb5 = (CheckBox) v.findViewById(R.id.cb5);
        final CheckBox cb6 = (CheckBox) v.findViewById(R.id.cb6);
        final CheckBox cb7 = (CheckBox) v.findViewById(R.id.cb7);
        final CheckBox cb8 = (CheckBox) v.findViewById(R.id.cb8);
        final CheckBox cb9 = (CheckBox) v.findViewById(R.id.cb9);
        final CheckBox cb10 = (CheckBox) v.findViewById(R.id.cb10);
        final CheckBox cb11 = (CheckBox) v.findViewById(R.id.cb11);
        final CheckBox cb12 = (CheckBox) v.findViewById(R.id.cb12);
        final CheckBox cb13 = (CheckBox) v.findViewById(R.id.cb13);
        final CheckBox cb14 = (CheckBox) v.findViewById(R.id.cb14);
        final CheckBox cb15 = (CheckBox) v.findViewById(R.id.cb15);
        final CheckBox cb16 = (CheckBox) v.findViewById(R.id.cb16);
        final CheckBox cb17 = (CheckBox) v.findViewById(R.id.cb17);
        final CheckBox cb18 = (CheckBox) v.findViewById(R.id.cb18);
        final CheckBox cb19 = (CheckBox) v.findViewById(R.id.cb19);
        final CheckBox cb20 = (CheckBox) v.findViewById(R.id.cb20);
        final CheckBox cbAOR = (CheckBox) v.findViewById(R.id.cbAllOrReset);
        final TextView tvTotal = (TextView) v.findViewById(R.id.textView);
        final ListView lvBookDetail = (ListView) v.findViewById(R.id.listView);
        listAdapter = new SimpleAdapter(getActivity(),mData,R.layout.listview_book_detail,new String[]{"title","info"},new int[]{R.id.title,R.id.info});


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
        cbAOR.setOnCheckedChangeListener(listener);

        tvTotal.setOnClickListener(listenerOnClick);
        lvBookDetail.setAdapter(listAdapter);
        return v;
    }
    public View.OnClickListener listenerOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            resetPrice(view);
        }
    };
    public CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
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
                case R.id.cbAllOrReset:
                    allOrReset(isChecked);break;


            }
            final CheckBox cbAOR = (CheckBox)getActivity().findViewById(R.id.cbAllOrReset);
            if(checkedBoxCount!=0)
                //当用户正在使用复选框时，将标题切换成可进行复位操作的提示
                getActivity().setTitle(R.string.checking_title);
            else {
                //当所有复选框都未被选中时恢复标题，因为用户此时不需要进行复位
                getActivity().setTitle(R.string.app_name);
                cbAOR.setText(R.string.AOR_check_all);
            }
        }
    };
    public void resetPrice(View view) {
        //模拟取消选中“全选/复位”复选框时的动作来实现复位功能
        allOrReset(false);
    }


    public void allOrReset(boolean isChecked) {


        final CheckBox cb1 = (CheckBox)getView().findViewById(R.id.cb1);
        final CheckBox cb2 = (CheckBox)getView().findViewById(R.id.cb2);
        final CheckBox cb3 = (CheckBox)getView().findViewById(R.id.cb3);
        final CheckBox cb4 = (CheckBox)getView().findViewById(R.id.cb4);
        final CheckBox cb5 = (CheckBox)getView().findViewById(R.id.cb5);
        final CheckBox cb6 = (CheckBox)getView().findViewById(R.id.cb6);
        final CheckBox cb7 = (CheckBox)getView().findViewById(R.id.cb7);
        final CheckBox cb8 = (CheckBox)getView().findViewById(R.id.cb8);
        final CheckBox cb9 = (CheckBox)getView().findViewById(R.id.cb9);
        final CheckBox cb10 = (CheckBox)getView().findViewById(R.id.cb10);
        final CheckBox cb11 = (CheckBox)getView().findViewById(R.id.cb11);
        final CheckBox cb12 = (CheckBox)getView().findViewById(R.id.cb12);
        final CheckBox cb13 = (CheckBox)getView().findViewById(R.id.cb13);
        final CheckBox cb14 = (CheckBox)getView().findViewById(R.id.cb14);
        final CheckBox cb15 = (CheckBox)getView().findViewById(R.id.cb15);
        final CheckBox cb16 = (CheckBox)getView().findViewById(R.id.cb16);
        final CheckBox cb17 = (CheckBox)getView().findViewById(R.id.cb17);
        final CheckBox cb18 = (CheckBox)getView().findViewById(R.id.cb18);
        final CheckBox cb19 = (CheckBox)getView().findViewById(R.id.cb19);
        final CheckBox cb20 = (CheckBox)getView().findViewById(R.id.cb20);
        final CheckBox cbAOR = (CheckBox)getView().findViewById(R.id.cbAllOrReset);

        if(isChecked) {

            //全选复选框
            cb1.setChecked(true);
            cb2.setChecked(true);
            cb3.setChecked(true);
            cb4.setChecked(true);
            cb5.setChecked(true);
            cb6.setChecked(true);
            cb7.setChecked(true);
            cb8.setChecked(true);
            cb9.setChecked(true);
            cb10.setChecked(true);
            cb11.setChecked(true);
            cb12.setChecked(true);
            cb13.setChecked(true);
            cb14.setChecked(true);
            cb15.setChecked(true);
            cb16.setChecked(true);
            cb17.setChecked(true);
            cb18.setChecked(true);
            cb19.setChecked(true);
            cb20.setChecked(true);

            //修改复选框文字为“复位”
            cbAOR.setText(R.string.AOR_reset);

        }else{

            //取消选择所有复选框
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
            cbAOR.setChecked(false);

            //恢复初始界面文字
            TextView textview = (TextView)getView().findViewById(R.id.textView);
            textview.setText(R.string.reset_complete);
            getActivity().setTitle(R.string.app_name);

            //重置总金额
            totalPrice =new BigDecimal(0);

            //修改复选框文字为“全选”
            cbAOR.setText(R.string.AOR_check_all);
        }
    }

    public void addToData(Object title, Object info){
        Map<String,Object> map = new HashMap<>();
        map.put("title",title);
        map.put("info",info);
        mData.add(map);
        indexArray.add(info);
        listAdapter.notifyDataSetChanged();
        setListHeight(1);
    }
    public void deleteData(Object info){
        int index;
        index=indexArray.lastIndexOf(info);
        mData.remove(index);
        indexArray.remove(index);
        listAdapter.notifyDataSetChanged();
        setListHeight(0);
    }

    public void setListHeight(int status){
        final ListView lvBookDetail = (ListView) getView().findViewById(R.id.listView);
        ListAdapter listAdapter = lvBookDetail.getAdapter();
        if (checkedBoxCount==0) {

            return;
        }

            View listItem = listAdapter.getView(0, null, lvBookDetail);
            listItem.measure(0,0);
            int totalHeight = checkedBoxCount * listItem.getMeasuredHeight();

        ViewGroup.LayoutParams params = lvBookDetail.getLayoutParams();
        params.height = totalHeight + (lvBookDetail.getDividerHeight() * checkedBoxCount);
        lvBookDetail.setLayoutParams(params);
    }

    public void buy1(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_1", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book1));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book1));
            totalPrice = totalPrice.subtract(book);
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy2(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_2", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book + "元", getString(R.string.book2));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book2));
            totalPrice = totalPrice.subtract(book);
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy3(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_3", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book3));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book3));
            totalPrice = totalPrice.subtract(book);
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy4(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_4", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book4));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book4));
            totalPrice = totalPrice.subtract(book);
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy5(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_5", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book5));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book5));
            totalPrice = totalPrice.subtract(book);
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy6(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_6", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book6));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book6));
            totalPrice = totalPrice.subtract(book);
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy7(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_7", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book7));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book7));
            totalPrice = totalPrice.subtract(book);
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy8(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_8", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book8));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book8));
            totalPrice = totalPrice.subtract(book); 
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy9(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_9", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book9));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book9));
            totalPrice = totalPrice.subtract(book); 
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy10(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_10", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book10));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book10));
            totalPrice = totalPrice.subtract(book); 
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy11(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_11", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book11));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book11));
            totalPrice = totalPrice.subtract(book); 
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy12(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_12", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book12));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book12));
            totalPrice = totalPrice.subtract(book); 
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy13(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_13", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book13));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book13));
            totalPrice = totalPrice.subtract(book); 
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy14(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_14", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book14));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book14));
            totalPrice = totalPrice.subtract(book); 
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy15(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_15", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book15));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book15));
            totalPrice = totalPrice.subtract(book); 
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy16(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_16", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book16));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book16));
            totalPrice = totalPrice.subtract(book); 
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy17(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_17", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book17));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book17));
            totalPrice = totalPrice.subtract(book); 
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy18(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_18", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book18));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book18));
            totalPrice = totalPrice.subtract(book); 
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy19(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_19", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book19));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book19));
            totalPrice = totalPrice.subtract(book); 
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
    public void buy20(boolean isChecked) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        TextView textview = (TextView) getView().findViewById(R.id.textView);
        BigDecimal book = new BigDecimal(prefs.getString("book_cost_20", "0"));
        if(isChecked) {
            checkedBoxCount++;
            addToData(book+"元",getString(R.string.book20));
            totalPrice = totalPrice.add(book);
            textview.setText("总金额：" + totalPrice + "元");
        }else{
            checkedBoxCount--;
            deleteData(getString(R.string.book20));
            totalPrice = totalPrice.subtract(book); 
            textview.setText("总金额：" + totalPrice + "元");
        }
    }
}
