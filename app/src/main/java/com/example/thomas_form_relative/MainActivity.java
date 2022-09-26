package com.example.thomas_form_relative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.thomas_form_relative.R;

public class MainActivity extends AppCompatActivity {


    private EditText etnpm , etnama;
    private RadioGroup rgjk;
    private RadioButton rbjk;
    private Spinner spProdi;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnpm = findViewById(R.id.et_npm);
        etnama = findViewById(R.id.et_nama);
        rgjk = findViewById(R.id.rg_jk);
        spProdi = findViewById(R.id.sp_prodi);

        btnDaftar = findViewById(R.id.btn_daftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama, npm, jk, prodi;
                int selectedID;

                npm = etnpm.getText().toString();
                nama= etnama.getText().toString();
                prodi = spProdi.getSelectedItem().toString();
                //radiogrup
                selectedID = rgjk.getCheckedRadioButtonId();
                rbjk = findViewById(selectedID);
                jk = rbjk.getText().toString();

                if (npm.trim().equals("")){
                    etnpm.setError("NPM Tidak Boleh Kosong");
                    return;
                }
                else if(nama.trim().equals("")){
                    etnama.setError("Nama Tidak Boleh Kosong");
                    return;
                }

                Intent intent = new Intent(MainActivity.this,
                        ResultActivity.class);
                intent.putExtra("varNPM" , npm);
                intent.putExtra("varNama", nama);
                intent.putExtra("varJk", jk);
                intent.putExtra("varProdi" , prodi);
                startActivity(intent);

            }
        });


    }
}