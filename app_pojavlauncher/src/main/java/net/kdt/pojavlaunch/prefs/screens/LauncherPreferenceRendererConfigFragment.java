package net.kdt.pojavlaunch.prefs.screens;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.*;
import android.widget.Toast;

import androidx.preference.*;

import net.kdt.pojavlaunch.R;
import net.kdt.pojavlaunch.prefs.LauncherPreferences;

//Experimental Settings for Mesa renderer
public class LauncherPreferenceRendererConfigFragment extends LauncherPreferenceFragment {

    @Override
    public void onCreatePreferences(Bundle b, String str) {
        addPreferencesFromResource(R.xml.pref_renderexp);
        computeVisibility();

        // Get RadioGroup Preference
        final PreferenceCategory radioGroupPref = findPreference("radioGroupPref");
        // Adding a Listener for an Option in a RadioGroup
        for (int i = 0; i < radioGroupPref.getPreferenceCount(); i++) {
            final Preference preference = radioGroupPref.getPreference(i);
            preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    // Set Selected Status
                    for (int i = 0; i < radioGroupPref.getPreferenceCount(); i++) {
                        ((SwitchPreference) radioGroupPref.getPreference(i)).setChecked(false);
                    }
                    ((SwitchPreference) preference).setChecked(true);
                    // Perform the appropriate action
                    if (preference.getKey().equals("ZinkF")) {
                        Toast.makeText(view.getContext(), "Default", Toast.LENGTH_SHORT).show();
                    } else if (preference.getKey().equals("ZinkS")) {
                        Toast.makeText(view.getContext(), "Test", Toast.LENGTH_SHORT).show();
                    } else if (preference.getKey().equals("VulkanLwarlip")) {
                        Toast.makeText(view.getContext(), "Test", Toast.LENGTH_SHORT).show();
                    } else if (preference.getKey().equals("Rvirpipe")) {
                        Toast.makeText(view.getContext(), "Test", Toast.LENGTH_SHORT).show();
                    } else if (preference.getKey().equals("Rpanfrost")) {
                        Toast.makeText(view.getContext(), "Test", Toast.LENGTH_SHORT).show();
                    } else if (preference.getKey().equals("Rfreedreno")) {
                        Toast.makeText(view.getContext(), "Test", Toast.LENGTH_SHORT).show();
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
