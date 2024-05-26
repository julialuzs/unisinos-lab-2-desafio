package etapa2;

import java.util.Random;

public class PrincipalCandidatos {

    private static final String[] nomes = {"Julia", "Gabriel", "Allan", "Paola", "Giordano", "Marina"};
    private static final int[] intencoesVoto = {100, 300, 150, 250};
    private static final String[] partidos = {"PT", "PL", "PSDB"};


    public static void main(String[] args)  {
        Candidato[] candidatos = gerarCandidatos(20);
        System.out.println(candidatos.toString());
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
        return null;
    }

    public static Candidato[] ordenaCandidatosPorVotos(Candidato[] candidatos) {
        return null;
    }

    public static Candidato[] ordenaCandidatosPorPartido(Candidato[] candidatos) {
        return null;
    }

    public static Candidato[] pesquisaBinariaCandidatos(Candidato[] candidatos) {
        return null;
    }


}
