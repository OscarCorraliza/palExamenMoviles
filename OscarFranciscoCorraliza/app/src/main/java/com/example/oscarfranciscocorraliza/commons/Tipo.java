package com.example.oscarfranciscocorraliza.commons;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

public class Tipo implements Parcelable {
    private String tipo;

    public Tipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    protected Tipo(Parcel in) {
        tipo = in.readString();
    }

    public static final Creator<Tipo> CREATOR = new Creator<Tipo>() {
        @Override
        public Tipo createFromParcel(Parcel in) {
            return new Tipo(in);
        }

        @Override
        public Tipo[] newArray(int size) {
            return new Tipo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
