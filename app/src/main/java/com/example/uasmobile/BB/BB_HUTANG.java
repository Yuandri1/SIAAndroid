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

public class BB_HUTANG extends AppCompatActivity {
    String server_bb_debithutang = "http://192.168.1.2/server_laundry/?laundry=bbdebithutang";
    ListView listbbdebithutang;
    ListBukuBesarDebitHutangBaseAdapter listBukuBesarDebitHutangBaseAdapter;
    List<ListDataBukuBesarDebitHutang> itemListbbdebithutang = new ArrayList<ListDataBukuBesarDebitHutang>();

    String server_bb_kredithutang = "http://192.168.1.2/server_laundry/?laundry=bbkredithutang";
    ListView listbbkredithutang;
    ListBukuBesarKreditHutangBaseAdapter listBukuBesarKreditHutangBaseAdapter;
    List<ListDataBukuBesarKreditHutang> itemListbbkredithutang = new ArrayList<ListDataBukuBesarKreditHutang>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bb_hutang);

        listbbdebithutang = (ListView) findViewById(R.id.list_BBDEBITHUTANG);
        listBukuBesarDebitHutangBaseAdapter = new ListBukuBesarDebitHutangBaseAdapter(BB_HUTANG.this,this, itemListbbdebithutang);
        listbbdebithutang.setAdapter(listBukuBesarDebitHutangBaseAdapter);
        tampilDataBukuBesarDebitHutang();

        listbbkredithutang = (ListView) findViewById(R.id.list_BBKREDITHUTANG);
        listBukuBesarKreditHutangBaseAdapter = new ListBukuBesarKreditHutangBaseAdapter(BB_HUTANG.this,this, itemListbbkredithutang);
        listbbkredithutang.setAdapter(listBukuBesarKreditHutangBaseAdapter);
        tampilDataBukuBesarKreditHutang();
    }

    private void tampilDataBukuBesarKreditHutang() {
        JsonArrayRequest jArr = new JsonArrayRequest(server_bb_kredithutang, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataBukuBesarKreditHutang item = new ListDataBukuBesarKreditHutang();

                        item.setKodebbkredithutang(obj.getString("kodebbdebitkas"));
                        item.setDescbbkredithutang(obj.getString("descbbdebitkas"));
                        item.setNominakredithutang(obj.getString("nominaldebitkas"));
                        //item.setNominalkreditkas(obj.getString("nsakundebitkas"));

                        // menambah item ke array
                        itemListbbkredithutang.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listBukuBesarKreditHutangBaseAdapter.notifyDataSetChanged();
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

    private void tampilDataBukuBesarDebitHutang() {
        JsonArrayRequest jArr = new JsonArrayRequest(server_bb_debithutang, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataBukuBesarDebitHutang item = new ListDataBukuBesarDebitHutang();

                        item.setKodebbdebithutang(obj.getString("kodebbdebithutang"));
                        item.setDescbbdebithutang(obj.getString("descbbdebithutang"));
                        item.setNominadebithutang(obj.getString("nominadebithutang"));
                        //item.setNominalkreditkas(obj.getString("nsakundebitkas"));

                        // menambah item ke array
                        itemListbbdebithutang.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listBukuBesarDebitHutangBaseAdapter.notifyDataSetChanged();
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