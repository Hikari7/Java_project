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
public class Mypage <S1, S2> {  //generics
    private int price;
    private final S1 userName;  //field変数
    private final S1 passWord;
    public Mypage(S1 userName, S1 passWord) {
        //instansiate
        this.userName = userName; 
        this.passWord = passWord;

        //他のやつはlocal class
    }
    public S1 getUserName() {  //privateになっているフィールド変数を
        return userName;//フィールド名
    }
    public S1 getPassWord() {
        return passWord;
    }
    
    
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
            }

            } while ("aaaa" != null);

        // } while(Character.toLowerCase(option) != "e");
        // System.out.println("Thank you, have a great trip!");
        // Scanner.close();
    }
    
}
