// public class Historico {

//     public static void main(String[] args){
//         //função palavraSorteada so pode ser chamada uma vez no jogo.
//         String palavraResposta = "teste";//Ignorar
//         palavraSorteada(palavraResposta);
         
//         char charTentativa = 't';
//         charSorteado(charTentativa);
//     }

//     public static void palavraSorteada(String palavraResposta) {

//         Arquivo historicodb = new Arquivo("historico.txt");
//         String stringSalva = "Palavra Sorteada:"+ palavraResposta;
       
//         historicodb.abrirEscrita();
//         historicodb.escreverLinha(stringSalva);
//         historicodb.fecharArquivo();

//     }

//     public static void charSorteado(char tentativa) {

//         Arquivo historicodb = new Arquivo("historico.txt");
//         String charSalva = "Char:"+ tentativa;
       
//         historicodb.abrirEscrita();
//         historicodb.escreverLinha(charSalva);
//         historicodb.fecharArquivo();

//     }
// }