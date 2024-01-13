package com.example.calculoimc;

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

                double IMC = (weight / (height * height));

                result.setText(String.valueOf(IMC));
                result.setVisibility(View.VISIBLE);

                if (IMC < 20) {
                    classe = "abaixo do peso";
                } else if (IMC < 25) {
                    classe = "normal";
                } else if (IMC < 30) {
                    classe = "sobrepeso";
                } else if (IMC < 35) {
                    classe = "obesidade 1";
                } else{
                    classe = "obesidade 2";
                }

                classification.setText(classe);
                classification.setVisibility(View.VISIBLE);
            }
        });


    }
}