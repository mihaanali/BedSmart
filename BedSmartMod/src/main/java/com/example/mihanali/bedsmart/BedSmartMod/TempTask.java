package com.example.mihanali.bedsmart.BedSmartMod;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class TempTask {

    private double tmp;
    ListView tw,lv1;
    Context context;
    TextView tw1;
    String dt1,tm;
    public TempTask (Context con, ListView tw, String dt) {
        this.tw = tw;
        this.context=con;

        dt1=dt;

    }
    ArrayList<String> l1=new ArrayList<String>();

    ArrayList<String>l2=new ArrayList<String>();
    ArrayList<String>l3=new ArrayList<String>();


    protected String doInBackground(Void... params)
    {

        String str="https://thingspeak.com/channels/641919/feed.json";

        URLConnection urlConn = null;
        BufferedReader bufferedReader = null;
        try
        {
            URL url = new URL(str);
            urlConn = url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuffer.append(line);
            }

            JSONObject js=new JSONObject(String.valueOf(stringBuffer));


            JSONArray arr=js.getJSONArray("feeds");
            String[] arr1=new String[100];
            JSONObject js2;
            String str1 = null,str2=dt1;

            for(int i=0;i<arr.length();i++){
                str1=arr.getString(i);
                String str3=dt1;
                if(str1.contains(str3)){
                    js2=arr.getJSONObject(i);
                    l1.add(js2.getString("field1"));

                    String[] parts=js2.getString("created_at").split("T");
                    String[]Parts1=parts[1].split("Z");
                    l3.add(Parts1[0]);
                }

            }

            for(int i=0;i<l1.size();i++) {
                if(l1.get(i)!="null"){
                tmp=Double.parseDouble(l1.get(i).trim());
                tm=String.valueOf(tmp);
                l2.add("Temperature at " + l3.get(i) + " - " + tm + " degree Celsius");}
            }

            return str2;
        }
        catch(Exception ex)
        {
            Log.e("App", "yourDataTask1", ex);
            return null;
        }
        finally
        {
            if(bufferedReader != null)
            {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    protected void onPostExecute(String  response)
    {
        if(response != null)
        {
            try {
                Log.println(1, "Hello:","Connected");
                Log.e("App", "Success: " + response );
            } catch (Exception ex) {
                Log.e("App", "Failure", ex);
            }
        }


        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(context.getApplicationContext(), android.R.layout.simple_list_item_1,l2);

        tw.setAdapter(arrayAdapter);


    }










}
