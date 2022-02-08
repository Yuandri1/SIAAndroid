package com.example.uasmobile.Peralatan;

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
import com.example.uasmobile.ListDataPengadaan;
import com.example.uasmobile.ListPengadaanAdapter;
import com.example.uasmobile.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Akun_Peralatan extends AppCompatActivity {
    String server_url_select = "http://192.168.1.2/server_laundry/?laundry=peralatan";
    ListView list;
    List<ListDataPengadaan> itemList = new ArrayList<ListDataPengadaan>();
    ListPengadaanAdapter listPengadaanAdapter;
    Button btn_tambah_peralatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun_peralatan);

        list = (ListView) findViewById(R.id.list);
        listPengadaanAdapter = new ListPengadaanAdapter(Akun_Peralatan.this,this,itemList);
        list.setAdapter(listPengadaanAdapter);

        btn_tambah_peralatan = findViewById(R.id.btn_tambah_peralatan);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListDataPengadaan data = itemList.get(i);
                //Toast.makeText(Akun_Kas.this,data.getKodeAkun(),Toast.LENGTH_SHORT).show();

                String get_kodeperalatan = data.getKode();
                String get_tipeperalatan = data.getTipePengada();
                String get_namaperalatan = data.getNama();
                String get_qtyperalatan = data.getQuantity();
                String get_hargaperalatan = data.getHarga();
                String get_descperalatan = data.getDeskripsi();
                String get_akundebetperalatan = data.getAkunDebet();
                String get_debetperalatan = data.getDebet();
                String get_akunkreditperalatan = data.getAkunKredit();
                String get_kreditperalatan = data.getKredit();

                Intent i_detail = new Intent(Akun_Peralatan.this,Detail_Peralatan.class);

                i_detail.putExtra("get_kodeperalatan", get_kodeperalatan);
                i_detail.putExtra("get_tipeperalatan", get_tipeperalatan);
                i_detail.putExtra("get_namaperalatan", get_namaperalatan);
                i_detail.putExtra("get_qtyperalatan", get_qtyperalatan);
                i_detail.putExtra("get_hargaperalatan", get_hargaperalatan);
                i_detail.putExtra("get_descperalatan", get_descperalatan);
                i_detail.putExtra("get_akundebetperalatan", get_akundebetperalatan);
                i_detail.putExtra("get_debetperalatan", get_debetperalatan);
                i_detail.putExtra("get_akunkreditperalatan", get_akunkreditperalatan);
                i_detail.putExtra("get_kreditperalatan", get_kreditperalatan);

                startActivity(i_detail);
            }
        });

        btn_tambah_peralatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Akun_Peralatan.this,"Tambah diklik",Toast.LENGTH_SHORT).show();
                Intent i_tambahperalatan = new Intent(Akun_Peralatan.this, Master_Peralatan.class);
                startActivity(i_tambahperalatan);
            }
        });
        tampilDataPengadaan();
    }

    private void tampilDataPengadaan() {
        listPengadaanAdapter.notifyDataSetChanged();
        JsonArrayRequest jArr = new JsonArrayRequest(server_url_select, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                // TextView text = findViewById(R.id.text);
                // Parsing json
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataPengadaan item = new ListDataPengadaan();


                        item.setKode(obj.getString("Kode"));
                        item.setTipePengada(obj.getString("TipePengada"));
                        item.setNama(obj.getString("Nama"));
                        item.setQuantity(obj.getString("Quantity"));
                        item.setHarga(obj.getString("Harga"));
                        item.setDeskripsi(obj.getString("Deskripsi"));
                        item.setAkunDebet(obj.getString("AkunDebet"));
                        item.setDebet(obj.getString("Debet"));
                        item.setAkunKredit(obj.getString("AkunKredit"));
                        item.setKredit(obj.getString("Kredit"));

                        // menambah item ke array
                        itemList.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                listPengadaanAdapter.notifyDataSetChanged();


                Toast.makeText(Akun_Peralatan.this,response.toString(),Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Akun_Peralatan.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        // menambah request ke request queue
        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mRequestQueue.add(jArr);
    }
}