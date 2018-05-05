package org.sandec.klinik.puskesmas.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.sandec.klinik.puskesmas.R;
import org.sandec.klinik.puskesmas.activities.Konstanta;
import org.sandec.klinik.puskesmas.activities.PendaftaranPoliActivity;
import org.sandec.klinik.puskesmas.model.Daftarpoli;

import java.util.ArrayList;

/**
 * Created by wakhyudi on 29/11/17.
 */

public class PoliAdapter extends RecyclerView.Adapter<PoliAdapter.PoliViewHolder> {
   private Context context;
   private ArrayList<Daftarpoli>listPoli;

    public PoliAdapter(Context context, ArrayList<Daftarpoli> listPoli) {
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
        TextView tvNamaPoli,tvNamaDokter;
        View view;

        public PoliViewHolder(View itemView) {
            super(itemView);
            ivGambarPoli = (ImageView)itemView.findViewById(R.id.iv_poli);
            tvNamaPoli = (TextView)itemView.findViewById(R.id.tv_poli);
            tvNamaDokter = (TextView)itemView.findViewById(R.id.tv_poli_nama_dokter);
            view = (View)itemView;
        }

        public void bindItem(View v, final int position){
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle b = new Bundle();
                    Intent i = new Intent(context,PendaftaranPoliActivity.class);
//                    String namaPoli = listPoli.get(position).getJudul1();
//                    String namaDokter = listPoli.get(position).getJudul2();
                    String id = listPoli.get(position).getId();
//                    b.putString(Konstanta.NAMA_POLI,namaPoli);
//                    b.putString(Konstanta.NAMA_DOKTER,namaDokter);
                    b.putString(Konstanta.LAYANAN_ID,id);
//                    String detail = "Poli "+desc+" melayani masyarakat yang  \n membutuhkan pelayanan "+desc;
//                    b.putString(Konstanta.DETAIL_POLI,detail);
                    i.putExtras(b);
                    context.startActivity(i);

                }
            });
        }
    }

    @Override
    public void onBindViewHolder(PoliAdapter.PoliViewHolder holder, int position) {
        String linkGambar = listPoli.get(position).getLinkIcon();
        Glide.with(context).load(linkGambar).into(holder.ivGambarPoli);
        //holder.ivGambarPoli.setImageResource(listPoli.get(position).getGambarPoli());
        holder.tvNamaPoli.setText(listPoli.get(position).getJudul1());
        holder.tvNamaDokter.setText(listPoli.get(position).getJudul2());
        holder.bindItem(holder.itemView,position);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle b = new Bundle();
//                Intent i = new Intent(context,PendaftaranPoliActivity.class);
//                String detail;
//                switch (listPoli.get(position).getId()){
//                    case "2":
//                        b.putString(Konstanta.NAMA_POLI,"Poli Umum");
//                        b.putString(Konstanta.LAYANAN_ID,"2");
//                        detail = "Poli Umum melayani masyarakat yang  \n membutuhkan pelayanan kesehatan Umum";
//                        b.putString(Konstanta.DETAIL_POLI,detail);
//                        i.putExtras(b);
//                        break;
//                    case "3":
//                        b.putString(Konstanta.NAMA_POLI,"Poli Gigi");
//                        b.putString(Konstanta.LAYANAN_ID,"3");
//                        detail = "Poli Gigi melayani masyarakat yang \n  membutuhkan pelayanan kesehatan Gigi";
//                        b.putString(Konstanta.DETAIL_POLI,detail);
//                        i.putExtras(b);
//                        break;
//                    case "4":
//                        b.putString(Konstanta.NAMA_POLI,"Poli Ibu dan Anak");
//                        b.putString(Konstanta.LAYANAN_ID,"4");
//                        detail = "Poli KIA melayani masyarakat yang \n  membutuhkan pelayanan kesehatan Ibu dan Anak";
//                        b.putString(Konstanta.DETAIL_POLI,detail);
//                        i.putExtras(b);
//                        break;
//                    case "5":
//                        b.putString(Konstanta.NAMA_POLI,"Poli KB");
//                        b.putString(Konstanta.LAYANAN_ID,"5");
//                        detail = "Poli KB melayani masyarakat yang \n  membutuhkan pelayanan KB";
//                        b.putString(Konstanta.DETAIL_POLI,detail);
//                        i.putExtras(b);
//                        break;
//                    case "6":
//                        b.putString(Konstanta.NAMA_POLI,"Poli Imunisasi");
//                        b.putString(Konstanta.LAYANAN_ID,"6");
//                        detail = "Poli Imunisasi melayani masyarakat yang \n  membutuhkan pelayanan Imunisasi";
//                        b.putString(Konstanta.DETAIL_POLI,detail);
//                        i.putExtras(b);
//                        break;
//                    case "7":
//                        b.putString(Konstanta.NAMA_POLI,"Poli Fisioterapi");
//                        b.putString(Konstanta.LAYANAN_ID,"7");
//                        detail = "Poli Fisioterapi melayani masyarakat yang \n  membutuhkan pelayanan Fisioterapi";
//                        b.putString(Konstanta.DETAIL_POLI,detail);
//                        i.putExtras(b);
//                        break;
//                    case "8":
//                        b.putString(Konstanta.NAMA_POLI,"Poli Gizi");
//                        b.putString(Konstanta.LAYANAN_ID,"8");
//                        detail = "Poli Gizi melayani masyarakat yang \n  membutuhkan pelayanan Gizi";
//                        b.putString(Konstanta.DETAIL_POLI,detail);
//                        i.putExtras(b);
//                        break;
//                    case "9":
//                        b.putString(Konstanta.NAMA_POLI,"Poli Sanitasi");
//                        b.putString(Konstanta.LAYANAN_ID,"9");
//                        detail = "Poli Sanitasi melayani masyarakat yang \n  membutuhkan pelayanan kesehatan Sanitasi";
//                        b.putString(Konstanta.DETAIL_POLI,detail);
//                        i.putExtras(b);
//                        break;
//                }
//                context.startActivity(i);
//            }
//        });//iki
    }

    @Override
    public int getItemCount() {
        return listPoli.size();
    }


}
