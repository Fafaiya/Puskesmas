package org.sandec.klinik.puskesmas.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.sandec.klinik.puskesmas.R;
import org.sandec.klinik.puskesmas.adapter.PoliAdapter;
import org.sandec.klinik.puskesmas.model.Poli;

import java.util.ArrayList;


public class PoliFragment extends Fragment {
    RecyclerView rvPoli;
    ArrayList<Poli>listPoli = new ArrayList<>();
    public int[]gambarPoli = {R.drawable.umum,
            R.drawable.gigi,
            R.drawable.kia,
            R.drawable.kb,
            R.drawable.imunisasi,
            R.drawable.fisioterapi,
            R.drawable.gizi,
            R.drawable.sanitasi};
    public String[]namaPoli = {"Umum",
            "Gigi",
            "KIA",
            "KB",
            "Imunisasi",
            "Fisioterapi",
            "Gizi",
            "Sanitasi"};

    public PoliFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poli, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPoli = (RecyclerView) view.findViewById(R.id.rv_daftar_poli);
        rvPoli.setLayoutManager(new GridLayoutManager(getActivity(),3));

        for (int i = 0; i <gambarPoli.length ; i++) {

            Poli poli = new Poli(gambarPoli[i],namaPoli[i]);
            listPoli.add(poli);

        }

        PoliAdapter adapter = new PoliAdapter(getActivity(),listPoli);
        rvPoli.setAdapter(adapter);

    }
}
