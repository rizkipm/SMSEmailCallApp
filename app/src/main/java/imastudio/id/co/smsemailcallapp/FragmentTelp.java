package imastudio.id.co.smsemailcallapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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

public class FragmentTelp extends Fragment{

    public FragmentTelp(){

    }

    //deklarasi widget
    EditText etNoHp;

    Button btnCall;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_telp, container, false);

        etNoHp = (EditText)view.findViewById(R.id.etNoHp);

        btnCall = (Button)view.findViewById(R.id.btnCall);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cek kalau no hp kosong
                String nNoHp = etNoHp.getText().toString();


                if (nNoHp.isEmpty()){
                    etNoHp.setError("No Hp tidak boleh kosong");
                }else {
//
                    String phoneNumber = String.format("tel: %s", nNoHp );

                    //manggil intent untuk panggil no hp
                    Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                    dialIntent.setData(Uri.parse(phoneNumber));

                    if (dialIntent.resolveActivity(getActivity().getPackageManager()) != null){
                        startActivity(dialIntent);
                    }else {
                        Toast.makeText(getActivity(),"Telpon gagal", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });



        return view;
    }
}
