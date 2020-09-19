package com.mostdanger.drawerdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

import androidx.annotation.NonNull;

import com.mostdanger.drawerdemo.R;

public class AjoutBusDialog extends Dialog {
    private Context context;

    public AjoutBusDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ajout_bus_layout);

    }

}
