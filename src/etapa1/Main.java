package etapa1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Labirinto labirintoObj = new Labirinto();
        labirintoObj.criaLabirinto("labirinto");
        boolean result = labirintoObj.percorreLabirinto();

        System.out.println(result);
    }
}