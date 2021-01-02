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
    Toolbar toolbar;
    TabLayout tabLayout;
    View view_line;
    EditText ev_phoneNumber;
    Button btn_send_certificationNumber;
    EditText ev_certificationNumber;
    Button btn_indentify_certifiationNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id_and_pw);

        // toolbar 설정
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //기본 타이틀 삭제
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //back버튼

        view_line = (View)findViewById(R.id.view_line);
        ev_phoneNumber = (EditText)findViewById(R.id.ev_phoneNumber);
        btn_send_certificationNumber = (Button)findViewById(R.id.btn_send_certificationNumber);
        ev_certificationNumber = (EditText)findViewById(R.id.ev_certificationNumber);
        btn_indentify_certifiationNumber = (Button)findViewById(R.id.btn_indentify_certificationNumber);

        view_line.setVisibility(View.INVISIBLE);
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
                changeTab(pos);
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
                view_line.setVisibility(View.INVISIBLE);
                ev_phoneNumber.setVisibility(View.INVISIBLE);
                btn_send_certificationNumber.setVisibility(View.INVISIBLE);
                ev_certificationNumber.setVisibility(View.INVISIBLE);
                btn_indentify_certifiationNumber.setVisibility(View.INVISIBLE);
                break;
            case 1:
                view_line.setVisibility(View.VISIBLE);
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
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}