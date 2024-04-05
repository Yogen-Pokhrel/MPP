package Lab3.prob1;

public class PersonWithJob {
	
	private double salary;
	Person person;
	
	public double getSalary() {
		return salary;
	}
	PersonWithJob(String n, double s) {
		person = new Person(n);
		salary = s;
	}
	
	@Override
	public boolean equals(Object aPersonWithJob) {
		if(aPersonWithJob == null) return false;
		if(!(aPersonWithJob instanceof PersonWithJob)) return false;
		PersonWithJob p = (PersonWithJob)aPersonWithJob;

		//person comparison is delegated to person class
		return this.person.equals(p.person) &&
				this.getSalary()==p.getSalary();
	}
	public static void main(String[] args) {
		PersonWithJob p1 = new PersonWithJob("Joe", 20000);
		PersonWithJob p2 = new PersonWithJob("Joe" , 20000);

		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}

}
