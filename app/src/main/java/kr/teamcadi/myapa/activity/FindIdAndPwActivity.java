package kr.teamcadi.myapa.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import kr.teamcadi.myapa.R;

// 화면 설명 : 아이디/비밀번호 찾기 화면
// Author : Soohyun, Last Modified : 2020.12.31
public class FindIdAndPwActivity extends AppCompatActivity {
    Toolbar toolbar; // 상단바
    TabLayout tabLayout; // 탭
    ImageView iv_divider; // 구분선
    RelativeLayout layout_certification; // 인증관련 뷰를 담은 레이아웃

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id_and_pw);

        // 상단바 설정
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //기본 타이틀 삭제
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //back버튼

        iv_divider = findViewById(R.id.iv_divider);
        layout_certification = findViewById(R.id.layout_certification);

        // 첫화면(로그인찾기화면)일 때 안보이도록 하는 부분
        iv_divider.setVisibility(View.INVISIBLE);
        layout_certification.setVisibility(View.INVISIBLE);

        // tab 설정
        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                changeTab(pos); // 탭 전환
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    // tab 전환시 동작
    private void changeTab(int pos) {
        switch (pos) {
            case 0:
                // 아이디 찾기 화면일 때 안보이도록 변경
                iv_divider.setVisibility(View.INVISIBLE);
                layout_certification.setVisibility(View.INVISIBLE);
                break;
            case 1:
                // 비밀번호 찾기 화면일 때 보이도록 변경
                iv_divider.setVisibility(View.VISIBLE);
                layout_certification.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //상단바의 back키 눌렀을 때
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}