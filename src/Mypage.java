import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mypage { // generics
    private final String userName; // final: 変更ができなくする
    private final String passWord;
    private int price; // field変数
    private String answer; // answerの仮の変数

    List<String> plan = new ArrayList<String>(){
        {
            add("Breakfast included"); //assume the user aleady reserved the plan
        }
    }; //playを配列に


    //method (like a function)
    public Mypage(String username, String password, int price ) {
        this.userName = username; // instansiate
        this.passWord = password; // 他のやつはlocal class
        this.price = price;

        //this: その変数が指すインスタンスのフィールドやメソッドを参照したり呼び出せるのと同じように、
        //自分自身のインスタンスを明示的に指し示し、そのフィールドやメソッドを使いたい時に使う変数
    }

    //fields
    public String getUserName() { 
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getAnswer() {
        return answer;
    }

    void additionalPlan(char choice) { // それぞれのadditional plan rateを足す
      
        switch (choice) {
            
            case 'a':
                if (plan.contains("Breakfast included")) {
                    System.out.println("You already booked this plan. Please confirm your booking info.");
                } else {
                    System.out.println("You added the additional plan successfully.\nPlease confirm your booking price on the top page.");
                    price = price + 50;
                    plan.add("Breakfast included.");
                }

                break;

            case 'b':
                if (plan.contains("Room service")) {
                    System.out.println("You already booked this plan. Please confirm your booking info.");
                } else {
                    System.out.println("You added the additional plan successfully.\nPlease confirm your booking price on the top page.");
                    price = price + 100;
                    plan.add("Room service");
                }

                break;

            case 'c':
                if (plan.contains("Rent a car")) {
                    System.out.println("You already booked this plan. Please confirm your booking info.");
                } else {
                    System.out.println("You added the additional plan successfully.\nPlease confirm your booking price on the top page.");
                    price = price + 150;
                    plan.add("Rent a car");
                }

                break;

            case 'd':
                if (plan.contains("Spa")) {
                    System.out.println("You already booked this plan. Please confirm your booking info.");
                } else {
                    System.out.println("You added the additional plan successfully.\nPlease confirm your booking price on the top page.");
                    price = price + 200;
                    plan.add("Spa");
                }

                break;

                default:
                System.out.println("Invalid option. Please try again.\n");
                break;
        }

    }

    void showMenu() {
        char option;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("✼••┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈••✼");
            System.out.println("*  My page | Hotel 我的家  *");
            System.out.println("✼••┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈••✼");
            System.out.println("A: See your booking info");
            System.out.println("B: Get additional plans");
            System.out.println("C: Cancel your reservation");
            System.out.println("D: Quit");
            option = scanner.next().charAt(0); // [a]bcd

            App.clearConsole();

            switch (option) {
                case 'a':
                    System.out.println("\n----------- Your booking info -------------");
                    System.out.println("* Total price: CAD " + price);
                    // plan.add("Breakfast included");
                    for (int i = 0; i < plan.size(); i++) {
                        System.out.println("* Additional plan: " + plan.get(i));
                    }
                    System.out.println("-------------------------------------------\n");
                    break;

                case 'b':
                    if (price < 1) {
                        System.out.println("You don't have any reservation.\n Please reserve a room first.\n");
                    } else {

                        System.out.println("*-------------------------------*");
                        System.out.println("      Get additional plans      ");
                        System.out.println("---------------------------------");
                        System.out.println("A: Breakfast included + $50");
                        System.out.println("B: Room service + $100"); 
                        System.out.println("C: Rent a car + $150"); 
                        System.out.println("D: Spa + $200"); 
                        System.out.println("---------------------------------");

                        char addplan;
                        addplan = scanner.next().charAt(0);
                        additionalPlan(addplan);

                        break;
                    }

                case 'c':
                    System.out.println("Are you sure you want to cancel the booking? Type [yes/no]\n");

                    answer = scanner.next();
                    if (answer.equals("yes")) {
                        System.out.println("Your booking canceled successfuly.");
                        System.out.println("Please confirm your price from the booking info.\n");
                        price = 0;
                        plan.clear();
                    } else if (answer.equals("no")) {
                        System.out.println("You'll be redirected the menu page.\n");
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }

                    break;

                
            }

        } while (Character.toLowerCase(option) != 'd'); // optionの時のcharがe(おわり)じゃなかったら
        System.out.println("Thank you for visiting us.\nHave a nice trip!\n\n");
        scanner.close();

    }
}
