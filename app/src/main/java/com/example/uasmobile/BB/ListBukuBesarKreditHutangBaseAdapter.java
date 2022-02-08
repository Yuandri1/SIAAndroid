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

public class ListBukuBesarKreditHutangBaseAdapter extends BaseAdapter {

    Activity activity;
    Context context;
    List<ListDataBukuBesarKreditHutang> items;
    private LayoutInflater inflater;

    public ListBukuBesarKreditHutangBaseAdapter(Activity activity, Context context, List<ListDataBukuBesarKreditHutang> items) {
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


        TextView kode_bbkredithutang   = (TextView) view.findViewById(R.id.kode_bbhutang);
        TextView desc_bbkredithutang   = (TextView) view.findViewById(R.id.desc_bbhutang);
        TextView nominal_kredit_bbhutang   = (TextView) view.findViewById(R.id.nominal_kredit_bbhutang);


        ListDataBukuBesarKreditHutang data = items.get(i);

        kode_bbkredithutang.setText(data.getKodebbkredithutang());
        desc_bbkredithutang.setText(data.getDescbbkredithutang());
        nominal_kredit_bbhutang.setText(data.getNominakredithutang());
        //nominal_kredit_bbhutang.setText(data.getNominalkreditkas());

        return view;
    }
}
