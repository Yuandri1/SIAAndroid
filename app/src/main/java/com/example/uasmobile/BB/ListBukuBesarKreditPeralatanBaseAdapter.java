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

public class ListBukuBesarKreditPeralatanBaseAdapter extends BaseAdapter {

    Activity activity;
    Context context;
    List<ListDataBukuBesarKreditPeralatan> items;
    private LayoutInflater inflater;

    public ListBukuBesarKreditPeralatanBaseAdapter(Activity activity, Context context, List<ListDataBukuBesarKreditPeralatan> items) {
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

        TextView kode_bbkreditperalatan   = (TextView) view.findViewById(R.id.kode_bbperalatan);
        TextView desc_bbkreditperalatan   = (TextView) view.findViewById(R.id.desc_bbperalatan);
        //TextView nominal_debet_bbperalatan   = (TextView) view.findViewById(R.id.nominal_debet_bbperalatan);
        TextView nominal_kredit_bbperalatan   = (TextView) view.findViewById(R.id.nominal_kredit_bbperalatan);

        ListDataBukuBesarKreditPeralatan data = items.get(i);

        kode_bbkreditperalatan.setText(data.getKodebbkreditperalatan());
        desc_bbkreditperalatan.setText(data.getDescbbkreditperalatan());
        nominal_kredit_bbperalatan.setText(data.getNominalkreditperalatan());
        //nominal_kredit_bbhutang.setText(data.getNominalkreditkas());

        return view;
    }
}
