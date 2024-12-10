public class pfe extends document {
    private String universite, specialite;

    public pfe(String titre, String auteur, int qte,String universite, String specialite) {
        super(titre, auteur,qte);
        this.universite = universite;
        this.specialite = specialite;
    }

    public String getUniversite() {
        return universite;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void afficherdetails() {
        System.out.println("PFE:");
        super.afficherdetails();
        System.out.println("l'université:" + this.universite);
        System.out.println("la spécialité:" + this.specialite);
    }
    public String afficherDocument() {
        return super.afficherDocument() + "spécialité: : " + this.specialite + "\nuniversité: " + this.universite;
    }
}