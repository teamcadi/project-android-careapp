package kr.teamcadi.myapa.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.fragment.HomeFragment;
import kr.teamcadi.myapa.fragment.MyPageFragment;
import kr.teamcadi.myapa.fragment.NotificationFragment;
import kr.teamcadi.myapa.fragment.RecentSearchFragment;
import kr.teamcadi.myapa.fragment.SearchDetailFragment;
import kr.teamcadi.myapa.fragment.SlideMenuFragment;

// 화면 설명 : 메인 화면
// Author : Jang Soo Hyun, Jaey, Seung Hyun Kim, Last Updated : 2021.01.14
public class MainActivity extends AppCompatActivity
{
    private FragmentManager fragmentManager = getSupportFragmentManager(); // Fragment 관리를 위한 요소

    // Fragment 객체
    private SlideMenuFragment slideMenuFragment = new SlideMenuFragment();
    private HomeFragment homeFragment = new HomeFragment();
    private MyPageFragment myPageFragment = new MyPageFragment();
    private NotificationFragment notificationFragment = new NotificationFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment, homeFragment).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener
    {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(item.getItemId())
            {
                case R.id.slideMenu:
                    transaction.replace(R.id.main_fragment, slideMenuFragment).commitAllowingStateLoss();
                    break;

                case R.id.home:
                    transaction.replace(R.id.main_fragment, homeFragment).commitAllowingStateLoss();
                    break;

                case R.id.myPage:
                    transaction.replace(R.id.main_fragment, myPageFragment).commitAllowingStateLoss();
                    break;

                case R.id.notification:
                    transaction.replace(R.id.main_fragment, notificationFragment).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }
}