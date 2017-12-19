package imastudio.id.co.smsemailcallapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by rizkisyaputra on 19/12/17.
 */

public class FragmentSMS extends Fragment{

    public FragmentSMS(){

    }

    //deklarasi widget
    EditText etNoHp, etTeks;

    Button btnSendSMS;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sms, container, false);

        etNoHp = (EditText)view.findViewById(R.id.etNoHp);
        etTeks = (EditText)view.findViewById(R.id.etTeksSMS);
        btnSendSMS = (Button)view.findViewById(R.id.btnKirimSMS);

        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cek kalau no hp kosong
                String nNoHp = etNoHp.getText().toString();
                String nPesan = etTeks.getText().toString();

                if (nNoHp.isEmpty()){
                    etNoHp.setError("No Hp tidak boleh kosong");
                }else {
//                    Intent smsIntent = new Intent(Intent.ACTION_VIEW);
//                    smsIntent.setData(Uri.parse("smsto:"));
//                    smsIntent.setType("address", new String(nNoHp));
//
//                    smsIntent.putExtra("sms-body", etTeks.getText().toString());

                    try{
//                        startActivity(smsIntent);

                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(nNoHp,null, nPesan, null, null );

                        Toast.makeText(getActivity(), "Sedang mengirim pesan", Toast.LENGTH_LONG).show();
                    }catch (ActivityNotFoundException e){
                        Toast.makeText(getActivity(),"SMS Failed", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });



        return view;
    }
}
