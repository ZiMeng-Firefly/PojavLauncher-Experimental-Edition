package net.kdt.pojavlaunch.prefs.screens;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

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
                        Toast.makeText(getContext(), R.string.mcl_setting_renderer_default, Toast.LENGTH_SHORT).show();
                    } else if (preference.getKey().equals("ZinkS")) {
                        Toast.makeText(getContext(), R.string.mcl_setting_renderer_zinks, Toast.LENGTH_SHORT).show();
                    } else if (preference.getKey().equals("VulkanLwarlip")) {
                        Toast.makeText(getContext(), R.string.mcl_setting_renderer_zinkt, Toast.LENGTH_SHORT).show();
                    } else if (preference.getKey().equals("Rvirpipe")) {
                        Toast.makeText(getContext(), R.string.mcl_setting_renderer_virgl, Toast.LENGTH_SHORT).show();
                    } else if (preference.getKey().equals("Rpanfrost")) {
                        Toast.makeText(getContext(), R.string.mcl_setting_renderer_pan, Toast.LENGTH_SHORT).show();
                    } else if (preference.getKey().equals("Rfreedreno")) {
                        Toast.makeText(getContext(), R.string.mcl_setting_renderer_fd, Toast.LENGTH_SHORT).show();
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

        Preference experimentalSetUpPreference = requirePreference("ExperimentalSetup");
        boolean isExperimentalSetUpEnabled = p.getBoolean("ExperimentalSetup", false);

        if (((SwitchPreference) preference).getKey().equals("ExperimentalSetup")) {
            if (isExperimentalSetUpEnabled) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Warning");
                builder.setMessage("You have turned on experimental settings.This feature may generate unexpected bugs.Continue to use?");
                builder.setPositiveButton("Fuck", null);
                builder.setNegativeButton("Fear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences.Editor editor = p.edit();
                        editor.putBoolean("ExperimentalSetup", false);
                        editor.apply();
                    }
                });
                AlertDialog dialog = builder.create();
                builder.show();
            }
        }
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
        //Generate any of 3 characters
        String[] characters = {"A", "B", "C"};
        Random random = new Random();
        int index = random.nextInt(characters.length);
        String randomCharacter = characters[index];

        // Create AlertDialog. Builder and set popup content
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("anything：" + randomCharacter);

        // Set the pop-up window button
        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        // Create and display popup
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
