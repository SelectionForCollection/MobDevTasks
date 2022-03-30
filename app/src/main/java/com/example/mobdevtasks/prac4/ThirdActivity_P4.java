package com.example.mobdevtasks.prac4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobdevtasks.R;

public class ThirdActivity_P4 extends AppCompatActivity {

    EditText S, H, F, s, h, f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("МОЙ СОБСВТЕННЫЙ ЛОГ", "Третья сцена создана");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.prac4_third_page);

        S = findViewById(R.id.street);
        H = findViewById(R.id.house);
        F = findViewById(R.id.flat);
        s = findViewById(R.id.T_street);
        h = findViewById(R.id.T_house);
        f = findViewById(R.id.T_flat);
        Button btn_ok = findViewById(R.id.btn_ok);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (S.getText().toString().equals("") || H.getText().toString().equals("") || F.getText().toString().equals("")
                        || s.getText().toString().equals("") || h.getText().toString().equals("") || f.getText().toString().equals("")) {
                    Toast.makeText(ThirdActivity_P4.this, "Введите данные", Toast.LENGTH_SHORT).show();
                } else {
                    setResult(1, new Intent().putExtra("merge", "От " + S.getText().toString()
                            + ", " + H.getText().toString() + ", " + F.getText().toString()
                            + "\nДо " + s.getText().toString() + ", " + h.getText().toString()
                            + ", " + f.getText().toString()));
                    finish();
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("МОЙ СОБСВТЕННЫЙ ЛОГ", "Третья сцена уничтожена");
    }
}