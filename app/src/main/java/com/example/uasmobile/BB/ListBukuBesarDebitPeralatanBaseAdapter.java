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

public class ListBukuBesarDebitPeralatanBaseAdapter extends BaseAdapter {

    Activity activity;
    Context context;
    List<ListDataBukuBesarDebitPeralatan> items;
    private LayoutInflater inflater;

    public ListBukuBesarDebitPeralatanBaseAdapter(Activity activity, Context context, List<ListDataBukuBesarDebitPeralatan> items) {
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
            view = inflater.inflate(R.layout.list_bbperalatan, null);
        }

        TextView kode_bbdebitperalatan   = (TextView) view.findViewById(R.id.kode_bbperalatan);
        TextView desc_bbdebitperalatan   = (TextView) view.findViewById(R.id.desc_bbperalatan);
        TextView nominal_debet_bbperalatan   = (TextView) view.findViewById(R.id.nominal_debet_bbperalatan);
        //TextView nominal_kredit_bbhutang   = (TextView) view.findViewById(R.id.nominal_kredit_bbhutang);

        ListDataBukuBesarDebitPeralatan data = items.get(i);

        kode_bbdebitperalatan.setText(data.getKodebbdebitperalatan());
        desc_bbdebitperalatan.setText(data.getDescbbdebitperalatan());
        nominal_debet_bbperalatan.setText(data.getNominaldebitperalatan());
        //nominal_kredit_bbhutang.setText(data.getNominalkreditkas());
        return view;
    }
}
