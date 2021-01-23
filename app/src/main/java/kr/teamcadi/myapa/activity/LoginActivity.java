package kr.teamcadi.myapa.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import kr.teamcadi.myapa.R;
import kr.teamcadi.myapa.domain.MemberDTO;
import kr.teamcadi.myapa.network.ServiceLogin;

// 화면 설명 : 로그인 화면
// Author : Jang Su Hyun, Jaey, Last Modified : 2021.1.23
public class LoginActivity extends AppCompatActivity
{
    // 로그인이 성공하면 static 형태인 DTO 변수에 담아서 어느 곳에서나 접근 가능하도록 함
    public static MemberDTO loginDTO = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText edit_id = (EditText)findViewById(R.id.ev_id);
        final EditText edit_pw = (EditText)findViewById(R.id.ev_password);
        CheckBox check_autologin = (CheckBox)findViewById(R.id.cb_autologin);
        TextView findIdAndPassword = (TextView)findViewById(R.id.tv_findIdAndPassword);
        Button btn_login = (Button)findViewById(R.id.btn_login);
        Button btn_save = (Button)findViewById(R.id.btn_signup);

        // 로그인 버튼 클릭할 때 동작
        btn_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String id = edit_id.getText().toString();
                String pw = edit_pw.getText().toString();

                // 아무것도 입력을 안하고 로그인 버튼을 누를 경우
                if(id.equals("") || pw.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호를 입력하세요.", Toast.LENGTH_LONG).show();
                }

                // 로그인 동작 수행
                ServiceLogin serviceLogin = new ServiceLogin(id, pw);

                // 로그인 동작 수행 중 예외 처리 부분
                try
                {
                    serviceLogin.execute().get();
                }

                catch(Exception e)
                {
                    e.printStackTrace();
                }

                if(loginDTO != null)
                {
                    Toast.makeText(getApplicationContext(), loginDTO.getUserName() + "님 환영합니다!", Toast.LENGTH_LONG).show();
                }

                else
                {
                    Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호를 확인해주세요!", Toast.LENGTH_LONG).show();

                    // 입력란 초기화
                    edit_id.setText("");
                    edit_pw.setText("");
                    edit_id.requestFocus();
                }
            }
        });
    }
}