package com.example.hp.musicshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.ToIntFunction;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    int quantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    HashMap goodsMap;
    String goodsName;
    double price;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CreateSpinner();
        CreateMap();
    }

    void CreateSpinner()
    {
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();

        spinnerArrayList.add("Guitar");
        spinnerArrayList.add("Violin");
        spinnerArrayList.add("Sax");
        spinnerArrayList.add("Banjo");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }


    void CreateMap()
    {
        goodsMap = new HashMap();
        goodsMap.put("Guitar", 500.0);
        goodsMap.put("Violin",400.0);
        goodsMap.put("Sax",1500.0);
        goodsMap.put("Banjo",250.0);
    }

    public void increaseQuantityValue(View view) {
        quantity = quantity + 1;
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText(""+quantity);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    public void decreaseQuantityValue(View view) {
        quantity = quantity - 1;
        if (quantity < 0)
        {
            quantity = 0;
        }
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText(""+quantity);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double)goodsMap.get(goodsName);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
        ImageView goodsImageView = findViewById(R.id.goodsImageView);

        switch (goodsName)
        {
            case "Guitar":
                goodsImageView.setImageResource(R.drawable.guitar);
                break;
            case "Violin":
                goodsImageView.setImageResource(R.drawable.violin);
                break;
            case "Sax":
                goodsImageView.setImageResource(R.drawable.sax);
                break;
            case "Banjo":
                goodsImageView.setImageResource(R.drawable.banjo);
                break;
            default:
                goodsImageView.setImageResource(R.drawable.guitar);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
