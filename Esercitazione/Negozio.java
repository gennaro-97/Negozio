import java.util.Scanner;

public class Negozio {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        GestoreProdotti gestoreProdotti = new GestoreProdotti();
      
       
        menu(scanner, gestoreProdotti);

        scanner.close();
    }

    public static void menu(Scanner scanner, GestoreProdotti gestoreProdotti) {
        int scelta = -1;
        do {
            System.out.println("1. Aggiungi prodotto");
            System.out.println("2. Rimuovi prodotto");
            System.out.println("3. Mostra prodotti");
            System.out.println("4. Verifica se un alimentare è scontabile");
            System.out.println("5. Verifica se un elettronico è restituibile");
            System.out.println("6. Verifica se un abbigliamento è restituibile");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    aggiungiProdotto(scanner, gestoreProdotti);
                    System.out.println();
                    break;
                case 2:
                    rimuoviProdotto(scanner, gestoreProdotti);
                    System.out.println();
                    break;
                case 3:
                    gestoreProdotti.mostraProdotti();
                    System.out.println();
                    break;
                case 4:
                    verificaAlimentareScontabile(scanner, gestoreProdotti);
                    System.out.println();
                    break;
                case 5:
                    verificaElettronicoRestituibile(scanner, gestoreProdotti);
                    System.out.println();
                    break;
                case 6:
                    verificaAbbigliamentoRestituibile(scanner, gestoreProdotti);
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        } while (scelta != 0);
    }
    

    public static void aggiungiProdotto(Scanner scanner, GestoreProdotti gestoreProdotti) {
        System.out.println("1. Alimentare");
        System.out.println("2. Elettronico");
        System.out.println("3. Abbigliamento");
        System.out.print("Scelta: ");
        int scelta = scanner.nextInt();
        switch (scelta) {
            case 1:
                aggiungiAlimentare(scanner, gestoreProdotti);
                System.out.println();
                break;
            case 2:
                aggiungiElettronico(scanner, gestoreProdotti);
                System.out.println();
                break;
            case 3:
                aggiungiAbbigliamento(scanner, gestoreProdotti);
                System.out.println();
                break;
            default:
                System.out.println("Scelta non valida");
        }
    }

    public static void aggiungiAlimentare(Scanner scanner, GestoreProdotti gestoreProdotti) {
        scanner.nextLine();
        ControlloInput validator = new ControlloInput(scanner);

        String codice = validator.leggiStringa("Inserisci il codice del prodotto: ");
        String nome = validator.leggiStringa("Inserisci il nome del prodotto: ");
        double prezzo = validator.leggiDouble("Inserisci il prezzo: ");
        String dataScadenza = validator.leggiStringa("Inserisci la data di scadenza (gg/mm/aaaa): ");
        boolean prossimoAllaScadenza = validator.leggiBoolean("Il prodotto è prossimo alla scadenza? (true/false): ");

        Alimentare alimentare = new Alimentare(prezzo, nome, codice, dataScadenza, prossimoAllaScadenza);
        gestoreProdotti.aggiungiProdotto(alimentare);
        
        System.out.println("Prodotto alimentare aggiunto con successo!");
    }

    public static void aggiungiElettronico(Scanner scanner, GestoreProdotti gestoreProdotti) {
        scanner.nextLine();
        ControlloInput validator = new ControlloInput(scanner);

        String codice = validator.leggiStringa("Inserisci il codice del prodotto: ");
        String nome = validator.leggiStringa("Inserisci il nome del prodotto: ");
        double prezzo = validator.leggiDouble("Inserisci il prezzo: ");
        int mesiGaranzia = validator.leggiIntero("Inserisci la durata della garanzia (mesi): ", 1, 36);
        int mesiAcquisto = validator.leggiIntero("Inserisci il numero di mesi dall'acquisto: ", 0, mesiGaranzia);

        Elettronico elettronico = new Elettronico(prezzo, nome, codice, mesiGaranzia, mesiAcquisto);
        gestoreProdotti.aggiungiProdotto(elettronico);
        

        System.out.println("Prodotto elettronico aggiunto con successo!");
    }

    public static void aggiungiAbbigliamento(Scanner scanner, GestoreProdotti gestoreProdotti) {
        scanner.nextLine();
        ControlloInput validator = new ControlloInput(scanner);

        String codice = validator.leggiStringa("Inserisci il codice del prodotto: ");
        String nome = validator.leggiStringa("Inserisci il nome del prodotto: ");
        double prezzo = validator.leggiDouble("Inserisci il prezzo: ");
        String taglia = validator.leggiStringa("Inserisci la taglia: ");
        String materiale = validator.leggiStringa("Inserisci il materiale: ");
        int giorniDallAcquisto = validator.leggiIntero("Inserisci il numero di giorni dall'acquisto: ", 1, 365);

        Abbigliamento abbigliamento = new Abbigliamento(prezzo, nome, codice, taglia, materiale, giorniDallAcquisto);
        gestoreProdotti.aggiungiProdotto(abbigliamento);
        

        System.out.println("Prodotto di abbigliamento aggiunto con successo!");
    }

    public static void rimuoviProdotto(Scanner scanner, GestoreProdotti gestoreProdotti) {
        scanner.nextLine();
        ControlloInput validator = new ControlloInput(scanner);

        String codice = validator.leggiStringa("Inserisci il codice del prodotto da rimuovere: ");
        String tipo = validator.leggiStringa("Inserisci il tipo di prodotto (alimentare, elettronico, abbigliamento): ");

        gestoreProdotti.rimuoviProdotto(codice, tipo);
    }

    // Verifica se un prodotto alimentare è scontabile
