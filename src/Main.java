import java.io.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        String pin = "";
        Account acc = null;
        Bank bank = new Bank(pin, "", 0);
        Bank loadedBank = loadBankDataFromFile("bank_data.ser");
        boolean userBool = false;
        boolean userPin = false;



        Scanner myObj = new Scanner(System.in);

        System.out.println("Please choose the number of service you would like: 1: Make a banking account || 2: Sign in ");
        String choice = myObj.nextLine();
        if (choice.equals("1")) {
            System.out.println("Please choose a username ");
            acc = new Account(pin, "", 0);
            acc.setName(myObj.nextLine());
            bank.setName(acc.getName());
            while (pin == null || pin.length() != 4) {
                System.out.println("Please choose a 4-digit PIN ");
                pin = myObj.nextLine();

                if (pin.length() != 4) {
                    System.out.println("Invalid PIN. Please enter exactly 4 digits.");
                }
            }

            bank.setPin(pin);

            bank.setBalance(acc.getBalance());
            System.out.println("NUMBER is: " + bank.getPin());


            System.out.println("Username is: " + bank.getName());
            System.out.println("Balance is: " + bank.getBalance());
            saveBankDataToFile(bank, "bank_data.ser");

            System.out.println("Would you like another service: 1: Make a banking account || 2: Sign in || 3: Deposit Money || 4: Make a transaction || 5: Change your PIN || 6: Check your remaining balance ");
             choice = myObj.nextLine();


        }

        if (choice.equals("2")) {
            System.out.println("Enter your username");
            String user = myObj.nextLine();

            if (loadedBank.getName().equals(user)) {
                System.out.println(loadedBank.getBalance());
                userBool = true;
            }
            System.out.println("Enter your pin");
            String pinInp = myObj.nextLine();
            if (loadedBank.getPin().equals(pinInp)) {
                userPin = true;
            }
            else if (!loadedBank.getName().equals(user) || loadedBank.getPin().equals(pinInp)){
                System.out.println("Please check your credentials! ");
                choice = "0";
            }
            if (userPin==true &&userBool==true){
                System.out.println("Would you like to:  1: Deposit Money || 2: Make a transaction || 3: Change your PIN || 4: Check your remaining balance|| 0:Exit ");
                choice = myObj.nextLine();
                if (choice.equals("1")) {

                    System.out.println("Please enter an amount of money ");
                    acc.setBalance(myObj.nextInt());
                    System.out.println("Username is: " + acc.getName());
                    System.out.println("Balance is: " + acc.getBalance());
                }

            }
            System.out.println("Would you like another service: 1: Make a banking account || 2: Sign in || 3: Deposit Money || 4: Make a transaction || 5: Change your PIN || 6: Check your remaining balance ");
            choice = myObj.nextLine();
        }

        System.out.println("Would you like another service: 1: Make a banking account || 2: Sign in || 3: Deposit Money || 4: Make a transaction || 5: Change your PIN || 6: Check your remaining balance ");
        choice = myObj.nextLine();
    }

    private static void saveBankDataToFile(Bank bankData, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(bankData);
            System.out.println("Bank data saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Bank loadBankDataFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Bank) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}