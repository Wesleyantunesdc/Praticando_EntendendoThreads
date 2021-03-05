package wesleyantunes.cursoandroid.threads.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button botaoIniciar;
    private String texto;
    private Handler handler = new Handler();
    private boolean pararExecucao = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botaoIniciar = findViewById(R.id.btn_iniciar);
    }

    public void iniciarThread(View view){
       /* MyThread myThread = new MyThread();
        Toast.makeText(getApplicationContext(),"Executando Thread em segundo plano.",Toast.LENGTH_SHORT).show();
        myThread.start();*/

        pararExecucao = false;
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();
    }

    public void pararThread(View view){
        pararExecucao = true;
    }


    class MyThread extends Thread{
        @Override
        public void run() {
            for(int i=0; i<=15; i++){
                Log.d("Thread", "Contador: "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Thread secundarias não podem fazer alterações na interface do usuario, somente a UI(Principal) pode realizar;
    class MyRunnable implements Runnable{
        @Override
        public void run() {
            for(int i=0; i<=15; i++){
                if(pararExecucao) {
                    return;
                }
                texto = "Contador: "+i;
                Log.d("Thread", "Contador: "+i);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        botaoIniciar.setText(texto);
                    }
                });

//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        botaoIniciar.setText(texto);
//                    }
//                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}