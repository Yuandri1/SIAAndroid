package com.example.uasmobile.Laporan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.uasmobile.MainActivity;
import com.example.uasmobile.Pengadaan;
import com.example.uasmobile.R;

public class Laporan extends AppCompatActivity {
    Button btn_jurnal_umum, btn_buku_besar, btn_neraca_saldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);
        btn_jurnal_umum = findViewById(R.id.btn_jurnal_umum);
        btn_buku_besar = findViewById(R.id.btn_buku_besar);
        btn_neraca_saldo = findViewById(R.id.btn_neraca_saldo);

        btn_jurnal_umum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Laporan.this,"Tombol di Klik", Toast.LENGTH_SHORT).show();
                Intent intent_jurnal_umum = new Intent(Laporan.this, Jurnal_Umum.class);
                startActivity(intent_jurnal_umum);
            }
        });

        btn_buku_besar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Laporan.this,"Tombol di Klik", Toast.LENGTH_SHORT).show();
                Intent intent_buku_besar = new Intent(Laporan.this, Buku_Besar.class);
                startActivity(intent_buku_besar);

            }
        });
        btn_neraca_saldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Laporan.this,"Tombol di Klik", Toast.LENGTH_SHORT).show();
                Intent intent_neraca_saldo = new Intent(Laporan.this, Neraca_Saldo.class);
                startActivity(intent_neraca_saldo);
            }
        });
    }
}