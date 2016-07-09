package devferrarizero.my_reminder;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class AddingActivity extends AppCompatActivity implements View.OnClickListener {

    final String LOG_TAG = "my_logs";
    Button btn_sel_time, btn_back1, btn_add1;
    EditText et_todo_name;
    DBHelper dbHelper;
    TimePicker timePicker;

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
        et_todo_name = (EditText)findViewById(R.id.et_todo_name);
        timePicker = (TimePicker)findViewById(R.id.timePicker);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        String name = et_todo_name.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        /*if (id == R.id.btn_sel_time) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            TimePicker picker = new TimePicker(this);

            builder.setTitle("Select time")
                    .setView(picker)
                    .setNegativeButton("Cancel", null)
                    .setPositiveButton("Set", null);
            builder.show();
        }*/
        if (id == R.id.btn_back1) {
            Intent intent = new Intent(AddingActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.btn_add1) {
            cv.put(DBHelper.KEY_DATE, MainActivity.selectedDate);
            cv.put(DBHelper.KEY_HOUR, timePicker.getHour());
            cv.put(DBHelper.KEY_MINUTE, timePicker.getMinute());
            cv.put(DBHelper.KEY_TODO, name);

            database.insert(DBHelper.TABLE_CONTACTS, null, cv);
        }
        dbHelper.close();
    }
}
