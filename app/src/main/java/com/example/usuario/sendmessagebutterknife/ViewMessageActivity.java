package com.example.usuario.sendmessagebutterknife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.usuario.sendmessagebutterknife.pojo.Message;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Esta clase recive un mensaje y lo muestra en pantalla
 * @author mamorky
 * */
public class ViewMessageActivity extends AppCompatActivity {

    @BindView(R.id.txvViewMessage)
    TextView txvViewMessage;
    @BindView(R.id.txvViewUser)
    TextView txvViewUser;
    Message msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);

        //Muy importante necesario vincular
        ButterKnife.bind(this);

        //1. Recoger el Intent que se ha enviado
        Intent intent = getIntent();
        //2. Recoger el mensaje de Bundle
        Bundle bundle = intent.getExtras();
        //3. Mostrar el mensaje
        msg = (Message) bundle.getSerializable("mensaje");
        txvViewMessage.setText(msg.getMessage().toString());
        String viewUser = String.format(getResources().getString(R.string.txvViewUser), msg.getUser());
        txvViewUser.setText(viewUser);

        //Podriamos ahorranos pasos haciendo lo siguiente lo siguiente
        //txvViewMessage.setText(getIntent().getExtras().getString("message"));
    }

}
