package com.example.samplebroadcastemisor;

import android.adservices.adselection.RemoveAdSelectionOverrideRequest;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "Emisor";

    private static final String EXTRA_MOON_PHASE = "org.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        Button btnSendMessage = findViewById(R.id.btnEnviar);
        EditText edtMessage = findViewById(R.id.edtText);

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = edtMessage.getText().toString();
                sendMessage(message);
            }
        });
    }


    public void sendMessage(String message){
        Intent intent = new Intent();

        //intent.setComponent(new ComponentName());

        intent.setAction(EXTRA_MOON_PHASE);
        intent.putExtra(EXTRA_MOON_PHASE,message);

        sendBroadcast(intent);
        Log.d(TAG, "Mensaje Eviado");


    }
}