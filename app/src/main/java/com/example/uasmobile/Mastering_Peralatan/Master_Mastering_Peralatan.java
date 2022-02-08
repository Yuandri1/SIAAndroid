package com.example.uasmobile.Mastering_Peralatan;

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
import com.example.uasmobile.R;

import java.util.HashMap;
import java.util.Map;

public class Master_Mastering_Peralatan extends AppCompatActivity {
    EditText mstring_kode_peralatan, mstring_nama_peralatan, mstring_desc_peralatan, mstring_lokasi_peralatan, msting_grup_peralatan;
    Button btn_tambah_mstr_peralatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_mastering_peralatan);

        mstring_kode_peralatan = findViewById(R.id.mstring_kode_peralatan);
        mstring_nama_peralatan = findViewById(R.id.mstring_nama_peralatan);
        mstring_desc_peralatan = findViewById(R.id.mstring_desc_peralatan);
        mstring_lokasi_peralatan = findViewById(R.id.mstring_lokasi_peralatan);
        msting_grup_peralatan = findViewById(R.id.msting_grup_peralatan);


        btn_tambah_mstr_peralatan = findViewById(R.id.btn_tambah_mstr_peralatan);
        btn_tambah_mstr_peralatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mstring_kodeperalatan = mstring_kode_peralatan.getText().toString().trim();
                String mstring_namaperalatan = mstring_nama_peralatan.getText().toString().trim();
                String mstring_descperalatan = mstring_desc_peralatan.getText().toString().trim();
                String mstring_lokasiperalatan = mstring_lokasi_peralatan.getText().toString().trim();
                String mstring_groupperalatan = msting_grup_peralatan.getText().toString().trim();

                if (mstring_kodeperalatan.isEmpty()){
                    mstring_kode_peralatan.setError("Kode Peralatan Harus di Isi !!");
                    mstring_kode_peralatan.requestFocus();
                }else if (mstring_namaperalatan.isEmpty()){
                    mstring_nama_peralatan.setError("Nama Peralatan Harus di Isi !!");
                    mstring_nama_peralatan.requestFocus();
                }else if (mstring_descperalatan.isEmpty()){
                    mstring_desc_peralatan.setError("Desc Peralatan Harus di Isi !!");
                    mstring_desc_peralatan.requestFocus();
                }else if (mstring_lokasiperalatan.isEmpty()){
                    mstring_lokasi_peralatan.setError("Lokasi Peralatan Harus di Isi !!");
                    mstring_lokasi_peralatan.requestFocus();
                }else if (mstring_groupperalatan.isEmpty()){
                    msting_grup_peralatan.setError("Harga Peralatan Harus di Isi !!");
                    msting_grup_peralatan.requestFocus();
                }else {
                    insert_data_ke_server(mstring_kodeperalatan, mstring_namaperalatan, mstring_descperalatan, mstring_lokasiperalatan, mstring_groupperalatan);
                }
            }
        });
    }

    private void insert_data_ke_server(String mstring_kodeperalatan, String mstring_namaperalatan, String mstring_descperalatan, String mstring_lokasiperalatan, String mstring_groupperalatan) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.2/server_laundry/?laundry=insertmasterperalatan";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //Toast.makeText(TambahKomik.this,response.toString(), Toast.LENGTH_SHORT).show();
                        if (response.toString().equals("insert_data_berhasil")) {
                            Intent i_main = new Intent(Master_Mastering_Peralatan.this, Mastering_Peralatan.class);
                            startActivity(i_main);
                            finish();
                        } else {
                            Toast.makeText(Master_Mastering_Peralatan.this, response.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Master_Mastering_Peralatan.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();

                params.put("kode_mstring", mstring_kodeperalatan);
                params.put("nama_mstring", mstring_namaperalatan);
                params.put("desc_mstring", mstring_descperalatan);
                params.put("lokasi_mstring", mstring_lokasiperalatan);
                params.put("group_mstring", mstring_groupperalatan);

                return params;
            }
        };
        queue.add(stringRequest);
    }


}