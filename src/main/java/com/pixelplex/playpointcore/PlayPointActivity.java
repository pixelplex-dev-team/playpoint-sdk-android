package com.pixelplex.playpointcore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;

/**
 * Created by kirillvolkov on 31.10.2017.
 */

public class PlayPointActivity extends AppCompatActivity {

    public static final String LOGGER_ACTION = "LOGGER_ACTION";
    public static final String ACTION_GET_LOGS = "ACTION_GET_LOGS";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkOperation();
    }

    private void checkOperation() {
        String operation = getIntent().getStringExtra(LOGGER_ACTION);
        if (operation != null && operation.equals(ACTION_GET_LOGS)) {
            Getlogs();
        }
    }

    private void Getlogs() {
        Intent intent = new Intent();
        intent.putExtra("logs", (Serializable) Logger.getInstance().getLogs());
        this.setResult(RESULT_OK, intent);
        this.finish();
    }
}
