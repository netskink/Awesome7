// Copyright (c) 2014, John F. Davis davisjf@gmail.com
// All rights reserved.
// 
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met: 
// 
// 1. Redistributions of source code must retain the above copyright notice, this
// list of conditions and the following disclaimer. 
// 2. Redistributions in binary form must reproduce the above copyright notice,
// this list of conditions and the following disclaimer in the documentation
// and/or other materials provided with the distribution. 
// 
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
// ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
// WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
// DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
// ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
// (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
// LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
// ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
// SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
// 
// The views and conclusions contained in the software and documentation are those
// of the authors and should not be interpreted as representing official policies, 
// either expressed or implied, of the FreeBSD Project.

package net.skink.awesome7;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.Activity;

public class MyMenuActivity extends Activity {
	

    int screenWidth;
    int screenHeight;	                

	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Bundle theBundle;
		theBundle = getIntent().getExtras();

		if (null != theBundle) {
			screenWidth=theBundle.getInt("screenWidth");
			screenHeight=theBundle.getInt("screenHeight");
		}
		super.onCreate(savedInstanceState);

	}	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.my_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	  	Intent intent;
	   	switch (item.getItemId()) {
	   	case R.id.menuItemAbout:
	       	intent = new Intent(this,AboutActivity.class);
			startActivity(intent);
	   		return true;
	   	
	   	default:
	   		return super.onOptionsItemSelected(item);
	   	}
	
	}

	public void startNewActivity(Class<?> cls, String stWarframeName) {
		
	    Intent intent = new Intent(this,cls);
	    intent.putExtra("warframe_name",stWarframeName);
//	    intent.putExtra("toonID",toonID);
//	    intent.putExtra("toonFactionName",toonFactionName);

	    startActivity(intent);

	}
}
