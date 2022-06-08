package View;
import java.io.IOException;
import java.util.Scanner;

public class LimpaConsole{
    public void limpar() throws IOException, InterruptedException {

        //Limpa a tela no windows, no linux e no MacOS
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");

    }
}
