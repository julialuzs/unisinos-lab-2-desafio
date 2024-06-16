package etapa3;

import java.util.Scanner;
import java.util.Stack;

public class Etapa3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("Insira uma expressão a ser validada: ");
        String expressao = scanner.next();
        scanner.close();

        Stack<Character> stack = new Stack<>();

        for(char c : expressao.toCharArray()) {
            stack.push(c);
        }

        boolean estaCorreto = checkBrackets(stack);
        System.out.println(estaCorreto ? "Expressão válida" : "Expressão inválida");
    }

    public static boolean checkBrackets(Stack<Character> s1) {
        Stack<Character> auxiliar = new Stack<>();

        while (!s1.empty()) {
            Character atual = s1.pop();
            if (atual == ')') {
                auxiliar.push(atual);
            } else if (atual == '(') {
                if (auxiliar.isEmpty()) {
                    return false;
                } else {
                    auxiliar.pop();
                }
            }
        }
        return auxiliar.isEmpty();
    }
}
