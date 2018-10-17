package br.com.murilo.ecommercepucapp.application;

import android.app.ProgressDialog;
import android.content.Context;

public class IndeterminateProgressDialog {

    private final ProgressDialog dialog;

    public IndeterminateProgressDialog(Context context, String waitingMessage) {
        this.dialog = new ProgressDialog(context);
        this.dialog.setIndeterminate(true);
        this.dialog.setMessage(waitingMessage);
    }

    public void show() {
        this.dialog.show();
    }

    public void close() {
        this.dialog.dismiss();
    }

}
