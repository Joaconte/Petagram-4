package jcg.petagram.vista.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jcg.petagram.R;
import jcg.petagram.adapter.MascotaAdaptador;
import jcg.petagram.pojo.Mascota;
import jcg.petagram.presentador.IMascotasFavoritasActivityPresenter;
import jcg.petagram.presentador.MascotasFavoritasActivityPresenter;

public class MascotasFavoritasActivity extends AppCompatActivity implements IMascotasFavoritasActivityView {

    private RecyclerView listaMascotas;
    private IMascotasFavoritasActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        toolbarSupport();

        listaMascotas = findViewById(R.id.rvMascotasFavoritasActivity);

        ArrayList<Mascota> mascotas = getIntent().getParcelableArrayListExtra("mascotas");

        presenter = new MascotasFavoritasActivityPresenter(this, this, mascotas);

    }

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {

        return new MascotaAdaptador(mascotas, this);
    }

    @Override
    public void inicializarAdaptador(MascotaAdaptador adaptador){

        listaMascotas.setAdapter(adaptador);
    }

    public void toolbarSupport(){

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent;

        switch (item.getItemId()){
            case R.id.mContacto:
                intent = new Intent(this, FormularioActivity.class);
                startActivity(intent);
                break;

            case R.id.mAcercaDe:
                intent = new Intent(this, BiografiaAutorActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}