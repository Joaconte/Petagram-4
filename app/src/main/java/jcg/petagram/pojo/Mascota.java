package jcg.petagram.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Mascota implements Parcelable {

    private Integer id;
    private String nombre;
    private int foto;
    private int cantidadDeMeGusta;

    public Mascota(String nombre, int foto, int cantidadDeMeGusta, int id) {
        this.nombre = nombre;
        this.foto = foto;
        this.cantidadDeMeGusta = cantidadDeMeGusta;
        this.id = id;
    }

    public Mascota(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
    }

    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    public Mascota() {
    }

    public String getNombre() {
        return nombre;
    }

    public int getFoto() {
        return foto;
    }

    public int getLikes() {
        return cantidadDeMeGusta;
    }

    public Integer getId() {
        return id;
    }

    public void agregarLike() {
        cantidadDeMeGusta++;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void setLikes(int likes) {
        this.cantidadDeMeGusta = likes;
    }


    protected Mascota(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        nombre = in.readString();
        foto = in.readInt();
        cantidadDeMeGusta = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(nombre);
        dest.writeInt(foto);
        dest.writeInt(cantidadDeMeGusta);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Mascota> CREATOR = new Creator<Mascota>() {
        @Override
        public Mascota createFromParcel(Parcel in) {
            return new Mascota(in);
        }

        @Override
        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };

}