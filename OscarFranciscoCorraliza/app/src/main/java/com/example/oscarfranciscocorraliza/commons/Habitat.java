package com.example.oscarfranciscocorraliza.commons;

import android.os.Parcel;
import android.os.Parcelable;

public class Habitat implements Parcelable {
    private String habitat;

    public Habitat(String habitat) {
        this.habitat = habitat;
    }

    protected Habitat(Parcel in) {
        habitat = in.readString();
    }

    public static final Creator<Habitat> CREATOR = new Creator<Habitat>() {
        @Override
        public Habitat createFromParcel(Parcel in) {
            return new Habitat(in);
        }

        @Override
        public Habitat[] newArray(int size) {
            return new Habitat[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(habitat);
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
}
