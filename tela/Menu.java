package tela;

import utils.Entrada;

public class Menu {
      public Menu () {
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
                        
                        break;
                  default:
                        break;
                        // new Menu();
            }
      }
}