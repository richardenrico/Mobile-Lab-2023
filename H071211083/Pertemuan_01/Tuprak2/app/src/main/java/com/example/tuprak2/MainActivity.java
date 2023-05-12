package com.example.tuprak2;

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

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private String[] Item = {"Bola", "Kerucut", "Balok"};
    TextView idjarijari, idpanjang, idtinggi, Hasil;
    EditText garisjarijari, garispanjang, garistinggi;
    Button Btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner List = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_dropdown_item, Item);
        List.setAdapter(adapter);

        idjarijari = findViewById(R.id.idjarijari);
        idpanjang = findViewById(R.id.idpanjang);
        idtinggi = findViewById(R.id.idtinggi);

        garisjarijari = findViewById(R.id.garisjarijari);
        garispanjang = findViewById(R.id.garispanjang);
        garistinggi = findViewById(R.id.garistinggi);

        Btn1 = findViewById(R.id.hitung);
        Hasil = findViewById(R.id.hasil);

        List.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
                if (selectedItem == "Kerucut") {
                    idtinggi.setVisibility(View.VISIBLE);
                    garistinggi.setVisibility(View.VISIBLE);
                    idpanjang.setVisibility(View.GONE);
                    garispanjang.setVisibility(View.GONE);
                    idjarijari.setText("Jari-jari");
                    idtinggi.setText("Tinggi");
                    Hasil.setText("Hasil");
                } else if (selectedItem == "Balok") {
                    idpanjang.setVisibility(View.VISIBLE);
                    garispanjang.setVisibility(View.VISIBLE);
                    idtinggi.setVisibility(View.VISIBLE);
                    garistinggi.setVisibility(View.VISIBLE);
                    idjarijari.setText("Lebar");
                    idpanjang.setText("Panjang");
                    idtinggi.setText("Tinggi");
                    Hasil.setText("Hasil");
                } else {
                    idpanjang.setVisibility(View.GONE);
                    garispanjang.setVisibility(View.GONE);
                    idtinggi.setVisibility(View.GONE);
                    garistinggi.setVisibility(View.GONE);
                    idjarijari.setText("Jari-jari");
                    Hasil.setText("Hasil");
                }
                Toast.makeText(getApplicationContext(), adapter.getItem(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = garisjarijari.getText().toString();
                String text2 = garispanjang.getText().toString();
                String text3 = garistinggi.getText().toString();

                    String selectedItem = List.getSelectedItem().toString();
                    double nilai1, nilai2, nilai3, hasil;
                    if (selectedItem == "Bola") {
                        if (text1.isEmpty()) {
                            garisjarijari.setError("Harap isi");
                        }else {
                            nilai1 = Double.parseDouble(garisjarijari.getText().toString());
                            hasil = (4.00 / 3.00) * Math.PI * Math.pow(nilai1, 3);

                            Hasil.setText(String.format("%.2f", hasil));
                        }
                    } else if (selectedItem == "Kerucut") {
                        if (text1.isEmpty() && text3.isEmpty()) {
                            garisjarijari.setError("Harap isi");
                            garistinggi.setError("Harap isi");
                        }else if (text1.isEmpty()){
                            garisjarijari.setError("harap isi");
                        }else if (text2.isEmpty()){
                        garispanjang.setError("harap isi");
                        }else {
                        nilai1 = Double.parseDouble(garisjarijari.getText().toString());
                        nilai3 = Double.parseDouble(garistinggi.getText().toString());
                        hasil = (Math.PI * nilai1 * nilai1 * nilai3) / 3.00;

                        Hasil.setText(String.format("%.2f", hasil));
                        }
                    } else {
                        if (text1.isEmpty() && text2.isEmpty() && text3.isEmpty()) {
                            garisjarijari.setError("Harap isi");
                            garispanjang.setError("harap isi");
                            garistinggi.setError("harap isi");
                        } else if (text1.isEmpty() && text2.isEmpty()) {
                            garisjarijari.setError("harap isi");
                            garispanjang.setError("harap isi");
                        } else if (text2.isEmpty() && text3.isEmpty()) {
                            garispanjang.setError("harap isi");
                            garistinggi.setError("harap isi");
                        } else if (text3.isEmpty() && text1.isEmpty()) {
                            garistinggi.setError("harap isi");
                            garisjarijari.setError("harap isi");
                        } else if (text1.isEmpty()) {
                            garisjarijari.setError("harap isi");
                        } else if (text2.isEmpty()) {
                            garispanjang.setError("harap isi");
                        } else if (text3.isEmpty()) {
                            garistinggi.setError("harap isi");
                        } else {
                            nilai1 = Double.parseDouble(garisjarijari.getText().toString());
                            nilai2 = Double.parseDouble(garispanjang.getText().toString());
                            nilai3 = Double.parseDouble(garistinggi.getText().toString());
                            hasil = nilai1 * nilai2 * nilai3;

                            Hasil.setText(String.format("%.2f", hasil));

                        }
                    }
                }

        });
    }
}