package jcg.petagram.pojo;

import java.util.ArrayList;


public class ListaIdMascotasFavoritas extends ArrayList<Integer>{

    private static final Integer LIMITE = 5;

    public ListaIdMascotasFavoritas() { }

    public void agregarIdMascota(Integer id) {

        if ( pertenece( id ) ) {
            remove(id);

        }else if (size() == LIMITE){
            remove(4);
        }

        add(0, id);
    }

    public boolean pertenece(Integer id) {

        boolean pertenece = false;

        for (int i = 0; i < size(); i++) {
            if (get(i).equals(id))
                pertenece = true;
        }

        return pertenece;
    }

}