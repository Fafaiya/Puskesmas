package org.sandec.klinik.puskesmas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.sandec.klinik.puskesmas.R;
import org.sandec.klinik.puskesmas.model.DaftarHistory;

import java.util.ArrayList;

/**
 * Created by wakhyudi on 24/12/17.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<DaftarHistory> listHistory;


    public HistoryAdapter(Context context, ArrayList<DaftarHistory> listHistory) {
        this.context = context;
        this.listHistory = listHistory;
    }

    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false
        );

        return new MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPoli;
        TextView tvStatus, tvTanggal, tvLayanan, tvNoAntrian;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivPoli = (ImageView) itemView.findViewById(R.id.iv_item_history);
            tvStatus = (TextView) itemView.findViewById(R.id.tv_item_history_status);
            tvTanggal = (TextView) itemView.findViewById(R.id.tv_item_history_tanggal);
            tvLayanan = (TextView) itemView.findViewById(R.id.tv_item_history_layanan);
            tvNoAntrian = (TextView) itemView.findViewById(R.id.tv_item_history_no_antrian);
        }
    }

    @Override
    public void onBindViewHolder(HistoryAdapter.MyViewHolder holder, int position) {

        holder.ivPoli.setImageResource(R.drawable.gigi);
        holder.tvStatus.setText(listHistory.get(position).getStatus());
        holder.tvTanggal.setText(listHistory.get(position).getTanggal());
        holder.tvLayanan.setText(listHistory.get(position).getNamaPoli());
        holder.tvNoAntrian.setText(listHistory.get(position).getNoAntrian());

    }

    @Override
    public int getItemCount() {
        return listHistory.size();
    }


}
