package apptablet.sacooliveros.edu.pe.bdatossemana.DataBaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {

        BaseDeDatos.execSQL(Utilidades.CREAR_TABLA_VIDEOSEMINARIO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase BaseDeDatos, int i, int i1) {

        BaseDeDatos.execSQL("DROP TABLE IF EXISTS videoseminario");

    }


}
