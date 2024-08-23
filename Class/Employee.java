public class Employee {

    // declaring variables

    int id;
    String name;
    float salary;

    // declaring constructor

    public Employee(int id, String name, float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // declaring display function

    public void Display() {
        System.out.println("Salary Before Bonus: ");
        System.out.println("id: " + id + "\t name: " + name + "\t salary: " + salary);

        // Increasing Salary by 20%

        System.out.print("Salary After Bonus: ");
        System.out.println((salary + salary * 0.20) + "\n");
    }
}
