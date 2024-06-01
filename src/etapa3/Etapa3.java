package etapa3;

import etapa2.Candidato;
import java.io.IOException;
import java.util.Stack;

public class Etapa3 {

    public static void main(String[] args) throws IOException {
        StaticList<Candidato> candidatos = new StaticList<Candidato>(6);
        Candidato candidato1 = new Candidato("Candidato 1", "PT", 10);
        Candidato candidato2 = new Candidato("Candidato 2", "PT", 20);
        candidatos.insert(candidato1, 0);
        candidatos.insert(candidato2, 1);
        candidatos.insert(candidato1, 2);
        candidatos.insert(candidato1, 3);
        candidatos.insert(candidato2, 4);
        candidatos.insert(candidato1, 5);

        int qtd1 = candidatos.contaElementos(candidato1);
        int qtd2 = candidatos.contaElementos(candidato2);
        System.out.println(qtd1 + ", " + qtd2);

        Stack<Character> stack = new Stack<>();

        stack.push('(');
        stack.push('(');
        stack.push('A');
        stack.push('+');
        stack.push('B');
        stack.push(')');

        boolean estaCorreto = checkBrackets(stack);
        System.out.println(estaCorreto);
    }

    public static boolean checkBrackets(Stack<Character> stack) {
        Stack<Character> auxiliar = new Stack<>();

        while (!stack.empty()) {
            Character atual = stack.pop();
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
