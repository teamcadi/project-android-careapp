package kr.teamcadi.myapa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ReportThird extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_3);

        EditText ev_r3_term = (EditText)findViewById(R.id.ev_r3_term);

        ev_r3_term.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ReportThird.this,Calendar.class);
                startActivity(i);
                finish();
            }
        });
    }
}
