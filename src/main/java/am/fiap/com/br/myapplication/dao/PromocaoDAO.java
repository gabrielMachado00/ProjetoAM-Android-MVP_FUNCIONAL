package am.fiap.com.br.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import am.fiap.com.br.myapplication.model.Promocao;

/**
 * Created by Monteiro on 24/09/16.
 */
public class PromocaoDAO  extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "AM.db";
    private static final int DATABASE_VERSION = 1;

    public PromocaoDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "CREATE TABLE T_AM2016_PROMOCAO(" +
                "ID integer PRIMARY KEY" +
                "DESCRICAO TEXT" +
                " QTD_PONTOS INTEGER)";

        sqLiteDatabase.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String sql = "DROP TABLE IF EXISTS T_AM2016_PROMOCAO";

        sqLiteDatabase.execSQL(sql);

    }

    public void cadastrar(Promocao promocao){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = pegaPromocao(promocao);
        db.insert("T_AM2016_PROMOCAO",null,cv);

    }

    private ContentValues pegaPromocao(Promocao promocao){

        ContentValues cv = new ContentValues();
        cv.put("ID",promocao.getCodigo());
        cv.put("DESCRICAO",promocao.getDescricao());
        cv.put("QTD_PONTOS",promocao.getPontos());

        return  cv;


    }
}
