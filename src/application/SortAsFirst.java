package application;

import java.util.Comparator;

public class SortAsFirst implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o2.getFirst_name().compareTo(o1.getFirst_name());
	}

}
