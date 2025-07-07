package application;

import java.util.Comparator;

public class SortAsLast implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o2.getLast_name().compareTo(o1.getLast_name());
	}

}
