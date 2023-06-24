package tela;
import utils.Logica;
import utils.Entrada;

public class Menu {
      Logica logica;
      public Menu () {
            logica= new Logica();
            String menu = 
                          "########## JOGO DA FORCA #######\n" +
                          "  [1] - Jogar\n" +
                          "  [2] - Ver histórico de palavras\n" +
                          "  [3] - Sair do Jogo\n" +
                          "################################";

            char op = ' ';
            op = Entrada.leiaChar(menu);
            switch (op) {
                  case '1':
                        new Jogo();
                        break;
                  case '2':
                        logica.verHistorico();
                        break;
                  default:
                        break;
                        // new Menu();
            }
      }
}