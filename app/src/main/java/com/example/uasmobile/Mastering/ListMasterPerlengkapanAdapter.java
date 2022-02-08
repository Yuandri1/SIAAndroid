package com.example.uasmobile.Mastering;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.uasmobile.R;

import java.util.List;

public class ListMasterPerlengkapanAdapter extends BaseAdapter {

    Activity activity;
    Context context;
    List<ListDataMasterPerlengkapan> items;

    public ListMasterPerlengkapanAdapter(Activity activity, Context context, List<ListDataMasterPerlengkapan> items) {
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
            view = inflater.inflate(R.layout.list_master_perlengkapan, null);
        }


        TextView mastering_kode_perlengkapan   = (TextView) view.findViewById(R.id.mastering_kode_perlengkapan);
        TextView mastering_nama_perlengkapan = (TextView) view.findViewById(R.id.mastering_nama_perlengkapan);
        TextView mastering_desc_perlengkapan = (TextView) view.findViewById(R.id.mastering_desc_perlengkapan);

        ListDataMasterPerlengkapan data = items.get(i);


        mastering_kode_perlengkapan.setText(data.getKodePerlengkapan());
        mastering_nama_perlengkapan.setText(data.getNamaPerlengkapan());
        mastering_desc_perlengkapan.setText(data.getDescPerlengkapan());

        return view;
    }
}
