package jcg.petagram.vista.activity;

import androidx.appcompat.app.AppCompatActivity;
import jcg.petagram.R;
import jcg.petagram.pojo.JavaMailAPI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class FormularioActivity extends AppCompatActivity {

    TextInputEditText tietNombre;
    TextInputEditText tietEmail;
    TextInputEditText tietComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        tietNombre        = findViewById(R.id.tietNombre);
        tietEmail         = findViewById(R.id.tietEmail);
        tietComentario    = findViewById(R.id.tietComentario);

    }

    public void enviarComentario(View view) {

        String nombre = tietNombre.getText().toString();
        String email = tietEmail.getText().toString();
        String comentario = tietComentario.getText().toString();

        new JavaMailAPI(email, nombre, comentario, this);

    }
}