public class document {
    private String titre,auteur;
    private int qte;

    public document(String titre,String auteur,int qte) {
        this.titre = titre;
        this.auteur=auteur;
        this.qte=qte;

    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getQte() {
        return qte;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }
    public void afficherdetails(){
        System.out.println("le titre:"+this.titre);
        System.out.println("l'auteur:"+this.auteur);
        System.out.println("la quantité: "+this.qte);
    }
    public String afficherDocument(){
        return "Titre: "+this.titre+"\nAuteur: "+this.auteur+"\nQuantité: "+this.qte;
    }
}
