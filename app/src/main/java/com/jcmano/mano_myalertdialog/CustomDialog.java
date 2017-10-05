package com.jcmano.mano_myalertdialog;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by JCMANO on 05/10/2017.
 */

public class CustomDialog extends DialogFragment {

    LayoutInflater inflater;
    View view;
    EditText eUser, ePass;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.login_dialog,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);

        builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                eUser = (EditText) view.findViewById(R.id.et_username);
                ePass = (EditText) view.findViewById(R.id.et_password);

                String user = eUser.getText().toString();
                String pass = ePass.getText().toString();
                String msg = "Username is " + user +", Password is" + pass;
                Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();

            }
        });

        //return super.onCreateDialog(savedInstanceState);
        Dialog dialog = builder.create();
        return dialog;
    }
}
