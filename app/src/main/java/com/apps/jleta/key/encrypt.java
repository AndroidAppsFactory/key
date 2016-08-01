package com.apps.jleta.key;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.jleta.key.secret.Decrypt;
import com.apps.jleta.key.secret.Encryptor;

public class encrypt extends AppCompatActivity {

    //TODO
    private static String seed = "replace with the correct key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_encrypt, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickEncrypt(View view) {
        try {
            String output = new Encryptor().encrpt(seed, ((EditText) findViewById(R.id.txtPass)).getText().toString());
            ((EditText) findViewById(R.id.txtEncryptionOutput)).setText(output);
            copyToClipBoard(output);
        }catch(Exception ex){
            Toast.makeText(getBaseContext(), "something went wrong!", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickDecrypt(View view) {
        try{
            String output = new Decrypt().decrypt(seed, ((EditText) findViewById(R.id.txtPass)).getText().toString());
            ((EditText) findViewById(R.id.txtEncryptionOutput)).setText(output);
            copyToClipBoard(output);
        }catch(Exception ex){
            Toast.makeText(getBaseContext(), "something went wrong!", Toast.LENGTH_LONG).show();
        }
    }

    private void copyToClipBoard(String text) {
        ClipboardManager clipMan = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("text", text);
        clipMan.setPrimaryClip(clip);
        Toast.makeText(getBaseContext(), "done!", Toast.LENGTH_LONG).show();
    }
}
