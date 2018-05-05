package org.sandec.klinik.puskesmas.fragment;

import android.app.ProgressDialog;
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

public class LayananFinishedFragment extends Fragment {
    RecyclerView rvHistoryFinished;
    List<History> listHistory = new ArrayList<>();
    List<History> listFinished = new ArrayList<>();

    public LayananFinishedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_layanan_finished, container, false);

        rvHistoryFinished = (RecyclerView) view.findViewById(R.id.rv_layanan_finished);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvHistoryFinished.setLayoutManager(llm);

        final ProgressDialog pd = new ProgressDialog(getActivity());
        pd.setMessage("Load data from server");
        pd.show();

//        ServiceClient service = ServiceGenerator.createService(ServiceClient.class);
//        Call<ListHistory> getListHistory = service.getHistory("read_history", "history");
//
//        getListHistory.enqueue(new Callback<ListHistory>() {
//            @Override
//            public void onResponse(Call<ListHistory> call, Response<ListHistory> response) {
//                pd.dismiss();
//                listHistory = response.body().getListHistory();
//                for (int i = 0; i < listHistory.size(); i++) {
//                    //memfilter objek yang statusnya sudah selesai
//                    if (listHistory.get(i).getStatus().equals("1")) {
//                        String token = listHistory.get(i).getToken();
//                        String nik = listHistory.get(i).getNik();
//                        String layanan = listHistory.get(i).getJenisLayanan();
//                        String tgl = listHistory.get(i).getTanggal();
//                        String antrian = listHistory.get(i).getNoAntrian();
//                        String poli = listHistory.get(i).getPoli();
//                        History history = new History(token, nik, layanan, tgl, antrian, poli, "Selesai");
//                        listFinished.add(history);
//                    }
//                }
//                HistoryAdapter adapter = new HistoryAdapter(getActivity(), listFinished);
//                rvHistoryFinished.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<ListHistory> call, Throwable t) {
//                pd.dismiss();
//                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });


        return view;
    }

}
