package org.neosoft.com.d1challenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class ActivityB extends AppCompatActivity {
    TextView txtDisplay;
    String mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        txtDisplay= (TextView) findViewById(R.id.txtNumber);
        mRandom= generateRandom();

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String value = extras.getString("Random");
            txtDisplay.setText(value);
        }

        findViewById(R.id.btnActB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ActivityA.class);
                intent.putExtra("Random", mRandom);
                startActivity(intent);
                finish();
            }
        });
    }

    public String generateRandom(){
        int min = 1;
        int max = 100;

        Random r = new Random();
        int random = r.nextInt(max - min + 1) + min;

        return String.valueOf(random);
    }
}
