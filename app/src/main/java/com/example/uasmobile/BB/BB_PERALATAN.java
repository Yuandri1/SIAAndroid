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

public class BB_PERALATAN extends AppCompatActivity {

    String server_bb_debitperalatan = "http://192.168.1.2/server_laundry/?laundry=bbdebitperalatan";
    ListView listbbdebitperalatan;
    ListBukuBesarDebitPeralatanBaseAdapter listBukuBesarDebitPeralatanBaseAdapter;
    List<ListDataBukuBesarDebitPeralatan> itemListbbdebitperalatan = new ArrayList<ListDataBukuBesarDebitPeralatan>();

    String server_bb_kreditperalatan = "http://192.168.1.2/server_laundry/?laundry=bbkreditperalatan";
    ListView listbbkreditperalatan;
    ListBukuBesarKreditPeralatanBaseAdapter listBukuBesarKreditPeralatanBaseAdapter;
    List<ListDataBukuBesarKreditPeralatan> itemListbbkreditperalatan = new ArrayList<ListDataBukuBesarKreditPeralatan>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bb_peralatan);

        listbbdebitperalatan = (ListView) findViewById(R.id.list_BBDEBITPERALATAN);
        listBukuBesarDebitPeralatanBaseAdapter = new ListBukuBesarDebitPeralatanBaseAdapter(BB_PERALATAN.this,this, itemListbbdebitperalatan);
        listbbdebitperalatan.setAdapter(listBukuBesarDebitPeralatanBaseAdapter);
        tampilDataBukuBesarDebitPeralatan();

        listbbkreditperalatan = (ListView) findViewById(R.id.list_BBKREDITPERALATAN);
        listBukuBesarKreditPeralatanBaseAdapter = new ListBukuBesarKreditPeralatanBaseAdapter(BB_PERALATAN.this,this, itemListbbkreditperalatan);
        listbbkreditperalatan.setAdapter(listBukuBesarKreditPeralatanBaseAdapter);
        tampilDataBukuBesarKreditPeralatan();
    }

    private void tampilDataBukuBesarDebitPeralatan() {
        JsonArrayRequest jArr = new JsonArrayRequest(server_bb_debitperalatan, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataBukuBesarDebitPeralatan item = new ListDataBukuBesarDebitPeralatan();

                        item.setKodebbdebitperalatan(obj.getString("kodebbdebitperalatan"));
                        item.setDescbbdebitperalatan(obj.getString("descbbdebitperalatan"));
                        item.setNominaldebitperalatan(obj.getString("nominaldebitperalatan"));
                        //item.setNominalkreditkas(obj.getString("nsakundebitkas"));

                        // menambah item ke array
                        itemListbbdebitperalatan.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listBukuBesarDebitPeralatanBaseAdapter.notifyDataSetChanged();
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

    private void tampilDataBukuBesarKreditPeralatan() {
        JsonArrayRequest jArr = new JsonArrayRequest(server_bb_kreditperalatan, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataBukuBesarKreditPeralatan item = new ListDataBukuBesarKreditPeralatan();

                        item.setKodebbkreditperalatan(obj.getString("kodebbkreditperalatan"));
                        item.setDescbbkreditperalatan(obj.getString("descbbkreditperalatan"));
                        item.setNominalkreditperalatan(obj.getString("nominalkreditperalatan"));
                        //item.setNominalkreditkas(obj.getString("nsakundebitkas"));

                        // menambah item ke array
                        itemListbbkreditperalatan.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listBukuBesarKreditPeralatanBaseAdapter.notifyDataSetChanged();
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