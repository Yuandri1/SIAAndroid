package com.example.uasmobile.Mastering;

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
import com.example.uasmobile.Mastering_Peralatan.Detail_Master_Peralatan;
import com.example.uasmobile.Mastering_Peralatan.Mastering_Peralatan;
import com.example.uasmobile.Mastering_Peralatan.Update_Mastering_Peralatan;
import com.example.uasmobile.R;

import java.util.HashMap;
import java.util.Map;

public class Detail_Master_Perlengkapan extends AppCompatActivity {
    TextView mas_kode_perlengkapan, mas_nama_perlengkapan, mas_desc_perlengkapan;
    Button btn_delete_mastering_perlengkapan, btn_update_mastering_perlengkapan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_master_perlengkapan);

        Intent getdata = getIntent();
        Bundle b = getdata.getExtras();

        String masterkodeperlengkapan = (String) b.get("get_masterkodeperlengkapan");
        String masternamaperlengkapan = (String) b.get("get_masternamaperlengkapan");
        String masterdescperlengkapan = (String) b.get("get_masterdescperlengkapan");

        Toast.makeText(Detail_Master_Perlengkapan.this,masterkodeperlengkapan, Toast.LENGTH_SHORT).show();

        mas_kode_perlengkapan = findViewById(R.id.mas_kode_perlengkapan);
        mas_nama_perlengkapan = findViewById(R.id.mas_nama_perlengkapan);
        mas_desc_perlengkapan = findViewById(R.id.mas_desc_perlengkapan);

        btn_delete_mastering_perlengkapan = findViewById(R.id.btn_delete_mastering_perlengkapan);
        btn_update_mastering_perlengkapan = findViewById(R.id.btn_update_mastering_perlengkapan);

        mas_kode_perlengkapan.setText(masterkodeperlengkapan);
        mas_nama_perlengkapan.setText(masternamaperlengkapan);
        mas_desc_perlengkapan.setText(masterdescperlengkapan);

        btn_delete_mastering_perlengkapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hapus_mastering_perlengkapan(masterkodeperlengkapan);Toast.makeText(Detail_Master_Perlengkapan.this,"Delete diklik",Toast.LENGTH_SHORT).show();
                Intent i_deleteperalatan = new Intent(Detail_Master_Perlengkapan.this, Mastering_Perlengkapan.class);
                startActivity(i_deleteperalatan);
                finish();

            }
        });

        btn_update_mastering_perlengkapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_update_masterP = new Intent(Detail_Master_Perlengkapan.this, Update_Mastering_Perlengkapan.class);
                i_update_masterP.putExtra("update_masterkodeperlengkapan", masterkodeperlengkapan);
                i_update_masterP.putExtra("update_masternamaperlengkapan", masternamaperlengkapan);
                i_update_masterP.putExtra("update_masterdescperlengkapan", masterdescperlengkapan);

                startActivity(i_update_masterP);
            }
        });
    }


    private void hapus_mastering_perlengkapan(String masterkodeperlengkapan) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.2/server_laundry/?laundry=hapusmasterperlengkapan";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //Toast.makeText(TambahKomik.this,response.toString(), Toast.LENGTH_SHORT).show();
                        if (response.toString().equals("insert_data_berhasil")) {
                            Intent i_main = new Intent(Detail_Master_Perlengkapan.this, Mastering_Perlengkapan.class);
                            startActivity(i_main);
                            finish();
                        } else {
                            Toast.makeText(Detail_Master_Perlengkapan.this, response.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Detail_Master_Perlengkapan.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();

                params.put("kode_master_perlengkapan", masterkodeperlengkapan);


                return params;
            }
        };
        queue.add(stringRequest);

    }
}