package tela;

import utils.Entrada;

public class GameOver {
    public GameOver() {
        System.out.println("Você Perdeu!");
        boolean escolha = Entrada.leiaBoolean("Game Over \nDeseja jogar novamente?");
        if(escolha){
            new Jogo();
        }else{
            System.exit(0);
        }
    }
}
