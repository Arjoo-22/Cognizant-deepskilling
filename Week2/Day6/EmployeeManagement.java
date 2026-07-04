class Employee {

    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId,
             String name,
             String position,
             double salary) {

        this.employeeId=employeeId;
        this.name=name;
        this.position=position;
        this.salary=salary;
    }

    void display() {
        System.out.println(
                employeeId+" "+
                name+" "+
                position+" "+
                salary
        );
    }
}

public class EmployeeManagement {

    Employee employees[]=new Employee[10];
    int size=0;

    // Add
    void addEmployee(Employee e){

        if(size<employees.length){
            employees[size]=e;
            size++;
        }
    }

    // Search
    void searchEmployee(int id){

        for(int i=0;i<size;i++){

            if(employees[i].employeeId==id){
                employees[i].display();
                return;
            }
        }

        System.out.println("Not Found");
    }

    // Traverse
    void displayEmployees(){

        for(int i=0;i<size;i++)
            employees[i].display();
    }

    // Delete
    void deleteEmployee(int id){

        int index=-1;

        for(int i=0;i<size;i++){

            if(employees[i].employeeId==id){
                index=i;
                break;
            }
        }

        if(index==-1){
            System.out.println("Not Found");
            return;
        }

        for(int i=index;i<size-1;i++)
            employees[i]=employees[i+1];

        size--;
    }

    public static void main(String[] args){

        EmployeeManagement obj=
                new EmployeeManagement();

        obj.addEmployee(
                new Employee(1,
                        "Arjoo",
                        "Developer",
                        50000)
        );

        obj.addEmployee(
                new Employee(2,
                        "Rahul",
                        "Tester",
                        40000)
        );

        obj.displayEmployees();

        System.out.println("\nSearch:");
        obj.searchEmployee(2);

        obj.deleteEmployee(1);

        System.out.println("\nAfter Delete:");
        obj.displayEmployees();

    }
}