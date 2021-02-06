package kr.teamcadi.myapa.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import kr.teamcadi.myapa.R;

// 화면 설명 : 캘린더뷰 화면
// Author : Hyeonae, Last Modified : 2021.02.06
public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }
}