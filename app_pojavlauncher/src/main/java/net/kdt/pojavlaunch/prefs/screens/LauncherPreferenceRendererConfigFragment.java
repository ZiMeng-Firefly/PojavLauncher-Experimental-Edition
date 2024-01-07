package net.kdt.pojavlaunch.prefs.screens;

import android.content.SharedPreferences;
import android.os.Bundle;

import net.kdt.pojavlaunch.R;
import net.kdt.pojavlaunch.prefs.LauncherPreferences;

//Experimental Settings for Mesa renderer
public class LauncherPreferenceRendererConfigFragment extends LauncherPreferenceFragment {

    @Override
    public void onCreatePreferences(Bundle b, String str) {
        addPreferencesFromResource(R.xml.pref_renderexp);
        computeVisibility();

        // Get RadioGroup Preference
        final PreferenceCategory radioGroupPref = (PreferenceCategory) findPreference("radioGroupPref");
        // Adding a Listener for an Option in a RadioGroup
        for (int i =0; i < radioGroupPref.getPreferenceCount(); i++) {
            radioGroupPref.getPreference(i).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    // Set Selected Status
                    for (int i =0; i < radioGroupPref.getPreferenceCount(); i++) {
                        radioGroupPref.getPreference(i).setChecked(false);
                    }
                    preference.setChecked(true);
                    // Perform the appropriate action
                    if (preference.getKey().equals("option1")) {
                        // Perform the operation of option one
                    } else if (preference.getKey().equals("option2")) {
                        // Perform the operation of option 2
                    } else if (preference.getKey().equals("option3")) {
                        // Perform the operation of option three
                    }
                    return true;
                }
            });
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences p, String s) {
        super.onSharedPreferenceChanged(p, s);
        computeVisibility();
    }

    private void computeVisibility(){
        requirePreference("ZinkF").setVisible(LauncherPreferences.PREF_EXP_SETUP);
        requirePreference("ZinkS").setVisible(LauncherPreferences.PREF_EXP_SETUP);
        requirePreference("VulkanLwarlip").setVisible(LauncherPreferences.PREF_EXP_SETUP);
        requirePreference("Rvirpipe").setVisible(LauncherPreferences.PREF_EXP_SETUP);
        requirePreference("Rpanfrost").setVisible(LauncherPreferences.PREF_EXP_SETUP);
        requirePreference("Rfreedreno").setVisible(LauncherPreferences.PREF_EXP_SETUP);
    }
}
