package com.cortek.calcuthebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class main extends Activity {

    //初始化页面指示器
    private Bitmap cursor;
    private int bmWidth;
    private int offSet;
    private float scrollPath;
    private float scrollStart;
    private float scrollEnd;
    private int currentItem;
    private Matrix matrix = new Matrix();
    //private Animation animation;
    //private int animationDuration=200;//动画速度(ms)

//初始化ViewPager与FragmentList
    private ViewPager viewPager;//ViewPager
    private FragPagerAdapter fAdapter;//fragmentPager适配器
    private ArrayList<Fragment> fragList = new ArrayList<>();//fragment形式的页卡



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        initCursor();//初始化页面指示器

        //初始化两个页面并添加到FragmentList
        Fragment pickBookFragment = new PickBookFragment();
        Fragment bookPriceFragment = new BookPriceFragment();
        fragList.add(0,pickBookFragment);
        fragList.add(1,bookPriceFragment);

        //设定适配器
        fAdapter = new FragPagerAdapter(getFragmentManager(), fragList);

        //设定ViewPager
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(fAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            //当切换页面时，页面指示器进行滑动的动画效果
            ImageView cursorImage = (ImageView) findViewById(R.id.cursor);
            @Override
            public void onPageSelected(int arg0) {

                //这个动画得出来的效果不好，已舍去
                /*switch (arg0) {
                    case 0:
                        if (currentItem == 1) {
                            animation = new TranslateAnimation(
                                    offSet * 2 + bmWidth, 0, 0, 0);
                        }

                        break;
                    case 1:
                        if (currentItem == 0) {
                            animation = new TranslateAnimation(
                                    0, offSet * 2 + bmWidth, 0, 0);
                        }

                        break;
                }*/
                currentItem = arg0;

                //animation.setDuration(animationDuration);
                //animation.setFillAfter(true);
                //ImageView cursorImage = (ImageView) findViewById(R.id.cursor);
                //cursorImage.startAnimation(animation);


            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                //新动画效果，能够实时根据页面位置改变指示器的位置
                switch (position){
                    case 0:
                        matrix.setTranslate(scrollStart + scrollPath * positionOffset,0);
                        cursorImage.setImageMatrix(matrix);
                        break;
                    case 1:
                        matrix.setTranslate(scrollEnd - scrollPath * positionOffset,0);
                        cursorImage.setImageMatrix(matrix);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }


        });

        TextView tvPickBooks = (TextView) findViewById(R.id.tvPickBooks);
        tvPickBooks.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                viewPager.setCurrentItem(0);
            }
        });

        TextView tvSetPrice = (TextView) findViewById(R.id.tvSetPrice);
        tvSetPrice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                viewPager.setCurrentItem(1);
            }
        });


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
        if (id == R.id.action_about) {
            Intent intent = new Intent(main.this, About.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initCursor() {
        cursor = BitmapFactory.decodeResource(getResources(), R.drawable.cursor);
        bmWidth = cursor.getWidth();

        DisplayMetrics dm;
        dm = getResources().getDisplayMetrics();

        offSet = (dm.widthPixels - 2 * bmWidth) / 4;
        scrollStart = offSet;
        scrollEnd = offSet * 3 + bmWidth;
        scrollPath = scrollEnd - scrollStart;
        matrix.setTranslate(offSet, 0);
        ImageView cursorImage = (ImageView) findViewById(R.id.cursor);
        cursorImage.setImageMatrix(matrix);
        currentItem = 0;
    }

}
