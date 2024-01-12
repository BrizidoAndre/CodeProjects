package com.example.conversormoedas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import com.example.conversormoedas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private TextView result;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Começa aqui

        result = findViewById(R.id.txt_result);

        Button btn_convert = findViewById(R.id.btn_convert);

        btn_convert.setOnClickListener(new View.OnClickListener() {

            public void convert() {
                RadioGroup radioOption = findViewById(R.id.radioOption);

                int selected = radioOption.getCheckedRadioButtonId();
                EditText input_value = findViewById(R.id.input_value);

                double converted_value = 0.0;

                double getValue;
                getValue = Double.parseDouble(input_value.getText().toString());

                if (selected == R.id.radio_usd) {
                    converted_value = getValue / 4.87;
                } else if (selected == R.id.radio_eur) {
                    converted_value = getValue / 5.35;
                } else{
                    converted_value = getValue / 0.0054;
                }
                result.setText(String.valueOf(converted_value));
                result.setVisibility(View.VISIBLE);
            }

            @Override
            public void onClick(View v) {
                convert();
            }

        });

    }
}