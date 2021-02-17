package kr.teamcadi.myapa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MemberJoinThird extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_join_3);

        ImageButton btn_mj3_done = (ImageButton)findViewById(R.id.btn_mj3_done);
        ImageView iv_mj3_backarrow = (ImageView)findViewById(R.id.iv_mj3_backarrow);


        iv_mj3_backarrow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MemberJoinThird.this, MemberJoinSecond.class);
                startActivity(i);
                finish();
            }
        });
    }
}
