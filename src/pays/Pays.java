package pays;

public class Pays implements Comparable<Pays>{
    
    private String nom;
    private double surface;
    private double population;

    public Pays(){
        this.nom = "";
        this.population = 0;
        this.surface = 0;
    }

    public Pays(String nom, double population, double surface){
        if(nom != null){
            this.nom = nom;
        } else {
            System.out.println("Pays Constructeur : Nom Null");
        }

        if(population > 0){
            this.population = population;
        } else {
            System.out.println("Pays Constructeur : La population doit être superieur a 0");
        }

        if(surface > 0){
            this.surface = surface;
        } else {
            System.out.println("Pays Constructeur : Surface Doit etre positive");
        }
    }


    public String getNom(){
        return(this.nom);
    }

    public double getSurface(){
        return(this.surface);
    }

    public void setSurface(double surface){
        if(surface > 0){
            this.surface = surface;
        } else {
            System.out.println("setSurface : La surface doit etre positive");
        }
    }

    public double getPopulation(){
        return(this.population);
    }

    public void setPopulation(double population){
        if(population > 0){
            this.population = population;
        } else {
            System.out.println("setPopulation : doit etre superieur a 0");
        }
    }

    public String toString(){
        String aEnvoye = "Nom : " + this.nom + "\nPopulation : " + this.population + "\nSurface : " + this.surface;        
        return(aEnvoye);
    }

    /**
     * Si this > pays : 1
     * Si this < pays : -1
     * Si egaux : 0
     * @param o
     * @return
     */
    public int compareTo(Pays o) {
        int valeurARetourner = 0;

        if(o.surface > this.surface){
            valeurARetourner = -1;
        } else if(o.surface < this.surface){
            valeurARetourner = 1;
        } else if(o.surface == this.surface){
            valeurARetourner = 0;
        }

        return(valeurARetourner);        
    }
}
