package edu.scse.ParcelMathServiceDemo;

import android.os.Parcel;
import android.os.Parcelable;

public class AllResult implements Parcelable {
    public long addResult;
    public long subResult;
    public long mulResult;
    public double divResult;

    public AllResult(long addResult, long subResult, long mulResult, double divResult) {
        this.addResult = addResult;
        this.subResult = subResult;
        this.mulResult = mulResult;
        this.divResult = divResult;
    }

    //从Parcel对象得到数据，拆包函数
    public AllResult(Parcel parcel) {
        addResult = parcel.readLong();
        subResult = parcel.readLong();
        mulResult = parcel.readLong();
        divResult = parcel.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //顾名思义 wiiteToParcel  打包函数
    //将AllResult类内部的数据按照特定顺序写入Parcel对象
    //写入顺序必须与构造函数读取顺序一致
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(addResult);
        dest.writeLong(subResult);
        dest.writeLong(mulResult);
        dest.writeDouble(divResult);
    }

    //实现静态公共字段Creator，用来使用Parcel对象构造AllResult对象
    public static final Parcelable.Creator<AllResult> CREATOR = new Creator<AllResult>() {
        @Override
        public AllResult createFromParcel(Parcel parcel) {
            return new AllResult(parcel);
        }

        @Override
        public AllResult[] newArray(int size) {
            return new AllResult[size];
        }
    };
}
