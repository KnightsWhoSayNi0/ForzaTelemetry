package de.henrikkaltenbach.forzatelemetry;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
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

        listener = new UdpListener(8080);
        listener.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        listener.close();
    }
}