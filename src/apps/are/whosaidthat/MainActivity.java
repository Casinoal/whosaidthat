package apps.are.whosaidthat;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity{

	//zoom
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
  MediaPlayer hi = MediaPlayer.create(this, R.raw.welcomewho);
  hi.start();

    
        final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      
      public void run() {
    	    Button btn = (Button)findViewById(R.id.button1);
    	    btn.setVisibility(View.VISIBLE); //View.GONE, View.INVISIBLE are available too.
    	    
    	      	    
      }
    }, 3000);
    

    
   
    Button button = (Button) findViewById(R.id.button1);
    button.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
        	Intent launchactivity= new Intent(MainActivity.this,MainGame.class);                               
        	 startActivity(launchactivity);
        	
     
        }          
    });
   
    }}
    

