package com.masscode.mountainappsample.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Mountain implements Parcelable {
    private String name;
    private String remarks;
    private String photo;
    private String deskripsi;
    private String lokasi;

    protected Mountain(Parcel in) {
        name = in.readString();
        remarks = in.readString();
        photo = in.readString();
        deskripsi = in.readString();
        lokasi = in.readString();
    }

    public Mountain() {
    }

    public static final Creator<Mountain> CREATOR = new Creator<Mountain>() {
        @Override
        public Mountain createFromParcel(Parcel in) {
            return new Mountain(in);
        }

        @Override
        public Mountain[] newArray(int size) {
            return new Mountain[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(remarks);
        parcel.writeString(photo);
        parcel.writeString(deskripsi);
        parcel.writeString(lokasi);
    }
}
