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

public class ListBukuBesarDebitPerlengkapanBaseAdapter extends BaseAdapter {
    Activity activity;
    Context context;
    List<ListDataBukuBesarDebitPerlengkapan> items;
    private LayoutInflater inflater;

    public ListBukuBesarDebitPerlengkapanBaseAdapter(Activity activity, Context context, List<ListDataBukuBesarDebitPerlengkapan> items) {
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
            view = inflater.inflate(R.layout.list_bbperlengkapan, null);
        }

        TextView kode_bbdebitperlengkapan   = (TextView) view.findViewById(R.id.kode_bbperlengkapan);
        TextView desc_bbdebitperlengkapan   = (TextView) view.findViewById(R.id.desc_bbperlengkapan);
        TextView nominal_debet_bbperlengkapan   = (TextView) view.findViewById(R.id.nominal_debet_bbperlengkapan);
        //TextView nominal_kredit_bbhutang   = (TextView) view.findViewById(R.id.nominal_kredit_bbhutang);

        ListDataBukuBesarDebitPerlengkapan data = items.get(i);

        kode_bbdebitperlengkapan.setText(data.getKodebbdebitperlengkapan());
        desc_bbdebitperlengkapan.setText(data.getDescbbdebitperlengkapan());
        nominal_debet_bbperlengkapan.setText(data.getNominaldebitperlengkapan());
        //nominal_kredit_bbhutang.setText(data.getNominalkreditkas());
        return view;
    }
}
