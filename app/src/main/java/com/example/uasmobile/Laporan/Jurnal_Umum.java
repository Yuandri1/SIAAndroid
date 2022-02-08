package com.example.uasmobile.Laporan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.uasmobile.ListDataPengadaan;
import com.example.uasmobile.ListPengadaanAdapter;
import com.example.uasmobile.Peralatan.Akun_Peralatan;
import com.example.uasmobile.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Jurnal_Umum extends AppCompatActivity {
    String server_url_select = "http://192.168.1.2/server_laundry/?laundry=jurnalumum";
    ListView list;
    List<ListDataJurnalUmum> itemListJU = new ArrayList<ListDataJurnalUmum>();
    ListJurnalUmumAdapter listJurnalUmumAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurnal_umum);

        list = (ListView) findViewById(R.id.list_jurnal);
        listJurnalUmumAdapter = new ListJurnalUmumAdapter(Jurnal_Umum.this,this,itemListJU);
        list.setAdapter(listJurnalUmumAdapter);

        tampilDataJurnalUmum();
    }

    private void tampilDataJurnalUmum() {
        listJurnalUmumAdapter.notifyDataSetChanged();
        JsonArrayRequest jArr = new JsonArrayRequest(server_url_select, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                // TextView text = findViewById(R.id.text);
                // Parsing json
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataJurnalUmum item = new ListDataJurnalUmum();


                        item.setKode_JU(obj.getString("Kode_JU"));
                        item.setHarga_JU(obj.getString("Harga_JU"));
                        item.setDeskripsi_JU(obj.getString("Deskripsi_JU"));
                        item.setAkunDebet_JU(obj.getString("AkunDebet_JU"));
                        item.setDebet_JU(obj.getString("Debet_JU"));
                        item.setAkunKredit_JU(obj.getString("AkunKredit_JU"));
                        item.setKredit_JU(obj.getString("Kredit_JU"));

                        // menambah item ke array
                        itemListJU.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                listJurnalUmumAdapter.notifyDataSetChanged();


                Toast.makeText(Jurnal_Umum.this,response.toString(),Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Jurnal_Umum.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        // menambah request ke request queue
        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mRequestQueue.add(jArr);
    }
}