package com.example.dialog_iadrikhinskii2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Declaring variables
    private Button bgButton;
    public ConstraintLayout constraintLayout;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding variables
        bgButton = (Button)findViewById(R.id.button_fon);
        constraintLayout = findViewById(R.id.ConstraintLayout);
        context = MainActivity.this;

        //Add listener to button
        bgButton.setOnClickListener(this);
    }

    //When button is clicked
    @Override
    public void onClick(View v) {
        //Strings for dialog
        final CharSequence[] items = {getText(R.string.red), getText(R.string.green), getText(R.string.yellow)};

        //Declaring builder for alert window, setting title for it, and adding options
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.message);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        constraintLayout.setBackgroundResource(R.color.redColor);
                        Toast.makeText(context, R.string.red, Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        constraintLayout.setBackgroundResource(R.color.greenColor);
                        Toast.makeText(context, R.string.green, Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        constraintLayout.setBackgroundResource(R.color.yellowColor);
                        Toast.makeText(context, R.string.yellow, Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

        //Creating AlertDialog from builder and showing it
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}