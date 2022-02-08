package com.example.uasmobile.Laporan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

public class Neraca_Saldo extends AppCompatActivity {

    String server_ns_kas = "http://192.168.1.2/server_laundry/?laundry=nskas";
    ListView listnskas;
    ListNeracaSaldoKasBaseAdapter listNeracaSaldoKasBaseAdapter;
    List<ListDataNeracaSaldoKas> itemListnskas = new ArrayList<ListDataNeracaSaldoKas>();

    String server_ns_hutang = "http://192.168.1.2/server_laundry/?laundry=nshutang";
    ListView listnshutang;
    ListNeracaSaldoHutangBaseAdapter listNeracaSaldoHutangBaseAdapter;
    List<ListDataNeracaSaldoHutang> itemListnshutang = new ArrayList<ListDataNeracaSaldoHutang>();

    String server_ns_modal = "http://192.168.1.2/server_laundry/?laundry=nsmodal";
    ListView listnsmodal;
    ListNeracaSaldoModalBaseAdapter listNeracaSaldoModalBaseAdapter;
    List<ListDataNeracaSaldoModal> itemListnsmodal = new ArrayList<ListDataNeracaSaldoModal>();

    String server_ns_peralatan = "http://192.168.1.2/server_laundry/?laundry=nsperalatan";
    ListView listnsperalatan;
    ListNeracaSaldoPeralatanBaseAdapter listNeracaSaldoPeralatanBaseAdapter;
    List<ListDataNeracaSaldoPeralatan> itemListnsperalatan = new ArrayList<ListDataNeracaSaldoPeralatan>();

    String server_ns_perlengkapan = "http://192.168.1.2/server_laundry/?laundry=nsperlengkapan";
    ListView listnsperlengkapan;
    ListNeracaSaldoPerlengkapanBaseAdapter listNeracaSaldoPerlengkapanBaseAdapter;
    List<ListDataNeracaSaldoPerlengkapan> itemListnsperlengkapan = new ArrayList<ListDataNeracaSaldoPerlengkapan>();

