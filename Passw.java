import java.util.Random;
import java.util.Scanner;

public class Passw {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    //A senha deve ser armazenada num vetor de quatro posições e um outro vetor similar deve ser usado
    //para receber as tentativas do jogador desafiado.
    int [] password = new int[4];
    int [] userTry = new int[4];

    fill(password);
    comparete(password);
    
    
    input.close();

   
  }
  public static void fill(int[] fill){

    //Como será utilizada interface de texto, ao invés de cores serão usados números (de 1 a 6) para compor a senha de  quatro dígitos.
    //A senha deve ser gerada aleatoriamente pelo programa.
    Random rand = new Random();
    for (int i =0; i < fill.length ; i++) {
      fill[i] = rand.nextInt(6)+1;      

    }
  }
  public static void comparete(int [] password) {
    Scanner input = new Scanner(System.in);
    int [] userTrys = new int[4];
    for(int i=0;i<userTrys.length;i++){
      userTrys[i] = input.nextInt();
      System.out.println(userTrys);

    }
      
  }
}