package com.example.uasmobile.Perlengkapan;

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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.uasmobile.Peralatan.Akun_Peralatan;
import com.example.uasmobile.Peralatan.Master_Peralatan;
import com.example.uasmobile.R;

import java.util.HashMap;
import java.util.Map;

public class Master_Perlengkapan extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText mst_kode_perlengkapan, mst_tipe_pengadaan_perlengkapan, mst_nama_perlengkapan, mst_qty_perlengkapan,
            mst_harga_perlengkapan, mst_desc_perlengkapan,  mst_nom_debet_perlengkapan, mst_nom_kredit_perlengkapan;
    Button btn_tambah_mstr_perlengkapan;
    Spinner mst_nam_debet_perlengkapan, mst_nam_kredit_perlengkapan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_perlengkapan);

        mst_nam_debet_perlengkapan = findViewById(R.id.mst_nam_debet_perlengkapan);
        ArrayAdapter<CharSequence> adapterDebet = ArrayAdapter.createFromResource(this, R.array.Akun, android.R.layout.simple_spinner_item);
        adapterDebet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mst_nam_debet_perlengkapan.setAdapter(adapterDebet);
        mst_nam_debet_perlengkapan.setOnItemSelectedListener(this);

        mst_nam_kredit_perlengkapan = findViewById(R.id.mst_nam_kredit_perlengkapan);
        ArrayAdapter<CharSequence> adapterKredit = ArrayAdapter.createFromResource(this, R.array.Akun, android.R.layout.simple_spinner_item);
        adapterKredit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mst_nam_kredit_perlengkapan.setAdapter(adapterKredit);
        mst_nam_kredit_perlengkapan.setOnItemSelectedListener(this);



        mst_kode_perlengkapan = findViewById(R.id.mst_kode_perlengkapan);
        mst_tipe_pengadaan_perlengkapan = findViewById(R.id.mst_tipe_pengadaan_perlengkapan);
        mst_nama_perlengkapan = findViewById(R.id.mst_nama_perlengkapan);
        mst_qty_perlengkapan = findViewById(R.id.mst_qty_perlengkapan);
        mst_harga_perlengkapan = findViewById(R.id.mst_harga_perlengkapan);
        mst_desc_perlengkapan = findViewById(R.id.mst_desc_perlengkapan);

        mst_nom_debet_perlengkapan = findViewById(R.id.mst_nom_debet_perlengkapan);

        mst_nom_kredit_perlengkapan = findViewById(R.id.mst_nom_kredit_perlengkapan);


        btn_tambah_mstr_perlengkapan = findViewById(R.id.btn_tambah_mstr_perlengkapan);
        btn_tambah_mstr_perlengkapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mst_kodeperlengkapan = mst_kode_perlengkapan.getText().toString().trim();
                String mst_tipe_pengadaanperlengkapan = mst_tipe_pengadaan_perlengkapan.getText().toString().trim();
                String mst_namaperlengkapan = mst_nama_perlengkapan.getText().toString().trim();
                String mst_qtyperlengkapan = mst_qty_perlengkapan.getText().toString().trim();
                String mst_hargaperlengkapan = mst_harga_perlengkapan.getText().toString().trim();
                String mst_descperlengkapan = mst_desc_perlengkapan.getText().toString().trim();
                String mst_namdebetperlengkapan = mst_nam_debet_perlengkapan.getSelectedItem().toString().trim();
                String mst_nomdebetperlengkapan = mst_nom_debet_perlengkapan.getText().toString().trim();
                String mst_namkreditperlengkapan = mst_nam_kredit_perlengkapan.getSelectedItem().toString().trim();
                String mst_nomkreditperlengkapan = mst_nom_kredit_perlengkapan.getText().toString().trim();

                Intent i_newperlengkapann = new Intent(Master_Perlengkapan.this, Akun_Perlengkapan.class);
                startActivity(i_newperlengkapann);
                finish();

                if (mst_kodeperlengkapan.isEmpty()){
                    mst_kode_perlengkapan.setError("Kode Perlengkapan Harus di Isi !!");
                    mst_kode_perlengkapan.requestFocus();
                }else if (mst_tipe_pengadaanperlengkapan.isEmpty()){
                    mst_tipe_pengadaan_perlengkapan.setError("Tipe Perlengkapan Harus di Isi !!");
                    mst_tipe_pengadaan_perlengkapan.requestFocus();
                }else if (mst_namaperlengkapan.isEmpty()){
                    mst_nama_perlengkapan.setError("Nama Perlengkapan Harus di Isi !!");
                    mst_nama_perlengkapan.requestFocus();
                }else if (mst_qtyperlengkapan.isEmpty()){
                    mst_qty_perlengkapan.setError("Qty Perlengkapan Harus di Isi !!");
                    mst_qty_perlengkapan.requestFocus();
                }else if (mst_hargaperlengkapan.isEmpty()){
                    mst_harga_perlengkapan.setError("Harga Perlengkapan Harus di Isi !!");
                    mst_harga_perlengkapan.requestFocus();
                }else if (mst_descperlengkapan.isEmpty()){
                    mst_desc_perlengkapan.setError("Desc Perlengkapan Harus di Isi !!");
                    mst_desc_perlengkapan.requestFocus();
                }else if (mst_nomdebetperlengkapan.isEmpty()) {
                    mst_nom_debet_perlengkapan.setError("Nominal Debet Perlengkapan Harus di Isi !!");
                    mst_nom_debet_perlengkapan.requestFocus();
                }else if (mst_nomkreditperlengkapan.isEmpty()) {
                    mst_nom_kredit_perlengkapan.setError("Nominal Kredit Perlengkapan Harus di Isi !!");
                    mst_nom_kredit_perlengkapan.requestFocus();
                }else {
                    insert_data_ke_server(mst_kodeperlengkapan, mst_tipe_pengadaanperlengkapan, mst_namaperlengkapan, mst_qtyperlengkapan,
                            mst_hargaperlengkapan, mst_descperlengkapan, mst_namdebetperlengkapan, mst_nomdebetperlengkapan, mst_namkreditperlengkapan, mst_nomkreditperlengkapan);
                }

            }
        });
    }

    private void insert_data_ke_server(String mst_kodeperlengkapan, String mst_tipe_pengadaanperlengkapan, String mst_namaperlengkapan, String mst_qtyperlengkapan, String mst_hargaperlengkapan, String mst_descperlengkapan, String mst_namdebetperlengkapan, String mst_nomdebetperlengkapan, String mst_namkreditperlengkapan, String mst_nomkreditperlengkapan) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.2/server_laundry/?laundry=insertperlengkapan";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //Toast.makeText(TambahKomik.this,response.toString(), Toast.LENGTH_SHORT).show();
                        if (response.toString().equals("insert_data_berhasil")) {
                            Intent i_main = new Intent(Master_Perlengkapan.this, Akun_Perlengkapan.class);
                            startActivity(i_main);
                            finish();
                        } else {
                            Toast.makeText(Master_Perlengkapan.this, response.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Master_Perlengkapan.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();

                params.put("kode_perlengkapan", mst_kodeperlengkapan);
                params.put("tipe_pengadaan_perlengkapan", mst_tipe_pengadaanperlengkapan);
                params.put("nama_perlengkapan", mst_namaperlengkapan);
                params.put("qty_perlengkapan", mst_qtyperlengkapan);
                params.put("harga_perlengkapan", mst_hargaperlengkapan);
                params.put("deskripsi_perlengkapan", mst_descperlengkapan);
                params.put("nama_debet_perlengkapan", mst_namdebetperlengkapan);
                params.put("nominal_debet_perlengkapan", mst_nomdebetperlengkapan);
                params.put("nama_kredit_perlengkapan", mst_namkreditperlengkapan);
                params.put("nominal_kredit_perlengkapan", mst_nomkreditperlengkapan);

                return params;
            }
        };
        queue.add(stringRequest);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String listakun = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), listakun, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}