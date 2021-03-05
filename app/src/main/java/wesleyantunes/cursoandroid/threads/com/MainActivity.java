package wesleyantunes.cursoandroid.threads.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iniciarThread(View view){
       /* MyThread myThread = new MyThread();
        Toast.makeText(getApplicationContext(),"Executando Thread em segundo plano.",Toast.LENGTH_SHORT).show();
        myThread.start();*/
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();
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

    class MyRunnable implements Runnable{
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

}