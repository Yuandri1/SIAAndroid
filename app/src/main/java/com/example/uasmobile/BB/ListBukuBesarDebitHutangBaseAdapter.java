package com.example.uasmobile.BB;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.uasmobile.R;

import java.util.List;

public class ListBukuBesarDebitHutangBaseAdapter extends BaseAdapter {

    Activity activity;
    Context context;
    List<ListDataBukuBesarDebitHutang> items;
    private LayoutInflater inflater;

    public ListBukuBesarDebitHutangBaseAdapter(Activity activity, Context context, List<ListDataBukuBesarDebitHutang> items) {
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
            view = inflater.inflate(R.layout.list_bbhutang, null);
        }

        TextView kode_bbdebithutang   = (TextView) view.findViewById(R.id.kode_bbhutang);
        TextView desc_bbdebithutang   = (TextView) view.findViewById(R.id.desc_bbhutang);
        TextView nominal_debit_bbhutang   = (TextView) view.findViewById(R.id.nominal_debet_bbhutang);
        //TextView nominal_kredit_bbhutang   = (TextView) view.findViewById(R.id.nominal_kredit_bbhutang);

        ListDataBukuBesarDebitHutang data = items.get(i);

        kode_bbdebithutang.setText(data.getKodebbdebithutang());
        desc_bbdebithutang.setText(data.getDescbbdebithutang());
        nominal_debit_bbhutang.setText(data.getNominadebithutang());
        //nominal_kredit_bbhutang.setText(data.getNominalkreditkas());

        return view;
    }
}
