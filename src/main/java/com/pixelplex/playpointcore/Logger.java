package com.pixelplex.playpointcore;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kirillvolkov on 27.10.2017.
 */

public class Logger {

    private static final String fileName = "PlayPointLog.txt";
    private File logFile;
    private Context context;

    public static Logger getInstance() {
        return instance;
    }

    private static Logger instance;

    public static void initialize(Context context) {
        if(instance == null){
            instance = new Logger(context);
        }
    }

    private Logger(Context context) {
        this.context = context;
        logFile = new File(context.getFilesDir(), fileName);
    }

    public void writeLog(String data) {

        try {
            FileOutputStream outputStream = new FileOutputStream(logFile, true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.append(String.format("[%s] : %s;", new Date().toString(), data));
            outputStreamWriter.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<String> getLogs() {

        List<String> result = new ArrayList<>();

        try {
            InputStream instream = context.openFileInput(fileName);
            if (instream != null) {
                InputStreamReader inputreader = new InputStreamReader(instream);
                BufferedReader buffreader = new BufferedReader(inputreader);
                String line;
                while ((line = buffreader.readLine()) != null) {
                    result.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
