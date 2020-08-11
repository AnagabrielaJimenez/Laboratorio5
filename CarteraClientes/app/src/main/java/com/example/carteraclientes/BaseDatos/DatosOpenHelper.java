package com.example.carteraclientes.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.carteraclientes.BaseDatos.BaseDatosClass;
import androidx.annotation.Nullable;

public class DatosOpenHelper extends SQLiteOpenHelper{
    private static final String NOMBRE_BD="DATOS.db";
    private static final int VERSION_BD=1;
    private static final String TABLA_CLIENTE=
            "CREATE TABLE " +BaseDatosClass.DATOS.TABLE_NAME + " (" +
                    BaseDatosClass.DATOS.COLUMN_NOMBRE + " TEXT," +
                    BaseDatosClass.DATOS.COLUMN_DIRECCION + " TEXT," +
                    BaseDatosClass.DATOS.COLUMN_EMAIL + " TEXT," +
                    BaseDatosClass.DATOS.COLUMN_TELEFONO + " TEXT)";

    private static final String DELETE_ENTRIES="DROP TABLE IF EXISTS'"+TABLA_CLIENTE+"'";

    public DatosOpenHelper(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(TABLA_CLIENTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i,int i1){
        sqLiteDatabase.execSQL(DELETE_ENTRIES);
        sqLiteDatabase.execSQL(TABLA_CLIENTE);
    }

    public void agregarClientes(String nombre, String direccion, String email, String telefono){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BaseDatosClass.DATOS.COLUMN_NOMBRE, nombre);
        values.put(BaseDatosClass.DATOS.COLUMN_DIRECCION, direccion);
        values.put(BaseDatosClass.DATOS.COLUMN_EMAIL, email);
        values.put(BaseDatosClass.DATOS.COLUMN_TELEFONO, telefono);

        long newRowId = db.insert(BaseDatosClass.DATOS.TABLE_NAME, null, values);
    }

}