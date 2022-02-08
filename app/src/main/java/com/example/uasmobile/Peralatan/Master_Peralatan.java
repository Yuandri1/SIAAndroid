package com.example.uasmobile.Peralatan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.uasmobile.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Master_Peralatan extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText mst_kode_peralatan, mst_nama_peralatan,
            mst_qty_peralatan, mst_harga_peralatan, mst_desc_peralatan, mst_nom_debet_peralatan,
            mst_nom_kredit_peralatan, mst_tipe_pengadaan_peralatan;
    Button  btn_tambah_mstr_peralatan;

    Spinner mst_nam_debet_peralatan, mst_nam_kredit_peralatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_peralatan);

        mst_nam_debet_peralatan = findViewById(R.id.mst_nam_debet_peralatan);
        ArrayAdapter<CharSequence> adapterDebet = ArrayAdapter.createFromResource(this, R.array.Akun, android.R.layout.simple_spinner_item);
        adapterDebet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mst_nam_debet_peralatan.setAdapter(adapterDebet);
        mst_nam_debet_peralatan.setOnItemSelectedListener(this);

        mst_nam_kredit_peralatan = findViewById(R.id.mst_nam_kredit_peralatan);
        ArrayAdapter<CharSequence> adapterKredit = ArrayAdapter.createFromResource(this, R.array.Akun, android.R.layout.simple_spinner_item);
        adapterKredit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mst_nam_kredit_peralatan.setAdapter(adapterKredit);
        mst_nam_kredit_peralatan.setOnItemSelectedListener(this);

        mst_kode_peralatan = findViewById(R.id.mst_kode_peralatan);
        mst_tipe_pengadaan_peralatan = findViewById(R.id.mst_tipe_pengadaan_peralatan);
        mst_nama_peralatan = findViewById(R.id.mst_nama_peralatan);
        mst_qty_peralatan = findViewById(R.id.mst_qty_peralatan);
        mst_harga_peralatan = findViewById(R.id.mst_harga_peralatan);
        mst_desc_peralatan = findViewById(R.id.mst_desc_peralatan);

        mst_nom_debet_peralatan = findViewById(R.id.mst_nom_debet_peralatan);
        //mst_nam_kredit_peralatan = findViewById(R.id.mst_nam_kredit_peralatan);
        mst_nom_kredit_peralatan = findViewById(R.id.mst_nom_kredit_peralatan);


        btn_tambah_mstr_peralatan = findViewById(R.id.btn_tambah_mstr_peralatan);
        btn_tambah_mstr_peralatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mst_kodeperalatan = mst_kode_peralatan.getText().toString().trim();
                String mst_tipe_pengadaanperalatan = mst_tipe_pengadaan_peralatan.getText().toString().trim();
                String mst_namaperalatan = mst_nama_peralatan.getText().toString().trim();
                String mst_qtyperalatan = mst_qty_peralatan.getText().toString().trim();
                String mst_hargaperalatan = mst_harga_peralatan.getText().toString().trim();
                String mst_descperalatan = mst_desc_peralatan.getText().toString().trim();
                String mst_namdebetperalatan = mst_nam_debet_peralatan.getSelectedItem().toString();
                String mst_nomdebetperalatan = mst_nom_debet_peralatan.getText().toString().trim();
                String mst_namkreditperalatan = mst_nam_kredit_peralatan.getSelectedItem().toString().trim();
                String mst_nomkreditperalatan = mst_nom_kredit_peralatan.getText().toString().trim();

                //Toast.makeText(Master_Peralatan.this,"Tambah diklik",Toast.LENGTH_SHORT).show();
                Intent i_newperalatan = new Intent(Master_Peralatan.this, Akun_Peralatan.class);
                startActivity(i_newperalatan);
                finish();

                if (mst_kodeperalatan.isEmpty()){
                    mst_kode_peralatan.setError("Kode Peralatan Harus di Isi !!");
                    mst_kode_peralatan.requestFocus();
                } else if (mst_tipe_pengadaanperalatan.isEmpty()){
                    mst_tipe_pengadaan_peralatan.setError("Tipe Pengadaan Peralatan Harus di Isi !!");
                    mst_tipe_pengadaan_peralatan.requestFocus();
                } else if (mst_namaperalatan.isEmpty()){
                    mst_nama_peralatan.setError("Nama Peralatan Harus di Isi !!");
                    mst_nama_peralatan.requestFocus();
                } else if (mst_qtyperalatan.isEmpty()){
                    mst_qty_peralatan.setError("Quantity Peralatan Harus di Isi !!");
                    mst_qty_peralatan.requestFocus();
                } else if (mst_hargaperalatan.isEmpty()){
                    mst_harga_peralatan.setError("Harga Peralatan Harus di Isi !!");
                    mst_harga_peralatan.requestFocus();
                } else if (mst_descperalatan.isEmpty()){
                    mst_desc_peralatan.setError("Deskripsi Peralatan Harus di Isi !!");
                    mst_desc_peralatan.requestFocus();
                } else if (mst_nomdebetperalatan.isEmpty()) {
                    mst_nom_debet_peralatan.setError("Nominal Debet Peralatan Harus di Isi !!");
                    mst_nom_debet_peralatan.requestFocus();
                } else if(mst_nomkreditperalatan.isEmpty()) {
                    mst_nom_kredit_peralatan.setError("Nominal Kredit Peralatan Harus di Isi !!");
                    mst_nom_kredit_peralatan.requestFocus();
                } else {
                    insert_data_ke_server(mst_kodeperalatan, mst_tipe_pengadaanperalatan, mst_namaperalatan,
                            mst_qtyperalatan, mst_hargaperalatan, mst_descperalatan,mst_namdebetperalatan, mst_nomdebetperalatan, mst_namkreditperalatan, mst_nomkreditperalatan);
                }
            }
        });
    }

    private void insert_data_ke_server(String mst_kodeperalatan, String mst_tipe_pengadaanperalatan, String mst_namaperalatan, String mst_qtyperalatan, String mst_hargaperalatan, String mst_descperalatan, String mst_namdebetperalatan, String mst_nomdebetperalatan, String mst_namkreditperalatan, String mst_nomkreditperalatan) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.2/server_laundry/?laundry=insertperalatan";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //Toast.makeText(TambahKomik.this,response.toString(), Toast.LENGTH_SHORT).show();
                        if (response.toString().equals("insert_data_berhasil")) {
                            Intent i_main = new Intent(Master_Peralatan.this, Akun_Peralatan.class);
                            startActivity(i_main);
                            finish();
                        } else {
                            Toast.makeText(Master_Peralatan.this, response.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Master_Peralatan.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();

                params.put("kode_peralatan", mst_kodeperalatan);
                params.put("tipe_pengadaan_peralatan", mst_tipe_pengadaanperalatan);
                params.put("nama_peralatan", mst_namaperalatan);
                params.put("qty_peralatan", mst_qtyperalatan);
                params.put("harga_peralatan", mst_hargaperalatan);
                params.put("deskripsi_peralatan", mst_descperalatan);
                params.put("nama_debet_peralatan", mst_namdebetperalatan);
                params.put("nominal_debet_peralatan", mst_nomdebetperalatan);
                params.put("nama_kredit_peralatan", mst_namkreditperalatan);
                params.put("nominal_kredit_peralatan", mst_nomkreditperalatan);

                return params;
            }
        };
        queue.add(stringRequest);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String listakun = adapterView.getItemAtPosition(i).toString();
        //Toast.makeText(adapterView.getContext(), listakun, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
