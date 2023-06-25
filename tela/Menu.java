package tela;
import utils.Logica;
import utils.Entrada;
import utils.Historico;

public class Menu {
      Logica logica;
      Historico historico;
      
      public Menu () {

            //inicializa
            logica= new Logica();
            historico = new Historico();

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
                        historico.verHistorico();
                        break;
                  default:
                        break;
            }
      }
}