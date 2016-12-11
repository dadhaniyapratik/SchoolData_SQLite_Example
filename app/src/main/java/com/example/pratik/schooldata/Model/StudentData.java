package com.example.pratik.schooldata.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Pratik on 05-Nov-16.
 */

public class StudentData implements Parcelable {
    int _id;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public String getDiv() {
        return div;
    }

    public void setDiv(String div) {
        this.div = div;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    String fname;
    String lname;
    String std;
    String div;
    String result;
    String percent;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this._id);
        dest.writeString(this.fname);
        dest.writeString(this.lname);
        dest.writeString(this.std);
        dest.writeString(this.div);
        dest.writeString(this.result);
        dest.writeString(this.percent);
    }

    public StudentData() {
    }

    protected StudentData(Parcel in) {
        this._id = in.readInt();
        this.fname = in.readString();
        this.lname = in.readString();
        this.std = in.readString();
        this.div = in.readString();
        this.result = in.readString();
        this.percent = in.readString();
    }

    public static final Parcelable.Creator<StudentData> CREATOR = new Parcelable.Creator<StudentData>() {
        @Override
        public StudentData createFromParcel(Parcel source) {
            return new StudentData(source);
        }

        @Override
        public StudentData[] newArray(int size) {
            return new StudentData[size];
        }
    };
}
