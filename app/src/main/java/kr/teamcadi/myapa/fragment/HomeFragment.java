package kr.teamcadi.myapa.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.adapter.HomeFragViewPagerAdapter;

// 화면 설명 : 홈 화면(메인 컨텐츠 영역) -> MainActivity로 연결
// Author : Jaey, Last Modified : 2021.01.16
public class HomeFragment extends Fragment
{
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_eye, container, false);

        tabLayout = view.findViewById(R.id.treatment_tab);
        viewPager2 = view.findViewById(R.id.home_view_pager);

        HomeFragViewPagerAdapter homeFragViewPagerAdapter = new HomeFragViewPagerAdapter(this);
        viewPager2.setAdapter(homeFragViewPagerAdapter);

        String[] tabName = new String[]{"진료과", "진료과2", "진료과3"};

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabName[position].toString());
            }
        }).attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });

        return view;
    }
}