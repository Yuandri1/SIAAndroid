package com.example.uasmobile.Mastering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.uasmobile.Mastering_Peralatan.Master_Mastering_Peralatan;
import com.example.uasmobile.Mastering_Peralatan.Mastering_Peralatan;
import com.example.uasmobile.R;

import java.util.HashMap;
import java.util.Map;

public class Master_Mastering_Perlengkapan extends AppCompatActivity {
    EditText mstring_kode_perlengkapan, mstring_nama_perlengkapan, mstring_desc_perlengkapan;
    Button  btn_tambah_mstr_perlengkapan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_mastering_perlengkapan);

        mstring_kode_perlengkapan = findViewById(R.id.mstring_kode_perlengkapan);
        mstring_nama_perlengkapan = findViewById(R.id.mstring_nama_perlengkapan);
        mstring_desc_perlengkapan = findViewById(R.id.mstring_desc_perlengkapan);

        btn_tambah_mstr_perlengkapan = findViewById(R.id.btn_tambah_mstr_perlengkapan);
        btn_tambah_mstr_perlengkapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mstring_kodeperlengkapan = mstring_kode_perlengkapan.getText().toString().trim();
                String mstring_namaperlengkapan = mstring_nama_perlengkapan.getText().toString().trim();
                String mstring_descperlengkapan = mstring_desc_perlengkapan.getText().toString().trim();

                if (mstring_kodeperlengkapan.isEmpty()){
                    mstring_kode_perlengkapan.setError("Kode Perlengkapan Harus di Isi !!");
                    mstring_kode_perlengkapan.requestFocus();
                }else if (mstring_namaperlengkapan.isEmpty()){
                    mstring_nama_perlengkapan.setError("Nama Perlengkapan Harus di Isi !!");
                    mstring_nama_perlengkapan.requestFocus();
                }else if (mstring_descperlengkapan.isEmpty()){
                    mstring_desc_perlengkapan.setError("Desc Perlengkapan Harus di Isi !!");
                    mstring_desc_perlengkapan.requestFocus();
                }else {
                    insert_data_ke_server(mstring_kodeperlengkapan, mstring_namaperlengkapan, mstring_descperlengkapan);
                }
            }
        });
    }

    private void insert_data_ke_server(String mstring_kodeperlengkapan, String mstring_namaperlengkapan, String mstring_descperlengkapan) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.2/server_laundry/?laundry=insertmasterperlengkapan";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //Toast.makeText(TambahKomik.this,response.toString(), Toast.LENGTH_SHORT).show();
                        if (response.toString().equals("insert_data_berhasil")) {
                            Intent i_main = new Intent(Master_Mastering_Perlengkapan.this, Mastering_Perlengkapan.class);
                            startActivity(i_main);
                            finish();
                        } else {
                            Toast.makeText(Master_Mastering_Perlengkapan.this, response.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Master_Mastering_Perlengkapan.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();

                params.put("kode_mstringP", mstring_kodeperlengkapan);
                params.put("nama_mstringP", mstring_namaperlengkapan);
                params.put("desc_mstringP", mstring_descperlengkapan);


                return params;
            }
        };
        queue.add(stringRequest);
    }
}