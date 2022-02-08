package com.example.uasmobile.Laporan;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.uasmobile.ListDataPengadaan;
import com.example.uasmobile.R;

import java.util.List;

public class ListJurnalUmumAdapter extends BaseAdapter {
    Activity activity;
    Context context;
    List<ListDataJurnalUmum> itemsJU;

    private LayoutInflater inflater;

    public ListJurnalUmumAdapter(Activity activity, Context context, List<ListDataJurnalUmum> items) {
        this.activity = activity;
        this.context = context;
        this.itemsJU = items;
    }

    @Override
    public int getCount() {
        return itemsJU.size();
    }

    @Override
    public Object getItem(int i) {
        return itemsJU.get(i);
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
            view = inflater.inflate(R.layout.list_jurnal_umum, null);
        }


        TextView txt_kode_peng   = (TextView) view.findViewById(R.id.kode_peng);
        TextView txt_harga_peng   = (TextView) view.findViewById(R.id.tot_harga);
        TextView txt_desc_peng   = (TextView) view.findViewById(R.id.desc_peng);
        TextView txt_nam_debet_peng   = (TextView) view.findViewById(R.id.nam_debet_peng);
        TextView txt_nom_debet_peng   = (TextView) view.findViewById(R.id.nom_debet_peng);
        TextView txt_nam_kredit_peng   = (TextView) view.findViewById(R.id.nam_kredit_peng);
        TextView txt_nom_kredit_peng   = (TextView) view.findViewById(R.id.nom_kredit_peng);


        ListDataJurnalUmum data = itemsJU.get(i);


        txt_kode_peng.setText(data.getKode_JU());
        txt_harga_peng.setText(data.getHarga_JU());
        txt_desc_peng.setText(data.getDeskripsi_JU());
        txt_nam_debet_peng.setText(data.getAkunDebet_JU());
        txt_nom_debet_peng.setText(data.getDebet_JU());
        txt_nam_kredit_peng.setText(data.getAkunKredit_JU());
        txt_nom_kredit_peng.setText(data.getKredit_JU());

        return view;
    }
}