    String server_ns_total = "http://192.168.1.2/server_laundry/?laundry=nstotal";
    ListView listnstotal;
    ListNeracaSaldoTotalBaseAdapter listNeracaSaldoTotalBaseAdapter;
    List<ListDataNeracaSaldoTotal> itemListnstotal = new ArrayList<ListDataNeracaSaldoTotal>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neraca_saldo);

        listnskas = (ListView) findViewById(R.id.list_NSKAS);
        listNeracaSaldoKasBaseAdapter = new ListNeracaSaldoKasBaseAdapter(Neraca_Saldo.this,this, itemListnskas);
        listnskas.setAdapter(listNeracaSaldoKasBaseAdapter);
        tampilDataNeracaSaldoKas();

        listnshutang = (ListView) findViewById(R.id.list_NSHUTANG);
        listNeracaSaldoHutangBaseAdapter = new ListNeracaSaldoHutangBaseAdapter(Neraca_Saldo.this,this, itemListnshutang);
        listnshutang.setAdapter(listNeracaSaldoHutangBaseAdapter);
        tampilDataNeracaSaldoHutang();

        listnsmodal = (ListView) findViewById(R.id.list_NSMODAL);
        listNeracaSaldoModalBaseAdapter = new ListNeracaSaldoModalBaseAdapter(Neraca_Saldo.this,this,itemListnsmodal);
        listnsmodal.setAdapter(listNeracaSaldoModalBaseAdapter);
        tampilDataNeracaSaldoModal();

        listnsperalatan = (ListView) findViewById(R.id.list_NSPERALATAN);
        listNeracaSaldoPeralatanBaseAdapter = new ListNeracaSaldoPeralatanBaseAdapter(Neraca_Saldo.this, this,  itemListnsperalatan);
        listnsperalatan.setAdapter(listNeracaSaldoPeralatanBaseAdapter);
        tampilDataNeracaSaldoPeralatan();

        listnsperlengkapan = (ListView) findViewById(R.id.list_NSPERLENGKAPAN);
        listNeracaSaldoPerlengkapanBaseAdapter = new ListNeracaSaldoPerlengkapanBaseAdapter(Neraca_Saldo.this, this, itemListnsperlengkapan);
        listnsperlengkapan.setAdapter(listNeracaSaldoPerlengkapanBaseAdapter);
        tampilDataNeracaSaldoPerlengkapan();

        listnstotal = (ListView) findViewById(R.id.list_NSTOTAL);
        listNeracaSaldoTotalBaseAdapter = new ListNeracaSaldoTotalBaseAdapter(Neraca_Saldo.this,this, itemListnstotal);
        listnstotal.setAdapter(listNeracaSaldoTotalBaseAdapter);
        tampilDataNeracaSaldoTotal();
    }

    private void tampilDataNeracaSaldoKas() {
        JsonArrayRequest jArr = new JsonArrayRequest(server_ns_kas, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataNeracaSaldoKas item = new ListDataNeracaSaldoKas();

                        item.setNstotaldebitkas(obj.getString("nstotaldebitkas"));
                        item.setNstotalkreditkas(obj.getString("nstotalkreditkas"));
                        item.setNsnomorakunkas(obj.getString("nsnomorakunkas"));
                        item.setNsakundebitkas(obj.getString("nsakundebitkas"));

                        // menambah item ke array
                        itemListnskas.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listNeracaSaldoKasBaseAdapter.notifyDataSetChanged();
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

    private void tampilDataNeracaSaldoHutang() {
        JsonArrayRequest jArr = new JsonArrayRequest(server_ns_hutang, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataNeracaSaldoHutang item = new ListDataNeracaSaldoHutang();

                        item.setNstotaldebithutang(obj.getString("nstotaldebithutang"));
                        item.setNstotalkredithutang(obj.getString("nstotalkredithutang"));
                        item.setNsnomorakunhutang(obj.getString("nsnomorakunhutang"));
                        item.setNsakundebithutang(obj.getString("nsakundebithutang"));

                        // menambah item ke array
                        itemListnshutang.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listNeracaSaldoHutangBaseAdapter.notifyDataSetChanged();
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

    private void tampilDataNeracaSaldoModal() {
        JsonArrayRequest jArr = new JsonArrayRequest(server_ns_modal, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataNeracaSaldoModal item = new ListDataNeracaSaldoModal();

                        item.setNstotaldebitmodal(obj.getString("nstotaldebitmodal"));
                        item.setNstotalkreditmodal(obj.getString("nstotalkreditmodal"));
                        item.setNsnomorakunmodal(obj.getString("nsnomorakunmodal"));
                        item.setNsakunkreditmodal(obj.getString("nsakunkreditmodal"));

                        // menambah item ke array
                        itemListnsmodal.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listNeracaSaldoModalBaseAdapter.notifyDataSetChanged();
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

    private void tampilDataNeracaSaldoPeralatan() {
        JsonArrayRequest jArr = new JsonArrayRequest(server_ns_peralatan, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataNeracaSaldoPeralatan item = new ListDataNeracaSaldoPeralatan();

                        item.setNstotaldebitperalatan(obj.getString("nstotaldebitperalatan"));
                        item.setNstotalkreditperalatan(obj.getString("nstotalkreditperalatan"));
                        item.setNsnomorakunperalatan(obj.getString("nsnomorakunperalatan"));
                        item.setNsakunkreditperalatan(obj.getString("nsakunkreditperalatan"));

                        // menambah item ke array
                        itemListnsperalatan.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listNeracaSaldoPeralatanBaseAdapter.notifyDataSetChanged();
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

    private void tampilDataNeracaSaldoPerlengkapan() {
        JsonArrayRequest jArr = new JsonArrayRequest(server_ns_perlengkapan, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataNeracaSaldoPerlengkapan item = new ListDataNeracaSaldoPerlengkapan();

                        item.setNstotaldebitperlengkapan(obj.getString("nstotaldebitperlengkapan"));
                        item.setNstotalkreditperlengkapan(obj.getString("nstotalkreditperlengkapan"));
                        item.setNsnomorakunperlengkapan(obj.getString("nsnomorakunperlengkapan"));
                        item.setNsakunkreditperlengkapan(obj.getString("nsakunkreditperlengkapan"));

                        // menambah item ke array
                        itemListnsperlengkapan.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listNeracaSaldoPerlengkapanBaseAdapter.notifyDataSetChanged();
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

    private void tampilDataNeracaSaldoTotal() {
        JsonArrayRequest jArr = new JsonArrayRequest(server_ns_total, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        ListDataNeracaSaldoTotal item = new ListDataNeracaSaldoTotal();

                        item.setNstotaldebittotal(obj.getString("nstotaldebittotal"));
                        item.setNstotalkredittotal(obj.getString("nstotalkredittotal"));

                        // menambah item ke array
                        itemListnstotal.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                listNeracaSaldoTotalBaseAdapter.notifyDataSetChanged();
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