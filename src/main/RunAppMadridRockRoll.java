package main;

import java.awt.EventQueue;

import control.ControllerMadridRockRoll;
import view.AddRunner;
import view.SeeRunner;
import view.WMadridRockRoll;


public class RunAppMadridRockRoll {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				WMadridRockRoll w = new WMadridRockRoll();
				AddRunner pAdd = new AddRunner();
				SeeRunner pSee = new SeeRunner();
				
				
				
				ControllerMadridRockRoll c = new ControllerMadridRockRoll(w, pAdd, pSee);
				
				w.setControl(c);
				pAdd.setControl(c);
				pSee.setControl(c);
				
				w.hacerVisible();
				
				
			}
		});
		
		
	}

}
