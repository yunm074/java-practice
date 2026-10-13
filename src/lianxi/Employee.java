package lianxi;
public class Employee {
    String id;
    String name;
    double salary;

    public double getAnnualSalary(){
        return salary * 12;
    }

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.id = "001";
        emp.name = "张三";
        emp.salary = 10000;
        System.out.println(emp.getAnnualSalary());
    }
}
