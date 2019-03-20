package com.example.rayca.my_application_lab_5;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.rayca.my_application_lab_5.api.TelemedicineAPI;

import java.net.InetAddress;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static final String BASE_URL = "https://docs.postman-echo.com/?fbclid=IwAR0xrHleqSYR6wiAUZU3ClUojlBpYrkp-NdftnnQO-AvKpxHvhy-8pHJ7og#9a4c3bce-30f7-a496-c9ec-78afecbf1545";
    private static final String SHARED_PREFERENCES = "SHARED_PREFERENCES";
    private static final String TOKEN_AUTH = "TOKEN_AUTH";
    private static TelemedicineAPI telemedicineAPI;
    private static SharedPreferences prefs;


    @Override
    public void onCreate() {
        super.onCreate();
        telemedicineAPI = createTelemedicineAPI();
        prefs = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
    }

    public TelemedicineAPI createTelemedicineAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(App.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(TelemedicineAPI.class);
    }

    public static TelemedicineAPI getApi() {
        return telemedicineAPI;
    }

    public static void logIn(String token) {
        prefs.edit().putString(TOKEN_AUTH, token).apply();
        Log.d("TOKEN_NEW", token);
    }

    public static boolean checkAuth(){
        return getAuthToken().length() > 0;
    }

    public static void logOut(){
        prefs.edit().putString(TOKEN_AUTH, "").apply();
    }

    public static String getAuthToken(){
        String token = prefs.getString(TOKEN_AUTH, "");
        return token;
    }
}
