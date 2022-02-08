package com.example.uasmobile.Perlengkapan;

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
import com.example.uasmobile.Peralatan.Akun_Peralatan;
import com.example.uasmobile.Peralatan.Detail_Peralatan;
import com.example.uasmobile.Peralatan.Master_Peralatan;
import com.example.uasmobile.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Akun_Perlengkapan extends AppCompatActivity {
    String server_url_select = "http://192.168.1.2/server_laundry/?laundry=perlengkapan";
    ListView list;
    List<ListDataPengadaan> itemList = new ArrayList<ListDataPengadaan>();
    ListPengadaanAdapter listPengadaanAdapter;
    Button btn_tambah_perlengkapan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun_perlengkapan);
        list = (ListView) findViewById(R.id.list);
        listPengadaanAdapter = new ListPengadaanAdapter(Akun_Perlengkapan.this,this,itemList);
        list.setAdapter(listPengadaanAdapter);
        btn_tambah_perlengkapan = findViewById(R.id.btn_tambah_perlengkapan);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListDataPengadaan data = itemList.get(i);
                //Toast.makeText(Akun_Kas.this,data.getKodeAkun(),Toast.LENGTH_SHORT).show();

                String get_kodeperlengkapan = data.getKode();
                String get_tipeperlengkapan = data.getTipePengada();
                String get_namaperlengkapan = data.getNama();
                String get_qtyperlengkapan = data.getQuantity();
                String get_hargaperlengkapan = data.getHarga();
                String get_descperlengkapan = data.getDeskripsi();
                String get_akundebetperlengkapan = data.getAkunDebet();
                String get_debetperlengkapan= data.getDebet();
                String get_akunkreditperlengkapan = data.getAkunKredit();
                String get_kreditperlengkapan = data.getKredit();

                Intent i_detail = new Intent(Akun_Perlengkapan.this, Detail_Perlengkapan.class);

                i_detail.putExtra("get_kodeperlengkapan", get_kodeperlengkapan);
                i_detail.putExtra("get_tipeperlengkapan", get_tipeperlengkapan);
                i_detail.putExtra("get_namaperlengkapan", get_namaperlengkapan);
                i_detail.putExtra("get_qtyperlengkapan", get_qtyperlengkapan);
                i_detail.putExtra("get_hargaperlengkapan", get_hargaperlengkapan);
                i_detail.putExtra("get_descperlengkapan", get_descperlengkapan);
                i_detail.putExtra("get_akundebetperlengkapan", get_akundebetperlengkapan);
                i_detail.putExtra("get_debetperlengkapan", get_debetperlengkapan);
                i_detail.putExtra("get_akunkreditperlengkapan", get_akunkreditperlengkapan);
                i_detail.putExtra("get_kreditperlengkapan", get_kreditperlengkapan);

                startActivity(i_detail);
            }
        });


        btn_tambah_perlengkapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Akun_Perlengkapan.this,"Tambah diklik",Toast.LENGTH_SHORT).show();
                Intent i_tambahperlengkapan = new Intent(Akun_Perlengkapan.this, Master_Perlengkapan.class);
                startActivity(i_tambahperlengkapan);
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


                Toast.makeText(Akun_Perlengkapan.this,response.toString(),Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Akun_Perlengkapan.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        // menambah request ke request queue
        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mRequestQueue.add(jArr);
    }
}
