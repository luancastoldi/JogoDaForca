package tela;

import utils.Entrada;
import utils.Historico;
import utils.Logica;

public class Jogo {
    Logica logica;
    Historico historico;

    public Jogo() {

        logica = new Logica();
        historico = new Historico();

        String palavraSorteada = logica.sorteaPalavra();
        String letrasUsadas = "";
        String digitos = "";

        System.out.println(palavraSorteada); // esconder palavra

        while (logica.temChance()) {
            String[] boneca = logica.desenhaBoneco(true);

            String telinha = boneca[0] + '\n';
            telinha += " " + boneca[1] + "       " + desenhaTraco(palavraSorteada, digitos) + '\n';
            telinha += " " + boneca[2];

            char letra = Entrada.leiaChar(telinha);
            letra = (letra + "").toLowerCase().charAt(0);

            if (letrasUsadas.contains(String.valueOf(letra))) {
                System.out.println(letra + " - Está letra já foi escolhida!");
            } else {

                letrasUsadas += letra + ", ";

                if (palavraSorteada.contains(String.valueOf(letra))) {
                    System.out.println("Acertou!");
                    digitos += letra;
                } else {
                    System.out.println("Errou!");
                    logica.adicionaErro();
                    if (logica.getErros() == 6) {
                        historico.salvarHistorico(letrasUsadas, palavraSorteada);
                        logica.gameOver();
                    }
                }
            }

            if (letra == '3') {
                System.out.println("Saiu");
                break;
            }

            String palavraAtualizada = atualizaTraco(palavraSorteada, digitos);
            if (palavraSorteada.equals(palavraAtualizada)) {
                historico.salvarHistorico(letrasUsadas, palavraSorteada);
                System.out.println("Parabéns!! - Jogo Finalizado");
                Boolean novamente = Entrada.leiaBoolean("Você Ganhou!!!\nDeseja jogar novamente?");
                if (novamente) {
                    new Menu();
                }
                break;
            }
        }
    }

    public String atualizaTraco(String palavra, String digitos) {
        int qtdeTraco = palavra.length();
        String tracado = "";

        // para cada letra na palavra (sorteada)
        for (int i = 0; i < qtdeTraco; i++) {
            char letra = '_';

            if (palavra.charAt(i) == ' ' ||
                    palavra.charAt(i) == '-') {
                letra = palavra.charAt(i);
            }

            // cada digitos (do teclado)
            for (int j = 0; j < digitos.length(); j++) {
                char letraAtual = digitos.charAt(j);

                // Boolean flagEncontrou = false;
                if (palavra.charAt(i) == letraAtual) {
                    letra = letraAtual;
                    break;
                }
            }
            tracado += letra;
        }
        return tracado;
    }

    public String desenhaTraco(String palavra, String digitos) {
        int qtdeTraco = palavra.length();
        String tracado = "";

        // para cada letra na palavra (sorteada)
        for (int i = 0; i < qtdeTraco; i++) {
            char letra = '_';

            if (palavra.charAt(i) == ' ' ||
                    palavra.charAt(i) == '-') {
                letra = palavra.charAt(i);
            }

            // cada digitos (do teclado)
            for (int j = 0; j < digitos.length(); j++) {
                char letraAtual = digitos.charAt(j);

                // Boolean flagEncontrou = false;
                if (palavra.charAt(i) == letraAtual) {
                    letra = letraAtual;
                    break;
                }
            }
            tracado += " " + letra;
        }
        return tracado;
    }
}
