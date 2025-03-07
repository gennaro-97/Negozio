public class Alimentare extends Prodotto implements IScontabile {
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
        return "========ALIMENTO========\n" + super.getDescrizione() + " - " + dataScadenza + " - " + prossimoAllaScadenza;
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
