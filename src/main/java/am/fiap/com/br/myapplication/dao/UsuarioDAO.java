package am.fiap.com.br.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import am.fiap.com.br.myapplication.model.UsuarioTO;

/**
 * Created by Victor on 07/09/2016.
 */
public class UsuarioDAO extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AM.db";
    private static final int DATABASE_VERSION = 1;

    public UsuarioDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE T_USUARIO (" +
                "id TEXT PRIMARY KEY," +
                "nome TEXT," +
                "sobrenome TEXT," +
                "RG TEXT," +
                "CPF TEXT," +

                "IDADE INTEGER" +
                ")";

            db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS T_USUARIO";

        db.execSQL(sql);

    }

    public void cadastrar(UsuarioTO usuario){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = pegaUsuarios(usuario);

        db.insert("T_USUARIO",null,cv);
        db.close();
    }

    private ContentValues pegaUsuarios(UsuarioTO usuario){
        ContentValues cv = new ContentValues();
        cv.put("id",usuario.get_id());
        cv.put("nome",usuario.getPrimeiroNome());
        cv.put("sobrenome",usuario.getUltimoNome());
        cv.put("RG",usuario.getRg());
        cv.put("CPF",usuario.getCpf());
        cv.put("IDADE",usuario.getIdade());


        return cv;
    }
}
