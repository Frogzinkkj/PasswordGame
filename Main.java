import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[] password = GenerateNumber();
    String fAttempt;
    String fPassword;
    String line;
    String[] numbers;
   
    


    System.out.println("Digite quatro Digitos separados por espaço: ");
    line= input.nextLine();
    numbers = line.split(" ");
    fAttempt = String.join("",numbers);
    fPassword = Arrays.toString(password).replaceAll("[\\[\\], ]", "");
    
    comp(fAttempt, fPassword,input);
 
    
    
  }

  public static void comp(String numbers, String password, Scanner input){
    int trys = 0;
    while (!numbers.equals(password) && trys <= 10) {
      int corrects = 0;
      int halfCorrects = 0;
      boolean[] verifyReply = new boolean[password.length()];

      for(int i = 0; i< numbers.length();i++){
        if (numbers.charAt(i) == password.charAt(i)){
          corrects++;
          verifyReply[i] = true;
          
        }
      }
      for(int i = 0; i<numbers.length();i++){
        if(numbers.charAt(i) != password.charAt(i)){
          for(int c = 0; c<numbers.length();c++){
            if(!verifyReply[c] && numbers.charAt(i) == password.charAt(c)){
              halfCorrects++;
              verifyReply[c] = true;
              break;
            }
          }
        }
      }
      trys++;
      System.out.println("Dígitos corretos: " + corrects);
      System.out.println("Dígitos deslocados: " + halfCorrects);
      System.out.println("Você tem " + (10-trys) +" Tentativas");
      
      if(trys<10){
        System.out.println("Digite quatro Digitos separados por espaço: ");
        String line= input.nextLine();
        String [] newNumbers = line.split(" ");
        numbers = String.join("",newNumbers);
      }else{
        System.out.println("Você excedeu o número de tentativas. A senha correta era: " + password);
        break;
      }
    }
    if(numbers.equals(password)){
      System.out.println("Parabéns! Você acertou a senha.");
    }
  }







  public static int [] GenerateNumber(){
    Random generate = new Random();
    int[] password = new int[4];

    for(int i = 0; i< password.length;i++){
      password[i] = generate.nextInt(10);
    }

    return password;
  }
}