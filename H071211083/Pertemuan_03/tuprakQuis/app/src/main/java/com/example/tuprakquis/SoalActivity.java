package com.example.tuprakquis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.tuprakquis.databinding.ActivitySoalBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SoalActivity extends AppCompatActivity {

    private ActivitySoalBinding binding;
    private Soal soal;
    private List<Soal> quiz = new ArrayList<>();
    private TextView[] tvOpsi;
    private CardView[] cvOpsi;
    private int indexSekarang = 0;
    private int score = 0;
    private boolean stop = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySoalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        quiz = generateSoal();
        System.out.println(quiz.get(0).getPertanyaan());
        tvOpsi = new TextView[]{
                binding.opsi1, binding.opsi2, binding.opsi3, binding.opsi4
        };
        cvOpsi = new CardView[]{
                binding.cvopsi1, binding.cvopsi2, binding.cvopsi3, binding.cvopsi4
        };
        renderSoal();
        tvOpsi [0].setOnClickListener(v -> onOpsiClicked (0));
        tvOpsi [1].setOnClickListener(v -> onOpsiClicked (1));
        tvOpsi [2].setOnClickListener(v -> onOpsiClicked (2));
        tvOpsi [3].setOnClickListener(v -> onOpsiClicked (3));
    }

    private void onOpsiClicked(int i) {
        if (stop){
            stop = false;
            soal = quiz.get(indexSekarang);
            boolean kosong = i == soal.getBenar();

            if (kosong){
                cvOpsi [i].setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.green)));
            }else {
                cvOpsi [i].setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.red)));
            }

            if (kosong){
                score += soal.getScore();
            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    indexSekarang ++;
                    renderSoal();
                    if (indexSekarang == 4){
                        User user = getIntent().getParcelableExtra(ScoreActivity.EXTRA_USER);
                        Intent intent = new Intent(getApplicationContext(), ScoreActivity.class);
                        intent.putExtra(ScoreActivity.EXTRA_SCORE, score);
                        intent.putExtra(ScoreActivity.EXTRA_USER, user);
                        startActivity(intent);
                    }
                }
            }, 1000);

        }


    }


    private void renderSoal(){
        stop = true;
        soal = quiz.get(indexSekarang);
        binding.nomor.setText(String.format("Quis, %d of 5", indexSekarang + 1));
        binding.pertanyaan.setText(soal.getPertanyaan());
        for (int i = 0; i < tvOpsi.length; i++) {
            tvOpsi[i].setText(String.valueOf(soal.getOpsi()[i]));
            cvOpsi [i].setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.cincau)));
        }

    }
    private List<Soal> generateSoal(){
        quiz.add(new Soal("Apa yang dimaksud seni patung?", new String[]{"Seni membuat gambar dengan pensil","Seni membuat patung dari tanah liat, kayu, atau batu","Seni membuat patung dari kain dan kawat", "Seni membuat patung dari kertas" }, 1, 25));
        quiz.add(new Soal("Apa yang dimaksud dengan seni rupa?", new String[]{"Bentuk seni yang mencakup karya seni dua dimensi dan tiga dimensi","Bentuk seni yang melibatkan penampilan langsung oleh seniman di depan penonton","Bentuk seni yang mencakup musik, tari, dan teater", "Bentuk seni yang mencakup penggambaran cerita dalam bentuk kata" }, 0, 30));
        quiz.add(new Soal("Siapa seniman terkenal yang dikenal karena karya lukisannya?", new String[]{"Mozart","William Shakespeare","Isaac Newton", "Pablo Picasso" }, 3, 35));
        quiz.add(new Soal("Apa yang dimaksud dengan seni performatif?", new String[]{" Bentuk seni yang mencakup musik, tari, dan teater"," Bentuk seni yang melibatkan penampilan langsung oleh seniman di depan penonton","Bentuk seni yang mencakup karya seni dua dimensi dan tiga dimensi", "Bentuk seni yang mencakup penggambaran cerita dalam bentuk kata" }, 1, 25));
        quiz.add(new Soal("Apa yang dimaksud dengan teknik seni batik?", new String[]{"Teknik melukis dengan menggunakan cat minyak","Teknik membuat patung dari bahan tanah liat","Teknik menghias kain dengan cara mengecat bagian kain tertentu dengan malam", "Teknik menggambar dengan menggunakan tinta dan kuas" }, 2, 20));
        quiz.add(new Soal("Apa yang dimaksud dengan seni abstrak?", new String[]{"Bentuk seni yang mencakup musik, tari, dan teater","Bentuk seni yang mencakup karya seni dua dimensi dan tiga dimensi","Bentuk seni yang tidak merepresentasikan objek atau figur yang dapat dikenali", "Bentuk seni yang mencakup penggambaran cerita dalam bentuk kata" }, 2, 20));
        Collections.shuffle(quiz);
        return quiz.subList(0, 5);
    }
}