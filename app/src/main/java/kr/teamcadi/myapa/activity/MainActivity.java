package kr.teamcadi.myapa.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.fragment.HomeFragment;
import kr.teamcadi.myapa.fragment.MyPageFragment;
import kr.teamcadi.myapa.fragment.NotificationFragment;
import kr.teamcadi.myapa.fragment.SlideMenuFragment;

// 화면 설명 : 메인 화면
// Author : Jang Soo Hyun, Jaey, Seung Hyun Kim, Last Updated : 2021.01.23
public class MainActivity extends AppCompatActivity
{
    private FragmentManager fragmentManager = getSupportFragmentManager(); // Fragment 관리를 위한 요소

    // Fragment 객체
    private HomeFragment homeFragment = new HomeFragment();
    private MyPageFragment myPageFragment = new MyPageFragment();
    private NotificationFragment notificationFragment = new NotificationFragment();

    DrawerLayout drawerLayout; // 사이드바를 위한 레이아웃
    NavigationView navigationView; // 사이드바

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 처음 화면 설정
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment, homeFragment).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        // 사이드바의 메뉴 클릭시
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                    case R.id.item_daily_report:
                        startActivity(new Intent(MainActivity.this, ReportActivity.class)); // 사이드바의 데일리리포트 클릭시 복약리포트(ReportActivity)로 이동
                        break;
                    case R.id.item_shopping:
                        break;
                    case R.id.item_setting:
                        break;
                    case R.id.item_notice:
                        break;
                    case R.id.item_service_center:
                        break;
                }
                return true;
            }
        });
    }

    // 하단바 클릭 시
    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener
    {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(item.getItemId())
            {
                case R.id.slideMenu:
                    drawerLayout.openDrawer(GravityCompat.START); // 사이드바 열림
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

    // 뒤로가기 눌렀을 경우
    @Override
    public void onBackPressed() {
        // 사이드 바에서 뒤로가기 눌렀을 경우
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START); // 사이드바 닫힘
        } else {
            super.onBackPressed();
        }
    }
}