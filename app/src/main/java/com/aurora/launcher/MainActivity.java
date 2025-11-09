package com.aurora.launcher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    MediaPlayer musica;
    ImageView logo, personagem;
    Button btnConectar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.logo);
        personagem = findViewById(R.id.personagem);
        btnConectar = findViewById(R.id.btnConectar);

        // Música de fundo
        musica = MediaPlayer.create(this, R.raw.musica_fundo);
        musica.setLooping(true);
        musica.start();

        // Animação inicial
        logo.setAlpha(0f);
        personagem.setAlpha(0f);

        logo.animate().alpha(1f).setDuration(2000).start();
        personagem.animate().alpha(1f).setDuration(2000).start();

        // Mostrar botão de conectar após 3 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btnConectar.setVisibility(View.VISIBLE);
                btnConectar.animate().alpha(1f).setDuration(1000).start();
            }
        }, 3000);

        // Botão conectar SAMP
        btnConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("samp://188.165.192.24:5644"));
                startActivity(intent);
            }
        });
    }
}
