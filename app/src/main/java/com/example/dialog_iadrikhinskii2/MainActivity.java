package com.example.dialog_iadrikhinskii2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
    private Button bgButton;
    public ConstraintLayout relativeLayout;
    Context context;
    final CharSequence[] items = {getText(R.string.red), getText(R.string.yellow), getText(R.string.green)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding variables
        bgButton = (Button)findViewById(R.id.button_fon);
        relativeLayout = (ConstraintLayout) findViewById(R.id.ConstraintLayout);
        context = this;

        bgButton.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.message);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        relativeLayout.setBackgroundResource(R.color.redColor);
                        break;
                    case 1:
                        relativeLayout.setBackgroundResource(R.color.greenColor);
                        break;
                    case 2:
                        relativeLayout.setBackgroundResource(R.color.yellowColor);
                        break;
                }
                Toast.makeText(context, R.string.green, Toast.LENGTH_LONG).show();
            }
        });
    }
}