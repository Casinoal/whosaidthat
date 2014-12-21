package apps.are.whosaidthat;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;



public class MainGame extends Activity implements OnClickListener {

	//Declaring buttons and sounds 
	
	ImageButton animal1;
	ImageButton animal2;
	ImageButton animal3;
	ImageButton animal4;
	MediaPlayer spoke;
	MediaPlayer right;
	MediaPlayer wrong;
	int file;
	Button button1, button2;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_game);
		
		//Generate a random number
		
		Random rnd = new Random();
		int noise = (int) rnd.nextInt(4)+1;

		// Take the random number and add it to the word animal... to create the sound file
		
		file = (this.getResources().getIdentifier("animal" + noise, "raw", this.getPackageName()));
		
		//play the random animal noise 
			
		spoke = MediaPlayer.create(this, file);
		spoke.start();
		
		
		animal1 = (ImageButton) findViewById(R.id.animal1);
		animal1.setOnClickListener(this);
		animal2 = (ImageButton) findViewById(R.id.animal2);
		animal2.setOnClickListener(this);
		animal3 = (ImageButton) findViewById(R.id.animal3);
		animal3.setOnClickListener(this);
		animal4 = (ImageButton) findViewById(R.id.animal4);
		animal4.setOnClickListener(this);
		
		
	}

	// this links to the button on-click event - it triggers the activity replay
	 public void replay(View view) {   
		
		 spoke.start();
		
	 }
	 
	 //this links to the new game button on click event - triggers a new game
	 public void newgame(View view) { 
		 Intent launchactivity= new Intent(MainGame.this,MainGame.class);                               
    	 startActivity(launchactivity);
	 }
	
	 public void onClick(View v) {
	
		 StopIfPlaying();
		 
		 int id = v.getId();

		 //turning the two integers into strings.  Both integers were DB file references.  These get the actual file names
		 
		 String button_name = getResources().getResourceEntryName(id);
		 String spoke_name = getResources().getResourceEntryName(file);
		 
		 //Some toast for troubleshooting to check what's being returned
		 //Toast.makeText(this, button_name, Toast.LENGTH_SHORT).show();
		 //Toast.makeText(this, spoke_name, Toast.LENGTH_SHORT).show();
		  
		 
		 //if the button pressed name is the same as the sound file name= correct
		 
		 if ( button_name.equals(spoke_name)) {

	        	right = MediaPlayer.create(this, R.raw.right);
				right.start();        
				
				//  wait for the correct sound clip to play, then start a new game
				right.setOnCompletionListener(new OnCompletionListener() {

		            @Override
		            public void onCompletion(MediaPlayer right) {
		        
				
				Intent launchactivity= new Intent(MainGame.this,MainGame.class);                               
		    	 startActivity(launchactivity);
		            }
				
				});
				
				//else the button was wrong - play the wrong sound
		      				
		 }else {
		 
			 wrong = MediaPlayer.create(this, R.raw.notright);
			 
			 if(wrong.isPlaying())
             {
			Toast.makeText(this, "playing", Toast.LENGTH_SHORT).show();
          //   wrong.stop();
           //  wrong.reset();
            // wrong.release();
             }
			 else{
				 
				wrong = MediaPlayer.create(this, R.raw.notright);
				wrong.start();    
			 }
				
			
			  
				
				
				
	                

	        }

		 }
	 private void StopIfPlaying() {  
		 if(wrong != null && wrong.isPlaying())  
		 {  
		 wrong.stop();  
		 }  
		 } 	         
	 }

			
	
			
	



