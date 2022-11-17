package com.aa.act.interview.org;

import java.util.Optional;

public abstract class Organization {

	private Position root;
	
	public Organization() {
		root = createOrganization();
	}
	
	protected abstract Position createOrganization();
	
	/**
	 * hire the given person as an employee in the position that has that title
	 * 
	 * @param person
	 * @param title
	 * @return the newly filled position or empty if no position has that title
	 */
        
        int identifier=999;
	public Optional<Position> hire(Name person, String title) {
		//your code here
		
		identifier=identifier+1;// generates an employee number
		Employee empl=new Employee(identifier, person); // assigns that employee number and first and last name to the person
		Position posn= new Position(title,empl); //assigns corresponding title to the employee 
		root.addDirectReport(posn);//adds direct report
		 return Optional.of(posn);
	}

	@Override
	public String toString() {
		return printOrganization(root,"");
	}
	
	private String printOrganization(Position pos, String prefix) {
		StringBuffer sb = new StringBuffer(prefix + "+-" + pos.toString() + "\n");
		for(Position p : pos.getDirectReports()) {
			sb.append(printOrganization(p, prefix + "\t"));
		}
		return sb.toString();
	}
}
