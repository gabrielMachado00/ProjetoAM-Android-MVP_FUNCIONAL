package am.fiap.com.br.myapplication.dao;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


import am.fiap.com.br.myapplication.model.LojistaTO;


/**
 * Created by Monteiro on 19/09/16.
 */
public class LojistaDAOHttp {

    private final String URL_POST = "https://29577a52-5270-498b-8af0-b9787031145e-bluemix.cloudant.com/lojista-db";
    private final String URL_GET_LOGIN = "https://29577a52-5270-498b-8af0-b9787031145e-bluemix.cloudant.com/lojista-db/_find";


    public void inserir(LojistaTO lojista) {

        Gson gson = new Gson();

        //lojista.setId(0);
        String json = gson.toJson(lojista);
        HttpConection conexao = new HttpConection();

        try {
            String jsonResult = conexao.execute(URL_POST, "POST", json).get();
        } catch (Exception e) {
            e.printStackTrace();
        }


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
                Log.e("Filtro", urls[2]);
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

            } catch (Exception e) {
                Log.e("erro", e.getMessage() + e.getCause());
            }
            return retorno;

        }
    }

    public LojistaTO getLojistaLogin(String cnpj) {

        String jsonFilter = "{\n" +
                "  \"selector\": {\n" +
                "    \"_id\": {\n" + cnpj +
                "      \n" +
                "    }\n" +
                "  }}";


        return null;


    }
}