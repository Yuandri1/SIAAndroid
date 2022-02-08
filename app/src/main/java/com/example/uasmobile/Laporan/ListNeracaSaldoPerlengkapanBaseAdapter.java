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

public class ListNeracaSaldoPerlengkapanBaseAdapter extends BaseAdapter {
    Activity activity;
    Context context;
    List<ListDataNeracaSaldoPerlengkapan> items;

    private LayoutInflater inflater;

    public ListNeracaSaldoPerlengkapanBaseAdapter(Activity activity, Context context, List<ListDataNeracaSaldoPerlengkapan> items) {
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
            view = inflater.inflate(R.layout.list_nsperlengkapan, null);

            TextView kode_nsperlengkapan = (TextView) view.findViewById(R.id.kode_nsperlengkapan);
            TextView desc_nsperlengkapan = (TextView) view.findViewById(R.id.desc_nsperlengkapan);
            TextView nominal_debet_nsperlengkapan = (TextView) view.findViewById(R.id.nominal_debet_nsperlengkapan);
            TextView nominal_kredit_nsperlengkapan = (TextView) view.findViewById(R.id.nominal_kredit_nsperlengkapan);

            ListDataNeracaSaldoPerlengkapan data = items.get(i);

            kode_nsperlengkapan.setText(data.getNsnomorakunperlengkapan());
            desc_nsperlengkapan.setText(data.getNsakunkreditperlengkapan());
            nominal_debet_nsperlengkapan.setText(data.getNstotaldebitperlengkapan());
            nominal_kredit_nsperlengkapan.setText(data.getNstotalkreditperlengkapan());
        }

        return view;
    }
}
