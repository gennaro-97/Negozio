import java.util.ArrayList;

public class GestoreProdotti {
    ArrayList<Prodotto> prodotti;
    

    public GestoreProdotti() {
        prodotti = new ArrayList<Prodotto>();
    }
    
    public void aggiungiProdotto(Prodotto prodotto) {
        prodotti.add(prodotto);
    }

    public void rimuoviProdotto(String codice, String tipo) {
        boolean trovato = false;
    
        // Scorri la lista dei prodotti
        for (int i = 0; i < prodotti.size(); i++) {
            Prodotto prodotto = prodotti.get(i);
    
            // Verifica se il codice corrisponde e il tipo specificato
            if (prodotto.codice.equals(codice)) {
                if (tipo.equalsIgnoreCase("alimentare") && prodotto instanceof Alimentare) {
                    trovato = true;
                    System.out.println("Rimuovendo prodotto alimentare: " + prodotto.nome);
                } else if (tipo.equalsIgnoreCase("elettronico") && prodotto instanceof Elettronico) {
                    trovato = true;
                    System.out.println("Rimuovendo prodotto elettronico: " + prodotto.nome);
                } else if (tipo.equalsIgnoreCase("abbigliamento") && prodotto instanceof Abbigliamento) {
                    trovato = true;
                    System.out.println("Rimuovendo prodotto di abbigliamento: " + prodotto.nome);
                }
    
                // Rimuovi il prodotto dalla lista
                prodotti.remove(i);
                return;
            }
        }
    
        // Se non viene trovato il prodotto
        if (!trovato) {
            System.out.println("Prodotto con codice " + codice + " e tipo " + tipo + " non trovato.");
        }
    }
    

    public void mostraProdotti() {
        // Verifica se la lista dei prodotti è vuota
        if (prodotti.isEmpty()) {
            System.out.println("Nessun prodotto presente nella lista.");
            return;  // Esce dal metodo se non ci sono prodotti
        }

        // Mostra i dati di tutti i prodotti
        for (Prodotto prodotto : prodotti) {
            prodotto.getDescrizione();
            System.out.println();
        }
    }

    public Prodotto trovaProdotto(String codice) {
        for (Prodotto prodotto : prodotti) {
            if (prodotto.getCodice().equals(codice)) {
                return prodotto;
            }
        }
        return null; // Restituisce null se il prodotto non è trovato
    }
}

