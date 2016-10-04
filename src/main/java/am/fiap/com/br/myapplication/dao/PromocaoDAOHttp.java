package am.fiap.com.br.myapplication.dao;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import am.fiap.com.br.myapplication.model.Promocao;

/**
 * Created by Monteiro on 24/09/16.
 */
public class PromocaoDAOHttp {

    private final String URL_POST = "https://29577a52-5270-498b-8af0-b9787031145e-bluemix.cloudant.com/promocoes-db/";
    private final String URL_FIND = "https://29577a52-5270-498b-8af0-b9787031145e-bluemix.cloudant.com/promocoes-db/_find";



    public void inserir(Promocao promocao){

        Gson gson = new Gson();

        promocao.setCodigo(0);
        String json = gson.toJson(promocao);

        HttpConection conexao = new HttpConection();

        try{
            String jsonResult = conexao.execute(URL_POST, "POST", json).get();
            Log.e("res",jsonResult);
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    private class HttpConection extends AsyncTask<String , Void , String> {


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



    }

    public List<Promocao>listarTodas(){

       // String jsonFilter = "{\"selector\": { \"_id\": \"{\"$gt\":0} }";
        String jsonFilter = "{\n" +
                "  \"selector\": {\n" +
                "    \"_id\": {\n" +
                "      \"$gt\": 0\n" +
                "    }}}";
        HttpConection conection = new HttpConection();
        List<Promocao>promocoes = new ArrayList<>();

        try{

            String jsonResult = conection.execute(URL_FIND,"POST",jsonFilter).get();

            //Exibe os dados retornados pela requisição
            JSONObject jsonSaida = new JSONObject(jsonResult);
            JSONArray jsonArray = (JSONArray) jsonSaida.get("docs");
            Gson gson = new Gson();

            for(int i = 0;i <jsonArray.length();i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                //popula o ArrayList
                promocoes.add(gson.fromJson(jsonObj.toString(),Promocao.class));
            }

        }catch (Exception e){
            Log.e("Erro",e.getMessage() + e.getCause());

        }
        return promocoes;
    }

    public Promocao findPromocao(String id){
        HttpConection conexao = new HttpConection();
        Gson gson = new Gson();
        Promocao promo = new Promocao();

        String filter = "{\n" +
                "  \"selector\": {\n" +
                "    \"_id\": \n" +
                "       \"" + id +"\"\n" +
                "    \n" +
                "  },\n" +
                "  \"fields\": [\n" +
                "   \"pontos\"\n" +
                "  \n" +
                "  ]\n" +
                "} ";


        try{

            String jsonResult = conexao.execute(URL_FIND,"POST",filter).get();
            JSONObject jsonSaida = new JSONObject(jsonResult);
            JSONArray jsonArray = (JSONArray) jsonSaida.get("docs");

            for(int i = 0;i <jsonArray.length();i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);


                promo = (gson.fromJson(jsonObj.toString(),Promocao.class));
            }




        }catch (Exception e){
            e.printStackTrace();
        }


        return promo;
    }
}
