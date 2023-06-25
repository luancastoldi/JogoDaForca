package utils;
import tela.Menu;
public class Historico {

    public void salvarHistorico(String letras, String palavraSorteada) {
        Arquivo historicoArquivo = new Arquivo("db/historico.txt");
        String linha, historicoCompleto = "";

        historicoArquivo.abrirLeitura();
        linha = historicoArquivo.lerLinha();

        while (linha != null) {
            historicoCompleto = historicoCompleto + linha + "\n";
            linha = historicoArquivo.lerLinha();
        }

        historicoArquivo.fecharArquivo();
        historicoArquivo.abrirEscrita();

        historicoArquivo.escreverLinha(historicoCompleto);
        historicoArquivo.escreverLinha("#######################################");
        historicoArquivo.escreverLinha("Palavra soteada: " + palavraSorteada);
        historicoArquivo.escreverLinha("Letras usadas: " + letras);
        historicoArquivo.fecharArquivo();
    }

    public void verHistorico() {

        Arquivo historicoArquivo = new Arquivo("db/historico.txt");
        String linha, historicoCompleto = "";

        historicoArquivo.abrirLeitura();
        linha = historicoArquivo.lerLinha();

        while (linha != null) {
            historicoCompleto = historicoCompleto + linha + "\n";
            linha = historicoArquivo.lerLinha();
        }
        // não sei oque isso faz
        // historicoCompleto = historicoCompleto;
        historicoArquivo.fecharArquivo();
        System.out.println(historicoCompleto);
        new Menu();
    }
}