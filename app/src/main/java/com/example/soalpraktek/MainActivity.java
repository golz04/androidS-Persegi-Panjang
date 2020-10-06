package com.example.soalpraktek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private double panjang, lebar, hasil;
    EditText txbPanjang, txbLebar, txbHasil;
    Button btnHitung, btnClear;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_option, menu);
        return true;
    }
    public boolean onOptionItemSelected(MenuItem menu)
    {
        if (menu.getItemId() == R.id.menuClear)
        {
            Toast.makeText(getApplicationContext(), "Halo", Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txbPanjang = (EditText)findViewById(R.id.txbPanjang);
        txbLebar = (EditText)findViewById(R.id.txbLebar);
        txbHasil = (EditText)findViewById(R.id.txbHasil);
        btnHitung = (Button)findViewById(R.id.btnHitung);
        btnClear = (Button)findViewById(R.id.btnClear);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txbPanjang.getText().length() > 0 && txbLebar.getText().length() > 0)
                {
                    panjang = Double.parseDouble(txbPanjang.getText().toString());
                    lebar = Double.parseDouble(txbLebar.getText().toString());
                    hasil = panjang * lebar;

                    txbHasil.setText(Double.toString(hasil));
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Panjang dan Lebar tidak boleh kosong !", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txbPanjang.setText("");
                txbLebar.setText("");
                txbHasil.setText("0");
                txbPanjang.requestFocus();
            }
        });
    }
}