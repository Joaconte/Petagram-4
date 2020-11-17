package jcg.petagram.restApi.model;

import jcg.petagram.pojo.Foto;
import jcg.petagram.pojo.Mascota;

public class PerfilResponse {

    Mascota mascota;
    Foto foto;

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }
}
