package com.example.myfirstapp;

import android.os.Parcel;
import android.os.Parcelable;

public class ListItemH implements Parcelable {
    private String firstThing;
    private String secondThing;
    private String resultThing;
    public ListItemH(String firstThing, String secondThing, String resultThing){
        this.firstThing = firstThing;
        this.secondThing = secondThing;
        this.resultThing = resultThing;
    }
    public String asStringText(){
        String strig;
        strig = String.format("%1s + %2s = %3s", firstThing, secondThing, resultThing);
        return strig;
        //return new String((firstThing + " + " + secondThing + " = " + resultThing));
    }
    public static final Creator<ListItemH> CREATOR = new Creator<ListItemH>() {
        @Override
        public ListItemH createFromParcel(Parcel get) {
            return new ListItemH(get);
        }

        @Override
        public ListItemH[] newArray(int size) {
            return new ListItemH[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }
    protected ListItemH(Parcel get){
        firstThing = get.readString();
        secondThing = get.readString();
        resultThing = get.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstThing);
        parcel.writeString(secondThing);
        parcel.writeString(resultThing);
    }
}
