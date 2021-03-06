package com.segeval.safedrive.fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.segeval.safedrive.R;
import com.segeval.safedrive.model.Model;
import com.segeval.safedrive.utils.Constants;


public class FragmentConf extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.fragment_configuration);
        dialog.setTitle("Configure");
        final EditText ip = (EditText) dialog.findViewById(R.id.ipadd_et);
        final EditText port = (EditText) dialog.findViewById(R.id.port);
        Button save = (Button) dialog.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Model.getInstance().setDeviceAddress(ip.getText().toString() + "," + port.getText().toString(),
                        Constants.WIFI_TAG);
                dialog.dismiss();
                Toast.makeText(getActivity(), "Changes have been saved!", Toast.LENGTH_SHORT).show();
            }
        });
        ip.setText(Model.getInstance().getDeviceAddress(Constants.WIFI_TAG).split(",")[0]);
        port.setText(Model.getInstance().getDeviceAddress(Constants.WIFI_TAG).split(",")[1]);

        return dialog;

    }
}
