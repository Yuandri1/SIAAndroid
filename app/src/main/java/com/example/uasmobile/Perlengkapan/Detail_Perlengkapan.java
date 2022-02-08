package com.example.uasmobile.Perlengkapan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.uasmobile.Peralatan.Akun_Peralatan;
import com.example.uasmobile.Peralatan.Detail_Peralatan;
import com.example.uasmobile.Peralatan.Update_Peralatan;
import com.example.uasmobile.R;

import java.util.HashMap;
import java.util.Map;

public class Detail_Perlengkapan extends AppCompatActivity {
    TextView txt_kode_perlengkapan,spn_tipe_pengadaan_perlengkapan,txt_nama_perlengkapan,txt_quantity_perlengkapan,
            txt_harga_perlengkapan,txt_desc_perlengkapan,txt_nom_debet_pengadaan_perlengkapan,txt_nom_kredit_pengadaan_perlengkapan,txt_nam_debet_pengadaan_perlengkapan,txt_nam_kredit_pengadaan_perlengkapan;
    Button btn_delete_perlengkapan,btn_update_perlengkapan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_perlengkapan);
        Intent getdata = getIntent();
        Bundle b = getdata.getExtras();

        String kodeperlengkapan = (String) b.get("get_kodeperlengkapan");
        String tipeperlengkapan = (String) b.get("get_tipeperlengkapan");
        String namaperlengkapan = (String) b.get("get_namaperlengkapan");
        String qtyperlengkapan = (String) b.get("get_qtyperlengkapan");
        String hargaperlengkapan = (String) b.get("get_hargaperlengkapan");
        String descperlengkapan = (String) b.get("get_descperlengkapan");
        String akundebetperlengkapan = (String) b.get("get_akundebetperlengkapan");
        String debetperlengkapan = (String) b.get("get_debetperlengkapan");
        String akunkreditperlengkapan = (String) b.get("get_akunkreditperlengkapan");
        String kreditperlengkapan = (String) b.get("get_kreditperlengkapan");

        Toast.makeText(Detail_Perlengkapan.this,kodeperlengkapan, Toast.LENGTH_SHORT).show();

        txt_kode_perlengkapan   =  findViewById(R.id.txt_kode_perlengkapan);
        spn_tipe_pengadaan_perlengkapan =  findViewById(R.id.spn_tipe_pengadaan_perlengkapan);
        txt_nama_perlengkapan =  findViewById(R.id.txt_nama_perlengkapan);
        txt_quantity_perlengkapan =  findViewById(R.id.txt_quantity_perlengkapan);
        txt_harga_perlengkapan =  findViewById(R.id.txt_harga_perlengkapan);
        txt_desc_perlengkapan =  findViewById(R.id.txt_desc_perlengkapan);
        txt_nam_debet_pengadaan_perlengkapan =  findViewById(R.id.txt_nam_debet_pengadaan_perlengkapan);
        txt_nom_debet_pengadaan_perlengkapan =  findViewById(R.id.txt_nom_debet_pengadaan_perlengkapan);
        txt_nam_kredit_pengadaan_perlengkapan =  findViewById(R.id.txt_nam_kredit_pengadaan_perlengkapan);
        txt_nom_kredit_pengadaan_perlengkapan =  findViewById(R.id.txt_nom_kredit_pengadaan_perlengkapan);

        btn_delete_perlengkapan = findViewById(R.id.btn_delete_perlengkapan);
        btn_update_perlengkapan = findViewById(R.id.btn_update_perlengkapan);


        txt_kode_perlengkapan.setText(kodeperlengkapan);
        spn_tipe_pengadaan_perlengkapan.setText(tipeperlengkapan);
        txt_nama_perlengkapan.setText(namaperlengkapan);
        txt_quantity_perlengkapan.setText(qtyperlengkapan);
        txt_harga_perlengkapan.setText(hargaperlengkapan);
        txt_desc_perlengkapan.setText(descperlengkapan);
        txt_nam_debet_pengadaan_perlengkapan.setText(akundebetperlengkapan);
        txt_nom_debet_pengadaan_perlengkapan.setText(debetperlengkapan);
        txt_nam_kredit_pengadaan_perlengkapan.setText(akunkreditperlengkapan);
        txt_nom_kredit_pengadaan_perlengkapan.setText(kreditperlengkapan);

        btn_delete_perlengkapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hapus_perlengkapan(kodeperlengkapan);
                Toast.makeText(Detail_Perlengkapan.this,"Delete diklik",Toast.LENGTH_SHORT).show();
                Intent i_deleteperlengkapann = new Intent(Detail_Perlengkapan.this, Akun_Perlengkapan.class);
                startActivity(i_deleteperlengkapann);
                finish();
            }
        });

        btn_update_perlengkapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_update = new Intent(Detail_Perlengkapan.this, Update_Perlengkapan.class);
                i_update.putExtra("update_kodeperlengkapan", kodeperlengkapan);
                i_update.putExtra("update_tipeperlengkapan", tipeperlengkapan);
                i_update.putExtra("update_namaperlengkapan", namaperlengkapan);
                i_update.putExtra("update_qtyperlengkapan", qtyperlengkapan);
                i_update.putExtra("update_hargaperlengkapan", hargaperlengkapan);
                i_update.putExtra("update_descperlengkapan", descperlengkapan);
                i_update.putExtra("update_akundebetperlengkapan", akundebetperlengkapan);
                i_update.putExtra("update_debetperlengkapan", debetperlengkapan);
                i_update.putExtra("update_akunkreditperlengkapan", akunkreditperlengkapan);
                i_update.putExtra("update_kreditperlengkapan", kreditperlengkapan);


                startActivity(i_update);
            }
        });

    }

    private void hapus_perlengkapan(String kodeperlengkapan) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.2/server_laundry/?laundry=hapusperlengkapan";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //Toast.makeText(TambahKomik.this,response.toString(), Toast.LENGTH_SHORT).show();
                        if (response.toString().equals("insert_data_berhasil")) {
                            Intent i_main = new Intent(Detail_Perlengkapan.this, Akun_Perlengkapan.class);
                            startActivity(i_main);
                            finish();
                        } else {
                            Toast.makeText(Detail_Perlengkapan.this, response.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Detail_Perlengkapan.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();

                params.put("kode_perlengkapan", kodeperlengkapan);


                return params;
            }
        };
        queue.add(stringRequest);
    }
}