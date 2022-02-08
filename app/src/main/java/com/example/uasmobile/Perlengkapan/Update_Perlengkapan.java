package com.example.uasmobile.Perlengkapan;

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
import com.example.uasmobile.Peralatan.Akun_Peralatan;
import com.example.uasmobile.Peralatan.Update_Peralatan;
import com.example.uasmobile.R;

import java.util.HashMap;
import java.util.Map;

public class Update_Perlengkapan extends AppCompatActivity {
    EditText udt_kode_perlengkapan,udt_tipe_pengadaan_perlengkapan,udt_nama_perlengkapan,udt_qty_perlengkapan,
            udt_harga_perlengkapan,udt_desc_perlengkapan,udt_nom_debet_perlengkapan,udt_nom_kredit_perlengkapan,udt_nam_debet_perlengkapan,udt_nam_kredit_perlengkapan;
    Button btn_tambah_udt_perlengkapan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_perlengkapan);
        Intent getdata = getIntent();
        Bundle b = getdata.getExtras();
        udt_kode_perlengkapan = findViewById(R.id.udt_kode_perlengkapan);
        udt_tipe_pengadaan_perlengkapan = findViewById(R.id.udt_tipe_pengadaan_perlengkapan);
        udt_nama_perlengkapan = findViewById(R.id.udt_nama_perlengkapan);
        udt_qty_perlengkapan = findViewById(R.id.udt_qty_perlengkapan);
        udt_harga_perlengkapan = findViewById(R.id.udt_harga_perlengkapan);
        udt_desc_perlengkapan = findViewById(R.id.udt_desc_perlengkapan);
        udt_nam_debet_perlengkapan = findViewById(R.id.udt_nam_debet_perlengkapan);
        udt_nom_debet_perlengkapan = findViewById(R.id.udt_nom_debet_perlengkapan);
        udt_nam_kredit_perlengkapan = findViewById(R.id.udt_nam_kredit_perlengkapan);
        udt_nom_kredit_perlengkapan = findViewById(R.id.udt_nom_kredit_perlengkapan);

        btn_tambah_udt_perlengkapan = findViewById(R.id.btn_tambah_udt_perlengkapan);

        String update_kodeperlengkapan = (String) b.get("update_kodeperlengkapan");
        String update_tipeperlengkapan = (String) b.get("update_tipeperlengkapan");
        String update_namaperlengkapan = (String) b.get("update_namaperlengkapan");
        String update_qtyperlengkapan = (String) b.get("update_qtyperlengkapan");
        String update_hargaperlengkapan = (String) b.get("update_hargaperlengkapan");
        String update_descperlengkapan = (String) b.get("update_descperlengkapan");
        String update_akundebetperlengkapan = (String) b.get("update_akundebetperlengkapan");
        String update_debetperlengkapan = (String) b.get("update_debetperlengkapan");
        String update_akunkreditperlengkapan = (String) b.get("update_akunkreditperlengkapan");
        String update_kreditperlengkapan = (String) b.get("update_kreditperlengkapan");


        udt_kode_perlengkapan.setText(update_kodeperlengkapan);
        udt_tipe_pengadaan_perlengkapan.setText(update_tipeperlengkapan);
        udt_nama_perlengkapan.setText(update_namaperlengkapan);
        udt_qty_perlengkapan.setText(update_qtyperlengkapan);
        udt_harga_perlengkapan.setText(update_hargaperlengkapan);
        udt_desc_perlengkapan.setText(update_descperlengkapan);
        udt_nam_debet_perlengkapan.setText(update_akundebetperlengkapan);
        udt_nom_debet_perlengkapan.setText(update_debetperlengkapan);
        udt_nam_kredit_perlengkapan.setText(update_akunkreditperlengkapan);
        udt_nom_kredit_perlengkapan.setText(update_kreditperlengkapan);

        btn_tambah_udt_perlengkapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String desc_perlengkapan = udt_desc_perlengkapan.getText().toString().trim();
                update_peralatan(update_kodeperlengkapan,desc_perlengkapan);
                Intent i_update = new Intent(Update_Perlengkapan.this, Akun_Perlengkapan.class);
                startActivity(i_update);
                finish();
            }
        });
    }

    private void update_peralatan(String update_kodeperlengkapan, String desc_perlengkapan) {

        RequestQueue queue = Volley.newRequestQueue(Update_Perlengkapan.this);
        String url ="http://192.168.1.2/server_laundry/?laundry=updateperlengkapan";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Update_Perlengkapan.this,response.toString(), Toast.LENGTH_SHORT).show();
                        if(response.toString().equals("Update_berhasil")){

                        }else{
                            Toast.makeText(Update_Perlengkapan.this,response.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Update_Perlengkapan.this,error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();

                params.put("kode_perlengkapan", update_kodeperlengkapan);
                params.put("get_update_desc_perlengkapan", desc_perlengkapan);


                return params;
            }

        };

        queue.add(stringRequest);
    }
}