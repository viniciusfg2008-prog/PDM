package com.example.applicativo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nomes = new ArrayList<>();
        ListView listanomes = findViewById(R.id.listView);
        ArrayAdapter<String> usb = new ArrayAdapter<>(getApplicationContext(),
                R.layout.listaitens, R.id.textView, nomes);
        listanomes.setAdapter(usb);

        listanomes.setOnItemClickListener((adapterView, view, position, id) ->
                Toast.makeText(getApplicationContext(), nomes.get(position), Toast.LENGTH_LONG).show());

        Button b = findViewById(R.id.b);
        EditText ed = findViewById(R.id.ed);

        b.setOnClickListener(view -> {
            String nome = ed.getText().toString().trim();
            if (!nome.isEmpty()) {
                nomes.add(nome);
                usb.notifyDataSetChanged();
                ed.setText("");
            }
        });
    }
}
