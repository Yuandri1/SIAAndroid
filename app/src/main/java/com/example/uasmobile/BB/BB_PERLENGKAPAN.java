package com.example.uasmobile.BB;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.uasmobile.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BB_PERLENGKAPAN extends AppCompatActivity {

    String server_bb_debitperlengkapan = "http://192.168.1.2/server_laundry/?laundry=bbdebitperlengkapan";
    ListView listbbdebitperlengkapan;
    ListBukuBesarDebitPerlengkapanBaseAdapter listBukuBesarDebitPerlengkapanBaseAdapter;
    List<ListDataBukuBesarDebitPerlengkapan> itemListbbdebitperlengkapan = new ArrayList<ListDataBukuBesarDebitPerlengkapan>();

    String server_bb_kreditperlengkapan = "http://192.168.1.2/server_laundry/?laundry=bbkreditperlengkapan";
    ListView listbbkreditperlengkapan;
    ListBukuBesarKreditPerlengkapanBaseAdapter listBukuBesarKreditPerlengkapanBaseAdapter;
    List<ListDataBukuBesarKreditPerlengkapan> itemListbbkreditperlengkapan = new ArrayList<ListDataBukuBesarKreditPerlengkapan>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bb_perlengkapan);

        listbbdebitperlengkapan = (ListView) findViewById(R.id.list_BBDEBITPERLENGKAPAN);
        listBukuBesarDebitPerlengkapanBaseAdapter = new ListBukuBesarDebitPerlengkapanBaseAdapter(BB_PERLENGKAPAN.this,this, itemListbbdebitperlengkapan);
        listbbdebitperlengkapan.setAdapter(listBukuBesarDebitPerlengkapanBaseAdapter);
        tampilDataBukuBesarDebitPerlengkapan();

        listbbkreditperlengkapan = (ListView) findViewById(R.id.list_BBDEBITPERLENGKAPAN);
        listBukuBesarKreditPerlengkapanBaseAdapter = new ListBukuBesarKreditPerlengkapanBaseAdapter(BB_PERLENGKAPAN.this,this, itemListbbkreditperlengkapan);
        listbbkreditperlengkapan.setAdapter(listBukuBesarKreditPerlengkapanBaseAdapter);
        tampilDataBukuBesarKreditPerlengkapan();

    }

    private void tampilDataBukuBesarKreditPerlengkapan() {
        JsonArrayRequest jArr = new JsonArrayRequest(server_bb_kreditperlengkapan, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataBukuBesarKreditPerlengkapan item = new ListDataBukuBesarKreditPerlengkapan();

                        item.setKodebbkreditperlengkapan(obj.getString("kodebbkreditperlengkapan"));
                        item.setDescbbkreditperalengkapan(obj.getString("descbbkreditperalengkapan"));
                        item.setNominalkreditperlengkapan(obj.getString("nominalkreditperlengkapan"));
                        //item.setNominalkreditkas(obj.getString("nsakundebitkas"));

                        // menambah item ke array
                        itemListbbkreditperlengkapan.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listBukuBesarKreditPerlengkapanBaseAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        // menambah request ke request queue
        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mRequestQueue.add(jArr);
    }

    private void tampilDataBukuBesarDebitPerlengkapan() {
        JsonArrayRequest jArr = new JsonArrayRequest(server_bb_debitperlengkapan, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataBukuBesarDebitPerlengkapan item = new ListDataBukuBesarDebitPerlengkapan();

                        item.setKodebbdebitperlengkapan(obj.getString("kodebbdebitperlengkapan"));
                        item.setDescbbdebitperlengkapan(obj.getString("descbbdebitperlengkapan"));
                        item.setNominaldebitperlengkapan(obj.getString("nominaldebitperlengkapan"));
                        //item.setNominalkreditkas(obj.getString("nsakundebitkas"));

                        // menambah item ke array
                        itemListbbdebitperlengkapan.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listBukuBesarDebitPerlengkapanBaseAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        // menambah request ke request queue
        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mRequestQueue.add(jArr);
    }
}