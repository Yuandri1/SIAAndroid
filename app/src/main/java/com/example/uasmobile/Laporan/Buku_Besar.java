package com.example.uasmobile.Laporan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.uasmobile.BB.BB_HUTANG;
import com.example.uasmobile.BB.BB_KAS;
import com.example.uasmobile.BB.BB_MODAL;
import com.example.uasmobile.BB.BB_PERALATAN;
import com.example.uasmobile.BB.BB_PERLENGKAPAN;
import com.example.uasmobile.R;

public class Buku_Besar extends AppCompatActivity {
    Button btn_bb_kas, btn_bb_hutang, btn_bb_modal, btn_bb_peralatan, btn_bb_perlengkapan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_besar);

        btn_bb_kas = findViewById(R.id.btn_bb_kas);
        btn_bb_hutang = findViewById(R.id.btn_bb_hutang);
        btn_bb_modal = findViewById(R.id.btn_bb_modal);
        btn_bb_peralatan = findViewById(R.id.btn_bb_peralatan);
        btn_bb_perlengkapan = findViewById(R.id.btn_bb_perlengkapan);


        btn_bb_kas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Buku_Besar.this,"Tombol di Klik", Toast.LENGTH_SHORT).show();
                Intent intent_bb_kas = new Intent(Buku_Besar.this, BB_KAS.class);
                startActivity(intent_bb_kas);
            }
        });

        btn_bb_hutang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Buku_Besar.this,"Tombol di Klik", Toast.LENGTH_SHORT).show();
                Intent intent_bb_hutang = new Intent(Buku_Besar.this, BB_HUTANG.class);
                startActivity(intent_bb_hutang);
            }
        });
        btn_bb_modal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Buku_Besar.this,"Tombol di Klik", Toast.LENGTH_SHORT).show();
                Intent intent_bb_modal = new Intent(Buku_Besar.this, BB_MODAL.class);
                startActivity(intent_bb_modal);
            }
        });
        btn_bb_peralatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Buku_Besar.this,"Tombol di Klik", Toast.LENGTH_SHORT).show();
                Intent intent_bb_peralatan = new Intent(Buku_Besar.this, BB_PERALATAN.class);
                startActivity(intent_bb_peralatan);
            }
        });
        btn_bb_perlengkapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Buku_Besar.this,"Tombol di Klik", Toast.LENGTH_SHORT).show();
                Intent intent_bb_perlengkapan = new Intent(Buku_Besar.this, BB_PERLENGKAPAN.class);
                startActivity(intent_bb_perlengkapan);
            }
        });
    }
}