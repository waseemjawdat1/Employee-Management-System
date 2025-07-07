package application;

import java.util.Comparator;

public class SortAsEducation implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o2.getEducation().compareTo(o1.getEducation());
	}

}
