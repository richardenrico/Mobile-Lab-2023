package com.example.tugasandroid1pt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Spinner pilihan;
    ViewFlipper konten;
    EditText jariBola,jariKerucut,tinggiKerucut,panjangBalok,tinggiBalok,lebarBalok;
    Button hitung;
    String bangunRuang;
    TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pilihan = (Spinner) findViewById(R.id.pilihan);
        konten = (ViewFlipper) findViewById(R.id.konten);
        hitung = (Button) findViewById(R.id.hitung);
        hasil = (TextView) findViewById(R.id.hasil);
        pilihan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bangunRuang  = pilihan.getSelectedItem().toString();
                switch (bangunRuang) {
                    case "Bola":
                        konten.setDisplayedChild(0);
                        break;
                    case "Kerucut":
                        konten.setDisplayedChild(1);
                        break;
                    case "Balok":
                        konten.setDisplayedChild(2);
                        break;
                    default:
                        konten.setDisplayedChild(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double volume = 0.0;
                float j, t, l, p;
                bangunRuang = pilihan.getSelectedItem().toString();
                switch (bangunRuang) {
                    case "Bola":
                        jariBola = (EditText) findViewById(R.id.jari_bola);
                        if (jariBola.getText().toString().isEmpty()) {
                            jariBola.setError("empty");
                            // show an error message or disable the button
                        } else {
                            hitung.setEnabled(true);
                            j = (float) Integer.parseInt(jariBola.getText().toString());
                            volume = 4.0 / 3.0 * Math.PI * Math.pow(j, 3);
                            hasil.setText(String.valueOf(volume));
                        }
                        break;
                    case "Kerucut":
                        jariKerucut = (EditText) findViewById(R.id.jari_kerucut);
                        tinggiKerucut = (EditText) findViewById(R.id.tinggi_kerucut);
                        if (jariKerucut.getText().toString().isEmpty()) {
                            jariKerucut.setError("empty");
                        }
                        if (tinggiKerucut.getText().toString().isEmpty()) {
                            tinggiKerucut.setError("empty");
                        }
                        if (!jariKerucut.getText().toString().isEmpty() && !tinggiKerucut.getText().toString().isEmpty()) {
                            j = (float) Integer.parseInt(jariKerucut.getText().toString());
                            t = (float) Integer.parseInt(tinggiKerucut.getText().toString());
                            volume = 1.0 / 3.0 * Math.PI * Math.pow(j, 2) * t;
                            hasil.setText(String.valueOf(volume));
                        }
                        break;
                    case "Balok":
                        panjangBalok = (EditText) findViewById(R.id.panjang_balok);
                        lebarBalok = (EditText) findViewById(R.id.lebar_balok);
                        tinggiBalok = (EditText) findViewById(R.id.tinggi_balok);
                        if (panjangBalok.getText().toString().isEmpty()) {
                            panjangBalok.setError("empty");
                        }
                        if (lebarBalok.getText().toString().isEmpty()) {
                            lebarBalok.setError("empty");
                        }
                        if (tinggiBalok.getText().toString().isEmpty()) {
                            tinggiBalok.setError("empty");
                        }
                        if (!panjangBalok.getText().toString().isEmpty()
                                && !lebarBalok.getText().toString().isEmpty()
                                && !tinggiBalok.getText().toString().isEmpty()) {
                            p = (float) Integer.parseInt(panjangBalok.getText().toString());
                            l = (float) Integer.parseInt(lebarBalok.getText().toString());
                            t = (float) Integer.parseInt(tinggiBalok.getText().toString());
                            volume = p * l * t;
                            hasil.setText(String.valueOf(volume));
                        }
                        break;
                    default:

                }
            }
        });
    }
}