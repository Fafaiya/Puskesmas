package org.sandec.klinik.puskesmas.network;

import org.sandec.klinik.puskesmas.model.Antrian;
import org.sandec.klinik.puskesmas.model.DaftarHistory;
import org.sandec.klinik.puskesmas.model.Daftarpoli;
import org.sandec.klinik.puskesmas.model.DetailAntrian;
import org.sandec.klinik.puskesmas.model.ResponServer;
import org.sandec.klinik.puskesmas.model.ResponseCekNIK;
import org.sandec.klinik.puskesmas.model.TambahAntrian;
import org.sandec.klinik.puskesmas.model.TambahAntrianResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by wakhyudi on 18/12/17.
 */

public interface ServiceClient {
//    @POST("daftar_baru")
//    Call<ResponServer> getDaftar(@Query("action") String action,
//                           @Query("sheetName") String sheetName,
//                           @Query("token") String token,
//                           @Query("nik") String nik,
//                           @Query("nama") String nama,
//                           @Query("alamat") String alamat,
//                           @Query("tanggal_lahir") String tanggalLahir,
//                           @Query("telp") String telp,
//                           @Query("no_bpjs") String noBpjs,
//                           @Query("jenis_kelamin") String jenisKelamin);

    //tambah daftar baru, Nik tidak terdaftar
    @POST("daftar_baru")
    Call<ResponServer> getDaftar(@Query("nik") String nik,
                                 @Query("nama") String nama,
                                 @Query("alamat") String alamat,
                                 @Query("tanggal_lahir") String tanggalLahir,
                                 @Query("telp") String telp,
                                 @Query("no_bpjs") String noBpjs,
                                 @Query("jK") String jenisKelamin);

    //mendaptkan antrian akhir
    @POST("antrian_akhir/")
    Call<Antrian> getDaftarAntrian(@Query("layanan_ID") String idPoli,
                                   @Query("token") String token);


//    @POST("tambah_antrian/")
//    Call<TambahAntrian> getDaftarPoli(@Query("last_layanan_ID") int lastLayananId,
//                                      @Query("token") String token,
//                                      @Query("bpjs") String bpjs,
//                                      @Query("nik") String nik,
//                                      @Query("waktu") int waktu);
    //Daftar ke Antrian
    @POST("tambah_antrian/")
    Call<ArrayList<TambahAntrianResponse>> getDaftarPoliResponse(@Query("last_layanan_ID") int lastLayananId,
                                                      @Query("token") String token,
                                                      @Query("bpjs") String bpjs,
                                                      @Query("nik") String nik,
                                                      @Query("waktu") String waktu);

    //Antrian detail
    @POST("antrian_detail/")
    Call<DetailAntrian> getDetailAntrian(@Query("ID") String idAntrian );




    //Cek NIK
    @POST("check_nik/")
    Call<ResponseCekNIK>cekNik(@Query("nik")String nik);




    //mendapatakan list
    @POST("get_list_layanan")
    Call<ArrayList<Daftarpoli>> getListLayanan();

    //membaca history
    @POST("get_history/")
    Call<ArrayList<DaftarHistory>>  getHistory(@Query("token") String token);


//    @POST("exec")
//    Call<Validasi>  getValidate(@Query("action") String action,
//                                @Query("sheetName") String sheetName,
//                                @Query("nik") String nik,
//                                @Query("no_validasi") String noValidasi);


//    Call<ResponServer>  getDaftarPoli(@Query("action") String action,
//                                      @Query("sheetName") String sheetName,
//                                      @Query("token") String token,
//                                      @Query("nik") String nik,
//                                      @Query("jenis_layanan") String jenisLayanan,
//                                      @Query("tanggal") String tanggal);

//    @POST("antrian_akhir/")
//    Call<Antrian>  getDaftarAntrian(@Query("action") String action,
//                                    @Query("sheetName") String sheetName);



//    @POST("exec")
//    Call<Validasi>  getNIKDukcapil(@Query("action") String action,
//                                   @Query("sheetName") String sheetName,
//                                   @Query("nik") String nik);


    @POST("register_device/")
    Call<ResponServer>getResponseIdReg(@Query("token") String idDevice);

}
