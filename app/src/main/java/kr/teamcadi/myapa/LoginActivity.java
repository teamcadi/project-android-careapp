package kr.teamcadi.myapa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// 화면 설명 : 로그인 화면
// Author : Soohyun, Last Modified : 2020.11.28
public class LoginActivity extends AppCompatActivity
{
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
        Button btn_signup = (Button)findViewById(R.id.btn_signup);

        btn_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String id = edit_id.getText().toString();
                String pw = edit_pw.getText().toString();

                if(id.equals(""))
                    Toast.makeText(getApplicationContext(),"아이디를 입력하세요.", Toast.LENGTH_LONG).show();
                if(pw.equals(""))
                    Toast.makeText(getApplicationContext(),"비밀번호를 입력하세요.", Toast.LENGTH_LONG).show();

                if(!id.equals("") && !pw.equals(""))
                    Toast.makeText(getApplicationContext(),"로그인 성공", Toast.LENGTH_LONG).show();
            }
        });

        findIdAndPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, FindIdAndPwActivity.class));
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MemberJoinBasic.class));
            }
        });
    }
}