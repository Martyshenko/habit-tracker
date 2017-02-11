package savern.habittracker.data;

import android.provider.BaseColumns;

public final class HabitContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public HabitContract() {
    }

    public static final class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habits";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_DAY = "day of the week";
        public static final String COLUMN_FIRST_HABIT = "morning exercise";
        public static final String COLUMN_SECOND_HABIT = "a glass of water";
        public static final String COLUMN_THIRD_HABIT = "healthy breakfast";
        public static final String COLUMN_FOURTH_HABIT = "meditation";

        //values for every habit
        //In a world of 1s and 0s are you a zero or the one?)
        public static final int HABIT_IS_SKIPPED = 0;
        public static final int HABIT_IS_DONE = 1;

    }
}
