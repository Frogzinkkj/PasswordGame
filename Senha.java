import java.util.Random;
import java.util.Scanner;

public class Senha {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String senha = gerarSenha();
        
        System.out.println("Digite quatro dígitos separados por espaço: ");
        String tentativa = entrada.nextLine().replaceAll(" ", "");

        int tentativas = 0;
        while (!tentativa.equals(senha) && tentativas < 10) {
            int corretos = contarDigitosCorretos(tentativa, senha);
            int deslocados = contarDigitosDeslocados(tentativa, senha);

            System.out.println("Dígitos corretos: " + corretos);
            System.out.println("Dígitos deslocados: " + deslocados);
            System.out.println("Você tem " + (10 - tentativas - 1) + " tentativas restantes.");

            tentativas++;

            if (tentativa.equals(senha)) {
                break;
            } else if (tentativas < 10) {
                System.out.println("Tente novamente: ");
                tentativa = entrada.nextLine().replaceAll(" ", "");
            } else {
                System.out.println("Você excedeu o número de tentativas. A senha correta era: " + senha);
            }
        }

        if (tentativa.equals(senha)) {
            System.out.println("Parabéns! Você acertou a senha.");
        }
    }

    public static String gerarSenha() {
        Random gerar = new Random();
        StringBuilder senha = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            senha.append(gerar.nextInt(10));
        }
        return senha.toString();
    }

    public static int contarDigitosCorretos(String tentativa, String senha) {
        int corretos = 0;
        for (int i = 0; i < tentativa.length(); i++) {
            if (tentativa.charAt(i) == senha.charAt(i)) {
                corretos++;
            }
        }
        return corretos;
    }

    public static int contarDigitosDeslocados(String tentativa, String senha) {
        int deslocados = 0;
        boolean[] verificados = new boolean[senha.length()];

        for (int i = 0; i < tentativa.length(); i++) {
            if (tentativa.charAt(i) != senha.charAt(i)) {
                for (int j = 0; j < senha.length(); j++) {
                    if (!verificados[j] && tentativa.charAt(i) == senha.charAt(j)) {
                        deslocados++;
                        verificados[j] = true;
                        break;
                    }
                }
            }
        }
        return deslocados;
    }
}
