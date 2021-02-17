package kr.teamcadi.myapa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Calendar extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        ImageView iv_c_backarrow = (ImageView)findViewById(R.id.iv_c_backarrow);

        iv_c_backarrow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                Intent i = new Intent(Calendar.this,ReportThird.class);
                startActivity(i);
                finish();
            }
        });
    }
}
