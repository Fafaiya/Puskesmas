package org.sandec.klinik.puskesmas.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;

import org.sandec.klinik.puskesmas.R;
import org.sandec.klinik.puskesmas.adapter.PoliAdapter;
import org.sandec.klinik.puskesmas.model.Daftarpoli;
import org.sandec.klinik.puskesmas.network.ServiceClient;
import org.sandec.klinik.puskesmas.network.ServiceGenerator;

import java.util.ArrayList;

//import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PoliFragment extends Fragment {
    RecyclerView rvPoli;
    SweetAlertDialog sd;
    ArrayList<Daftarpoli>listPoli = new ArrayList<>();
//    public int[]gambarPoli = {R.drawable.umum,
//            R.drawable.gigi,
//            R.drawable.kia,
//            R.drawable.kb,
//            R.drawable.imunisasi,
//            R.drawable.fisioterapi,
//            R.drawable.gizi,
//            R.drawable.sanitasi};
//    public String[]namaPoli = {"Umum",
//            "Gigi",
//            "KIA",
//            "KB",
//            "Imunisasi",
//            "Fisioterapi",
//            "Gizi",
//            "Sanitasi"};

    public PoliFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_poli, container, false);

        sd = new SweetAlertDialog(getActivity(),SweetAlertDialog.PROGRESS_TYPE);
        sd.getProgressHelper().setBarColor(R.color.colorPrimary);
        sd.setTitleText("Load data from server");
        sd.setCancelable(false);
        sd.show();


//        final ProgressDialog pd =  new ProgressDialog(getActivity());
//        pd.setMessage("Load data From Server");
//        pd.show();

        rvPoli = (RecyclerView) view.findViewById(R.id.rv_daftar_poli);
        rvPoli.setLayoutManager(new GridLayoutManager(getActivity(),3));

        ServiceClient service = ServiceGenerator.createService(ServiceClient.class);

        Call<ArrayList<Daftarpoli>>getListPoli = service.getListLayanan();


        getListPoli.enqueue(new Callback<ArrayList<Daftarpoli>>() {
            @Override
            public void onResponse(Call<ArrayList<Daftarpoli>> call, Response<ArrayList<Daftarpoli>> response) {
                sd.dismiss();
                //                pd.dismiss();
                listPoli = response.body();

//                for (int i = 0; i <listPoli.size() ; i++) {
//                    String id = listPoli.get(i).getId();
//                    String desc = listPoli.get(i).getDescription();
//                    String linkIcon = listPoli.get(i).getLinkIcon();
//
//                    Daftarpoli daftarpoli = new Daftarpoli(id,desc,linkIcon);
//
//                }
                PoliAdapter adapter = new PoliAdapter(getActivity(),listPoli);

                rvPoli.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Daftarpoli>> call, Throwable t) {
//                pd.dismiss();
                sd.dismiss();

                SweetAlertDialog sdError = new SweetAlertDialog(getActivity(),SweetAlertDialog.ERROR_TYPE);
                sdError.setTitleText("Oops ...");
                sdError.setContentText(""+t.getMessage());
                sdError.show();
//                Toast.makeText(getActivity(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//
//        for (int i = 0; i <gambarPoli.length ; i++) {
//
//            Poli poli = new Poli(gambarPoli[i],namaPoli[i]);
//            listPoli.add(poli);
//
//        }
//
//        PoliAdapter adapter = new PoliAdapter(getActivity(),listPoli);
//        rvPoli.setAdapter(adapter);
//
//    }
}
