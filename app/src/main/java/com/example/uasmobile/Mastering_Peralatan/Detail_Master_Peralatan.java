package com.example.uasmobile.Mastering_Peralatan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.uasmobile.Peralatan.Master_Peralatan;
import com.example.uasmobile.Peralatan.Update_Peralatan;
import com.example.uasmobile.R;

import java.util.HashMap;
import java.util.Map;

public class Detail_Master_Peralatan extends AppCompatActivity {
    TextView mas_kode_peralatan, mas_nama_peralatan, mas_desc_peralatan, mas_lokasi_peralatan, mas_grup_peralatan;
    Button btn_update_mastering_peralatan, btn_delete_mastering_peralatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_master_peralatan);

        Intent getdata = getIntent();
        Bundle b = getdata.getExtras();

        String masterkodeperalatan = (String) b.get("get_masterkodeperalatan");
        String masternamaperalatan = (String) b.get("get_masternamaperalatan");
        String masterdescperalatan = (String) b.get("get_masterdescperalatan");
        String masterlokasiperalatan = (String) b.get("get_masterlokasiperalatan");
        String mastergrupperalatan = (String) b.get("get_mastergrupperalatan");

        Toast.makeText(Detail_Master_Peralatan.this,masterkodeperalatan, Toast.LENGTH_SHORT).show();

        mas_kode_peralatan = findViewById(R.id.mas_kode_peralatan);
        mas_nama_peralatan = findViewById(R.id.mas_nama_peralatan);
        mas_desc_peralatan = findViewById(R.id.mas_desc_peralatan);
        mas_lokasi_peralatan = findViewById(R.id.mas_lokasi_peralatan);
        mas_grup_peralatan = findViewById(R.id.mas_grup_peralatan);

        btn_update_mastering_peralatan =findViewById(R.id.btn_update_mastering_peralatan);
        btn_delete_mastering_peralatan =findViewById(R.id.btn_delete_mastering_peralatan);

        mas_kode_peralatan.setText(masterkodeperalatan);
        mas_nama_peralatan.setText(masternamaperalatan);
        mas_desc_peralatan.setText(masterdescperalatan);
        mas_lokasi_peralatan.setText(masterlokasiperalatan);
        mas_grup_peralatan.setText(mastergrupperalatan);

        btn_delete_mastering_peralatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hapus_mastering_peralatan(masterkodeperalatan);Toast.makeText(Detail_Master_Peralatan.this,"Delete diklik",Toast.LENGTH_SHORT).show();
                Intent i_deleteperalatan = new Intent(Detail_Master_Peralatan.this, Mastering_Peralatan.class);
                startActivity(i_deleteperalatan);
                finish();

            }
        });
        btn_update_mastering_peralatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_update_masterA = new Intent(Detail_Master_Peralatan.this, Update_Mastering_Peralatan.class);
                i_update_masterA.putExtra("update_masterkodeperalatan", masterkodeperalatan);
                i_update_masterA.putExtra("update_masternamaperalatan", masternamaperalatan);
                i_update_masterA.putExtra("update_masterdescperalatan", masterdescperalatan);
                i_update_masterA.putExtra("update_masterlokasiperalatan", masterlokasiperalatan);
                i_update_masterA.putExtra("update_mastergrupperalatan", mastergrupperalatan);
                startActivity(i_update_masterA);
            }
        });
    }

    private void hapus_mastering_peralatan(String masterkodeperalatan) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.2/server_laundry/?laundry=hapusmasterperalatan";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //Toast.makeText(TambahKomik.this,response.toString(), Toast.LENGTH_SHORT).show();
                        if (response.toString().equals("insert_data_berhasil")) {
                            Intent i_main = new Intent(Detail_Master_Peralatan.this, Mastering_Peralatan.class);
                            startActivity(i_main);
                            finish();
                        } else {
                            Toast.makeText(Detail_Master_Peralatan.this, response.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Detail_Master_Peralatan.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();

                params.put("kode_master_peralatan", masterkodeperalatan);


                return params;
            }
        };
        queue.add(stringRequest);
    }
}