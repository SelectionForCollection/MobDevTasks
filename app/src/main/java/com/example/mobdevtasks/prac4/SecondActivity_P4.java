package com.example.mobdevtasks.prac4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mobdevtasks.R;

public class SecondActivity_P4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("МОЙ СОБСВТЕННЫЙ ЛОГ", "Вторая сцена создана");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.prac4_second_page);

        TextView sp_phone = findViewById(R.id.sp_phone);
        TextView fi = findViewById(R.id.fi);
        Button btn = findViewById(R.id.set_path);

        sp_phone.setText(getIntent().getStringExtra("Phone"));
        fi.setText(getIntent().getStringExtra("fi"));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(SecondActivity_P4.this, ThirdActivity_P4.class), 1);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView textView = findViewById(R.id.text_path);
        Button btn_call = findViewById(R.id.call_taxi);

        assert data != null;
        textView.setText(data.getStringExtra("merge"));

        btn_call.setEnabled(true);
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity_P4.this, "Такси вызвано!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("МОЙ СОБСВТЕННЫЙ ЛОГ", "Вторая сцена уничтожена");
    }
}