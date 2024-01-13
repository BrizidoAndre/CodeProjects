package com.example.calculoimc;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.calculoimc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private TextView classification;

    private String classe;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        result = findViewById(R.id.txt_result);
        classification =(TextView) findViewById(R.id.txt_classification);

        Button btn_calculate = findViewById(R.id.btn_calculate);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }


            public void calculate() {

                EditText input_height = findViewById(R.id.input_height);
                EditText input_weight = findViewById(R.id.input_weight);

                double height = Double.parseDouble(input_height.getText().toString());
                double weight = Double.parseDouble(input_weight.getText().toString());

                double IMC = weight / (height * height);

                result.setText(String.valueOf(IMC));
                result.setVisibility(View.VISIBLE);

                if (IMC < 20) {
                    classe = "Abaixo do peso";
                    classification.setTextColor(Color.parseColor("#50bfdb"));
                } else if (IMC < 25) {
                    classe = "Normal";
                    classification.setTextColor(Color.parseColor("#000000"));
                } else if (IMC < 30) {
                    classe = "Sobrepeso";
                    classification.setTextColor(Color.parseColor("#f98404"));
                } else if (IMC < 35) {
                    classe = "Obesidade 1";
                    classification.setTextColor(Color.parseColor("#fc5404"));
                } else{
                    classe = "Obesidade 2";
                    classification.setTextColor(Color.parseColor("#f2372e"));

                }

                classification.setText(classe);
                classification.setVisibility(View.VISIBLE);
            }
        });


    }
}