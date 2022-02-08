package com.example.uasmobile.Peralatan;

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

public class Update_Peralatan extends AppCompatActivity {
    EditText udt_kode_peralatan,udt_tipe_pengadaan_peralatan,udt_nama_peralatan,udt_qty_peralatan,
            udt_harga_peralatan,udt_desc_peralatan,udt_nam_debet_peralatan,udt_nom_debet_peralatan,udt_nam_kredit_peralatan,udt_nom_kredit_peralatan;
    Button btn_tambah_udt_peralatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_peralatan);
        Intent getdata = getIntent();
        Bundle b = getdata.getExtras();
        udt_kode_peralatan = findViewById(R.id.udt_kode_peralatan);
        udt_tipe_pengadaan_peralatan = findViewById(R.id.udt_tipe_pengadaan_peralatan);
        udt_nama_peralatan = findViewById(R.id.udt_nama_peralatan);
        udt_qty_peralatan = findViewById(R.id.udt_qty_peralatan);
        udt_harga_peralatan = findViewById(R.id.udt_harga_peralatan);
        udt_desc_peralatan = findViewById(R.id.udt_desc_peralatan);
        udt_nam_debet_peralatan = findViewById(R.id.udt_nam_debet_peralatan);
        udt_nom_debet_peralatan = findViewById(R.id.udt_nom_debet_peralatan);
        udt_nam_kredit_peralatan = findViewById(R.id.udt_nam_kredit_peralatan);
        udt_nom_kredit_peralatan = findViewById(R.id.udt_nom_kredit_peralatan);

        btn_tambah_udt_peralatan = findViewById(R.id.btn_tambah_udt_peralatan);

        String update_kodeperalatan = (String) b.get("update_kodeperalatan");
        String update_tipeperalatan = (String) b.get("update_tipeperalatan");
        String update_namaperalatan = (String) b.get("update_namaperalatan");
        String update_qtyperalatan = (String) b.get("update_qtyperalatan");
        String update_hargaperalatan = (String) b.get("update_hargaperalatan");
        String update_descperalatan = (String) b.get("update_descperalatan");
        String update_akundebetperalatan = (String) b.get("update_akundebetperalatan");
        String update_debetperalatan = (String) b.get("update_debetperalatan");
        String update_akunkreditperalatan = (String) b.get("update_akunkreditperalatan");
        String update_kreditperalatan = (String) b.get("update_kreditperalatan");


        udt_kode_peralatan.setText(update_kodeperalatan);
        udt_tipe_pengadaan_peralatan.setText(update_tipeperalatan);
        udt_nama_peralatan.setText(update_namaperalatan);
        udt_qty_peralatan.setText(update_qtyperalatan);
        udt_harga_peralatan.setText(update_hargaperalatan);
        udt_desc_peralatan.setText(update_descperalatan);
        udt_nam_debet_peralatan.setText(update_akundebetperalatan);
        udt_nom_debet_peralatan.setText(update_debetperalatan);
        udt_nam_kredit_peralatan.setText(update_akunkreditperalatan);
        udt_nom_kredit_peralatan.setText(update_kreditperalatan);

        btn_tambah_udt_peralatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipe_peralatan = udt_tipe_pengadaan_peralatan.getText().toString().trim();
                String nama_peralatan = udt_nama_peralatan.getText().toString().trim();
                String nama_debet_peralatan = udt_nam_debet_peralatan.getText().toString().trim();
                String nama_kredit_peralatan = udt_nam_kredit_peralatan.getText().toString().trim();
                String desc_peralatan = udt_desc_peralatan.getText().toString().trim();

                update_peralatan(update_kodeperalatan,desc_peralatan,tipe_peralatan,nama_peralatan,nama_debet_peralatan,nama_kredit_peralatan);
                Intent i_update = new Intent(Update_Peralatan.this, Akun_Peralatan.class);
                startActivity(i_update);
                finish();
            }
        });
    }

    private void update_peralatan(String update_kodeperalatan, String desc_peralatan, String tipe_peralatan, String nama_peralatan, String nama_debet_peralatan, String nama_kredit_peralatan) {
        RequestQueue queue = Volley.newRequestQueue(Update_Peralatan.this);
        String url ="http://192.168.1.2/server_laundry/?laundry=updateperalatan";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Update_Peralatan.this,response.toString(), Toast.LENGTH_SHORT).show();
                        if(response.toString().equals("Update_berhasil")){

                        }else{
                            Toast.makeText(Update_Peralatan.this,response.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Update_Peralatan.this,error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();

                params.put("kode_peralatan", update_kodeperalatan);
                params.put("get_update_desc_peralatan", desc_peralatan);
                params.put("tipe_peralatan", tipe_peralatan);
                params.put("nama_peralatan", nama_peralatan);
                params.put("nama_debet_peralatan", nama_debet_peralatan);
                params.put("nama_kredit_peralatan", nama_kredit_peralatan);


                return params;
            }

        };

        queue.add(stringRequest);
    }


}