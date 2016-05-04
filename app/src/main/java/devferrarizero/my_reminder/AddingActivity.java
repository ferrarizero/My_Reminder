package devferrarizero.my_reminder;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class AddingActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_sel_time, btn_back1, btn_add1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding1);

        btn_sel_time = (Button)findViewById(R.id.btn_sel_time);
        btn_sel_time.setOnClickListener(this);
        btn_back1 = (Button)findViewById(R.id.btn_back1);
        btn_back1.setOnClickListener(this);
        btn_add1 = (Button)findViewById(R.id.btn_add1);
        btn_add1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_sel_time){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            TimePicker picker = new TimePicker(this);

            builder.setTitle("Select time")
                    .setView(picker)
                    .setNegativeButton("Cancel", null)
                    .setPositiveButton("Set", null);
            builder.show();
        } else if (id == R.id.btn_back1){
            Intent intent = new Intent(AddingActivity.this, MainActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_add){

        }
    }
}
