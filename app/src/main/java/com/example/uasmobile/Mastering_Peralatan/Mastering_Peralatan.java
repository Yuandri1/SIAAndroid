package com.example.uasmobile.Mastering_Peralatan;

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
import com.example.uasmobile.Mastering.ListDataMasterPeralatan;
import com.example.uasmobile.Mastering.ListMasterPeralatanAdapter;
import com.example.uasmobile.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Mastering_Peralatan extends AppCompatActivity {
    String server_url_select = "http://192.168.1.2/server_laundry/?laundry=masterperalatan";
    ListView listperalatan;
    List<ListDataMasterPeralatan> itemListPeralatan = new ArrayList<ListDataMasterPeralatan>();
    ListMasterPeralatanAdapter listMasterPeralatanAdapter;
    Button btn_tambah_mastering_peralatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mastering_peralatan);

        listperalatan = findViewById(R.id.list_peralatan);
        listMasterPeralatanAdapter = new ListMasterPeralatanAdapter(Mastering_Peralatan.this,this,itemListPeralatan);
        listperalatan.setAdapter(listMasterPeralatanAdapter);
        btn_tambah_mastering_peralatan = findViewById(R.id.btn_tambah_mastering_peralatan);

        listperalatan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListDataMasterPeralatan data = itemListPeralatan.get(i);
                //Toast.makeText(Akun_Kas.this,data.getKodeAkun(),Toast.LENGTH_SHORT).show();

                String get_masterkodeperalatan = data.getKodePeralatan();
                String get_masternamaperalatan = data.getNamaPeralatan();
                String get_masterdescperalatan = data.getDescPeralatan();
                String get_masterlokasiperalatan = data.getLokasiPeralatan();
                String get_mastergrupperalatan = data.getGrupPeralatan();

                Intent i_detail = new Intent(Mastering_Peralatan.this, Detail_Master_Peralatan.class);

                i_detail.putExtra("get_masterkodeperalatan", get_masterkodeperalatan);
                i_detail.putExtra("get_masternamaperalatan", get_masternamaperalatan);
                i_detail.putExtra("get_masterdescperalatan", get_masterdescperalatan);
                i_detail.putExtra("get_masterlokasiperalatan", get_masterlokasiperalatan);
                i_detail.putExtra("get_mastergrupperalatan", get_mastergrupperalatan);

                startActivity(i_detail);
            }
        });

        btn_tambah_mastering_peralatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Mastering_Peralatan.this,"Tambah diklik",Toast.LENGTH_SHORT).show();
                Intent i_tambahmstrperalatan = new Intent(Mastering_Peralatan.this, Master_Mastering_Peralatan.class);
                startActivity(i_tambahmstrperalatan);

            }
        });
        tampilDataAlat();
    }

    private void tampilDataAlat() {
        listMasterPeralatanAdapter.notifyDataSetChanged();
        JsonArrayRequest jArr = new JsonArrayRequest(server_url_select, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                // TextView text = findViewById(R.id.text);
                // Parsing json
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataMasterPeralatan item = new ListDataMasterPeralatan();


                        item.setKodePeralatan(obj.getString("KodePeralatan"));
                        item.setNamaPeralatan(obj.getString("NamaPeralatan"));
                        item.setDescPeralatan(obj.getString("DescPeralatan"));
                        item.setLokasiPeralatan(obj.getString("LokasiPeralatan"));
                        item.setGrupPeralatan(obj.getString("GrupPeralatan"));

                        // menambah item ke array
                        itemListPeralatan.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                listMasterPeralatanAdapter.notifyDataSetChanged();


                Toast.makeText(Mastering_Peralatan.this,response.toString(),Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Mastering_Peralatan.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        // menambah request ke request queue
        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mRequestQueue.add(jArr);
    }
}