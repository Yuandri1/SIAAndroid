package com.example.uasmobile;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListPengadaanAdapter extends BaseAdapter {
    Activity activity;
    Context context;
    List<ListDataPengadaan> items;

    private LayoutInflater inflater;

    public ListPengadaanAdapter(Activity activity, Context context, List<ListDataPengadaan> items) {
        this.activity = activity;
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            view = inflater.inflate(R.layout.list_pengadaan, null);
        }


        TextView txt_kode_pengadaan   = (TextView) view.findViewById(R.id.txt_kode_pengadaan);
        TextView txt_tipe_pengadaan   = (TextView) view.findViewById(R.id.spn_tipe_pengadaan);
        TextView txt_nama_pengadaan   = (TextView) view.findViewById(R.id.txt_nama_pengadaan);
        TextView txt_quantity_pengadaan   = (TextView) view.findViewById(R.id.txt_quantity_pengadaan);
        TextView txt_harga_pengadaan   = (TextView) view.findViewById(R.id.txt_harga_pengadaan);
        TextView txt_desc_pengadaan   = (TextView) view.findViewById(R.id.txt_desc_pengadaan);
        TextView txt_nam_debet_pengadaan   = (TextView) view.findViewById(R.id.txt_nam_debet_pengadaan);
        TextView txt_nom_debet_pengadaan   = (TextView) view.findViewById(R.id.txt_nom_debet_pengadaan);
        TextView txt_nam_kredit_pengadaan   = (TextView) view.findViewById(R.id.txt_nam_kredit_pengadaan);
        TextView txt_nom_kredit_pengadaan   = (TextView) view.findViewById(R.id.txt_nom_kredit_pengadaan);


        ListDataPengadaan data = items.get(i);


        txt_kode_pengadaan.setText(data.getKode());
        txt_tipe_pengadaan.setText(data.getTipePengada());
        txt_nama_pengadaan.setText(data.getNama());
        txt_quantity_pengadaan.setText(data.getQuantity());
        txt_harga_pengadaan.setText(data.getHarga());
        txt_desc_pengadaan.setText(data.getDeskripsi());
        txt_nam_debet_pengadaan.setText(data.getAkunDebet());
        txt_nom_debet_pengadaan.setText(data.getDebet());
        txt_nam_kredit_pengadaan.setText(data.getAkunKredit());
        txt_nom_kredit_pengadaan.setText(data.getKredit());


        return view;
    }
}
