package de.henrikkaltenbach.forzatelemetry.activities;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import de.henrikkaltenbach.forzatelemetry.BuildConfig;
import de.henrikkaltenbach.forzatelemetry.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        TextView tvVersion = findViewById(R.id.tvVersion);
        tvVersion.setText("Version " + BuildConfig.VERSION_NAME);
    }
}