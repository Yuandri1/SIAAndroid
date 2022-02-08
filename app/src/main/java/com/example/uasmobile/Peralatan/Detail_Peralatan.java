package com.example.uasmobile.Peralatan;

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
import com.example.uasmobile.R;

import java.util.HashMap;
import java.util.Map;

public class Detail_Peralatan extends AppCompatActivity {
    TextView txt_kode_peralatan,spn_tipe_pengadaan_peralatan,txt_nama_peralatan,txt_quantity_peralatan,txt_harga_peralatan,
            txt_desc_peralatan,txt_nom_debet_pengadaan_peralatan,txt_nom_kredit_pengadaan_peralatan,txt_nam_debet_pengadaan_peralatan,txt_nam_kredit_pengadaan_peralatan;
    Button btn_delete_peralatan, btn_update_peralatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_peralatan);

        Intent getdata = getIntent();
        Bundle b = getdata.getExtras();

        String kodeperalatan = (String) b.get("get_kodeperalatan");
        String tipeperalatan = (String) b.get("get_tipeperalatan");
        String namaperalatan = (String) b.get("get_namaperalatan");
        String qtyperalatan = (String) b.get("get_qtyperalatan");
        String hargaperalatan = (String) b.get("get_hargaperalatan");
        String descperalatan = (String) b.get("get_descperalatan");
        String akundebetperalatan = (String) b.get("get_akundebetperalatan");
        String debetperalatan = (String) b.get("get_debetperalatan");
        String akunkreditperalatan = (String) b.get("get_akunkreditperalatan");
        String kreditperalatan = (String) b.get("get_kreditperalatan");

        //Toast.makeText(Detail_Peralatan.this,kodeperalatan, Toast.LENGTH_SHORT).show();

        txt_kode_peralatan   =  findViewById(R.id.txt_kode_peralatan);
        spn_tipe_pengadaan_peralatan =  findViewById(R.id.spn_tipe_pengadaan_peralatan);
        txt_nama_peralatan =  findViewById(R.id.txt_nama_peralatan);
        txt_quantity_peralatan =  findViewById(R.id.txt_quantity_peralatan);
        txt_harga_peralatan =  findViewById(R.id.txt_harga_peralatan);
        txt_desc_peralatan =  findViewById(R.id.txt_desc_peralatan);
        txt_nam_debet_pengadaan_peralatan =  findViewById(R.id.txt_nam_debet_pengadaan_peralatan);
        txt_nom_debet_pengadaan_peralatan =  findViewById(R.id.txt_nom_debet_pengadaan_peralatan);
        txt_nam_kredit_pengadaan_peralatan =  findViewById(R.id.txt_nam_kredit_pengadaan_peralatan);
        txt_nom_kredit_pengadaan_peralatan =  findViewById(R.id.txt_nom_kredit_pengadaan_peralatan);

        btn_delete_peralatan = findViewById(R.id.btn_delete_peralatan);
        btn_update_peralatan = findViewById(R.id.btn_update_peralatan);


        txt_kode_peralatan.setText(kodeperalatan);
        spn_tipe_pengadaan_peralatan.setText(tipeperalatan);
        txt_nama_peralatan.setText(namaperalatan);
        txt_quantity_peralatan.setText(qtyperalatan);
        txt_harga_peralatan.setText(hargaperalatan);
        txt_desc_peralatan.setText(descperalatan);
        txt_nam_debet_pengadaan_peralatan.setText(akundebetperalatan);
        txt_nom_debet_pengadaan_peralatan.setText(debetperalatan);
        txt_nam_kredit_pengadaan_peralatan.setText(akunkreditperalatan);
        txt_nom_kredit_pengadaan_peralatan.setText(kreditperalatan);

        btn_delete_peralatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hapus_peralatan(kodeperalatan);
                Toast.makeText(Detail_Peralatan.this,"Delete diklik",Toast.LENGTH_SHORT).show();
                Intent i_deleteperalatan = new Intent(Detail_Peralatan.this, Akun_Peralatan.class);
                startActivity(i_deleteperalatan);
                finish();
            }
        });

        btn_update_peralatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_update = new Intent(Detail_Peralatan.this, Update_Peralatan.class);
                i_update.putExtra("update_kodeperalatan", kodeperalatan);
                i_update.putExtra("update_tipeperalatan", tipeperalatan);
                i_update.putExtra("update_namaperalatan", namaperalatan);
                i_update.putExtra("update_qtyperalatan", qtyperalatan);
                i_update.putExtra("update_hargaperalatan", hargaperalatan);
                i_update.putExtra("update_descperalatan", descperalatan);
                i_update.putExtra("update_akundebetperalatan", akundebetperalatan);
                i_update.putExtra("update_debetperalatan", debetperalatan);
                i_update.putExtra("update_akunkreditperalatan", akunkreditperalatan);
                i_update.putExtra("update_kreditperalatan", kreditperalatan);


                startActivity(i_update);
            }
        });

    }

    private void hapus_peralatan(String kodeperalatan) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.2/server_laundry/?laundry=hapusperalatan";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //Toast.makeText(TambahKomik.this,response.toString(), Toast.LENGTH_SHORT).show();
                        if (response.toString().equals("insert_data_berhasil")) {
                            Intent i_main = new Intent(Detail_Peralatan.this, Akun_Peralatan.class);
                            startActivity(i_main);
                            finish();
                        } else {
                            Toast.makeText(Detail_Peralatan.this, response.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Detail_Peralatan.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();

                params.put("kode_peralatan", kodeperalatan);


                return params;
            }
        };
        queue.add(stringRequest);
    }

}
