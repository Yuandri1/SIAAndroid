package com.example.uasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.uasmobile.Laporan.Laporan;
import com.example.uasmobile.Mastering.Mastering;

public class MainActivity extends AppCompatActivity {
    Button btn_pengadaan, btn_laporan, btn_mastering;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    btn_pengadaan = findViewById(R.id.pengadaan);
        btn_laporan = findViewById(R.id.laporan);
    btn_mastering = findViewById(R.id.mastering);

    btn_pengadaan.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,"Tombol di Klik", Toast.LENGTH_SHORT).show();
            Intent intent_pengadaan = new Intent(MainActivity.this,Pengadaan.class);
            startActivity(intent_pengadaan);
        }
    });
    btn_mastering.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,"Tombol di Klik", Toast.LENGTH_SHORT).show();
            Intent intent_pengadaan = new Intent(MainActivity.this, Mastering.class);
            startActivity(intent_pengadaan);
        }
    });
    btn_laporan.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,"Tombol di Klik", Toast.LENGTH_SHORT).show();
            Intent intent_laporan = new Intent(MainActivity.this, Laporan.class);
            startActivity(intent_laporan);
        }
    });

    }
}