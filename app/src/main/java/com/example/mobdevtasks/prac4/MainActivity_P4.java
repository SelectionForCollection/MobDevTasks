package com.example.mobdevtasks.prac4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mobdevtasks.R;

public class MainActivity_P4 extends AppCompatActivity {

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("МОЙ СОБСВТЕННЫЙ ЛОГ", "Первая сцена создана");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prac4_first_page);

        EditText phone = findViewById(R.id.fp_phone);
        EditText name = findViewById(R.id.fp_name);
        EditText surname = findViewById(R.id.fp_surname);
        Button reg_btn = findViewById(R.id.registry);
        Button new_user = findViewById(R.id.new_user);

        pref = getPreferences(MODE_PRIVATE);
        if (pref == null) {
            Toast.makeText(this, "pref is null!!", Toast.LENGTH_SHORT).show();
        } else {
            phone.setText(pref.getString("phone", ""));
            name.setText(pref.getString("name", ""));
            surname.setText(pref.getString("surname", ""));
            reg_btn.setText("Log in");
        }

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(phone.getText().toString().equals("") || name.getText().toString().equals("") || surname.getText().toString().equals(""))) {
                    Intent intent = new Intent(MainActivity_P4.this, SecondActivity.class);
                    intent.putExtra("Phone", phone.getText().toString());
                    intent.putExtra("fi", name.getText().toString() + " " + surname.getText().toString());

                    startActivity(intent);
                    finish();
                }
            }
        });

        new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone.setText("");
                name.setText("");
                surname.setText("");
                reg_btn.setText("registry");
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        EditText phone = findViewById(R.id.fp_phone);
        EditText name = findViewById(R.id.fp_name);
        EditText surname = findViewById(R.id.fp_surname);

        pref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("phone", phone.getText().toString()).apply();
        editor.putString("name", name.getText().toString()).apply();
        editor.putString("surname", surname.getText().toString()).apply();
        Toast.makeText(this, "Probably pref is not null", Toast.LENGTH_SHORT).show();

        Log.d("МОЙ СОБСВТЕННЫЙ ЛОГ", "Первая сцена уничтожена");
    }
}
