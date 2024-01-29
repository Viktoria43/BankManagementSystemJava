import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.Serializable;

public class Bank implements Serializable{
   private ArrayList<String> pins = new ArrayList<String>();
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<Integer> balances = new ArrayList<>();
   private String pin="";
private String name ="";
private int balance= 0;

    public Bank (String pin, String name, int balance){
        this.pin = pin;
        this.name=name;
        this.balance = balance;



    }

    public void setPin(String pin){
        this.pin = pin;
        pins.add(pin);
    }
    public String getPin(){
        return pin;
    }
    public void setName(String Name) {
        this.name=Name;
        usernames.add(Name);
    }
    public String getName() {
        return name;
    }
    public void setBalance(int balance) {
        this.balance=balance;
        balances.add(balance);
    }
    public int getBalance() {
        return balance;
    }
    private static void saveBankDataToFile(Bank bankData, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(bankData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
