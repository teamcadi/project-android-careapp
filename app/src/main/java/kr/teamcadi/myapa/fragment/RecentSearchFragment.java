package kr.teamcadi.myapa.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import kr.teamcadi.myapa.R;

// 화면 설명 : 검색 전 화면 (최근 검색어, 해시태그)
// Author : Jang Soo Hyun, Last Modified : 2021.01.05
public class RecentSearchFragment extends Fragment
{
    public RecentSearchFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_recent_search, container, false);
    }
}