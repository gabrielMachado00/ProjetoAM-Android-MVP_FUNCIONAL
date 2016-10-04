package am.fiap.com.br.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import am.fiap.com.br.myapplication.model.LojistaTO;


public class LojistaDAO extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "AM.db1";
    private static final int DATABASE_VERSION = 2;

    public LojistaDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String sql = "CREATE TABLE T_LOJISTA (" +
                "id TEXT PRIMARY KEY" +
                "razaoSocial TEXT" +
                "cnpj TEXT" +
                ")";


        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS T_LOJISTA";
        sqLiteDatabase.execSQL(sql);


    }

    public void cadastrar(LojistaTO lojista){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = pegaLojistas(lojista);
        db.insert("T_LOJISTA",null,cv);
    }



    private ContentValues pegaLojistas(LojistaTO lojista){
        ContentValues cv = new ContentValues();

        cv.put("id",lojista.get_id());
        cv.put("razaoSocial",lojista.getRazaoSocial());
        cv.put("cnpj",lojista.getCnpj());
        //cv.put("cidade",lojista.getCidade().getNome());


        return  cv;


    }
}
