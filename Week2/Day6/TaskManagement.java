class Task {

    int taskId;
    String taskName;
    String status;

    Task next;

    Task(int taskId,
         String taskName,
         String status){

        this.taskId=taskId;
        this.taskName=taskName;
        this.status=status;
    }
}

class TaskLinkedList {

    Task head=null;

    // Add
    void addTask(int id,
                 String name,
                 String status){

        Task newTask=
                new Task(id,name,status);

        if(head==null){
            head=newTask;
        }
        else{

            Task temp=head;

            while(temp.next!=null)
                temp=temp.next;

            temp.next=newTask;
        }
    }

    // Search
    void searchTask(int id){

        Task temp=head;

        while(temp!=null){

            if(temp.taskId==id){

                System.out.println(
                        temp.taskId+" "+
                        temp.taskName+" "+
                        temp.status);

                return;
            }

            temp=temp.next;
        }

        System.out.println("Task not found");
    }

    // Traverse
    void displayTasks(){

        Task temp=head;

        while(temp!=null){

            System.out.println(
                    temp.taskId+" "+
                    temp.taskName+" "+
                    temp.status);

            temp=temp.next;
        }
    }

    // Delete
    void deleteTask(int id){

        if(head==null)
            return;

        if(head.taskId==id){
            head=head.next;
            return;
        }

        Task temp=head;

        while(temp.next!=null &&
                temp.next.taskId!=id){

            temp=temp.next;
        }

        if(temp.next!=null)
            temp.next=temp.next.next;
    }

    public static void main(String args[]){

        TaskLinkedList list=
                new TaskLinkedList();

        list.addTask(1,
                "Coding",
                "Pending");

        list.addTask(2,
                "Testing",
                "Completed");

        list.displayTasks();

        System.out.println("\nSearch:");
        list.searchTask(2);

        list.deleteTask(1);

        System.out.println(
                "\nAfter Delete:");

        list.displayTasks();
    }
}