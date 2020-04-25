package com.example.sajo.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.sajo.dao.registrationDao;
import com.example.sajo.data.model.registerstudent;


@Database(entities = {registerstudent.class}, version = 1, exportSchema = false)
    public abstract class RegisterDatabase extends RoomDatabase {

     private static RegisterDatabase mInstance ;

        public static final String DATABASE_Registration= "student-database";

        public abstract registrationDao registrationDao();


        public synchronized static RegisterDatabase getDatabaseInstance(Context context) {
            if (mInstance == null) {
                mInstance = Room.databaseBuilder(context.getApplicationContext(), RegisterDatabase.class, DATABASE_Registration)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();

                // TODO: 4/25/2020  handle allow run on main thread
            }
            return mInstance;
        }

        public static void destroyInstance() {
            mInstance = null;
        }
}
