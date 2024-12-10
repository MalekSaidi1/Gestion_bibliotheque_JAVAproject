import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class adherant {
     private String nom,prenom;
    private  int id;
    private static int num=1;
    private LocalDate dateinscri = LocalDate.now();
    private List<document> listeDocumentsEmpruntes;


    public adherant(String nom ,String prenom) {
        this.nom = nom;
        this.prenom=prenom;
        this.id=num;
        num++;
        this.listeDocumentsEmpruntes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getId() {
        return id;
    }

    public void setDateinscri(LocalDate dateinscri) {
        this.dateinscri = dateinscri;
    }

   public void afficherAdherant(){
        System.out.println("adherant num°:"+this.id);
        System.out.println("nom:"+this.nom);
        System.out.println("prenom:"+this.prenom);
        System.out.println("date d'inscription:"+this.dateinscri);
        System.out.println("Documents empruntés :");
        if (listeDocumentsEmpruntes.isEmpty()) {
            System.out.print("Aucun document emprunté.");
        } else {
            for (document doc : listeDocumentsEmpruntes) {
                System.out.println("- " + doc.getTitre());
            }
    }
    }
public String afficheradherant (){
        String s="adherant num: "+this.id+"\nnom: "+this.nom+"\nprenom: "+this.prenom+"\ndate d'inscription: "+this.dateinscri+"\n Liste des emprunts: ";
    if (listeDocumentsEmpruntes.isEmpty()) {
       s+="Aucun document emprunté.";
    } else {
        for (document doc : listeDocumentsEmpruntes) {
            s += "- " + doc.getTitre();
        }
    }
        return s;
}
    public String renouvelerInscri(){
     if (!verifAbonnement())
     {   dateinscri=LocalDate.now();
         return "L'inscription a été renouvelée avec succès !";}
    else {
       return "L'abonnement est encore valide, pas besoin de le renouveler.";
    }
    }

    public boolean verifAbonnement() {
        LocalDate dateFinAbonnement = dateinscri.plusYears(1);
        LocalDate dateActuelle = LocalDate.now();
        return dateActuelle.isBefore(dateFinAbonnement);
    }

    public void emprunter( document doc) {
        if (verifAbonnement()) {
            listeDocumentsEmpruntes.add(doc);
            System.out.println("Le document a été emprunté avec succès.");
        } else {
            System.out.println("L'abonnement n'est plus valide. Veuillez le renouveler avant d'emprunter.");
        }
    }

    public void retourner(document doc) {
        if (listeDocumentsEmpruntes.contains(doc)) {
            System.out.println("Le document  a été retourné avec succès.");
        } else {
            System.out.println("Le document n'est pas dans votre liste  d'emprunts.");
        }
    }



}
