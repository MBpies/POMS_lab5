package com.example.myfirstapp;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import static java.lang.Thread.sleep;

public class MyService extends Service {
    Task task;
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        PendingIntent pendingIntent = intent.getParcelableExtra(MainActivity.PEN_TAG);
        task = new Task(pendingIntent);
        Thread thread = new Thread(task,"THREAD0");
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        task.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private class Task implements Runnable{

        private PendingIntent pen;
        private boolean end = false;
        Task(PendingIntent pen){
            this.pen = pen;
        }
        void echo(Intent intent, int code){
            try{pen.send(MyService.this, code, intent);
            }
            catch (PendingIntent.CanceledException e){
                e.printStackTrace();
            }
        }
        void stop(){
            end = true;
        }
        @Override
        public void run() {
            echo(new Intent(),MainActivity.START);
            int a = 0;
            int b = 1;
            int buffer = 0;
            while (b<999999&&!end){
                buffer = b;
                b = a + b;
                a = buffer;
                echo(new Intent().putExtra(MainActivity.ECHO_TAG,b),MainActivity.ECHO);
                try{
                    sleep(2500);
                } catch (InterruptedException e){
                    e.printStackTrace();
                    break;
                }
            }
            echo(new Intent(),MainActivity.STOP);
        }

    }
}
