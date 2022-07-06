import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

/* 1) login: user_name, PW
* 2) reservation number
* 3) showMenu
* 4)
* A: check current info
* - DD/MM/YYYY, Price, Option (Breakfast Only)
* - $250
* 
* B: Change the meal plans
* 
* a: Room Only -> - $50
* b: Brakfast Only -> 0
* c: Half Board -> + $60
* d: Full Board -> + $80
* 
* C: Cancel the reservation
* -> show the refund price
* 
* D: Quit "Thank you!"
* 
* E: error message
*/
// public class Mypage <S1, S2> {  //generics
public class Mypage  {  //generics
    private final int price;              //field変数
    private final String userName;      //final: 変更ができなくする
    private final String passWord;
    // private final S1 userName;
    // private final S1 passWord;


    public Mypage(String string, String string2, int i) {
        this.userName = string;      //instansiate
        this.passWord = string2;      //他のやつはlocal class
        this.price = i;   
    }

    public String getUserName() {  //privateになっているフィールド変数を
        return userName;//フィールド名
    }
    public String getPassWord() {
        return passWord;
    }
    
    String answer;
    
    void showMenu() {
        char option;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("===========================");
            System.out.println("Welcome to travel.com");
            System.out.println("===========================");
            System.out.println("A: Check your booking info");
            System.out.println("B: Change the meal plan");
            System.out.println("C: Cancel the reservation");
            System.out.println("D: Quit");
            option = scanner.next().charAt(0);  //[a]bcd

            switch (option) {
                case 'a': 
                System.out.println("----------------");
                System.out.println("Booking price: " + price);
                System.out.println("----------------");
                System.out.println("\n");
                break;

                case 'b':
                System.out.println("----------------");
                System.out.println("Which meal plan would you want to change?");
                System.out.println("A: Room Only");   // -50$
                System.out.println("B: Breakfast Only");   // 0$
                System.out.println("C: Half borad (includes two meals)");  // + 50$
                System.out.println("D: Full board (includes the three main meals)");   // + 80$
                System.out.println("----------------");
                System.out.println("\n");
                break;

                case 'c':
                System.out.println("Are you sure you want to cancel the booking? Type [yes/no]");
                if (answer.equals("yes")){
                    System.out.println("Your booking were canceled successfuly.");
                } else {
                    System.out.println("OK.");
                }
                break;    
                }

            
        

            } while (Character.toLowerCase(option)!= 'd');   //optionの時のcharがe(おわり)じゃなかったら
            System.out.println("Thank you for visiting us. Have a nice trip!");
            scanner.close();

    }
    
}
