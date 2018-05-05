package org.sandec.klinik.puskesmas.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.sandec.klinik.puskesmas.R;
import org.sandec.klinik.puskesmas.model.History;

import java.util.ArrayList;
import java.util.List;

public class LayananProgressFragment extends Fragment {
    RecyclerView rvHistoryProgress;
    List<History> listHistory = new ArrayList<>();
    List<History> listProgress = new ArrayList<>();
    public LayananProgressFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_layanan_progress, container, false);
        rvHistoryProgress = (RecyclerView) view.findViewById(R.id.rv_layanan_progress);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvHistoryProgress.setLayoutManager(llm);



//        ServiceClient service = ServiceGenerator.createService(ServiceClient.class);
//        Call<ListHistory> getListHistory = service.getHistory("read_history", "history");
//
//        getListHistory.enqueue(new Callback<ListHistory>() {
//            @Override
//            public void onResponse(Call<ListHistory> call, Response<ListHistory> response) {
//
//                listHistory = response.body().getListHistory();
//                for (int i = 0; i < listHistory.size(); i++) {
//                    //memfilter objek yang statusnya sudah selesai
//                    if (listHistory.get(i).getStatus().equals("0")) {
//                        String token = listHistory.get(i).getToken();
//                        String nik = listHistory.get(i).getNik();
//                        String layanan = listHistory.get(i).getJenisLayanan();
//                        String tgl = listHistory.get(i).getTanggal();
//                        String antrian = listHistory.get(i).getNoAntrian();
//                        String poli = listHistory.get(i).getPoli();
//                        History history = new History(token, nik, layanan, tgl, antrian, poli, "Dalam Proses");
//                        listProgress.add(history);
//                    }
//                }
//                HistoryAdapter adapter = new HistoryAdapter(getActivity(), listProgress);
//                rvHistoryProgress.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<ListHistory> call, Throwable t) {
//
//                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });


        return view;
    }

}
