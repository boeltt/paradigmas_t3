package entidades;

public class Planeta {
	//A entidade foi reutilizada do enunciado do trabalho
    private String nome;
    private double massa;         
    private double diametro;      
    private double distanciaSol;  
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

    //Método toString por boa prática
	@Override
	public String toString() {
		return "Planeta [nome=" + nome + ", massa=" + massa + ", diametro=" + diametro + ", distanciaSol="
				+ distanciaSol + ", temAtmosfera=" + temAtmosfera + "]";
	}
}

