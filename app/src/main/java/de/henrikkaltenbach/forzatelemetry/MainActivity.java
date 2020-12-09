package de.henrikkaltenbach.forzatelemetry;

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import de.henrikkaltenbach.forzatelemetry.databinding.ActivityMainBinding;
import de.henrikkaltenbach.forzatelemetry.network.ClientListen;
import de.henrikkaltenbach.forzatelemetry.telemetry.TelemetryViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setTelemetry(TelemetryViewModel.getInstance());

        Thread thread = new Thread(new ClientListen());
        thread.start();
    }
}