package com.DATAS.myapplication; // Replace with your package name

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.DATAS.myapplication.R;

public class MainActivity extends AppCompatActivity {
    // ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupQuickActionButtons();
    }

    private void setupQuickActionButtons() {
        Button btnSosAlert = findViewById(R.id.btnSosAlert);
        Button btnReport = findViewById(R.id.btnReport);
        Button btnGuides = findViewById(R.id.btnGuides);

        btnSosAlert.setOnClickListener(v -> handleSosAlert());
        btnReport.setOnClickListener(v -> handleReport());
        btnGuides.setOnClickListener(v -> handleGuides());
    }

    // 1. SOS Alert Function (Shows confirmation dialog then dials emergency contact)
    private void handleSosAlert() {
        new AlertDialog.Builder(this)
                .setTitle("EMERGENCY SOS")
                .setMessage("Are you sure you want to trigger an immediate emergency alert?")
                .setPositiveButton("YES, CALL SOS", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Action: Open phone dialer with emergency number (e.g., 911 or Campus Security)
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:911")); // Change 911 to your campus security number
                        startActivity(intent);

                        Toast.makeText(MainActivity.this, "Initiating Emergency Call...", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("CANCEL", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    // 2. Report Function (Navigates to Report Incident Screen)
    private void handleReport() {
        Toast.makeText(this, "Opening Incident Report...", Toast.LENGTH_SHORT).show();

        // Uncomment the line below after creating ReportActivity
        // Intent intent = new Intent(MainActivity.this, ReportActivity.class);
        // startActivity(intent);
    }

    // 3. Guides Function (Navigates to Safety Guides Screen or opens safety site)
    private void handleGuides() {
        Toast.makeText(this, "Loading Safety Guides...", Toast.LENGTH_SHORT).show();

        // Option A: Navigate to Guides Activity
        // Intent intent = new Intent(MainActivity.this, GuidesActivity.class);
        // startActivity(intent);

        // Option B: Open an online safety guide PDF/Webpage
        // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.example.com/safety-guides"));
        // startActivity(browserIntent);
    }
}