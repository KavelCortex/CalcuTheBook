package com.cortek.calcuthebook;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by 嘉维 on 2015/3/20 0020.
 */
public class ThemeDialogFragment extends DialogFragment {

    private static final String TAG="TestTag";

    ImageView col_1,col_2,col_3,col_4,col_5,col_6,col_7,col_8,col_9;

    int backupColor;
    int chosenColor;
    Drawable chosenDrawable;
    View dialogView;
    DialogInterface.OnClickListener dialogListener;
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_theme_dialog, null);
        dialogView = view;
        initThemePad(view);
        builder.setView(view)
               .setPositiveButton(R.string.dialog_positive,dialogListener = new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                       SharedPreferences.Editor editor = prefs.edit();
                       editor.putInt("CurrentTheme",chosenColor);
                       editor.commit();
                       initActionBar();
                   }
               })
               .setNegativeButton(R.string.dialog_negative,dialogListener = new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                       SharedPreferences.Editor editor = prefs.edit();
                       editor.putInt("CurrentTheme", backupColor);
                       editor.commit();
                   }
               });
        return builder.create();
    }

    private void initActionBar() {
        Drawable theme;
        Resources res = this.getResources();
        ActionBar actionBar = getActivity().getActionBar();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        int resId = prefs.getInt("CurrentTheme",R.drawable.red);
        theme = res.getDrawable(resId);
        actionBar.setBackgroundDrawable(theme);
    }

    public void initThemePad(View v){

        ArrayList<ImageView> imageList = new ArrayList<>();
        ArrayList<Integer> colorList = new ArrayList<>();

        col_1 = (ImageView)v.findViewById(R.id.col_1);
        col_2 = (ImageView)v.findViewById(R.id.col_2);
        col_3 = (ImageView)v.findViewById(R.id.col_3);
        col_4 = (ImageView)v.findViewById(R.id.col_4);

        Color.addColor(imageList,col_1,colorList,R.drawable.red);
        Color.addColor(imageList,col_2,colorList,R.drawable.blue);
        Color.addColor(imageList,col_3,colorList,R.drawable.orange);
        Color.addColor(imageList,col_4,colorList,R.drawable.mint);
        Color.initial(imageList,colorList);

        col_1.setOnClickListener(viewListener);
        col_2.setOnClickListener(viewListener);
        col_3.setOnClickListener(viewListener);
        col_4.setOnClickListener(viewListener);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        backupColor = prefs.getInt("CurrentTheme",R.drawable.dogepic);
        chosenColor = backupColor;
        Resources res = this.getResources();
        Drawable chosenDrawable = res.getDrawable(chosenColor);
        ImageView colorPreviewer = (ImageView)dialogView.findViewById(R.id.col_preview);
        colorPreviewer.setBackground(chosenDrawable);
        TextView colorText = (TextView)dialogView.findViewById(R.id.color_text);
        colorText.setText(R.string.dialog_current_color);

    }


    View.OnClickListener viewListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            chosenColor = (Integer)view.getTag();
            chosenDrawable = view.getBackground();
            TextView colorText = (TextView)dialogView.findViewById(R.id.color_text);
            colorText.setText(R.string.dialog_chosen_color);
            ImageView colorPreviewer = (ImageView)dialogView.findViewById(R.id.col_preview);
            colorPreviewer.setBackground(chosenDrawable);
        }
    };

}
