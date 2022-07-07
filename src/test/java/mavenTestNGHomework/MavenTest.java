package mavenTestNGHomework;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class MavenTest {
    public static void main(String[] args) throws IOException {
        System.out.println("######## 3.uzdevums! ########");

        String asciiArt = FigletFont.convertOneLine("Evita Vavilina");
        System.out.println(asciiArt);
    }
}