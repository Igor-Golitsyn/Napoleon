package com.example.golit.napoleonproject.bins;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by golit on 28.04.2017.
 */
public class DataRes implements Parcelable {

    @SerializedName("uuid")
    @Expose
    private int uuid;
    @SerializedName("type")
    @Expose
    private int type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("descr")
    @Expose
    private String descr;
    @SerializedName("group")
    @Expose
    private String group;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("discount")
    @Expose
    private String discount;
    @SerializedName("urlThumbImage")
    @Expose
    private String urlThumbImage;

    protected DataRes(Parcel in) {
        uuid = in.readInt();
        type = in.readInt();
        name = in.readString();
        descr = in.readString();
        group = in.readString();
        price = in.readString();
        discount = in.readString();
        urlThumbImage = in.readString();
    }

    public DataRes(int uuid, int type, String name, String descr, String group, String price, String discount, String urlThumbImage) {
        this.uuid = uuid;
        this.type = type;
        this.name = name;
        this.descr = descr;
        this.group = group;
        this.price = price;
        this.discount = discount;
        this.urlThumbImage = urlThumbImage;
    }

    public static final Creator<DataRes> CREATOR = new Creator<DataRes>() {
        @Override
        public DataRes createFromParcel(Parcel in) {
            return new DataRes(in);
        }

        @Override
        public DataRes[] newArray(int size) {
            return new DataRes[size];
        }
    };

    public int getUuid() {
        return uuid;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescr() {
        return descr;
    }

    public String getGroup() {
        return group;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }

    public String getUrlThumbImage() {
        return urlThumbImage;
    }

    @Override
    public String toString() {
        return "DataRes{" +
                "uuid=" + uuid +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                ", group='" + group + '\'' +
                ", price='" + price + '\'' +
                ", discount='" + discount + '\'' +
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
        dest.writeInt(type);
        dest.writeString(name);
        dest.writeString(descr);
        dest.writeString(group);
        dest.writeString(price);
        dest.writeString(discount);
        dest.writeString(urlThumbImage);
    }
}

