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

public class ListBukuBesarDebitModalBaseAdapter extends BaseAdapter {
    Activity activity;
    Context context;
    List<ListDataBukuBesarDebitModal> items;
    private LayoutInflater inflater;

    public ListBukuBesarDebitModalBaseAdapter(Activity activity, Context context, List<ListDataBukuBesarDebitModal> items) {
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
            view = inflater.inflate(R.layout.list_bbmodal, null);
        }

        TextView kode_bbdebitmodal   = (TextView) view.findViewById(R.id.kode_bbmodal);
        TextView desc_bbdebitmodal  = (TextView) view.findViewById(R.id.desc_bbmodal);
        TextView nominal_debit_bbmodal   = (TextView) view.findViewById(R.id.nominal_debet_bbmodal);
        //TextView nominal_kredit_bbhutang   = (TextView) view.findViewById(R.id.nominal_kredit_bbmodal);

        ListDataBukuBesarDebitModal data = items.get(i);

        kode_bbdebitmodal.setText(data.getKodebbdebitmodal());
        desc_bbdebitmodal.setText(data.getDescbbdebitmodal());
        nominal_debit_bbmodal.setText(data.getNominaldebitmodal());
        //nominal_kredit_bbhutang.setText(data.getNominalkreditkas());

        return view;
    }
}
