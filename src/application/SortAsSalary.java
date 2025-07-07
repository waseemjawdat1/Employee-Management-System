package application;

import java.util.Comparator;

public class SortAsSalary implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return Double.compare(o2.pay(), o1.pay());
	}
	

}
