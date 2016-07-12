package devferrarizero.my_reminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarActivity extends AppCompatActivity implements View.OnClickListener {

    public static String selectedDate;
    CalendarView calendar;
    Button btn_back, btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendar = (CalendarView)findViewById(R.id.calendarView);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        selectedDate = sdf.format(new Date(calendar.getDate()));
        btn_back = (Button)findViewById(R.id.btn_back1);
        btn_back.setOnClickListener(this);
        btn_next = (Button)findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //int id = v.getId();
        switch (v.getId()){
            case R.id.btn_back1:
                Intent intent = new Intent(CalendarActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_next:
                intent = new Intent(CalendarActivity.this, AddingActivity.class);
                startActivity(intent);
                break;
        }
    }
}
