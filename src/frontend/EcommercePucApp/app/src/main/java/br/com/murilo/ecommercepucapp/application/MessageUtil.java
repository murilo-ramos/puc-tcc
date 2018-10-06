package br.com.murilo.ecommercepucapp.application;

import android.content.Context;
import android.widget.Toast;

/**
 * Classe utilitária de mensagens da aplicação
 * @author murilocosta
 */
public class MessageUtil {

    public static void showShortToast(Context context, String message) {
        showToast(context, message, Toast.LENGTH_SHORT);
    }

    public static void showLongToast(Context context, String message) {
        showToast(context, message, Toast.LENGTH_LONG);
    }

    public static void showToast(Context context, String message, int length) {
        Toast toast = Toast.makeText(context, message, length);
        toast.show();
    }

}
