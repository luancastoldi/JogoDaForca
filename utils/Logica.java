package utils;

import tela.GameOver;

public class Logica {
    String[] palavras;
    int erros = 0;

    public Logica() {

    }

    public String sorteaPalavra() {
        Arquivo arq = new Arquivo("db/banco.txt");
        arq.abrirLeitura();
        
        String linha = arq.lerLinha();

        while (linha != null) {
            palavras = linha.split(";");
            linha = arq.lerLinha();
        }

        int rand = (int) (Math.random() * palavras.length);
        String retorno = palavras[rand];

        return retorno;
    }

    //gravarPalavra
    //verificaLetraMané
    //adicionaMembro

    public void adicionaErro() {
        erros++;
        if (erros==6) {
            new GameOver();
        }
    }

    public int maxErros() {
        return 6;
    }

    public boolean temChance() {
        return erros < maxErros();
    }

    public void zeraErro() {
        erros = 0;
    }

    public String[] desenhaBoneco(boolean acerto) {
        String cabess = "   ";
        String brassL = " ";
        String corpao = " ";
        String brassR = " ";
        String pernaL = " ";
        String pernaR = " ";

        switch (erros) {
            case 6: pernaR = "\\";
            case 5: pernaL = "/";
            case 4: brassR = "\\";
            case 3: brassL = "/";
            case 2: corpao = "|";
            case 1: cabess = " O ";
        }

        String[] retorno = {
                     cabess,
            brassL + corpao + brassR,
            pernaL +   " "  + pernaR
        };

        return retorno;
    }
    
    public void salvarHistorico(String letras, String palavraSorteada) {
        Arquivo historico = new Arquivo("db/historico.txt");
        String linha, historicoCompleto = "";
        
        historico.abrirLeitura();
        linha = historico.lerLinha();
        
        while (linha!=null) {
            historicoCompleto = historicoCompleto + linha + "\n";   
            linha = historico.lerLinha();
        }
        
        historico.fecharArquivo();
        historico.abrirEscrita();

        historico.escreverLinha(historicoCompleto);
        historico.escreverLinha("#######################################");
        historico.escreverLinha("   Palavra soteada: "+ palavraSorteada);
        historico.escreverLinha(letras);
       
        historico.fecharArquivo();
    }
    
    public void verHistorico() {
        Arquivo historico = new Arquivo("db/historico.txt");
        String linha, historicoCompleto = "";
        
        historico.abrirLeitura();
        linha = historico.lerLinha();
        
        while (linha!=null) {
            historicoCompleto = historicoCompleto + linha + "\n";   
            linha = historico.lerLinha();
        }
        historicoCompleto = historicoCompleto;
        historico.fecharArquivo();
        System.out.println(historicoCompleto);
    }
}
