package com.example.uasmobile.Mastering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.uasmobile.Mastering_Peralatan.Detail_Master_Peralatan;
import com.example.uasmobile.Mastering_Peralatan.Master_Mastering_Peralatan;
import com.example.uasmobile.Mastering_Peralatan.Mastering_Peralatan;
import com.example.uasmobile.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Mastering_Perlengkapan extends AppCompatActivity {
    String server_url_select = "http://192.168.1.2/server_laundry/?laundry=masterperlengkapan";
    ListView listperlengkapan;
    List<ListDataMasterPerlengkapan> itemListPerlengkapan = new ArrayList<ListDataMasterPerlengkapan>();
    ListMasterPerlengkapanAdapter listMasterPerlengkapanAdapter;
    Button btn_tambah_mastering_perlengkapan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mastering_perlengkapan);
        listperlengkapan = (ListView) findViewById(R.id.list_perlengkapan);
        listMasterPerlengkapanAdapter = new ListMasterPerlengkapanAdapter(Mastering_Perlengkapan.this,this,itemListPerlengkapan);
        listperlengkapan.setAdapter(listMasterPerlengkapanAdapter);
        btn_tambah_mastering_perlengkapan = findViewById(R.id.btn_tambah_mastering_perlengkapan);

        listperlengkapan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListDataMasterPerlengkapan data = itemListPerlengkapan.get(i);
                //Toast.makeText(Akun_Kas.this,data.getKodeAkun(),Toast.LENGTH_SHORT).show();

                String get_masterkodeperlengkapan = data.getKodePerlengkapan();
                String get_masternamaperlengkapan = data.getNamaPerlengkapan();
                String get_masterdescperlengkapan = data.getDescPerlengkapan();


                Intent i_detail = new Intent(Mastering_Perlengkapan.this, Detail_Master_Perlengkapan.class);

                i_detail.putExtra("get_masterkodeperlengkapan", get_masterkodeperlengkapan);
                i_detail.putExtra("get_masternamaperlengkapan", get_masternamaperlengkapan);
                i_detail.putExtra("get_masterdescperlengkapan", get_masterdescperlengkapan);


                startActivity(i_detail);
            }
        });
        btn_tambah_mastering_perlengkapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Mastering_Perlengkapan.this,"Tambah diklik",Toast.LENGTH_SHORT).show();
                Intent i_tambahmstrperlengkapan = new Intent(Mastering_Perlengkapan.this, Master_Mastering_Perlengkapan.class);
                startActivity(i_tambahmstrperlengkapan);
            }
        });

        tampilDataPerlengkapan();

    }

    private void tampilDataPerlengkapan() {
        listMasterPerlengkapanAdapter.notifyDataSetChanged();
        JsonArrayRequest jArr = new JsonArrayRequest(server_url_select, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                // TextView text = findViewById(R.id.text);
                // Parsing json
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataMasterPerlengkapan item = new ListDataMasterPerlengkapan();


                        item.setKodePerlengkapan(obj.getString("KodePerlengkapan"));
                        item.setNamaPerlengkapan(obj.getString("NamaPerlengkapan"));
                        item.setDescPerlengkapan(obj.getString("DescPerlengkapan"));

                        // menambah item ke array
                        itemListPerlengkapan.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                listMasterPerlengkapanAdapter.notifyDataSetChanged();


                Toast.makeText(Mastering_Perlengkapan.this,response.toString(),Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Mastering_Perlengkapan.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        // menambah request ke request queue
        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mRequestQueue.add(jArr);
    }
}