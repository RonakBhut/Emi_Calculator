package com.example.android_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnCalculate;
    EditText edtAmount,edtRate,edtYear;
    private TextView txtTotalInterest,txtTotalEMI,txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBinding();
        initClick();

    }

    void initBinding() {
        btnCalculate = findViewById(R.id.btnCalculate);
        edtAmount = findViewById(R.id.edtAmount);
        edtRate = findViewById(R.id.edtRate);
        edtYear = findViewById(R.id.edtYear);

        txtTotalInterest=findViewById(R.id.txtTotalInterest);
        txtTotalEMI=findViewById(R.id.txtTotalEMI);
        txtTotal=findViewById(R.id.txtTotal);
    }

    void initClick() {

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amountData =  edtAmount.getText().toString();
                String rateData =  edtRate.getText().toString();
                String yearData =  edtYear.getText().toString();


                 int amount = Integer.parseInt(amountData);
                 int rate = Integer.parseInt(rateData);
                 int year = Integer.parseInt(yearData);


                   // (P*R*N)/100 = INTEREST
                  int interest = (amount*rate*year)/100;
                   // (AMOUNT+ INTEREST) = MONTHLY EMI
                  int emi = (amount+interest)/(year*12);
                  // AMOUNT+ INTEREST = TOTAL
                  int total = amount + interest;

                  txtTotalInterest.setText(""+interest);
                  txtTotalEMI.setText(""+emi);
                  txtTotal.setText(""+total);

            }
        });

    }


}