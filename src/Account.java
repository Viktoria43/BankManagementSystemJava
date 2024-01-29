public class Account{
  private  String pin ="";
    private String name ="";
    private int balance = 0;

    public Account (String pin, String name, int balance){
      this.pin =pin;
      this.name=name;
      this.balance=balance;
    }
    public void deposit(int amount) {
    }

    public void withdraw(int amount) {

    }
    public void setPin(String pin){
      this.pin= pin;
    }
  public String getPin(){
return pin;
  }
    public void setName (String name){
        this.name = name;
    }
    public String getName(){
      return name;
  }

  public int getBalance(){
      return balance;
  }

    public void setBalance (int balance){
        this.balance = balance;
    }
}