import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Publication technical = new Publication();
        Book java = new Book();
        Magzine business = new Magzine();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Accept and Display Publication");
            System.out.println("2. Accept and Display Book");
            System.out.println("3. Accept and Display Magazine");
            System.out.println("4. Order and Sale Book");
            System.out.println("5. Current Issue and Received Issue of Magazine");
            System.out.println("6. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    technical.accept();
                    technical.display();
                    break;
                case 2:
                    java.accept();
                    java.display();
                    break;
                case 3:
                     business.accept();
                     business.display();

                    break;
                case 4:
                    java.accept();
                    java.display();
                    int order = java.orderCopy();
                    java.saleCopy(order);
                    technical.saleCopy(order);
                    break;
                case 5:
                    business.accept();
                    int current =   business.currentIssued();
                    business.receivedIssue(current);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    }
public class Publication {
    String title;
    public int price;
    public int copy;


    public Publication() {

    }

    public Publication(String title, int price, int copy) {
        this.title = title;
        this.price = price;
        this.copy = copy;
    }
    public void accept() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter title of Publication");
        this.title = sc.nextLine();


    }
    public void display() {
        System.out.println("Title: " + this.title);

    }



    public int saleCopy(int orders){
        System.out.println("Total sale of publication " + orders);
        return orders;
    }



}
public class Book extends Publication{
    private String author;


    public Book() {

    }

    public Book(String title, int price, int copy, String author) {
        super(title, price, copy);
        this.author = author;

    }

    @Override
    public void accept() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter title of book");
        this.title = sc.nextLine();
        System.out.println("Enter name of author");
        this.author = sc.nextLine();
        System.out.println("Enter copies of " + this.title );
        this.copy = sc.nextInt();
        System.out.println("Enter price of book " + this.title);
        this.price = sc.nextInt();

    }

    @Override
    public void display() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Price: " + this.price);

    }

    public int orderCopy() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of copies of " + this.title + " to order");
        int order = sc.nextInt();
        if(order <= copy) {
            this.copy -= order;
            System.out.println("Total orders of book " + this.author + " " + order);
        }
        else{
            System.out.println("Insufficient copies");
        }
         return order;
    }

    @Override
    public int saleCopy(int orders){
        if(orders <= copy) {
            System.out.println("Total books of " + this.title + " sold " + orders);
        }

        return orders;
    }


}
public class Magzine extends Publication {

    public Magzine() {
        super();
    }


    public Magzine(String title, int price, int copy) {
        super(title, price, copy);

    }
    @Override
    public void accept() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter title of Magazine");
        this.title = sc.nextLine();
        System.out.println("Enter total copies of Magazine");
        this.copy = sc.nextInt();


    }

    @Override
    public void display(){
        System.out.println("Title of Magazine : " + this.title);
        System.out.println("Total copies of magazine : " + this.copy);
    }
    public void orderCopy() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of copies to order");
         int orders = sc.nextInt();
        if(orders <= copy) {
            copy-=orders;
            System.out.println("Total order of Magazine : "+ this.title + " are " + orders);

        }
        else {
            System.out.println("Insufficient copies");
        }
    }
    public int currentIssued() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of copies of " + this.title + " to issue");
        int current = sc.nextInt();
        sc.nextLine();  // Consume the newline left-over

        System.out.println("Enter date of issue in dd/mm/yyyy format");
        String date = sc.nextLine();

        System.out.println("Date of Issue of " + this.title + ": " + date);
        if (current <= this.copy) {
            this.copy -= current;
            System.out.println("Total Magazines issued: " + current);
        } else {
            System.out.println("Insufficient Magazines");
        }
        return current;
    }
    public void receivedIssue(int current) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total received copies of " + this.title);
        int received = sc.nextInt();
        sc.nextLine();  // Consume the newline left-over

        System.out.println("Enter date of received in dd/mm/yyyy format");
        String date = sc.nextLine();

        if (received < current) {
            System.out.println("Received Date of " + this.title + ": " + date);
            System.out.println("Magazines yet to be received: " + (current - received));
        }
        else {
            System.out.println("Received Date of " + this.title + ": " + date);
        }
        this.copy+=received;
    }

    @Override
    public int saleCopy(int orders){

        System.out.println("Total magazine " + this.title + " sold " + orders  );
        return orders;
    }




}