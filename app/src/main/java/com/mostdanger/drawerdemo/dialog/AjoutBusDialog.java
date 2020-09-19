package com.mostdanger.drawerdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.mostdanger.drawerdemo.R;
import com.mostdanger.drawerdemo.ui.activity.MainActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AjoutBusDialog extends Dialog {
    private Context context;
    private EditText edit_text_numemat;
    private EditText edit_text_typebus;
    private EditText edit_text_datefabbus;
    private EditText edit_text_marqbus;
    private EditText edit_text_datemiseserv;

    public AjoutBusDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ajout_bus_layout);
        edit_text_numemat= findViewById(R.id.edit_text_numemat);
        edit_text_typebus= findViewById(R.id.edit_text_typebus);
        edit_text_datefabbus= findViewById(R.id.edit_text_datefabbus);
        edit_text_marqbus= findViewById(R.id.edit_text_marqbus);
        edit_text_datemiseserv= findViewById(R.id.edit_text_datemiseserv);

        Date dateFabBus = null;
        try {
            dateFabBus = new SimpleDateFormat("dd/MM/yyyy").parse(edit_text_datefabbus.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dateMiseServ = null;
        try {
            dateMiseServ = new SimpleDateFormat("dd/MM/yyyy").parse(edit_text_datemiseserv.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String  marqBus= edit_text_marqbus.getText().toString();
        String numEmat= edit_text_numemat.getText().toString();
        String  typeBus= edit_text_typebus.getText().toString();

            ((MainActivity) context).ajouterBus(true,numEmat,typeBus,marqBus,dateFabBus,dateMiseServ);

    }

}
