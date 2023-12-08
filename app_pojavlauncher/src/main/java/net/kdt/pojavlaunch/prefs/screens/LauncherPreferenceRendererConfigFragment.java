package net.kdt.pojavlaunch.prefs.screens;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.SwitchPreference;
import androidx.preference.SwitchPreferenceCompat;

import net.kdt.pojavlaunch.R;
import net.kdt.pojavlaunch.Tools;
import net.kdt.pojavlaunch.prefs.CustomSeekBarPreference;
import net.kdt.pojavlaunch.prefs.LauncherPreferences;

/**
 * Fragment for any settings video related
 */
public class LauncherPreferenceRendererConfigFragment extends LauncherPreferenceFragment {

    @Override
    public void onCreatePreferences(Bundle b, String str) {
        addPreferencesFromResource(R.xml.pref_renderexp);
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
    }
}
