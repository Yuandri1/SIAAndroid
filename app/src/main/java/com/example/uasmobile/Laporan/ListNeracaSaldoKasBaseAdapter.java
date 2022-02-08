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

public class ListNeracaSaldoKasBaseAdapter extends BaseAdapter {
    Activity activity;
    Context context;
    List<ListDataNeracaSaldoKas> items;

    private LayoutInflater inflater;

    public ListNeracaSaldoKasBaseAdapter(Activity activity, Context context, List<ListDataNeracaSaldoKas> items) {
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
            view = inflater.inflate(R.layout.list_nskas, null);
        }

        TextView kode_nskas   = (TextView) view.findViewById(R.id.kode_nskas);
        TextView desc_nskas   = (TextView) view.findViewById(R.id.desc_nskas);
        TextView nominal_debet_nskas   = (TextView) view.findViewById(R.id.nominal_debet_nskas);
        TextView nominal_kredit_nskas   = (TextView) view.findViewById(R.id.nominal_kredit_nskas);

        ListDataNeracaSaldoKas data = items.get(i);

        kode_nskas.setText(data.getNsnomorakunkas());
        desc_nskas.setText(data.getNsakundebitkas());
        nominal_debet_nskas.setText(data.getNstotaldebitkas());
        nominal_kredit_nskas.setText(data.getNstotalkreditkas());


        return view;
    }
}
