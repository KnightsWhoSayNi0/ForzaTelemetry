package de.henrikkaltenbach.forzatelemetry.activities;

import android.content.Intent;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import android.view.Menu;
import android.view.MenuItem;

import de.henrikkaltenbach.forzatelemetry.BR;
import de.henrikkaltenbach.forzatelemetry.R;
import de.henrikkaltenbach.forzatelemetry.databinding.ActivityMainBinding;
import de.henrikkaltenbach.forzatelemetry.network.UdpListener;
import de.henrikkaltenbach.forzatelemetry.viewmodels.CalculatedViewModel;
import de.henrikkaltenbach.forzatelemetry.viewmodels.TelemetryViewModel;

public class MainActivity extends AppCompatActivity {

    private UdpListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVariable(BR.telemetry, TelemetryViewModel.getInstance());
        binding.setVariable(BR.calculated, CalculatedViewModel.getInstance());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listener = new UdpListener(8080);
        listener.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.settings:
                intent = new Intent(MainActivity.this, SettingsActivity.class);
                break;
            case R.id.about:
                intent = new Intent(MainActivity.this, AboutActivity.class);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        startActivity(intent);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        listener.close();
    }
}