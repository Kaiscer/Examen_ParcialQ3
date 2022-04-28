package model;

import java.util.ArrayList;


public class DataBase {
	
	
	private ArrayList<Runner> listRunners;
	
	
	
	
	public DataBase() {
		
		listRunners = new ArrayList<Runner>();
		
	}
	
	
	public void addCorredor (Runner runner) {
		
		listRunners.add(runner);
		
	}


	public ArrayList<Runner> getListRunners() {
		return listRunners;
	}


	public ArrayList<Runner> getListFilter(String filter) {
		ArrayList<Runner> listFilters = new ArrayList<Runner>();
		
		for (Runner runner : listRunners) {
			if (runner.getSexo().equals(filter)) {
				
				listFilters.add(runner);
			}
			
		}
		
		return listFilters;
	}
	
	
	

}
