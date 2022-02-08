package com.example.uasmobile.Mastering;

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
import com.example.uasmobile.Mastering_Peralatan.Mastering_Peralatan;
import com.example.uasmobile.Mastering_Peralatan.Update_Mastering_Peralatan;
import com.example.uasmobile.R;

import java.util.HashMap;
import java.util.Map;

public class Update_Mastering_Perlengkapan extends AppCompatActivity {
    EditText update_kode_perlengkapan, update_nama_perlengkapan, update_desc_perlengkapan;
    Button btn_tambah_update_perlengkapan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_mastering_perlengkapan);

        Intent getdata = getIntent();
        Bundle b = getdata.getExtras();

        update_kode_perlengkapan = findViewById(R.id.update_kode_perlengkapan);
        update_nama_perlengkapan = findViewById(R.id.update_nama_perlengkapan);
        update_desc_perlengkapan = findViewById(R.id.update_desc_perlengkapan);

        btn_tambah_update_perlengkapan = findViewById(R.id.btn_tambah_update_perlengkapan);

        String update_masterkodeperlengkapan = (String) b.get("update_masterkodeperlengkapan");
        String update_masternamaperlengkapan = (String) b.get("update_masternamaperlengkapan");
        String update_masterdescperlengkapan = (String) b.get("update_masterdescperlengkapan");

        update_kode_perlengkapan.setText(update_masterkodeperlengkapan);
        update_nama_perlengkapan.setText(update_masternamaperlengkapan);
        update_desc_perlengkapan.setText(update_masterdescperlengkapan);

        btn_tambah_update_perlengkapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String desc_master_perlengkapann = update_desc_perlengkapan.getText().toString().trim();
                update_mastering_perlengkapan(update_masterkodeperlengkapan,desc_master_perlengkapann);
                Intent i_update_master = new Intent(Update_Mastering_Perlengkapan.this, Mastering_Perlengkapan.class);
                startActivity(i_update_master);
                finish();
            }
        });
    }

    private void update_mastering_perlengkapan(String update_masterkodeperlengkapan, String desc_master_perlengkapann) {
        RequestQueue queue = Volley.newRequestQueue(Update_Mastering_Perlengkapan.this);
        String url ="http://192.168.1.2/server_laundry/?laundry=updatemasterperlengkapan";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Update_Mastering_Perlengkapan.this,response.toString(), Toast.LENGTH_SHORT).show();
                        if(response.toString().equals("Update_berhasil")){

                        }else{
                            Toast.makeText(Update_Mastering_Perlengkapan.this,response.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Update_Mastering_Perlengkapan.this,error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();

                params.put("update_masterkodeperlengkapan", update_masterkodeperlengkapan);
                params.put("desc_master_perlengkapan", desc_master_perlengkapann);


                return params;
            }

        };

        queue.add(stringRequest);
    }
}