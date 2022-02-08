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

public class ListNeracaSaldoTotalBaseAdapter extends BaseAdapter {
    Activity activity;
    Context context;
    List<ListDataNeracaSaldoTotal> items;

    private LayoutInflater inflater;

    public ListNeracaSaldoTotalBaseAdapter(Activity activity, Context context, List<ListDataNeracaSaldoTotal> items) {
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
            view = inflater.inflate(R.layout.list_nstotal, null);

            TextView nstotaldebit = (TextView) view.findViewById(R.id.nstotaldebit);
            TextView nstotalkredit = (TextView) view.findViewById(R.id.nstotalkredit);

            ListDataNeracaSaldoTotal data = items.get(i);

            nstotaldebit.setText(data.getNstotaldebittotal());
            nstotalkredit.setText(data.getNstotalkredittotal());
        }


        return view;
    }
}
