import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        ArrayList<String> listaDeNomes = new ArrayList<>();

        boolean continuar;

        do{
            leia.nextLine();
            System.out.println("Insira seu nome");
            String seuNome = leia.nextLine();
            listaDeNomes.add(seuNome);

            System.out.println();
            System.out.println("Voçê deseja continuar: Sim ou Não?");
            String resposta = leia.next();

            if(resposta.equals("sim")){
                continuar = true;
            }else{
                continuar = false;
            }

        }while(continuar);
    }
    
}
