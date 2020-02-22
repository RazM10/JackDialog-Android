package com.example.jackdialoglibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dialoglibrary.JackDialog;

public class MainActivity extends AppCompatActivity {

    JackDialog jackDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jackDialog = new JackDialog(MainActivity.this);
    }

    public void showDialog(View view) {
        jackDialog
                .setCancelable(true)
                .setTitle("Hello", Color.BLUE)
                .setDescription("HELLO WORLD", "#212121")
                .setPositiveButton("Save", R.color.colorPrimary, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Custom Positive Listener", Toast.LENGTH_SHORT).show();
                        jackDialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", "#ff0000", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Custom Negative Listener", Toast.LENGTH_SHORT).show();
                        jackDialog.dismiss();
                    }
                })
                .show();
    }
}
