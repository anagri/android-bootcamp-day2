package co.creativev.bootcamp.got;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String GOT_DB = "got.db";
    public static final int VERSION = 2;
    public static final GoTCharacter[] GOT_CHARACTERS =
            {
                    new GoTCharacter("Arya Stark", "arya.jpg", "arya_full.jpg", true, "Stark", "stark.jpg", "Arya Stark is the third child and second daughter of Lord Eddard Stark and Lady Catelyn Tully"),
                    new GoTCharacter("Bran Stark", "bran.jpg", "bran_full.jpg", true, "Stark", "stark.jpg", "Brandon Stark, typically called Bran, is the second son of Lord Eddard Stark and Lady Catelyn Tully."),
                    new GoTCharacter("Brienne Tarth", "brienne.jpg", "brienne_full.jpg", true, "Stark", "stark.jpg", "Brienne is sometimes called the Maid of Tarth and mocked as Brienne the Beauty."),
                    new GoTCharacter("Catelyn Stark", "catelyn.jpg", "catelyn_full.jpg", false, "Stark", "stark.jpg", "Lady Catelyn Stark, also called Catelyn Tully, is the wife of Lord Eddard Stark and Lady of Winterfell."),
                    new GoTCharacter("Cercei Lannister", "cercei.jpg", "cercei_full.jpg", true, "Lannister", "lannister.jpg", "Cersei Lannister is the eldest child of Tywin and Joanna Lannister by mere moments, and the twin sister of Jaime Lannister."),
                    new GoTCharacter("Daenerys Targaryen", "daenerys.jpg", "daenerys_full.jpg", true, "Targaryen", "targaryen.jpg", "Princess Daenerys Targaryen, known as Daenerys Stormborn and Dany, is one of the last confirmed members of House Targaryen"),
                    new GoTCharacter("Davos Seaworth", "davos.jpg", "davos_full.jpg", true, "Baratheon", "baratheon.jpg", "Ser Davos Seaworth, commonly called the Onion Knight, is the head of House Seaworth. He was once a smuggler."),
                    new GoTCharacter("Eddard Stark", "eddard.jpg", "eddard_full.jpg", false, "Stark", "stark.jpg", "Eddard Stark, also affectionately called 'Ned', is the head of House Stark, Lord of Winterfell, and Warden of the North."),
                    new GoTCharacter("Hodor", "hodor.jpg", "hodor_full.jpg", true, "Stark", "stark.jpg", "Hodor, the giant, simple-minded stableboy of Winterfell."),
                    new GoTCharacter("Jaime Lannister", "jaime.jpg", "jaime_full.jpg", true, "Lannister", "lannister.jpg", "Ser Jaime Lannister, known as the Kingslayer, is a knight from House Lannister. He is the twin brother of Queen Cersei Lannister."),
                    new GoTCharacter("Jaqen Hagar", "jaqen.jpg", "jaqen_full.jpg", true, "Faceless Men", "faceless.jpg", "Jaqen Hagar is the name of a sly Lorathi criminal who meets Arya Stark on her way to the Wall."),
                    new GoTCharacter("Joffrey Baratheon", "joffrey.jpg", "joffrey_full.jpg", false, "Baratheon", "baratheon.jpg", "Prince Joffrey Baratheon is known to the Seven Kingdoms as the eldest son and heir of King Robert I Baratheon and Queen Cersei Lannister."),
                    new GoTCharacter("Jon Snow", "jon.jpg", "jon_full.jpg", false, "Stark", "stark.jpg", "Jon Snow doesn't know anything"),
                    new GoTCharacter("Khal Drogo", "khal.jpg", "khal_full.jpg", false, "Dothraki", "dothraki.jpg", "Drogo is a powerful khal or warlord of the fearsome Dothraki nomads."),
                    new GoTCharacter("Melisandre", "melisandre.jpg", "melisandre_full.jpg", true, "Baratheon", "baratheon.jpg", "Melisandre is a priestess of R'hllor and a shadowbinder, hailing from the eastern city of Asshai. She has joined the entourage of Stannis Baratheon."),
                    new GoTCharacter("Petyr Baelish", "petyr.jpg", "petyr_full.jpg", true, "Lannister", "lannister.jpg", "Petyr Baelish, sometimes called Littlefinger, is the head of House Baelish of the Fingers. Petyr wears a mockingbird as his personal crest instead of House Baelish's sigil, a titan's head."),
                    new GoTCharacter("Podrick Payne", "podrick.jpg", "podrick_full.jpg", true, "Lannister", "lannister.jpg", "Podrick Payne is the squire of Tyrion Lannister. He is from a cadet branch of House Payne."),
                    new GoTCharacter("Grand Maester Pycelle", "pycelle.jpg", "pycelle_full.jpg", true, "Lannister", "lannister.jpg", "Pycelle is a Grand Maester of the Citadel who has served in King's Landing and on the small council for over forty years."),
                    new GoTCharacter("Ramsay Bolton", "ramsay.jpg", "ramsay_full.jpg", true, "Bolton", "bolton.jpg", "Ramsay Bolton (formerly Ramsay Snow) is the legitimized bastard son of Lord Roose Bolton. He is known as the Bastard of Bolton and the Bastard of the Dreadfort."),
                    new GoTCharacter("Renly Baratheon", "renly.jpg", "renly_full.jpg", false, "Baratheon", "baratheon.jpg", "Renly Baratheon is the Lord of Storm's End and Lord Paramount of the Stormlands. The younger brother of King Robert I and Lord Stannis."),
                    new GoTCharacter("Robb Stark", "robb.jpg", "robb_full.jpg", false, "Stark", "stark.jpg", "Robb Stark is the eldest son of Eddard Stark and Catelyn Tully and is the heir of House Stark to Winterfell and the north."),
                    new GoTCharacter("Robert Baratheon", "robert.jpg", "robert_full.jpg", false, "Baratheon", "baratheon.jpg", "King Robert I Baratheon is the Lord of the Seven Kingdoms of Westeros and the head of House Baratheon of King's Landing"),
                    new GoTCharacter("Roose Bolton", "roose.jpg", "roose_full.jpg", true, "Bolton", "bolton.jpg", "Roose Bolton is the Lord of the Dreadfort and head of House Bolton."),
                    new GoTCharacter("Sansa Stark", "sansa.jpg", "sansa_full.jpg", true, "Stark", "stark.jpg", "Arya Stark is the third child and second daughter of Lord Eddard Stark and Lady Catelyn Tully."),
                    new GoTCharacter("Stannis Baratheon", "stannis.jpg", "stannis_full.jpg", false, "Baratheon", "baratheon.jpg", "Stannis Baratheon is the head of House Baratheon of Dragonstone and the Lord of Dragonstone."),
                    new GoTCharacter("Tyrion Lannister", "tyrion.jpg", "tyrion_full.jpg", true, "Lannister", "lannister.jpg", "Tyrion is a dwarf, with stubby legs, a jutting forehead, mismatched eyes of green and black, and a mixture of pale blond and black hair."),
                    new GoTCharacter("Tywin Lannister", "tywin.jpg", "tywin_full.jpg", false, "Lannister", "lannister.jpg", "Tywin Lannister is Lord of Casterly Rock, Shield of Lannisport and Warden of the West. The head of House Lannister, Tywin is one of the most powerful lords in Westeros."),
                    new GoTCharacter("Varys", "varys.jpg", "varys_full.jpg", true, "Lannister", "lannister.jpg", "Varys, called the Spider, is an enigmatic member of the small council and the master of whisperers, or spymaster, for the Iron Throne of the Seven Kingdoms.")
            };
    public static final String GOT_TABLE = "got_characters";
    private static DatabaseHelper instance;

    private DatabaseHelper(Context context) {
        super(context, GOT_DB, null, VERSION);
    }

    public static DatabaseHelper getDatabaseHelper(Context context) {
        if (instance == null)
            instance = new DatabaseHelper(context);
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        db.execSQL("CREATE TABLE " + GOT_TABLE + "(" +
                GoTCharacter._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                GoTCharacter.NAME + " TEXT," +
                GoTCharacter.THUMB_URL + " TEXT," +
                GoTCharacter.FULL_URL + " TEXT," +
                GoTCharacter.HOUSE + " TEXT," +
                GoTCharacter.HOUSE_URL + " TEXT," +
                GoTCharacter.DESCRIPTION + " TEXT);");
        try {
            for (GoTCharacter gotCharacter : GOT_CHARACTERS) {
                ContentValues values = new ContentValues();
                values.put(GoTCharacter.NAME, gotCharacter.name);
                values.put(GoTCharacter.THUMB_URL, gotCharacter.thumbUrl);
                values.put(GoTCharacter.FULL_URL, gotCharacter.fullUrl);
                values.put(GoTCharacter.HOUSE, gotCharacter.house);
                values.put(GoTCharacter.HOUSE_URL, gotCharacter.houseUrl);
                values.put(GoTCharacter.DESCRIPTION, gotCharacter.description);
                db.insert(GOT_TABLE, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + GOT_TABLE + ";");
        onCreate(db);
    }

    public int getCount() {
        return (int) DatabaseUtils.longForQuery(getReadableDatabase(), "SELECT COUNT(*) from " + GOT_TABLE, null);
    }

    public Cursor getCharacterCursor() {
        return getReadableDatabase().query(GOT_TABLE, GoTCharacter.ALL_COLS, null, null, null, null, null);
    }
}
