package imastudio.id.co.smsemailcallapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
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

public class FragmentEmail extends Fragment{

    public FragmentEmail(){

    }

    //deklarasi widget
    EditText etEmailTujuan, etSubject, etTeks;

    Button btnKirimEmail;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_email, container, false);

        etEmailTujuan = (EditText)view.findViewById(R.id.etEmailTujuan);
        etTeks = (EditText)view.findViewById(R.id.etTeks);
        etSubject = (EditText) view.findViewById(R.id.etSubject);
        btnKirimEmail = (Button) view.findViewById(R.id.btnKrimEmail);

        btnKirimEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cek kalau no hp kosong
                String nEmailTujuan = etEmailTujuan.getText().toString();
                String nPesan = etTeks.getText().toString();
                String nSubject = etSubject.getText().toString();

                if (nEmailTujuan.isEmpty()){
                    etEmailTujuan.setError("Email tidak boleh kosong");
                }else {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ nEmailTujuan});
                    intent.putExtra(Intent.EXTRA_SUBJECT, nSubject);
                    intent.putExtra(Intent.EXTRA_TEXT, nPesan);
                    intent.setType("message/rfc822");
                    startActivity(Intent.createChooser(intent, "pilih email client :"));

                }
            }
        });



        return view;
    }
}
