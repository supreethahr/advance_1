package com.example.advance_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtName, txtPass;
    Button btnSave, btnCancel;
    TextView txtResult;
    private static final String NAME_KEY = "username";
    private static final String PASS_KEY = "password";
    private static final String MESSAGE_KEY = "message";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (EditText) findViewById(R.id.txtName);
        txtPass = (EditText) findViewById(R.id.txtPass);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        txtResult=(EditText)findViewById(R.id.txtResult);

        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
                String name = txtName.getText().toString();
                String pass = txtPass.getText().toString();

                Intent intent = new Intent(this, LogInVerifyActivity.class);

                Bundle bb = new Bundle();
                bb.putString(PASS_KEY, pass);

                intent.putExtras(bb);
                startActivityForResult(intent, 2);
                break;
            case R.id.btnCancel:
                break;
        }

    }




@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
  {
        super.onActivityResult(requestCode,resultCode,data);
    Log.d( "tag","Inside onActivityResult");
    if (requestCode==2)
        btnSave.setEnabled(false);
        String message=data.getStringExtra(MESSAGE_KEY);
    Toast.makeText( this,message,Toast.LENGTH_LONG).show();
  }
}




