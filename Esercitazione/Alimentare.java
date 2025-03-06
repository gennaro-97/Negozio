public class Alimentare extends Prodotto implements Scontabile {
    private String dataScadenza;
    private boolean prossimoAllaScadenza;

    public Alimentare(double prezzo, String nome, String codice, String dataScadenza, boolean prossimoAllaScadenza) {
        super(prezzo, nome, codice);
        this.dataScadenza = dataScadenza;
        this.prossimoAllaScadenza = prossimoAllaScadenza;
    }

    @Override
    public double getPrezzo() {
        return prezzo - calcolaSconto();
    }

    @Override
    public String getDescrizione() {
        return "Alimentare: " + nome + " - " + codice + " - " + dataScadenza + " - " + prossimoAllaScadenza;
    }

    @Override
    public double calcolaSconto() {
        if (prossimoAllaScadenza) {
            return prezzo * 0.2;
        } else {
            return 0;
        }
    }

    @Override
    public String getCodice() {
        return codice;
    }

}
