package net.kdt.pojavlaunch.prefs.screens;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.preference.*;

import java.util.Random;
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
                        // Nothing to do here
                    } else if (preference.getKey().equals("ZinkS")) {
                        // Nothing to do here
                    } else if (preference.getKey().equals("VulkanLwarlip")) {
                        // Nothing to do here
                    } else if (preference.getKey().equals("Rvirpipe")) {
                        // Nothing to do here
                    } else if (preference.getKey().equals("Rpanfrost")) {
                        // Nothing to do here
                    } else if (preference.getKey().equals("Rfreedreno")) {
                        // Nothing to do here
                    }
                    return true;
                }
            });
        }

        ((SwitchPreference) preference).setOnPreferenceLongClickListener(new Preference.OnPreferenceLongClickListener() {
            @Override
            public boolean onPreferenceLongClick(Preference preference) {
                if (preference.getKey().equals("ZinkF")) {
                    showPopupDialogWithRandomCharacter();
                }
                return true;
            }
        });
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

    private void showPopupDialogWithRandomCharacter() {
        String[] characters = {"A", "B", "C"};
        Random random = new Random();
        int index = random.nextInt(characters.length);
        String randomCharacter = characters[index];

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("随机字符：" + randomCharacter);

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
