package com.example.tugaspraktikum2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText etJari2, etPanjang, etLebar, etTinggi;
    Button button;
    TextView hasil;
    String[] geometry = {"Bola", "Kerucut", "Balok"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        etJari2 = findViewById(R.id.etJari2);
        etPanjang = findViewById(R.id.etPanjang);
        etLebar = findViewById(R.id.etLebar);
        etTinggi = findViewById(R.id.etTinggi);
        button = findViewById(R.id.button);
        hasil = findViewById(R.id.hasil);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinner.getSelectedItem().toString().equals(geometry[0])){
                    if (etJari2.getText().toString().isEmpty()){
                        etJari2.setError("Harap isi!");
                    }
                    else {
                        Double jari2 = Double.valueOf(etJari2.getText().toString());
                        Double volBola = (4.00 / 3.00) * Math.PI * Math.pow(jari2, 3);
                        String duaFormat = String.format("%.2f", volBola);
                        hasil.setText(duaFormat);
                    }
                } else if (spinner.getSelectedItem().toString().equals(geometry[1])) {
                    if (etJari2.getText().toString().isEmpty() && etTinggi.getText().toString().isEmpty()){
                        etJari2.setError("Harap Isi!");
                        etTinggi.setError("Harap isi!");
                    }else if (etJari2.getText().toString().isEmpty()){
                        etJari2.setError("Harap isi!");
                    } else if (etTinggi.getText().toString().isEmpty()){
                        etTinggi.setError("Harap isi!");
                    } else {
                        Double jari2 = Double.valueOf(etJari2.getText().toString());
                        Double tinggi = Double.valueOf(etTinggi.getText().toString());
                        Double volKerucut = (Math.PI * Math.pow(jari2, 2) * tinggi) / 3.00;
                        String duaFormat = String.format("%.2f", volKerucut);
                        hasil.setText(duaFormat);
                    }
                } else if (spinner.getSelectedItem().toString().equals(geometry[2])) {
                    if (etPanjang.getText().toString().isEmpty() && etLebar.getText().toString().isEmpty() && etTinggi.getText().toString().isEmpty()){
                        etPanjang.setError("Harap Isi!");
                        etLebar.setError("Harap isi!");
                        etTinggi.setError("Harap isi!");
                    }else if (etPanjang.getText().toString().isEmpty() && etLebar.getText().toString().isEmpty()){
                        etPanjang.setError("Harap Isi!");
                        etLebar.setError("Harap isi!");
                    } else if (etPanjang.getText().toString().isEmpty() && etTinggi.getText().toString().isEmpty()){
                        etPanjang.setError("Harap Isi!");
                        etTinggi.setError("Harap isi!");
                    } else if (etLebar.getText().toString().isEmpty() && etTinggi.getText().toString().isEmpty()) {
                        etLebar.setError("Harap isi!");
                        etTinggi.setError("Harap isi!");
                    } else if (etPanjang.getText().toString().isEmpty()){
                        etPanjang.setError("Harap isi!");
                    } else if (etLebar.getText().toString().isEmpty()){
                        etLebar.setError("Harap isi!");
                    } else if (etTinggi.getText().toString().isEmpty()){
                        etTinggi.setError("Harap isi!");
                    } else {
                        Double panjang = Double.valueOf(etPanjang.getText().toString());
                        Double lebar = Double.valueOf(etLebar.getText().toString());
                        Double tinggi = Double.valueOf(etTinggi.getText().toString());
                        Double volBalok = (panjang * lebar * tinggi);
                        String duaFormat = String.format("%.2f", volBalok);
                        hasil.setText(duaFormat);
                    }
                }
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, geometry);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0 :
                        etJari2.setVisibility(View.VISIBLE);
                        etPanjang.setVisibility(View.GONE);
                        etLebar.setVisibility(View.GONE);
                        etTinggi.setVisibility(View.GONE);
                        break;
                    case 1 :
                        etJari2.setVisibility(View.VISIBLE);
                        etPanjang.setVisibility(View.GONE);
                        etLebar.setVisibility(View.GONE);
                        etTinggi.setVisibility(View.VISIBLE);
                        break;
                    case 2 :
                        etJari2.setVisibility(View.GONE);
                        etPanjang.setVisibility(View.VISIBLE);
                        etLebar.setVisibility(View.VISIBLE);
                        etTinggi.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }





}