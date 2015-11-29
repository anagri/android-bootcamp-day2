package co.creativev.bootcamp.got;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;

public class GoTCharacter implements Parcelable, BaseColumns {
    public static final String NAME = "name";
    public static final String THUMB_URL = "thumb_url";
    public static final String FULL_URL = "full_url";
    public static final String HOUSE = "house";
    public static final String HOUSE_URL = "house_url";
    public static final String DESCRIPTION = "description";
    public static final String[] ALL_COLS = {_ID, NAME, THUMB_URL, FULL_URL, HOUSE, HOUSE_URL, DESCRIPTION};

    public final String name;
    public final String thumbUrl;
    public final boolean alive;
    public final String fullUrl;
    public final String houseUrl;
    public final String house;
    public final String description;

    public GoTCharacter(String name, String thumbUrl, String fullUrl, boolean alive, String house, String houseUrl, String description) {
        this.name = name;
        this.thumbUrl = thumbUrl;
        this.alive = alive;
        this.fullUrl = fullUrl;
        this.houseUrl = houseUrl;
        this.house = house;
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.thumbUrl);
        dest.writeByte(alive ? (byte) 1 : (byte) 0);
        dest.writeString(this.fullUrl);
        dest.writeString(this.houseUrl);
        dest.writeString(this.house);
        dest.writeString(this.description);
    }

    protected GoTCharacter(Parcel in) {
        this.name = in.readString();
        this.thumbUrl = in.readString();
        this.alive = in.readByte() != 0;
        this.fullUrl = in.readString();
        this.houseUrl = in.readString();
        this.house = in.readString();
        this.description = in.readString();
    }

    public static final Creator<GoTCharacter> CREATOR = new Creator<GoTCharacter>() {
        public GoTCharacter createFromParcel(Parcel source) {
            return new GoTCharacter(source);
        }

        public GoTCharacter[] newArray(int size) {
            return new GoTCharacter[size];
        }
    };
}
