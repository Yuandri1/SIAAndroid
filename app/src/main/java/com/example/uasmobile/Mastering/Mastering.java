package com.example.uasmobile.Mastering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.uasmobile.Mastering_Peralatan.Mastering_Peralatan;
import com.example.uasmobile.R;

public class Mastering extends AppCompatActivity {
    Button btn_mstr_peralatan,btn_mstr_perlengkapan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mastering);

        btn_mstr_peralatan = findViewById(R.id.btn_mstr_peralatan);
        btn_mstr_perlengkapan = findViewById(R.id.btn_mstr_perlengkapan);

        btn_mstr_peralatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Mastering.this,"Tombol di Klik", Toast.LENGTH_SHORT).show();
                Intent intent_mastering_peralatan = new Intent(Mastering.this, Mastering_Peralatan.class);
                startActivity(intent_mastering_peralatan);
            }
        });
        btn_mstr_perlengkapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Mastering.this,"Tombol di Klik", Toast.LENGTH_SHORT).show();
                Intent intent_mastering_perlengkapan = new Intent(Mastering.this, Mastering_Perlengkapan.class);
                startActivity(intent_mastering_perlengkapan);
            }
        });

    }
}