public static void verificaAlimentareScontabile(Scanner scanner, GestoreProdotti gestoreProdotti) {
    scanner.nextLine(); // Consuma la nuova linea residua
    ControlloInput validator = new ControlloInput(scanner);
    String codice = validator.leggiStringa("Inserisci il codice del prodotto alimentare: ");
    
    // Trova il prodotto alimentare con il codice
    Prodotto prodotto = gestoreProdotti.trovaProdotto(codice);
    if (prodotto instanceof Alimentare) {
        Alimentare alimentare = (Alimentare) prodotto;
        if (alimentare.calcolaSconto() > 0) {
            System.out.println("Il prodotto " + alimentare.getDescrizione() + " è scontabile.");
        } else {
            System.out.println("Il prodotto " + alimentare.getDescrizione() + " non è scontabile.");
        }
    } else {
        System.out.println("Prodotto non trovato o non è un prodotto alimentare.");
    }
}

// Verifica se un prodotto elettronico è restituibile
public static void verificaElettronicoRestituibile(Scanner scanner, GestoreProdotti gestoreProdotti) {
    scanner.nextLine(); // Consuma la nuova linea residua
    String codice = scanner.nextLine();
    
    // Trova il prodotto elettronico con il codice
    Prodotto prodotto = gestoreProdotti.trovaProdotto(codice);
    if (prodotto instanceof Elettronico) {
        Elettronico elettronico = (Elettronico) prodotto;
        if (elettronico.isRestituibile()) {
            System.out.println("Il prodotto " + elettronico.getDescrizione() + " è restituibile.");
        } else {
            System.out.println("Il prodotto " + elettronico.getDescrizione() + " non è restituibile.");
        }
    } else {
        System.out.println("Prodotto non trovato o non è un prodotto elettronico.");
    }
}

// Verifica se un prodotto di abbigliamento è restituibile
public static void verificaAbbigliamentoRestituibile(Scanner scanner, GestoreProdotti gestoreProdotti) {
    scanner.nextLine(); // Consuma la nuova linea residua
    String codice = scanner.nextLine();
    
    // Trova il prodotto di abbigliamento con il codice
    Prodotto prodotto = gestoreProdotti.trovaProdotto(codice);
    if (prodotto instanceof Abbigliamento) {
        Abbigliamento abbigliamento = (Abbigliamento) prodotto;
        if (abbigliamento.isRestituibile()) {
            System.out.println("Il prodotto " + abbigliamento.getDescrizione() + " è restituibile.");
        } else {
            System.out.println("Il prodotto " + abbigliamento.getDescrizione() + " non è restituibile.");
        }
    } else {
        System.out.println("Prodotto non trovato o non è un prodotto di abbigliamento.");
    }
}

}
