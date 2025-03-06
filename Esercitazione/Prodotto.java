public abstract class Prodotto implements Prodotti {
    protected double prezzo;
    protected String nome;
    protected String codice; 

    public Prodotto(double prezzo, String nome, String codice) {
        this.prezzo = prezzo;
        this.nome = nome;
        this.codice = codice;
    }

    public abstract double getPrezzo();
    public abstract String getDescrizione();
    public abstract String getCodice();

}
