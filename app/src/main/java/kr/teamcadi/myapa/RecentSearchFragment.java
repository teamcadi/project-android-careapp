package kr.teamcadi.myapa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// 화면 설명 : 검색 전 화면 (최근 검색어, 해시태그)
// Author : Soohyun, Last Modified : 2021.01.05
public class RecentSearchFragment extends Fragment {

    public RecentSearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recent_search, container, false);
    }
}