package com.example.coopacola.UI.Adapter;

import android.content.Context;
import android.util.Log;

import com.example.coopacola.Model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class JsonUserHelper {
    private Context context;
    private File file;
    private String filePath;
    private ArrayList<User> listOfUser;
    private static final String TAG = "JsonUserHelper";

    public JsonUserHelper(Context context, String fileName,ArrayList<User> listOfUser){
     this.context = context;
     file = new File(context.getFilesDir(),fileName);
     filePath =file.getPath();
     this.listOfUser = listOfUser;
    }

    public JsonUserHelper(Context context, String fileName){
        this.context = context;
        file = new File(context.getFilesDir(),fileName);
        filePath =file.getPath();
        this.listOfUser = listOfUser;
    }

    public void writeFile(){
        if(file.exists()){
            try(Writer writer = new FileWriter(filePath)){
                Gson gson = new Gson();
                gson.toJson(listOfUser,writer);
                Log.d(TAG, "writeFile: " + filePath);
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            try {

                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.d(TAG, "writeFile: File Not Exist" );
        }
    }

    public ArrayList<User> readFile(){
        ArrayList<User> retriveListOfData = null;
        try{
            Gson gson = new Gson();
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            int size = fileInputStream.available();
            byte[] buffer =new byte[size];
            fileInputStream.read(buffer);
            String retriveData = new String(buffer);
            fileInputStream.close();
            retriveListOfData = gson.fromJson(retriveData, new TypeToken<ArrayList<User>>(){}.getType());
            return retriveListOfData;
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retriveListOfData;
    }
}
