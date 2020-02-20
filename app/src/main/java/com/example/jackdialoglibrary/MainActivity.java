package com.example.jackdialoglibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dialoglibrary.JackDialog;
import com.example.dialoglibrary.NegativeButtonListener;
import com.example.dialoglibrary.PositiveButtonListener;

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
                .setCancelable(false)
                .setTitle("Hello",Color.BLUE)
                .setDescription("HELLO WORLD","#212121")
                .setPositiveButton("Save", R.color.colorPrimary, new PositiveButtonListener() {
                    @Override
                    public void onPositiveButtonClickListener(AlertDialog dialog) {
                        Toast.makeText(MainActivity.this, "Custom Positive Listener", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", "#ff0000", new NegativeButtonListener() {
                    @Override
                    public void onNegativeButtonClickListener(AlertDialog dialog) {
                        Toast.makeText(MainActivity.this, "Custom Negative Listener", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .show();
    }
}
