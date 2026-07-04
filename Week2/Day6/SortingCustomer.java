public class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    void display() {
        System.out.println(orderId + " " +
                customerName + " " +
                totalPrice);
    }
}

public class OrderSorting {

    // Bubble Sort
    static void bubbleSort(Order arr[]) {
        int n = arr.length;

        for(int i=0;i<n-1;i++) {
            for(int j=0;j<n-i-1;j++) {

                if(arr[j].totalPrice >
                        arr[j+1].totalPrice) {

                    Order temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    static void quickSort(Order arr[],
                          int low,
                          int high) {

        if(low<high) {

            int p=partition(arr,low,high);

            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }
    }

    static int partition(Order arr[],
                         int low,
                         int high) {

        double pivot=arr[high].totalPrice;

        int i=low-1;

        for(int j=low;j<high;j++) {

            if(arr[j].totalPrice<pivot) {

                i++;

                Order temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        Order temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;
    }

    static void display(Order arr[]) {
        for(Order o:arr)
            o.display();
    }

    public static void main(String[] args) {

        Order orders[]={
                new Order(1,"Arjoo",4500),
                new Order(2,"Rahul",1200),
                new Order(3,"Priya",8000),
                new Order(4,"Aman",3000)
        };

        System.out.println("Before Sorting:");
        display(orders);

        quickSort(orders,0,orders.length-1);

        System.out.println("\nAfter Sorting:");
        display(orders);
    }
} 
