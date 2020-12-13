package de.henrikkaltenbach.forzatelemetry.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.preference.PreferenceManager;

import de.henrikkaltenbach.forzatelemetry.BR;
import de.henrikkaltenbach.forzatelemetry.R;
import de.henrikkaltenbach.forzatelemetry.databinding.ActivityMainBinding;
import de.henrikkaltenbach.forzatelemetry.network.UdpListener;
import de.henrikkaltenbach.forzatelemetry.viewmodels.CalculatedViewModel;
import de.henrikkaltenbach.forzatelemetry.viewmodels.TelemetryViewModel;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private UdpListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVariable(BR.telemetry, TelemetryViewModel.getInstance());
        binding.setVariable(BR.calculated, CalculatedViewModel.getInstance());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);

        AppCompatDelegate.setDefaultNightMode(Integer.parseInt(sharedPreferences.getString(getString(R.string.key_theme), getString(R.string.default_theme))));

        startListener(sharedPreferences);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                return true;
            case R.id.about:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch (key) {
            case "port":
                startListener(sharedPreferences);
                return;
            case "raceOn":
                boolean onlyIfRaceIsOn = sharedPreferences.getBoolean(getString(R.string.key_race_on), true);
                listener.setRaceOn(onlyIfRaceIsOn);
                return;
            case "processingRate":
                int processingRate = Integer.parseInt(sharedPreferences.getString(getString(R.string.key_processing_rate), getString(R.string.default_processing_rate)));
                listener.setProcessingRate(processingRate);
                return;
            case "calculationRate":
                int calculationRate = Integer.parseInt(sharedPreferences.getString(getString(R.string.key_calculation_rate), getString(R.string.default_calculation_rate)));
                listener.setCalculationRate(calculationRate);
                return;
            case "sectorRate":
                int sectorRate = Integer.parseInt(sharedPreferences.getString(getString(R.string.key_sector_calculation_rate), getString(R.string.default_sector_calculation_rate)));
                listener.setSectorCalculationRate(sectorRate);
                return;
            case "theme":
                AppCompatDelegate.setDefaultNightMode(Integer.parseInt(sharedPreferences.getString(getString(R.string.key_theme), getString(R.string.default_theme))));
                return;
            default:
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        listener.close();
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    }

    private void startListener(SharedPreferences sharedPreferences) {
        final int MAX_PORT = 65535;
        int port = Integer.parseInt(sharedPreferences.getString(getString(R.string.key_port), getString(R.string.default_port)));
        if (port > MAX_PORT) {
            sharedPreferences.edit().putString(getString(R.string.key_port), getString(R.string.default_port)).commit();
            port = Integer.parseInt(getString(R.string.default_port));
            Toast.makeText(getApplicationContext(), getString(R.string.toast_port_reset), Toast.LENGTH_SHORT).show();
        }
        if (listener != null) {
            listener.close();
        }
        listener = new UdpListener(port);
        listener.start();
    }
}