package com.cortek.calcuthebook;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

/**
 * Created by 嘉维 on 2015/3/19 0019.
 */
public class BookPriceFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_cost);
        setupSimplePreferencesScreen();
    }
    private void setupSimplePreferencesScreen() {


        // In the simplified UI, fragments are not used at all and we instead
        // use the older PreferenceActivity APIs.

        // Add 'general' preferences.
        addPreferencesFromResource(R.xml.pref_cost);


        // Bind the summaries of EditText/List/Dialog/Ringtone preferences to
        // their values. When their values change, their summaries are updated
        // to reflect the new value, per the Android Design guidelines.
        bindPreferenceSummaryToValue(findPreference("book_cost_1"));
        bindPreferenceSummaryToValue(findPreference("book_cost_2"));
        bindPreferenceSummaryToValue(findPreference("book_cost_3"));
        bindPreferenceSummaryToValue(findPreference("book_cost_4"));
        bindPreferenceSummaryToValue(findPreference("book_cost_5"));
        bindPreferenceSummaryToValue(findPreference("book_cost_6"));
        bindPreferenceSummaryToValue(findPreference("book_cost_7"));
        bindPreferenceSummaryToValue(findPreference("book_cost_8"));
        bindPreferenceSummaryToValue(findPreference("book_cost_9"));
        bindPreferenceSummaryToValue(findPreference("book_cost_10"));
        bindPreferenceSummaryToValue(findPreference("book_cost_11"));
        bindPreferenceSummaryToValue(findPreference("book_cost_12"));
        bindPreferenceSummaryToValue(findPreference("book_cost_13"));
        bindPreferenceSummaryToValue(findPreference("book_cost_14"));
        bindPreferenceSummaryToValue(findPreference("book_cost_15"));
        bindPreferenceSummaryToValue(findPreference("book_cost_16"));
        bindPreferenceSummaryToValue(findPreference("book_cost_17"));
        bindPreferenceSummaryToValue(findPreference("book_cost_18"));
        bindPreferenceSummaryToValue(findPreference("book_cost_19"));
        bindPreferenceSummaryToValue(findPreference("book_cost_20"));
    }

    private static Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new Preference.OnPreferenceChangeListener() {
        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            String stringValue = value.toString();



            // For all other preferences, set the summary to the value's
            // simple string representation.
            preference.setSummary(stringValue+"元");

            return true;
        }
    };

    private static void bindPreferenceSummaryToValue(Preference preference) {
        // Set the listener to watch for value changes.
        preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);

        // Trigger the listener immediately with the preference's
        // current value.
        sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
                PreferenceManager
                        .getDefaultSharedPreferences(preference.getContext())
                        .getString(preference.getKey(),"0"));
    }
}
