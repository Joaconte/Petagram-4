package jcg.petagram.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Foto implements Parcelable {

    public String foto;
    public int cantidadDeMeGusta;

    public Foto(String foto, int cantidadDeMeGusta) {
        this.foto = foto;
        this.cantidadDeMeGusta = cantidadDeMeGusta;
    }

    public Foto(String foto) {
        this.foto = foto;
    }

    public Foto() {}

    public static final Creator<Foto> CREATOR = new Creator<Foto>() {
        @Override
        public Foto createFromParcel(Parcel in) {
            return new Foto(in);
        }

        @Override
        public Foto[] newArray(int size) {
            return new Foto[size];
        }
    };

    protected Foto(Parcel in) {
        foto = in.readString();
        cantidadDeMeGusta = in.readInt();
    }

    public String getFoto() {
        return foto;
    }

    public int getCantidadDeMeGusta() {
        return cantidadDeMeGusta;
    }

    public void agregarLike() {
        cantidadDeMeGusta++;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setCantidadDeMeGusta(int cantidadDeMeGusta) {
        this.cantidadDeMeGusta = cantidadDeMeGusta;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(foto);
        dest.writeInt(cantidadDeMeGusta);
    }
}
