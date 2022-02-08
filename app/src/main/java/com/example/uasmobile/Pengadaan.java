package com.example.uasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.uasmobile.Peralatan.Akun_Peralatan;
import com.example.uasmobile.Perlengkapan.Akun_Perlengkapan;

public class Pengadaan extends AppCompatActivity {
    Button btn_peralatan, btn_perlengkapan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengadaan);

        btn_peralatan = findViewById(R.id.btn_peralatan);
        btn_perlengkapan = findViewById(R.id.btn_perlengkapan);

        btn_peralatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pengadaan.this,"Tombol di Klik", Toast.LENGTH_SHORT).show();
                Intent intent_peralatan = new Intent (Pengadaan.this, Akun_Peralatan.class);
                startActivity(intent_peralatan);
            }
        });

        btn_perlengkapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pengadaan.this,"Tombol di Klik", Toast.LENGTH_SHORT).show();
                Intent intent_perlengkapan = new Intent(Pengadaan.this, Akun_Perlengkapan.class);
                startActivity(intent_perlengkapan);
            }
        });
    }
}