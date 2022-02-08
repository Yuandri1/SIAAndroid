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

public class ListNeracaSaldoPeralatanBaseAdapter extends BaseAdapter {
    Activity activity;
    Context context;
    List<ListDataNeracaSaldoPeralatan> items;

    private LayoutInflater inflater;

    public ListNeracaSaldoPeralatanBaseAdapter(Activity activity, Context context, List<ListDataNeracaSaldoPeralatan> items) {
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
            view = inflater.inflate(R.layout.list_nsperalatan, null);

            TextView kode_nsperalatan = (TextView) view.findViewById(R.id.kode_nsperalatan);
            TextView desc_nsperalatan = (TextView) view.findViewById(R.id.desc_nsperalatan);
            TextView nominal_debet_nsperalatan = (TextView) view.findViewById(R.id.nominal_debet_nsperalatan);
            TextView nominal_kredit_nsperalatan = (TextView) view.findViewById(R.id.nominal_kredit_nsperalatan);

            ListDataNeracaSaldoPeralatan data = items.get(i);

            kode_nsperalatan.setText(data.getNsnomorakunperalatan());
            desc_nsperalatan.setText(data.getNsakunkreditperalatan());
            nominal_debet_nsperalatan.setText(data.getNstotaldebitperalatan());
            nominal_kredit_nsperalatan.setText(data.getNstotalkreditperalatan());
        }

        return view;
    }
}
