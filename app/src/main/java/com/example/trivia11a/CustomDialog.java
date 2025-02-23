package com.example.trivia11a;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog implements View.OnClickListener {
    Button btnYes, btnNo;
    Context context;

    public CustomDialog(@NonNull Context context) {
        super(context);

        setContentView(R.layout.custom_dialog);
        this.context = context;

        this.btnYes = findViewById(R.id.btnYes);
        this.btnNo = findViewById(R.id.btnNo);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(btnYes == view)
        {
            dismiss(); // dismiss the dialog
            ((GameActivity)context).reset(); // restarts the game // context= הפנייה in this case for GameActivity
        }

        if(btnNo == view)
        {
            ((GameActivity)context).finish();
        }
    }
}
