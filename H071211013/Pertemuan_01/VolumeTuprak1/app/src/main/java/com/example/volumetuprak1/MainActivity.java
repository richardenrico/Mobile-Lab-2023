package com.example.volumetuprak1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView jari,panjang,lebar,tinggi,hasil;
    private EditText isijari,isipanjang,isilebar,isitinggi;
    private Spinner list;
    private Button hitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jari = findViewById(R.id.jari);
        isijari = findViewById(R.id.isijari);
        panjang = findViewById(R.id.panjang);
        isipanjang = findViewById(R.id.isipanjang);
        lebar = findViewById(R.id.lebar);
        isilebar = findViewById(R.id.isilebar);
        tinggi = findViewById(R.id.tinggi);
        isitinggi = findViewById(R.id.isitinggi);
        list = findViewById(R.id.list);
        hitung = findViewById(R.id.hitung);
        hasil = findViewById(R.id.hasil);

        String selectedValue = list.getSelectedItem().toString();
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 1:
                        jari.setVisibility(View.VISIBLE);
                        isijari.setVisibility(View.VISIBLE);
                        panjang.setVisibility(View.GONE);
                        isipanjang.setVisibility(View.GONE);
                        lebar.setVisibility(View.GONE);
                        isilebar.setVisibility(View.GONE);
                        tinggi.setVisibility(View.VISIBLE);
                        isitinggi.setVisibility(View.VISIBLE);
                        hitung.setVisibility(View.VISIBLE);
                        hasil.setVisibility(View.VISIBLE);
                        hasil.setText("");
                        isijari.setError(null);
                        isitinggi.setError(null);

                        hitung.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String jari = isijari.getText().toString();
                                String tinggi = isitinggi.getText().toString();

                                if (jari.isEmpty() && tinggi.isEmpty()){
                                    isijari.setError("Mohon di isi dahulu");
                                    isitinggi.setError("Mohon di isi dahulu");
                                } else if (jari.isEmpty()){
                                    isijari.setError("Mohon di isi dahulu");
                                } else if (tinggi.isEmpty()){
                                    isitinggi.setError("Mohon di isi dahulu");
                                } else {
                                    double jariKerucut = Double.parseDouble(jari);
                                    double tinggiKerucut = Double.parseDouble(tinggi);
                                    double volume = (1.0/3.0) * Math.PI * Math.pow(jariKerucut,2) * tinggiKerucut;
                                    hasil.setText(String.format("%.2f",volume));
                                }
                            }
                        });
                        break;

                    case 2:
                        jari.setVisibility(View.GONE);
                        isijari.setVisibility(View.GONE);
                        panjang.setVisibility(View.VISIBLE);
                        isipanjang.setVisibility(View.VISIBLE);
                        lebar.setVisibility(View.VISIBLE);
                        isilebar.setVisibility(View.VISIBLE);
                        tinggi.setVisibility(View.VISIBLE);
                        isitinggi.setVisibility(View.VISIBLE);
                        hitung.setVisibility(View.VISIBLE);
                        hasil.setVisibility(View.VISIBLE);
                        hasil.setText("");
                        isipanjang.setError(null);
                        isilebar.setError(null);
                        isitinggi.setError(null);

                        hitung.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String panjang = isipanjang.getText().toString();
                                String lebar = isilebar.getText().toString();
                                String tinggi = isitinggi.getText().toString();
                                if (panjang.isEmpty() && lebar.isEmpty() && tinggi.isEmpty()){
                                    isipanjang.setError("Mohon di isi dahulu");
                                    isilebar.setError("Mohon di isi dahulu");
                                    isitinggi.setError("Mohon di isi dahulu");
                                } else if (panjang.isEmpty() && lebar.isEmpty()){
                                    isipanjang.setError("Mohon di isi dahulu");
                                    isilebar.setError("Mohon di isi dahulu");
                                } else if (lebar.isEmpty() && tinggi.isEmpty()){
                                    isilebar.setError("Mohon di isi dahulu");
                                    isitinggi.setError("Mohon di isi dahulu");
                                } else if (panjang.isEmpty() && tinggi.isEmpty()){
                                    isipanjang.setError("Mohon di isi dahulu");
                                    isitinggi.setError("Mohon di isi dahulu");
                                } else if (panjang.isEmpty()){
                                    isipanjang.setError("Mohon di isi dahulu");
                                } else if (lebar.isEmpty()){
                                    isilebar.setError("Mohon di isi dahulu");
                                } else if (tinggi.isEmpty()){
                                    isitinggi.setError("Mohon di isi dahulu");
                                } else {
                                    double panjangBalok = Double.parseDouble(panjang);
                                    double lebarBalok = Double.parseDouble(lebar);
                                    double tinggiBalok = Double.parseDouble(tinggi);
                                    double volume = panjangBalok * lebarBalok * tinggiBalok;
                                    hasil.setText(String.format("%.2f",volume));
                                }
                            }
                        });
                        break;

                    case 3:
                        jari.setVisibility(View.VISIBLE);
                        isijari.setVisibility(View.VISIBLE);
                        panjang.setVisibility(View.GONE);
                        isipanjang.setVisibility(View.GONE);
                        lebar.setVisibility(View.GONE);
                        isilebar.setVisibility(View.GONE);
                        tinggi.setVisibility(View.GONE);
                        isitinggi.setVisibility(View.GONE);
                        hitung.setVisibility(View.VISIBLE);
                        hasil.setVisibility(View.VISIBLE);
                        hasil.setText("");
                        isijari.setError(null);

                        hitung.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String jari = isijari.getText().toString();

                                if (jari.isEmpty()){
                                    isijari.setError("Mohon di isi dahulu");
                                } else {
                                    double jariBola = Double.parseDouble(jari);
                                    double volume = (4.00/3.00) * Math.PI * Math.pow(jariBola,3);
                                    hasil.setText(String.format("%.2f", volume));
                                }
                            }
                        });
                        break;

                    case 0:
                        jari.setVisibility(View.GONE);
                        isijari.setVisibility(View.GONE);
                        panjang.setVisibility(View.GONE);
                        isipanjang.setVisibility(View.GONE);
                        lebar.setVisibility(View.GONE);
                        isilebar.setVisibility(View.GONE);
                        tinggi.setVisibility(View.GONE);
                        isitinggi.setVisibility(View.GONE);
                        hitung.setVisibility(View.GONE);
                        hasil.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}