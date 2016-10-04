package am.fiap.com.br.myapplication.dao;

import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import am.fiap.com.br.myapplication.model.UsuarioTO;

/**
 * Created by Victor on 07/09/2016.
 */
public class UsuarioDAOHttp {
    private final String URL_POST = "https://29577a52-5270-498b-8af0-b9787031145e-bluemix.cloudant.com/doadores-db/";
    private final String URL_FIND = "https://29577a52-5270-498b-8af0-b9787031145e-bluemix.cloudant.com/doadores-db/_find";



public void inserir(UsuarioTO usuario){

    Gson gson = new Gson();
    //usuario.setId(0);
    usuario.setQtdPontos(0);
    String json = gson.toJson(usuario);
    HttpConection conexao = new HttpConection();

    try{
        String jsonResult = conexao.execute(URL_POST, "POST", json).get();
    }catch (Exception e){
        e.printStackTrace();
    }


}

    public void atualizar(UsuarioTO usuarioTO,Integer pontos){
        Gson gson = new Gson();

        usuarioTO.setQtdPontos(pontos);
        String json = gson.toJson(usuarioTO);
        HttpConection conexao = new HttpConection();

        try{
            String jsonResult = conexao.execute(URL_POST,"POST",json).get();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  UsuarioTO findByID(String id){
        HttpConection conexao = new HttpConection();
        Gson gson = new Gson();
        UsuarioTO usuario = new UsuarioTO();
        String filter = "{\n" +
                "  \"selector\": {\n" +
                "    \"_id\": \n" +
                "       \"" + id +"\"\n" +

                "}}";


        try{

            String jsonResult = conexao.execute(URL_FIND,"POST",filter).get();
            JSONObject jsonSaida = new JSONObject(jsonResult);
            JSONArray jsonArray = (JSONArray) jsonSaida.get("docs");

            for(int i = 0;i <jsonArray.length();i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);


                usuario = (gson.fromJson(jsonObj.toString(),UsuarioTO.class));
            }




        }catch (Exception e){
            e.printStackTrace();
        }


        return usuario;

    }

    private class HttpConection extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            HttpURLConnection client;
            String retorno = "";

            try {
                URL url = new URL(urls[0]);
                client = (HttpURLConnection) url.openConnection();

                client.setRequestProperty("Content-Type", "application/json");
                client.setRequestProperty("charset", "utf-8");
                client.setRequestMethod(urls[1]);
                client.setDoOutput(true);
                client.setDoInput(true);



                OutputStreamWriter wr;

                wr = new OutputStreamWriter(client.getOutputStream());
                wr.write(urls[2]);
                Log.e("Filtro",urls[2]);
                wr.close();
                StringBuilder sb = new StringBuilder();
                int statusCodeHTTP = client.getResponseCode();

                if (statusCodeHTTP == HttpURLConnection.HTTP_OK) {

                    BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream(), "utf-8"));
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();

                    retorno = sb.toString();

                } else {
                    Log.e("Erro GET ALL ", "Erro na Requisição! Código do Erro: " + statusCodeHTTP + "\nMensagem de Erro: "
                            + client.getResponseMessage());
                }

            }catch (Exception e){
                Log.e("erro", e.getMessage() + e.getCause() );
            }
            return retorno;
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

        }
    }

}




