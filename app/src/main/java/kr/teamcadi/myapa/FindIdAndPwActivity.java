package kr.teamcadi.myapa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;

// 화면 설명 : 아이디/비밀번호 찾기 화면
// Author : Soohyun, Last Modified : 2020.12.31
public class FindIdAndPwActivity extends AppCompatActivity {
    Toolbar toolbar; // 상단바
    TabLayout tabLayout; // 탭
    View line; // 구분선
    EditText ev_phoneNumber; // 전화번호 입력창
    Button btn_send_certificationNumber; // 인증번호 전송 버튼
    EditText ev_certificationNumber; // 인증번호 입력창
    Button btn_indentify_certifiationNumber; // 인증번호 확인 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id_and_pw);

        // 상단바 설정
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //기본 타이틀 삭제
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //back버튼

        line = (View)findViewById(R.id.line);
        ev_phoneNumber = (EditText)findViewById(R.id.ev_phoneNumber);
        btn_send_certificationNumber = (Button)findViewById(R.id.btn_send_certificationNumber);
        ev_certificationNumber = (EditText)findViewById(R.id.ev_certificationNumber);
        btn_indentify_certifiationNumber = (Button)findViewById(R.id.btn_indentify_certificationNumber);

        // 첫화면(로그인찾기화면)일 때 안보이도록 하는 부분
        line.setVisibility(View.INVISIBLE);
        ev_phoneNumber.setVisibility(View.INVISIBLE);
        btn_send_certificationNumber.setVisibility(View.INVISIBLE);
        ev_certificationNumber.setVisibility(View.INVISIBLE);
        btn_indentify_certifiationNumber.setVisibility(View.INVISIBLE);

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
                line.setVisibility(View.INVISIBLE);
                ev_phoneNumber.setVisibility(View.INVISIBLE);
                btn_send_certificationNumber.setVisibility(View.INVISIBLE);
                ev_certificationNumber.setVisibility(View.INVISIBLE);
                btn_indentify_certifiationNumber.setVisibility(View.INVISIBLE);
                break;
            case 1:
                // 비밀번호 찾기 화면일 때 보이도록 변경
                line.setVisibility(View.VISIBLE);
                ev_phoneNumber.setVisibility(View.VISIBLE);
                btn_send_certificationNumber.setVisibility(View.VISIBLE);
                ev_certificationNumber.setVisibility(View.VISIBLE);
                btn_indentify_certifiationNumber.setVisibility(View.VISIBLE);
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