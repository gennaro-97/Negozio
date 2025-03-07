public class Abbigliamento extends Prodotto implements IRestituibile {
    private String taglia;
    private String colore;
    private int giorniAcquisto;

    public Abbigliamento(double prezzo, String nome, String codice, String taglia, String colore, int giorniAcquisto) {
        super(prezzo, nome, codice);
        this.taglia = taglia;
        this.colore = colore;
        this.giorniAcquisto = giorniAcquisto;
    }

    @Override
    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String getDescrizione() {
        return "========ABBIGLIAMENTO========\n" + super.getDescrizione() + " - " + taglia + " - " + colore + " - " + giorniAcquisto;
    }

    @Override
    public boolean isRestituibile() {
        return giorniAcquisto <= 30;
    }

    @Override
    public String condizioni() {
        if (isRestituibile()) {
            return "Restituibile";
        } else {
            return "Non restituibile";
        }
    }

    @Override
    public String getCodice() {
        return codice;
    }
    
}
