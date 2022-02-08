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

public class ListNeracaSaldoModalBaseAdapter extends BaseAdapter {
    Activity activity;
    Context context;
    List<ListDataNeracaSaldoModal> items;

    public ListNeracaSaldoModalBaseAdapter(Activity activity, Context context, List<ListDataNeracaSaldoModal> items) {
        this.activity = activity;
        this.context = context;
        this.items = items;
    }

    private LayoutInflater inflater;

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
            view = inflater.inflate(R.layout.list_nsmodal, null);

            TextView kode_nsmodal   = (TextView) view.findViewById(R.id.kode_nsmodal);
            TextView desc_nsmodal   = (TextView) view.findViewById(R.id.desc_nsmodal);
            TextView nominal_debet_nsmodal   = (TextView) view.findViewById(R.id.nominal_debet_nsmodal);
            TextView nominal_kredit_nsmodal   = (TextView) view.findViewById(R.id.nominal_kredit_nsmodal);

            ListDataNeracaSaldoModal data = items.get(i);

            kode_nsmodal.setText(data.getNsnomorakunmodal());
            desc_nsmodal.setText(data.getNsakunkreditmodal());
            nominal_debet_nsmodal.setText(data.getNstotaldebitmodal());
            nominal_kredit_nsmodal.setText(data.getNstotalkreditmodal());
        }
        return view;
    }
}
