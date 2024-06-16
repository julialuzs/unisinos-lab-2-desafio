package etapa2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {

    private static final String[] nomes = { "Julia", "Gabriel", "Allan", "Paola", "Giordano", "Marina" };
    private static final int[] intencoesVoto = { 1000, 3000, 999, 1500, 2500 };
    private static final String[] partidos = { "PT", "PL", "PSDB", "PSOL" };

    public static void main(String[] args)  {
        Candidato[] candidatos = gerarCandidatos(20);

        Candidato[] candidatosOrdenadosPorPartido = ordenaCandidatosPorPartido(Arrays.copyOf(candidatos, candidatos.length));
        Candidato[] candidatosOrdenadosPorVotos = ordenaCandidatosPorVotos(candidatosOrdenadosPorPartido);
        Candidato[] candidatosOrdenadosPorNome = ordenaCandidatosPorNome(candidatosOrdenadosPorVotos);

        System.out.println("Lista de candidatos ordenados: ");
        for (Candidato candidato : candidatosOrdenadosPorNome) {
            System.out.println(candidato.toString());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("Digite o nome do candidato a ser encontrado: ");
        String nomeBusca = scanner.next();
        Candidato candidatoBuscado = buscaCandidatoPorNome(candidatosOrdenadosPorNome, nomeBusca);
        if (candidatoBuscado == null) {
            System.out.println("Candidato com nome '" + nomeBusca + "' não encontrado.");
        } else {
            System.out.println(candidatoBuscado.toString());
        }
        scanner.close();
    }

    public static Candidato buscaCandidatoPorNome(Candidato[] candidatos, String nome) {
        int indexCandidato = pesquisaBinariaCandidatos(candidatos, nome);
        if (indexCandidato == -1) { return null; }
        return candidatos[indexCandidato];
    }

    public static Candidato[] gerarCandidatos(int numeroDeCandidatos) {
        Candidato[] candidatos = new Candidato[numeroDeCandidatos];

        for (int i = 0; i < numeroDeCandidatos; i++) {
            int randomNome = new Random().nextInt(nomes.length);
            int randomVotos = new Random().nextInt(intencoesVoto.length);
            int randomPartido = new Random().nextInt(partidos.length);

            candidatos[i] = new Candidato(
                nomes[randomNome],
                partidos[randomPartido],
                intencoesVoto[randomVotos]
            );
        }
        return candidatos;
    }

    public static Candidato[] ordenaCandidatosPorNome(Candidato[] candidatos) {
        int qtdCandidatos = candidatos.length;

        for (int i = 1; i < qtdCandidatos; i++) {
            Candidato chave = candidatos[i];
            int j = i - 1;

            while (j >= 0 && candidatos[j].getNome().compareToIgnoreCase(chave.getNome()) > 0) {
                candidatos[j + 1] = candidatos[j];
                j = j - 1;
            }
            candidatos[j + 1] = chave;
        }
        return candidatos;
    }

    public static Candidato[] ordenaCandidatosPorVotos(Candidato[] candidatos) {
        int qtdCandidatos = candidatos.length;

        for (int i = 1; i < qtdCandidatos; i++) {
            Candidato chave = candidatos[i];
            int j = i - 1;

            while (j >= 0 && candidatos[j].getIntencoesVotos() > chave.getIntencoesVotos()) {
                candidatos[j + 1] = candidatos[j];
                j = j - 1;
            }
            candidatos[j + 1] = chave;
        }
        return candidatos;
    }

    public static Candidato[] ordenaCandidatosPorPartido(Candidato[] candidatos) {
        int qtdCandidatos = candidatos.length;
        for (int i = 0; i < qtdCandidatos - 1; i++) {
            int idxMenorNum = i;
            for (int j = i + 1; j < qtdCandidatos; j++) {
                int comparacao = candidatos[j].getPartido()
                        .compareToIgnoreCase(candidatos[idxMenorNum].getPartido());
                if (comparacao < 0)
                    idxMenorNum = j;
            }

            Candidato temp = candidatos[idxMenorNum];
            candidatos[idxMenorNum] = candidatos[i];
            candidatos[i] = temp;
        }
        return candidatos;
    }

    public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome) {
        int inferior = 0;
        int superior = candidatos.length - 1;

        while (inferior <= superior) {
            int media = (inferior + superior) / 2;
            int comparacao = nome.compareToIgnoreCase(candidatos[media].getNome());

            if (comparacao == 0) return media;

            if (comparacao < 0) {
                superior = media - 1;
            } else {
                inferior = media + 1;
            }
        }
        return -1;
    }
}
