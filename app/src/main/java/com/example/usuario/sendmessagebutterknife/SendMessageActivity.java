package com.example.usuario.sendmessagebutterknife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.usuario.sendmessagebutterknife.pojo.Message;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.ButterKnife;

/**
 * Esta clase envia un mensaje de un usuario a otro
 *
 * @author mamorky
 *         Concenptos Aprendidos:
 *         <ul>
 *         <li>Concepto Context</li>
 *         <li>Paso de mensajes entre dos actividades mediante la clase @see android.content.Intent</li>
 *         <li>Paso de parámetros mediante el objeto @see android.os.Bundle</li>
 *         </ul>
 */
public class SendMessageActivity extends AppCompatActivity {

    @BindView(R.id.edtMessage)
    EditText edtMessage;
    @BindView(R.id.edtUser)
    EditText edtUser;
    @BindView(R.id.btnOk)
    Button btnOk;

    private static final String TAG = "SendMessageActivity";

    Message msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        // Vincular el ButterKnife
        ButterKnife.bind(this);}

        @OnClick(R.id.btnOk)
        public void getOnClick(View view)
        {
            switch (view.getId()){
                case R.id.btnOk:
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("mensaje",new Message(edtMessage.getText().toString(),edtUser.getText().toString()));
                    Intent intent = new Intent(SendMessageActivity.this,ViewMessageActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
            }
    }
}
