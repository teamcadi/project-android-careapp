package kr.teamcadi.myapa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// 화면 설명 : 검색화면
// Author : Soohyun, Last Modified : 2021.01.14
public class SearchActivity extends AppCompatActivity {
    public static EditText et_search;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    RecentSearchFragment recentSearchFragment;
    SearchDetailFragment searchDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        et_search = (EditText)findViewById(R.id.et_search);
        fragmentManager = getSupportFragmentManager();
        recentSearchFragment = new RecentSearchFragment();
        searchDetailFragment = new SearchDetailFragment();

        // 검색창 클릭 시
        et_search.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame_layout, recentSearchFragment).commit();
            }
        });

        // 검색 버튼 클릭 시
        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case EditorInfo.IME_ACTION_SEARCH:
                        transaction = fragmentManager.beginTransaction();
                        transaction.replace(R.id.frame_layout, searchDetailFragment).commit();
                        break;
                }
                return true;
            }
        });

        // 검색창 텍스트 변경 시
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame_layout, recentSearchFragment).commit();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}