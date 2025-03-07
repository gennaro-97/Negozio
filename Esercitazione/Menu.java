import java.util.Scanner;

public class Menu {
    public static void mostraMenu(Scanner scanner, GestoreOperazioniNegozio operazioniNegozio) {
        int scelta = -1;
        do {
            System.out.println("1. Aggiungi prodotto");
            System.out.println("2. Rimuovi prodotto");
            System.out.println("3. Mostra prodotti");
            System.out.println("4. Verifica se un alimentare è scontabile");
            System.out.println("5. Verifica se un prodotto elettronico è restituibile");
            System.out.println("6. Verifica se un abbigliamento è restituibile");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    // Passa al menu di aggiunta prodotto
                    mostraMenuAggiunta(scanner, operazioniNegozio);
                    break;
                case 2:
                    operazioniNegozio.rimuoviProdotto(scanner);
                    break;
                case 3:
                operazioniNegozio.mostraProdotti();
                    break;
                case 4:
                operazioniNegozio.verificaAlimentareScontabile(scanner);
                    break;
                case 5:
                operazioniNegozio.verificaElettronicoRestituibile(scanner);
                    break;
                case 6:
                    operazioniNegozio.verificaAbbigliamentoRestituibile(scanner);
                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        } while (scelta != 0);
    }

    // Metodo per aggiungere un prodotto, con selezione del tipo
    public static void mostraMenuAggiunta(Scanner scanner, GestoreOperazioniNegozio operazioniNegozio) {
        int scelta = -1;
        do {
            System.out.println("1. Alimentare");
            System.out.println("2. Elettronico");
            System.out.println("3. Abbigliamento");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                   operazioniNegozio.aggiungiAlimentare(scanner);
                    break;
                case 2:
                    operazioniNegozio.aggiungiElettronico(scanner);
                    break;
                case 3:
                    operazioniNegozio.aggiungiAbbigliamento(scanner);
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        } while (scelta < 1 || scelta > 3); // Resta nel menu finché la scelta non è valida
    }
}

