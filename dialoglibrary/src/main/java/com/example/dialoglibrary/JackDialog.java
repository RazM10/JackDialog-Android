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
    View viewCustom;
    Context context;
    AlertDialog.Builder dialog;
    TextView textView_okBtn, textView_cancelBtn, textView_title, textView_description;

    private PositiveButtonListener positiveButtonListener;
    private NegativeButtonListener negativeButtonListener;

    AlertDialog alertDialog;

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

    public JackDialog setTitle() {
        textView_title.setVisibility(View.VISIBLE);
        return this;
    }

    public JackDialog setTitle(String title) {
        textView_title.setVisibility(View.VISIBLE);
        textView_title.setText(title);
        return this;
    }

    public JackDialog setTitle(String title,String color) {
        textView_title.setVisibility(View.VISIBLE);
        textView_title.setTextColor(Color.parseColor(color));
        textView_title.setText(title);
        return this;
    }

    public JackDialog setTitle(String title,int color) {
        textView_title.setVisibility(View.VISIBLE);
        colorTryCatch(color,textView_title);
        textView_title.setText(title);
        return this;
    }

    public JackDialog setDescription() {
        textView_description.setVisibility(View.VISIBLE);
        return this;
    }

    public JackDialog setDescription(String text) {
        textView_description.setVisibility(View.VISIBLE);
        textView_description.setText(text);
        return this;
    }

    public JackDialog setDescription(String text,String color) {
        textView_description.setVisibility(View.VISIBLE);
        textView_description.setTextColor(Color.parseColor(color));
        textView_description.setText(text);
        return this;
    }

    public JackDialog setDescription(String text,int color) {
        textView_description.setVisibility(View.VISIBLE);
        colorTryCatch(color,textView_description);
        textView_description.setText(text);
        return this;
    }

    public JackDialog setPositiveButton() {
        textView_okBtn.setVisibility(View.VISIBLE);

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

    public JackDialog setPositiveButton(String text, PositiveButtonListener listener) {
        textView_okBtn.setText(text);
        textView_okBtn.setVisibility(View.VISIBLE);

        positiveButtonClicked(listener);

        return this;
    }

    public JackDialog setPositiveButton(String text, String color, PositiveButtonListener listener) {
        textView_okBtn.setText(text);
        textView_okBtn.setTextColor(Color.parseColor(color));
        textView_okBtn.setVisibility(View.VISIBLE);

        positiveButtonClicked(listener);

        return this;
    }

    public JackDialog setPositiveButton(String text, int color, PositiveButtonListener listener) {
        textView_okBtn.setText(text);
        colorTryCatch(color,textView_okBtn);
        textView_okBtn.setVisibility(View.VISIBLE);

        positiveButtonClicked(listener);

        return this;
    }


    private void positiveButtonClicked(PositiveButtonListener listener) {
        positiveButtonListener = listener;

        textView_okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeParentView();
                positiveButtonListener.onPositiveButtonClickListener(alertDialog);
            }
        });
    }

    public JackDialog setNegativeButton() {
        textView_cancelBtn.setVisibility(View.VISIBLE);
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

    public JackDialog setNegativeButton(String text, NegativeButtonListener listener) {
        textView_cancelBtn.setText(text);
        textView_cancelBtn.setVisibility(View.VISIBLE);

        negativeButtonClicked(listener);

        return this;
    }

    public JackDialog setNegativeButton(String text, String color, NegativeButtonListener listener) {
        textView_cancelBtn.setText(text);
        textView_cancelBtn.setTextColor(Color.parseColor(color));
        textView_cancelBtn.setVisibility(View.VISIBLE);

        negativeButtonClicked(listener);

        return this;
    }

    public JackDialog setNegativeButton(String text, int color, NegativeButtonListener listener) {
        textView_cancelBtn.setText(text);
        colorTryCatch(color,textView_cancelBtn);
        textView_cancelBtn.setVisibility(View.VISIBLE);

        negativeButtonClicked(listener);

        return this;
    }

    private void negativeButtonClicked(NegativeButtonListener listener) {
        negativeButtonListener = listener;

        textView_cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewCustom.getParent() != null) {
                    ((ViewGroup) viewCustom.getParent()).removeView(viewCustom); // <- fix
                }
                negativeButtonListener.onNegativeButtonClickListener(alertDialog);
            }
        });
    }

    private void colorTryCatch(int color,TextView tv){
        try{
            tv.setTextColor(context.getResources().getColor(color));
        } catch (Resources.NotFoundException e) {
            tv.setTextColor(color);
        }
    }

    public void show() {
//        dialog.setCancelable(false);
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
}
