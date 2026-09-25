package com.example.meuappincrivel;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainIMC extends AppCompatActivity {

    int posicao=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.imc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Integer[] imagens= new Integer[]{R. drawable.cachorro, R. drawable.gardem, R. drawable.happy, R. drawable.porquinho, R. drawable.patinho };
        Button botaoVoltar, botaoAvancar;
        botaoVoltar = findViewById(R.id.btnAnterior);
        botaoAvancar = findViewById(R.id.btnProximo);
        ImageView imageView=findViewById(R.id.imageView);

        botaoAvancar.setOnClickListener(view -> {
            if(posicao > imagens.length) posicao = 0;
            imageView.setImageResource(imagens[posicao]);
            posicao++;
        });

        botaoVoltar.setOnClickListener(view -> {
            if(posicao < 0) posicao = -1;
            imageView.setImageResource(imagens[posicao]);
            posicao--;
        });

    }

}