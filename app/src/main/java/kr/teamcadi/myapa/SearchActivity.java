package kr.teamcadi.myapa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

// 화면 설명 : 검색화면
// Author : Soohyun, Last Modified : 2021.01.05
public class SearchActivity extends AppCompatActivity {
    SearchView searchView;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    RecentSearchFragment recentSearchFragment;
    SearchDetailFragment searchDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView = (SearchView)findViewById(R.id.searchView);
        fragmentManager = getSupportFragmentManager();
        recentSearchFragment = new RecentSearchFragment();
        searchDetailFragment = new SearchDetailFragment();

        // 처음 화면 설정
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, recentSearchFragment).commit();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 검색버튼 누른 경우
            @Override
            public boolean onQueryTextSubmit(String query) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame_layout, searchDetailFragment).commit();

                return true;
            }

            // searchView의 텍스트가 바뀌는 경우
            @Override
            public boolean onQueryTextChange(String newText) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame_layout, recentSearchFragment).commit();

                return true;
            }
        });
    }
}