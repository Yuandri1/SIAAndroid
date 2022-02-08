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

public class BB_KAS extends AppCompatActivity {
    String server_bb_debitkas = "http://192.168.1.2/server_laundry/?laundry=bbdebitkas";
    ListView listbbdebitkas;
    ListBukuBesarDebitKasBaseAdapter listBukuBesarDebitKasBaseAdapter;
    List<ListDataBukuBesarDebitKas> itemListbbdebitkas = new ArrayList<ListDataBukuBesarDebitKas>();

    String server_bb_kreditkas = "http://192.168.1.2/server_laundry/?laundry=bbkreditkas";
    ListView listbbkreditkas;
    ListBukuBesarKreditKasBaseAdapter listBukuBesarKreditKasBaseAdapter;
    List<ListDataBukuBesarKreditKas> itemListbbkreditkas = new ArrayList<ListDataBukuBesarKreditKas>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bb_kas);

        listbbdebitkas = (ListView) findViewById(R.id.list_BBDEBITKAS);
        listBukuBesarDebitKasBaseAdapter = new ListBukuBesarDebitKasBaseAdapter(BB_KAS.this,this, itemListbbdebitkas);
        listbbdebitkas.setAdapter(listBukuBesarDebitKasBaseAdapter);
        tampilDataBukuBesarDebitKas();

        listbbkreditkas = (ListView) findViewById(R.id.list_BBKREDITKAS);
        listBukuBesarKreditKasBaseAdapter = new ListBukuBesarKreditKasBaseAdapter(BB_KAS.this,this, itemListbbkreditkas);
        listbbkreditkas.setAdapter(listBukuBesarKreditKasBaseAdapter);
        tampilDataBukuBesarKreditKas();


    }


    private void tampilDataBukuBesarKreditKas() {
        JsonArrayRequest jArr = new JsonArrayRequest(server_bb_kreditkas, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataBukuBesarKreditKas item = new ListDataBukuBesarKreditKas();

                        item.setKodebbkreditkas(obj.getString("kodebbdebitkas"));
                        item.setDescbbkreditkas(obj.getString("descbbdebitkas"));
                        item.setNominalkreditkas(obj.getString("nominaldebitkas"));
                        //item.setNominalkreditkas(obj.getString("nsakundebitkas"));

                        // menambah item ke array
                        itemListbbkreditkas.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listBukuBesarKreditKasBaseAdapter.notifyDataSetChanged();
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


    private void tampilDataBukuBesarDebitKas() {
        JsonArrayRequest jArr = new JsonArrayRequest(server_bb_debitkas, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataBukuBesarDebitKas item = new ListDataBukuBesarDebitKas();

                        item.setKodebbdebitkas(obj.getString("kodebbdebitkas"));
                        item.setDescbbdebitkas(obj.getString("descbbdebitkas"));
                        item.setNominaldebitkas(obj.getString("nominaldebitkas"));
                        //item.setNominalkreditkas(obj.getString("nsakundebitkas"));

                        // menambah item ke array
                        itemListbbdebitkas.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listBukuBesarDebitKasBaseAdapter.notifyDataSetChanged();
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