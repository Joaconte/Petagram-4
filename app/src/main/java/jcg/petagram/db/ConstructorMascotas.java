package jcg.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import jcg.petagram.pojo.Mascota;

public class ConstructorMascotas {

    BaseDatos db;

    public ConstructorMascotas(Context context) {

        db = new BaseDatos(context);
    }

    public ArrayList<Mascota> obtenerDatos(){

        return db.obtenerMascotasFavoritas();
    }

    public void insertarMascotas( ArrayList<Mascota> mascotas ) {


        db.deleteDB();

        ContentValues contentValues;

        for ( int i = 0 ; i < mascotas.size(); i++){

            contentValues = cargarContentValue( mascotas.get( i ) );
            db.insertarMascota(contentValues);
        }
    }

    private ContentValues cargarContentValue( Mascota mascota ){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, mascota.getNombre());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, mascota.getFoto());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, mascota.getLikes());

        return contentValues;
    }

}
