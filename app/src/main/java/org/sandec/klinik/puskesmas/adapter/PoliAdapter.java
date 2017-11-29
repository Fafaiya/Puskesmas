package org.sandec.klinik.puskesmas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.sandec.klinik.puskesmas.R;
import org.sandec.klinik.puskesmas.model.Poli;

import java.util.ArrayList;

/**
 * Created by wakhyudi on 29/11/17.
 */

public class PoliAdapter extends RecyclerView.Adapter<PoliAdapter.PoliViewHolder> {
   private Context context;
   private ArrayList<Poli>listPoli;

    public PoliAdapter(Context context, ArrayList<Poli> listPoli) {
        this.context = context;
        this.listPoli = listPoli;
    }

    @Override
    public PoliAdapter.PoliViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poli,parent,false);
        return new PoliViewHolder(itemView);
    }

    public class PoliViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGambarPoli;
        TextView tvNamaPoli;
        public PoliViewHolder(View itemView) {
            super(itemView);
            ivGambarPoli = (ImageView)itemView.findViewById(R.id.iv_poli);
            tvNamaPoli = (TextView)itemView.findViewById(R.id.tv_poli);
        }
    }

    @Override
    public void onBindViewHolder(PoliAdapter.PoliViewHolder holder, int position) {
        holder.ivGambarPoli.setImageResource(listPoli.get(position).getGambarPoli());
        holder.tvNamaPoli.setText(listPoli.get(position).getNamaPoli());
    }

    @Override
    public int getItemCount() {
        return listPoli.size();
    }


}
