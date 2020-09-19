package com.mostdanger.drawerdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.mostdanger.drawerdemo.R;
import com.mostdanger.drawerdemo.ui.activity.MainActivity;

public class AjoutBusDialog extends Dialog {
    private Context context;
    private Button button;

    public AjoutBusDialog(@NonNull final Context context) {
        super(context);
        this.context = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ajout_bus_layout);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
