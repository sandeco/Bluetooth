package sandeco.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 100;


    //BLUETOOTH
    private BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

    //THREADS

    private ImageButton btBt;
    private ImageButton btServer;
    private ImageButton btClient;

    private EditText input;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(adapter==null){
            Toast.makeText(this,"Seu mobile não tem bluetooth", Toast.LENGTH_LONG).show();
            finish();
        }else{

            input    = (EditText) findViewById(R.id.input);
            output   = (TextView) findViewById(R.id.output);
            btBt     = (ImageButton)findViewById(R.id.btnBT);
            btServer = (ImageButton)findViewById(R.id.btnServer);
            btClient = (ImageButton)findViewById(R.id.btnClient);
        }
    }


    public void ativarBT(View v){
        if (!adapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }


    public void ativarServidor(View v){
    }


    public void ativarCliente(View v){
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ENABLE_BT) {
            btBt.setBackgroundResource(R.drawable.ic_bluetoothON);

        }

    }

}
