package org.sandec.klinik.puskesmas.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wakhyudi on 18/12/17.
 */

public class ServiceGenerator {

//    public static final String BASE_URL = "https://script.google.com/macros/s/AKfycbwTP9bEdmOj776tX_R0WelEd-7sQcRD3Wns4KM05hu2EhyaWzI/";

    public static final String BASE_URL = "http://lite-server.com/ANTRIAN/smart/service/online/";

    private static Gson gson = new GsonBuilder().setLenient().create();
    //    private static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).build();
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

    
}
