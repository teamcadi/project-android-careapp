package kr.teamcadi.myapa;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

// 서비스 실행 시 첫 화면
// Author : Jaey, Last Modified : 2020.11.24
public class SplashActivity extends AppCompatActivity
{
    boolean connectResult = false;
    ConnectivityManager connectivityManager;

    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        connectivityManager = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivityManager != null)
        {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());

            if(networkCapabilities != null)
            {
                connectResult = networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR);
            }
            else
            {
                connectResult = false;
            }
        }

        if(connectResult == true)
        {
            Toast.makeText(getApplicationContext(), "Connection OK", Toast.LENGTH_LONG).show();
        }

        else
        {
            Toast.makeText(getApplicationContext(), "Connection NO", Toast.LENGTH_LONG).show();
        }
    }
}