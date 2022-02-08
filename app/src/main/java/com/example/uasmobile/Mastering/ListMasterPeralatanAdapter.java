package com.example.uasmobile.Mastering;

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

public class ListMasterPeralatanAdapter extends BaseAdapter {
    Activity activity;
    Context context;
    List<ListDataMasterPeralatan> items;

    private LayoutInflater inflater;

    public ListMasterPeralatanAdapter(Activity activity, Context context, List<ListDataMasterPeralatan> items) {
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
            view = inflater.inflate(R.layout.list_master_peralatan, null);
        }


        TextView mastering_kode_peralatan   = (TextView) view.findViewById(R.id.mastering_kode_peralatan);
        TextView mastering_nama_peralatan   = (TextView) view.findViewById(R.id.mastering_nama_peralatan);
        TextView mastering_desc_peralatan   = (TextView) view.findViewById(R.id.mastering_desc_peralatan);
        TextView mastering_lokasi_peralatan   = (TextView) view.findViewById(R.id.mastering_lokasi_peralatan);
        TextView mastering_grup_peralatan   = (TextView) view.findViewById(R.id.mastering_grup_peralatan);



        ListDataMasterPeralatan data = items.get(i);


        mastering_kode_peralatan.setText(data.getKodePeralatan());
        mastering_nama_peralatan.setText(data.getNamaPeralatan());
        mastering_desc_peralatan.setText(data.getDescPeralatan());
        mastering_lokasi_peralatan.setText(data.getLokasiPeralatan());
        mastering_grup_peralatan.setText(data.getGrupPeralatan());


        return view;
    }
}
