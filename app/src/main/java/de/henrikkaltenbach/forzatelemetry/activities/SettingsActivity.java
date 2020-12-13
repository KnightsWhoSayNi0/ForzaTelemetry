package de.henrikkaltenbach.forzatelemetry.activities;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import de.henrikkaltenbach.forzatelemetry.R;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preferences_main, rootKey);
            Preference ipPreference = findPreference(getString(R.string.key_ip_v4_address));
            if (ipPreference != null) {
                ipPreference.setSummary(getLocalIpv4Address());
            }
        }

        private static String getLocalIpv4Address() {
            final String androidWlan = "wlan0";
            final String localIpV4Prefix = "192.168.";
            try {
                for (Enumeration<NetworkInterface> eNI = NetworkInterface.getNetworkInterfaces(); eNI.hasMoreElements(); ) {
                    NetworkInterface ni = eNI.nextElement();
                    if (ni.getName().equals(androidWlan)) {
                        for (Enumeration<InetAddress> eIA = ni.getInetAddresses(); eIA.hasMoreElements(); ) {
                            InetAddress ia = eIA.nextElement();
                            if (ia.toString().contains(localIpV4Prefix)) {
                                return ia.toString().substring(1);
                            }
                        }
                    }
                }
            } catch (SocketException e) {
                e.printStackTrace();
            }
            return "could not find local ipv4 address.";
        }
    }
}