package entidades;

public class Planeta {
    private String nome;
    private double massa;         // em 10^24 kg
    private double diametro;      // em km
    private double distanciaSol;  // em milhões de km
    private boolean temAtmosfera;

    public Planeta(String nome, double massa, double diametro,
                   double distanciaSol, boolean temAtmosfera) {
        this.nome = nome;
        this.massa = massa;
        this.diametro = diametro;
        this.distanciaSol = distanciaSol;
        this.temAtmosfera = temAtmosfera;
    }

    public String getNome() {
        return nome;
    }

    public double getMassa() {
        return massa;
    }

    public double getDiametro() {
        return diametro;
    }

    public double getDistanciaSol() {
        return distanciaSol;
    }

    public boolean isTemAtmosfera() {
        return temAtmosfera;
    }
}

