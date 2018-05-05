package org.sandec.klinik.puskesmas.fragment;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.sandec.klinik.puskesmas.R;
import org.sandec.klinik.puskesmas.activities.Konstanta;
import org.sandec.klinik.puskesmas.adapter.HistoryAdapter;
import org.sandec.klinik.puskesmas.model.DaftarHistory;
import org.sandec.klinik.puskesmas.network.ServiceClient;
import org.sandec.klinik.puskesmas.network.ServiceGenerator;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

@SuppressWarnings("deprecation")
public class HistoryFragment extends Fragment {

    RecyclerView rvHistory;
    ArrayList<DaftarHistory>listHistory = new ArrayList<>();

    public HistoryFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("History");
        final ProgressDialog pd = new ProgressDialog(getActivity());
        pd.setMessage("load data from server");
        pd.show();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        rvHistory = (RecyclerView)view.findViewById(R.id.rv_history);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvHistory.setLayoutManager(llm);

        ServiceClient service = ServiceGenerator.createService(ServiceClient.class);

        SharedPreferences sp = getActivity().getSharedPreferences(Konstanta.FIREBASE, MODE_PRIVATE);
        String token = sp.getString(Konstanta.TOKEN_FIREBASE,"");

        Call<ArrayList<DaftarHistory>> readHistory = service.getHistory("123");

        readHistory.enqueue(new Callback<ArrayList<DaftarHistory>>() {
            @Override
            public void onResponse(Call<ArrayList<DaftarHistory>> call, Response<ArrayList<DaftarHistory>> response) {
                pd.dismiss();
                listHistory = response.body();

                HistoryAdapter adapter = new HistoryAdapter(getActivity(),listHistory);
                rvHistory.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<DaftarHistory>> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(getActivity(), "Koneksi ke server terputus", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
