package com.hr;

import com.ht.PilotPen;

public class PenAdapter implements Pen{

	PilotPen pp  = new PilotPen();
	
	@Override
	public void write(String s) {
		pp.marks(s);
		
	}

}
