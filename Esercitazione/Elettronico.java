public class Elettronico extends Prodotto implements Garantibile, IRestituibile {
    private int mesiGaranzia;
    private int mesiAcquisto;

    public Elettronico(double prezzo, String nome, String codice, int mesiGaranzia, int mesiAcquisto) {
        super(prezzo, nome, codice);
        this.mesiGaranzia = mesiGaranzia;
        this.mesiAcquisto = mesiAcquisto;
    }

    @Override
    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String getDescrizione() {
        return "========ELETTRONICA========\n" + super.getDescrizione() + " - " + mesiGaranzia + " - " + mesiAcquisto;
    }

    @Override
    public boolean inGaranzia() {
        return mesiAcquisto <= mesiGaranzia;
    }

    @Override
    public boolean isRestituibile() {
        return inGaranzia();
    }

    @Override
    public String condizioni() {
        if (inGaranzia()) {
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
