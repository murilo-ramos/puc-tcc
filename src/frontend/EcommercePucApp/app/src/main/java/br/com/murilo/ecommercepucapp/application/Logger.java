package br.com.murilo.ecommercepucapp.application;

import android.support.annotation.NonNull;
import android.util.Log;

public class Logger {

    private static final String APPLICATION_TAG = "ECOMMERCE_PUC";

    private final String tag;

    private Logger(Class clazz) {
        this.tag = this.getLogTag(clazz);
    }

    @NonNull
    public static Logger create(Class clazz) {
        return new Logger(clazz);
    }

    public void debug(String message) {
        Log.d(this.tag, message);
    }

    public void info(String message) {
        Log.i(this.tag, message);
    }

    public void warning(String message) {
        Log.w(this.tag, message);
    }
    public void error(String message) {
        Log.e(this.tag, message);
    }

    private String getLogTag(Class clazz) {
        return "[" + APPLICATION_TAG + " - " + clazz.getCanonicalName() + "]";
    }

}
