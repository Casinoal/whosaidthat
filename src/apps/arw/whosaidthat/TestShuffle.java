package apps.arw.whosaidthat;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.os.Bundle;
import apps.arw.whosaidthat.R;

public class TestShuffle extends Activity{    
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_test_shuffle);
	    
	}
	    
	    public static void main(String[] args) {     
		//define ArrayList to hold Integer objects    
		ArrayList<Integer> numbers = new ArrayList<Integer>();    
		for(int i = 0; i < 40; i++)     {  
			
			numbers.add(i+1);   }    
		
		Collections.shuffle(numbers);     
		
		System.out.print("This week's lottery numbers are: ");    
		for(int j =0; j < 6; j++)     {   
			System.out.print(numbers.get(j) + " ");   
			}   
		
		
	    
	    } 
	}
	
