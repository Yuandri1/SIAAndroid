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

public class BB_MODAL extends AppCompatActivity {
    String server_bb_debitmodal = "http://192.168.1.2/server_laundry/?laundry=bbdebitmodal";
    ListView listbbdebitmodal;
    ListBukuBesarDebitModalBaseAdapter listBukuBesarDebitModalBaseAdapter;
    List<ListDataBukuBesarDebitModal> itemListbbdebitmodal = new ArrayList<ListDataBukuBesarDebitModal>();

    String server_bb_kreditmodal = "http://192.168.1.2/server_laundry/?laundry=bbkreditmodal";
    ListView listbbkreditmodal;
    ListBukuBesarKreditModalBaseAdapter listBukuBesarKreditModalBaseAdapter;
    List<ListDataBukuBesarKreditModal> itemListbbkreditmodal = new ArrayList<ListDataBukuBesarKreditModal>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bb_modal);

        listbbdebitmodal = (ListView) findViewById(R.id.list_BBDEBITMODAL);
        listBukuBesarDebitModalBaseAdapter = new ListBukuBesarDebitModalBaseAdapter(BB_MODAL.this,this, itemListbbdebitmodal);
        listbbdebitmodal.setAdapter(listBukuBesarDebitModalBaseAdapter);
        tampilDataBukuBesarDebitModal();

        listbbkreditmodal = (ListView) findViewById(R.id.list_BBKREDITMODAL);
        listBukuBesarKreditModalBaseAdapter = new ListBukuBesarKreditModalBaseAdapter(BB_MODAL.this,this, itemListbbkreditmodal);
        listbbkreditmodal.setAdapter(listBukuBesarKreditModalBaseAdapter);
        tampilDataBukuBesarKreditModal();
    }

    private void tampilDataBukuBesarKreditModal() {
        JsonArrayRequest jArr = new JsonArrayRequest(server_bb_kreditmodal, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataBukuBesarKreditModal item = new ListDataBukuBesarKreditModal();

                        item.setKodebbkreditmodal(obj.getString("kodebbkreditmodal"));
                        item.setDescbbkreditmodal(obj.getString("descbbkreditmodal"));
                        item.setNominalkreditmodal(obj.getString("nominalkreditmodal"));
                        //item.setNominalkreditkas(obj.getString("nsakundebitkas"));

                        // menambah item ke array
                        itemListbbkreditmodal.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listBukuBesarKreditModalBaseAdapter.notifyDataSetChanged();
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

    private void tampilDataBukuBesarDebitModal() {
        JsonArrayRequest jArr = new JsonArrayRequest(server_bb_debitmodal, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataBukuBesarDebitModal item = new ListDataBukuBesarDebitModal();

                        item.setKodebbdebitmodal(obj.getString("kodebbdebitmodal"));
                        item.setDescbbdebitmodal(obj.getString("descbbdebitmodal"));
                        item.setNominaldebitmodal(obj.getString("nominaldebitmodal"));
                        //item.setNominalkreditkas(obj.getString("nsakundebitkas"));

                        // menambah item ke array
                        itemListbbdebitmodal.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listBukuBesarDebitModalBaseAdapter.notifyDataSetChanged();
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