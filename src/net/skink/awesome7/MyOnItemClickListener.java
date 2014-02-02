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


import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

// This class handles the main list 
public class MyOnItemClickListener implements OnItemClickListener {

	 private static String TAG = "OnItemClickListener";
	 private MyMenuActivity theCallingActivity = null;


	public MyOnItemClickListener(MainActivity a) {
		// TODO Auto-generated constructor stub
		theCallingActivity = a;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
		Log.d(TAG, "onitemselected"); 
		String selectedListItemName;
   	
    	switch (parent.getId()){
    	case R.id.listView1:
    		selectedListItemName = parent.getItemAtPosition(pos).toString();
    		//Toast.makeText(v.getContext(), companionName, Toast.LENGTH_SHORT).show();
    		break;

    	default:
    		return;
    	}
//    	if (selectedListItemName.equals("called")) {
//        	theCallingActivity.startNewActivity(ToonActivity.class);
//    		
//    	} else if (selectedListItemName.equals("another called")) {
//        	theCallingActivity.startNewActivity(AnotherCalledActivity.class);
//    	}   		
       	theCallingActivity.startNewActivity(ToonActivity.class,selectedListItemName);
    	
	}

}
