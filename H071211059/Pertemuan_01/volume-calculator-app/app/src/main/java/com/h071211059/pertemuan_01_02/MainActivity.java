package com.h071211059.pertemuan_01_02;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.h071211059.pertemuan_01_02.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    int selectedShape;
    List<Float> inputs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        final TextView resultText = (TextView) findViewById(R.id.hasil);

        binding.shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                clearInput();
                switch (i) {
                    case 0:
                        binding.hasil.setVisibility(View.GONE);
                        binding.calc.setVisibility(View.GONE);
                        binding.radiusView.setVisibility(View.GONE);
                        binding.lengthView.setVisibility(View.GONE);
                        binding.widthView.setVisibility(View.GONE);
                        binding.heightView.setVisibility(View.GONE);
                        break;
                    case 1:
                        binding.hasil.setVisibility(View.VISIBLE);
                        binding.calc.setVisibility(View.VISIBLE);
                        binding.radiusView.setVisibility(View.VISIBLE);
                        binding.radius.setError(null);
                        binding.lengthView.setVisibility(View.GONE);
                        binding.widthView.setVisibility(View.GONE);
                        binding.heightView.setVisibility(View.GONE);
                        selectedShape = 1;
                        break;
                    case 2:
                        binding.hasil.setVisibility(View.VISIBLE);
                        binding.calc.setVisibility(View.VISIBLE);
                        binding.radiusView.setVisibility(View.VISIBLE);
                        binding.lengthView.setVisibility(View.GONE);
                        binding.widthView.setVisibility(View.GONE);
                        binding.heightView.setVisibility(View.VISIBLE);
                        binding.radius.setError(null);
                        binding.height.setError(null);
                        selectedShape = 2;
                        break;
                    case 3:
                        binding.hasil.setVisibility(View.VISIBLE);
                        binding.calc.setVisibility(View.VISIBLE);
                        binding.radiusView.setVisibility(View.GONE);
                        binding.lengthView.setVisibility(View.VISIBLE);
                        binding.widthView.setVisibility(View.VISIBLE);
                        binding.heightView.setVisibility(View.VISIBLE);
                        binding.length.setError(null);
                        binding.width.setError(null);
                        binding.height.setError(null);
                        selectedShape = 3;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.calc.setOnClickListener(view -> {
            float r, l, w, h;
            System.out.println("clikced");

            inputs = new ArrayList<>();
            binding.hasil.setText("Hasil = ");
            if (selectedShape == 1) {
                if (filterInput(binding.radius)) return;

                r = Float.parseFloat(binding.radius.getText().toString());

                inputs.add(r);

                binding.hasil.append(String.valueOf(calculateResult(inputs, selectedShape)));
            }

            if (selectedShape == 2) {
                if (filterInput(binding.radius)) {
                    if (filterInput(binding.height)) return;
                    return;
                } else if (filterInput(binding.height)) return;
                r = Float.parseFloat(binding.radius.getText().toString());
                h = Float.parseFloat(binding.height.getText().toString());

                inputs.add(r);
                inputs.add(h);

                binding.hasil.setText("Hasil = " + calculateResult(inputs, selectedShape));

            }

            if (selectedShape == 3) {
                if (filterInput(binding.length)) {
                    if (filterInput(binding.width)) {
                        if (filterInput(binding.height)) return;
                        return;
                    }
                    return;
                } else if (filterInput(binding.width)) {
                    if (filterInput(binding.height)) return;
                    return;
                } else if (filterInput(binding.height)) return;

                l = Float.parseFloat(binding.length.getText().toString());
                w = Float.parseFloat(binding.width.getText().toString());
                h = Float.parseFloat(binding.height.getText().toString());

                inputs.add(l);
                inputs.add(w);
                inputs.add(h);

                binding.hasil.append(String.valueOf(calculateResult(inputs, selectedShape)));
            }
        });

    }

    /**
     * Clear all input
     */
    private void clearInput() {
        binding.hasil.setText("Hasil = ");
        binding.radius.setText("");
        binding.length.setText("");
        binding.width.setText("");
        binding.height.setText("");
    }

    /**
     * Calculate the result
     *
     * @param inputs list of input
     * @param shape selected shape
     * @return result of calculation
     */
    private float calculateResult(List<Float> inputs, int shape) {
        float result = 0.0f;
        switch (shape) {
            case 1:
                result = (float) ((4.0 / 3) * Math.PI * Math.pow(inputs.get(0), 3.0));
                break;
            case 2:
                result = (float) ((1.0 / 3) * Math.PI * Math.pow(inputs.get(0), 2) * inputs.get(1));
                break;
            case 3:
                result = inputs.get(0) * inputs.get(1) * inputs.get(2);
                break;
        }
        return result;
    }

    /**
     * Filter input
     *
     * @param input input to be filtered
     * @return true if input is empty, false otherwise
     */
    private boolean filterInput(EditText input) {
        if (input.getText().toString().equals("")) {
            input.setError("Field tidak boleh kosong!");
            return true;
        }
        return false;
    }
}