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

import java.io.File;
import java.util.Locale;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class ToonActivity extends MyMenuActivity {
	
	TextView mTvWarframeName;
	CharSequence stWarframeName;
	ImageView mIvPortrait;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.toon);
		mTvWarframeName = (TextView) findViewById(R.id.warframe_name);
		mIvPortrait = (ImageView) findViewById(R.id.imageView1);
		
	    // the name
		Bundle theBundle = getIntent().getExtras();
		stWarframeName = theBundle.getString("warframe_name");
		mTvWarframeName.setText(stWarframeName);
		
		// the portrait
		String stLowerCaseName = stWarframeName.toString().toLowerCase(new Locale("en"));
	
		// This does not work for me
		//int imageResource = getResources().getIdentifier("drawable/"+stLowerCaseName + ".jpg", null, getPackageName());
		//Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageResource);
		//mIvPortrait.setImageBitmap(bitmap);
		
		// 
		Context context = mIvPortrait.getContext();
		int id = context.getResources().getIdentifier(stLowerCaseName, "drawable", context.getPackageName());
		mIvPortrait.setImageResource(id);
	
		// Supposedly this  works if you download a file and want to view it.
		//String fname=new File(getFilesDir(), "drawable/"+stLowerCaseName+".jpg").getAbsolutePath();
        //Bitmap myBitmap = BitmapFactory.decodeFile(fname);
        //mIvPortrait.setImageBitmap(myBitmap);
	}
}
