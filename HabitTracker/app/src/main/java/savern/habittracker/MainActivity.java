package savern.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import savern.habittracker.data.HabitContract;
import savern.habittracker.data.HabitContract.HabitEntry;
import savern.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mDbHelper = new HabitDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertResults();
    }


    private void insertResults() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_DAY, "Monday");
        values.put(HabitEntry.COLUMN_FIRST_HABIT, HabitEntry.HABIT_IS_DONE);
        values.put(HabitEntry.COLUMN_SECOND_HABIT, HabitEntry.HABIT_IS_DONE);
        values.put(HabitEntry.COLUMN_THIRD_HABIT, HabitEntry.HABIT_IS_SKIPPED);
        values.put(HabitEntry.COLUMN_FOURTH_HABIT, HabitEntry.HABIT_IS_DONE);

        db.insert(HabitEntry.TABLE_NAME, null, values);
    }

    private Cursor readResults() {

        // Creating and/or opening a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                HabitContract.HabitEntry._ID,
                HabitEntry.COLUMN_DAY,
                HabitEntry.COLUMN_FIRST_HABIT,
                HabitEntry.COLUMN_SECOND_HABIT,
                HabitEntry.COLUMN_THIRD_HABIT,
                HabitEntry.COLUMN_FOURTH_HABIT
        };

        Cursor cursor = db.query(HabitEntry.TABLE_NAME, projection, null, null, null, null, null);

        return cursor;
    }
}
