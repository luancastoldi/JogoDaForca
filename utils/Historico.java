package utils;

public class Historico {

    public void salvarHistorico(String letras, String palavraSorteada) {
        Arquivo historico = new Arquivo("db/historico.txt");
        String linha, historicoCompleto = "";

        historico.abrirLeitura();
        linha = historico.lerLinha();

        while (linha != null) {
            historicoCompleto = historicoCompleto + linha + "\n";
            linha = historico.lerLinha();
        }

        historico.fecharArquivo();
        historico.abrirEscrita();

        historico.escreverLinha(historicoCompleto);
        historico.escreverLinha("#######################################");
        historico.escreverLinha("   Palavra soteada: " + palavraSorteada);
        historico.escreverLinha(letras);

        historico.fecharArquivo();
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
        historicoCompleto = historicoCompleto;
        historicoArquivo.fecharArquivo();
        System.out.println(historicoCompleto);
    }
}