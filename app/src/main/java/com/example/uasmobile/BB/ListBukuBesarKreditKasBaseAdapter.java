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

public class ListBukuBesarKreditKasBaseAdapter extends BaseAdapter {
    Activity activity;
    Context context;
    List<ListDataBukuBesarKreditKas> items;
    private LayoutInflater inflater;

    public ListBukuBesarKreditKasBaseAdapter(Activity activity, Context context, List<ListDataBukuBesarKreditKas> items) {
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
            view = inflater.inflate(R.layout.list_bbkas, null);
        }

        TextView kode_bbdebitkas   = (TextView) view.findViewById(R.id.kode_bbkas);
        TextView desc_bbdebitkas   = (TextView) view.findViewById(R.id.desc_bbkas);
        //TextView nominal_debet_bbkas   = (TextView) view.findViewById(R.id.nominal_debet_bbkas);
        TextView nominal_kredit_bbkas   = (TextView) view.findViewById(R.id.nominal_kredit_bbkas);

        ListDataBukuBesarKreditKas data = items.get(i);

        kode_bbdebitkas.setText(data.getKodebbkreditkas());
        desc_bbdebitkas.setText(data.getDescbbkreditkas());
        nominal_kredit_bbkas.setText(data.getNominalkreditkas());
        //nominal_kredit_bbkas.setText(data.getNominalkreditkas());





        return view;
    }
}
