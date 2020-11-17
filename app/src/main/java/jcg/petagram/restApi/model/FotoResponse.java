package jcg.petagram.restApi.model;

import java.util.ArrayList;

import jcg.petagram.pojo.Foto;

public class FotoResponse {

    ArrayList<Foto> fotos;

    public ArrayList<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<Foto> fotos) {
        this.fotos = fotos;
    }
}
