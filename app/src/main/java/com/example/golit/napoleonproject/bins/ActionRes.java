package com.example.golit.napoleonproject.bins;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by golit on 28.04.2017.
 */

public class ActionRes implements Parcelable {
    @SerializedName("uuid")
    @Expose
    private int uuid;
    @SerializedName("lineOne")
    @Expose
    private String lineOne;
    @SerializedName("lineTwo")
    @Expose
    private String lineTwo;
    @SerializedName("urlThumbImage")
    @Expose
    private String urlThumbImage;

    protected ActionRes(Parcel in) {
        uuid = in.readInt();
        lineOne = in.readString();
        lineTwo = in.readString();
        urlThumbImage = in.readString();
    }

    public static final Creator<ActionRes> CREATOR = new Creator<ActionRes>() {
        @Override
        public ActionRes createFromParcel(Parcel in) {
            return new ActionRes(in);
        }

        @Override
        public ActionRes[] newArray(int size) {
            return new ActionRes[size];
        }
    };

    public int getUuid() {
        return uuid;
    }

    public String getLineOne() {
        return lineOne;
    }

    public String getLineTwo() {
        return lineTwo;
    }

    public String getUrlThumbImage() {
        return urlThumbImage;
    }

    @Override
    public String toString() {
        return "ActionRes{" +
                "uuid=" + uuid +
                ", lineOne='" + lineOne + '\'' +
                ", lineTwo='" + lineTwo + '\'' +
                ", urlThumbImage='" + urlThumbImage + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(uuid);
        dest.writeString(lineOne);
        dest.writeString(lineTwo);
        dest.writeString(urlThumbImage);
    }
}
