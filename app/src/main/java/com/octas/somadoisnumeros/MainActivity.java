package com.octas.somadoisnumeros;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText n1text, n2text;
    private int n1, n2;

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

        Button buttonEnviar = findViewById(R.id.btnEnviar);
        n1text = findViewById(R.id.n1);
        n2text = findViewById(R.id.n2);


        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String valor1 = n1text.getText().toString();
               n1 = Integer.parseInt(valor1);

                String valor2 = n2text.getText().toString();
                n2 = Integer.parseInt(valor2);

                Intent intent = new Intent(getApplicationContext(), Resultado.class);

                intent.putExtra("n1", n1);
                intent.putExtra("n2", n2);

                startActivity(intent);
            }
        });

    }
}