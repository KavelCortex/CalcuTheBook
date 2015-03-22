package com.cortek.calcuthebook;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by 嘉维 on 2015/3/21 0021.
 */
public class Color {
    public static void initial (ArrayList<ImageView> imageList, ArrayList<Integer> colorList){
        for(int arg0=0;arg0<imageList.size();arg0++){
            ImageView image = imageList.get(arg0);
            image.setImageResource(colorList.get(arg0));
            image.setTag(colorList.get(arg0));
        }
    }
    public static void addColor(ArrayList<ImageView> imageList, ImageView imageView, ArrayList<Integer> colorList, int resId){
        imageList.add(imageView);
        colorList.add(resId);
    }
}
