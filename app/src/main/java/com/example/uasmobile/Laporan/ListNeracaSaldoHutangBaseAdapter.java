package com.example.uasmobile.Laporan;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.uasmobile.R;

import java.util.List;

public class ListNeracaSaldoHutangBaseAdapter extends BaseAdapter {
    Activity activity;
    Context context;
    List<ListDataNeracaSaldoHutang> items;

    private LayoutInflater inflater;

    public ListNeracaSaldoHutangBaseAdapter(Activity activity, Context context, List<ListDataNeracaSaldoHutang> items) {
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
            view = inflater.inflate(R.layout.list_nshutang, null);
        }

        TextView kode_nshutang   = (TextView) view.findViewById(R.id.kode_nshutang);
        TextView desc_nshutang   = (TextView) view.findViewById(R.id.desc_nshutang);
        TextView nominal_debet_nshutang   = (TextView) view.findViewById(R.id.nominal_debet_nshutang);
        TextView nominal_kredit_nshutang   = (TextView) view.findViewById(R.id.nominal_kredit_nshutang);

        ListDataNeracaSaldoHutang data = items.get(i);

        kode_nshutang.setText(data.getNsnomorakunhutang());
        desc_nshutang.setText(data.getNsakundebithutang());
        nominal_debet_nshutang.setText(data.getNstotaldebithutang());
        nominal_kredit_nshutang.setText(data.getNstotalkredithutang());


        return view;
    }
}
