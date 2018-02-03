package com.iteso.sesion5;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    Menu menu;
    EditText name;
    EditText phone;
    Spinner degree;
    AutoCompleteTextView textView;
    AutoCompleteTextView book;
    RadioButton gender_m;
    RadioButton gender_f;
    CheckBox sport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.activity_main_book);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.books));
        textView.setAdapter(adapter);

        name = findViewById(R.id.activity_main_name);
        phone = findViewById(R.id.activity_main_phone);
        degree = findViewById(R.id.activity_main_degree);
        book = findViewById(R.id.activity_main_book);
        gender_m = findViewById(R.id.activity_main_mas);
        gender_f = findViewById(R.id.activity_main_fem);
        sport = findViewById(R.id.activity_main_sport);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.activity_menu_save:
                save();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.activity_main_fem:
                if (checked)
                    ((RadioButton) view).toggle();
                    break;
            case R.id.activity_main_mas:
                if (checked)
                    ((RadioButton) view).toggle();
                    break;
        }
    }

    public void save(){
        String gender;
        if(gender_f.isChecked())
            gender = getResources().getString(R.string.fem);
        else
            gender = getResources().getString(R.string.masc);
        Alumno alumno = new Alumno(name.getText().toString(), phone.getText().toString(), degree.getSelectedItem().toString(), gender, book.getText().toString(), sport.isChecked());
        Toast.makeText(this, alumno.toString(), Toast.LENGTH_LONG).show();
        clean();
    }

    public void clean(){
        name.setText(null);
        phone.setText(null);
        degree.setSelection(0);
        gender_f.setChecked(true);
        gender_m.setChecked(false);
        book.setText(null);
        sport.setChecked(true);
    }

    public void onButtonClicked(View v){
        cleanDialog();
    }

    public void cleanDialog(){
        AlertDialog.Builder cleanDialog = new AlertDialog.Builder(ActivityMain.this);
        cleanDialog.setMessage(R.string.dialog_message).setCancelable(true);
        cleanDialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                clean();
            }
        });
        cleanDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        AlertDialog dialog = cleanDialog.create();
        dialog.show();;
    }
}
