package etapa1;

import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Labirinto {

    public char[][] labirinto;

    public Labirinto() { }

    public void criaLabirinto(String filename) throws IOException {
        String path = MessageFormat.format("src/etapa1/{0}.txt", filename);
        List<char[]> linhas = new ArrayList<>();
        int maxLength = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.length() > maxLength) {
                    maxLength = linha.length();
                }
                linhas.add(linha.toCharArray());
            }
        }

        this.labirinto = new char[linhas.size()][maxLength];

        for (int i = 0; i < linhas.size(); i++) {
            char[] linha = linhas.get(i);
            for (int j = 0; j < maxLength; j++) {
                if (j < linha.length) {
                    labirinto[i][j] = linha[j];
                } else {
                    labirinto[i][j] = ' ';
                }
            }
        }
    }

    public boolean percorreLabirinto() {
        if (labirinto == null) throw new IllegalArgumentException();
        return percorreLabirinto(0, 0);
    }

    private boolean percorreLabirinto(int x, int y) {
        boolean isForaDosLimites = x < 0 || y < 0 || x >= labirinto.length;
        if (isForaDosLimites) return false;

        boolean isParede = y >= labirinto[0].length || labirinto[x][y] == 'X';
        if (isParede) return false;

        boolean isDestino = labirinto[x][y] == 'D';
        if (isDestino) return true;

        boolean jaFoiVisitada = labirinto[x][y] == 'V';
        if (jaFoiVisitada) return false;

        // Marca a posição como visitada
        labirinto[x][y] = 'V';

        boolean encontradoPosicaoAndavel =
                percorreLabirinto(x + 1, y) ||  // baixo
                percorreLabirinto(x - 1, y) ||  // cima
                percorreLabirinto(x, y + 1) ||  // direita
                percorreLabirinto(x, y - 1);    // esquerda

        // Desmarca a posição visitada
        labirinto[x][y] = ' ';

        return encontradoPosicaoAndavel;
    }
}
