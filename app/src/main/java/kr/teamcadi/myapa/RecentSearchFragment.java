package kr.teamcadi.myapa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

// 화면 설명 : 검색 전 화면 (최근 검색어, 해시태그)
// Author : Soohyun, Last Modified : 2021.01.14
public class RecentSearchFragment extends Fragment {
    Button btn_hashtag1;
    Button btn_hashtag2;
    Button btn_hashtag3;
    Button btn_hashtag4;
    Button btn_hashtag5;
    Button btn_hashtag6;

    public RecentSearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.fragment_recent_search, container, false);
        btn_hashtag1 = (Button)layout.findViewById(R.id.btn_hashtag1);
        btn_hashtag2 = (Button)layout.findViewById(R.id.btn_hashtag2);
        btn_hashtag3 = (Button)layout.findViewById(R.id.btn_hashtag3);
        btn_hashtag4 = (Button)layout.findViewById(R.id.btn_hashtag4);
        btn_hashtag5 = (Button)layout.findViewById(R.id.btn_hashtag5);
        btn_hashtag6 = (Button)layout.findViewById(R.id.btn_hashtag6);

        //버튼 클릭 시
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_hashtag1:
                        setSearchText(btn_hashtag1);
                        break;
                    case R.id.btn_hashtag2:
                        setSearchText(btn_hashtag2);
                        break;
                    case R.id.btn_hashtag3:
                        setSearchText(btn_hashtag3);
                        break;
                    case R.id.btn_hashtag4:
                        setSearchText(btn_hashtag4);
                        break;
                    case R.id.btn_hashtag5:
                        setSearchText(btn_hashtag5);
                        break;
                    case R.id.btn_hashtag6:
                        setSearchText(btn_hashtag6);
                        break;
                }
            }
        };

        btn_hashtag1.setOnClickListener(clickListener);
        btn_hashtag2.setOnClickListener(clickListener);
        btn_hashtag3.setOnClickListener(clickListener);
        btn_hashtag4.setOnClickListener(clickListener);
        btn_hashtag5.setOnClickListener(clickListener);
        btn_hashtag6.setOnClickListener(clickListener);

        return layout;
    }

    public void setSearchText(Button button) {
        String text = button.getText().toString().substring(1);
        SearchActivity.et_search.setText(text);
        SearchActivity.et_search.setSelection(text.length());
    }
}