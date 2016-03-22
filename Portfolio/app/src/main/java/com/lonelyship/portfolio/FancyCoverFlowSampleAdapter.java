/*
 * Copyright 2013 David Schreiber
 *           2013 John Paul Nalog
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.lonelyship.portfolio;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import at.technikum.mti.fancycoverflow.FancyCoverFlow;
import at.technikum.mti.fancycoverflow.FancyCoverFlowAdapter;

class FancyCoverFlowSampleAdapter extends FancyCoverFlowAdapter {

	 int width  ;	
	 int height  ;
	 int imageWidth;
	 int imageHeight;
	
	// =============================================================================
	// Private members
	// =============================================================================
	private Activity a;
	FancyCoverFlowSampleAdapter (Activity a){
		this.a = a;
		Display mDisplay = a.getWindowManager().getDefaultDisplay(); 
		 width  = mDisplay.getWidth(); 
		 height = mDisplay.getHeight();
		//Toast.makeText(a, "width:"+width+" height:"+height, Toast.LENGTH_LONG).show();
		 imageWidth=width/4;
		 imageHeight=height*2/3;
		
	}
	
	private int[] images = { R.drawable.paint_master, R.drawable.bingo, R.drawable.hks,
			R.drawable.holdem, R.drawable.line_toy, R.drawable.random_keyboard,R.drawable.hologram
           ,R.drawable.kp};

	// =============================================================================
	// Supertype overrides
	// =============================================================================

	@Override
	public int getCount() {
		return images.length;
	}
	
	@Override
	public Integer getItem(int i) {
		return images[i];
	}

	@Override
	public long getItemId(int i) {
		return i;
	}
 

	@Override
	public View getCoverFlowItem(int i, View reuseableView, ViewGroup viewGroup) {
		CustomViewGroup customViewGroup = null;

		if (reuseableView != null) {
			customViewGroup = (CustomViewGroup) reuseableView;
		} else {
			customViewGroup = new CustomViewGroup(viewGroup.getContext());
			customViewGroup.setLayoutParams(new FancyCoverFlow.LayoutParams(
					imageWidth, imageHeight));
		}

		customViewGroup.getImageView().setImageResource(this.getItem(i));

		switch (i) {
		case 0:
            customViewGroup.getTextView_up().setText("繪畫大師");
			customViewGroup.getTextView_down().setText("2014.11~2015.1");
			break;
		case 1:
            customViewGroup.getTextView_up().setText("Bingo");
            customViewGroup.getTextView_down().setText("2015.2");
			break;
		case 2:
            customViewGroup.getTextView_up().setText("好康多");
            customViewGroup.getTextView_down().setText("2015.3");
			break;
		case 3:
            customViewGroup.getTextView_up().setText("德州撲克");
            customViewGroup.getTextView_down().setText("2015.4");
			break;
		case 4:
            customViewGroup.getTextView_up().setText("搖頭娃娃");
            customViewGroup.getTextView_down().setText("2015.5");
            break;
        case 5:
            customViewGroup.getTextView_up().setText("動態鍵盤");
            customViewGroup.getTextView_down().setText("2015.6");
            break;
        case 6:
            customViewGroup.getTextView_up().setText("全息投影");
            customViewGroup.getTextView_down().setText("2015.8");
            break;
        case 7:
            customViewGroup.getTextView_up().setText("太鼓達人");
            customViewGroup.getTextView_down().setText("2015.9");
            break;
		default:
			break;
		}

        customViewGroup.getTextView_up().setTextSize(30);
        customViewGroup.getTextView_up().setBackgroundColor(Color.BLACK);
        customViewGroup.getTextView_up().setTextColor(Color.WHITE);
		customViewGroup.getTextView_down().setTextSize(20);
		customViewGroup.getTextView_down().setBackgroundColor(Color.BLACK);
        customViewGroup.getTextView_down().setTextColor(Color.WHITE);

		return customViewGroup;
	}
}

class CustomViewGroup extends LinearLayout {

	// =============================================================================
	// Child views
	// =============================================================================

	private TextView textView_up;
    private TextView textView_down;
	private ImageView imageView;

	// =============================================================================
	// Constructor
	// =============================================================================

	CustomViewGroup(Context context) {
		super(context);

		this.setOrientation(VERTICAL);

		this.textView_up = new TextView(context);
        this.textView_down = new TextView(context);
		this.imageView = new ImageView(context);

		LayoutParams layoutParams = new LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
		this.textView_up.setLayoutParams(layoutParams);
        this.textView_down.setLayoutParams(layoutParams);
		this.imageView.setLayoutParams(layoutParams);
		this.textView_up.setGravity(Gravity.CENTER);
        this.textView_down.setGravity(Gravity.CENTER);
		this.imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		this.imageView.setAdjustViewBounds(true);

        this.addView(this.textView_up);
		this.addView(this.imageView);
		this.addView(this.textView_down);
	}

	// =============================================================================
	// Getters
	// =============================================================================

    TextView getTextView_up() {
        return textView_up;
    }

	TextView getTextView_down() {
		return textView_down;
	}

	ImageView getImageView() {
		return imageView;
	}
}
