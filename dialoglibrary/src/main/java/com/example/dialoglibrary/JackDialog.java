package com.example.dialoglibrary;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class JackDialog {
    private Context context;

    private View viewCustom;
    private TextView textView_okBtn, textView_cancelBtn, textView_title, textView_description;

    private AlertDialog.Builder dialog;
    private AlertDialog alertDialog;

    public JackDialog(Context context) {
        this.context = context;
        this.viewCustom = LayoutInflater.from(this.context).inflate(R.layout.jack_dialog, null);
        this.textView_okBtn = viewCustom.findViewById(R.id.tv_okBtn);
        this.textView_cancelBtn = viewCustom.findViewById(R.id.tv_cancelBtn);
        this.textView_title = viewCustom.findViewById(R.id.tv_title);
        this.textView_description = viewCustom.findViewById(R.id.tv_description);

        dialog = new AlertDialog.Builder(context)
                .setView(viewCustom);
    }

    public JackDialog setTitle(String title) {
        textView_title.setVisibility(View.VISIBLE);
        textView_title.setText(title);
        return this;
    }

    public JackDialog setTitle(String title, String color) {
        textView_title.setVisibility(View.VISIBLE);
        textView_title.setTextColor(Color.parseColor(color));
        textView_title.setText(title);
        return this;
    }

    public JackDialog setTitle(String title, int color) {
        textView_title.setVisibility(View.VISIBLE);
        colorTryCatch(color, textView_title);
        textView_title.setText(title);
        return this;
    }

    public JackDialog setDescription(String text) {
        textView_description.setVisibility(View.VISIBLE);
        textView_description.setText(text);
        return this;
    }

    public JackDialog setDescription(String text, String color) {
        textView_description.setVisibility(View.VISIBLE);
        textView_description.setTextColor(Color.parseColor(color));
        textView_description.setText(text);
        return this;
    }

    public JackDialog setDescription(String text, int color) {
        textView_description.setVisibility(View.VISIBLE);
        colorTryCatch(color, textView_description);
        textView_description.setText(text);
        return this;
    }

    public JackDialog setPositiveButton(String text) {
        textView_okBtn.setText(text);
        textView_okBtn.setVisibility(View.VISIBLE);

        textView_okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Positive Button Clicked", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
                if (viewCustom.getParent() != null) {
                    ((ViewGroup) viewCustom.getParent()).removeView(viewCustom); // <- fix
                }
            }
        });

        return this;
    }

    public JackDialog setPositiveButton(String text, View.OnClickListener listener) {
        textView_okBtn.setText(text);
        textView_okBtn.setVisibility(View.VISIBLE);

        textView_okBtn.setOnClickListener(listener);

        return this;
    }

    public JackDialog setPositiveButton(String text, String color, View.OnClickListener listener) {
        textView_okBtn.setText(text);
        textView_okBtn.setTextColor(Color.parseColor(color));
        textView_okBtn.setVisibility(View.VISIBLE);

        textView_okBtn.setOnClickListener(listener);

        return this;
    }

    public JackDialog setPositiveButton(String text, int color, View.OnClickListener listener) {
        textView_okBtn.setText(text);
        colorTryCatch(color, textView_okBtn);
        textView_okBtn.setVisibility(View.VISIBLE);

        textView_okBtn.setOnClickListener(listener);

        return this;
    }


    public JackDialog setNegativeButton(String text) {
        textView_cancelBtn.setText(text);
        textView_cancelBtn.setVisibility(View.VISIBLE);

        textView_cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Negative Button Clicked", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
                if (viewCustom.getParent() != null) {
                    ((ViewGroup) viewCustom.getParent()).removeView(viewCustom); // <- fix
                }
            }
        });

        return this;
    }

    public JackDialog setNegativeButton(String text, View.OnClickListener listener) {
        textView_cancelBtn.setText(text);
        textView_cancelBtn.setVisibility(View.VISIBLE);

        textView_cancelBtn.setOnClickListener(listener);

        return this;
    }

    public JackDialog setNegativeButton(String text, String color, View.OnClickListener listener) {
        textView_cancelBtn.setText(text);
        textView_cancelBtn.setTextColor(Color.parseColor(color));
        textView_cancelBtn.setVisibility(View.VISIBLE);

        textView_cancelBtn.setOnClickListener(listener);

        return this;
    }

    public JackDialog setNegativeButton(String text, int color, View.OnClickListener listener) {
        textView_cancelBtn.setText(text);
        colorTryCatch(color, textView_cancelBtn);
        textView_cancelBtn.setVisibility(View.VISIBLE);

        textView_cancelBtn.setOnClickListener(listener);

        return this;
    }

    private void colorTryCatch(int color, TextView tv) {
        if (color > 0) {
            tv.setTextColor(context.getResources().getColor(color));
        } else {
            tv.setTextColor(color);
        }
    }

    public void show() {
        removeParentView();
        alertDialog = dialog.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
    }

    public JackDialog setCancelable(boolean cancelable) {
        dialog.setCancelable(cancelable);
        return this;
    }

    public void removeParentView() {
        if (viewCustom.getParent() != null) {
            ((ViewGroup) viewCustom.getParent()).removeView(viewCustom); // <- fix
        }
    }

    public void dismiss() {
        alertDialog.dismiss();
    }
}
