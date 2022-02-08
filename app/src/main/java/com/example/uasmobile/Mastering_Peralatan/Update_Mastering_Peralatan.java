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
import com.example.uasmobile.Perlengkapan.Akun_Perlengkapan;
import com.example.uasmobile.Perlengkapan.Update_Perlengkapan;
import com.example.uasmobile.R;

import java.util.HashMap;
import java.util.Map;

public class Update_Mastering_Peralatan extends AppCompatActivity {
    EditText update_kode_peralatan, update_nama_peralatan, update_desc_peralatan, update_lokasi_peralatan, update_grup_peralatan;
    Button btn_tambah_update_peralatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_mastering_peralatan);
        Intent getdata = getIntent();
        Bundle b = getdata.getExtras();

        update_kode_peralatan = findViewById(R.id.update_kode_peralatan);
        update_nama_peralatan = findViewById(R.id.update_nama_peralatan);
        update_desc_peralatan = findViewById(R.id.update_desc_peralatan);
        update_lokasi_peralatan = findViewById(R.id.update_lokasi_peralatan);
        update_grup_peralatan = findViewById(R.id.update_grup_peralatan);


        btn_tambah_update_peralatan = findViewById(R.id.btn_tambah_update_peralatan);

        String update_masterkodeperalatan = (String) b.get("update_masterkodeperalatan");
        String update_masternamaperalatan = (String) b.get("update_masternamaperalatan");
        String update_masterdescperalatan = (String) b.get("update_masterdescperalatan");
        String update_masterlokasiperalatan = (String) b.get("update_masterlokasiperalatan");
        String update_mastergrupperalatan = (String) b.get("update_mastergrupperalatan");

        update_kode_peralatan.setText(update_masterkodeperalatan);
        update_nama_peralatan.setText(update_masternamaperalatan);
        update_desc_peralatan.setText(update_masterdescperalatan);
        update_lokasi_peralatan.setText(update_masterlokasiperalatan);
        update_grup_peralatan.setText(update_mastergrupperalatan);

        btn_tambah_update_peralatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String desc_master_peralatan = update_desc_peralatan.getText().toString().trim();
                update_mastering_peralatan(update_masterkodeperalatan,desc_master_peralatan);
                Intent i_update_master = new Intent(Update_Mastering_Peralatan.this, Mastering_Peralatan.class);
                startActivity(i_update_master);
                finish();
            }
        });
    }

    private void update_mastering_peralatan(String update_masterkodeperalatan, String desc_master_peralatan) {
        RequestQueue queue = Volley.newRequestQueue(Update_Mastering_Peralatan.this);
        String url ="http://192.168.1.2/server_laundry/?laundry=updatemasterperalatan";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Update_Mastering_Peralatan.this,response.toString(), Toast.LENGTH_SHORT).show();
                        if(response.toString().equals("Update_berhasil")){

                        }else{
                            Toast.makeText(Update_Mastering_Peralatan.this,response.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Update_Mastering_Peralatan.this,error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();

                params.put("update_masterkodeperalatan", update_masterkodeperalatan);
                params.put("desc_master_peralatan", desc_master_peralatan);


                return params;
            }

        };

        queue.add(stringRequest);
    }
}