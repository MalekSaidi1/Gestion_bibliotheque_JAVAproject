import java.util.ArrayList;
import java.util.List;

public class bibliotheque {
    private String nom;
    private int code;
    private List<document> listedesdocuments;
    private List<adherant> listedesadherants;

    public bibliotheque(String nom, int code) {
        this.nom = nom;
        this.code=code;
        this.listedesadherants = new ArrayList<>();
        this.listedesdocuments = new ArrayList<>();

    }

    public String getNom() {
        return nom;
    }

    public void ajouterAdherant(adherant A){
        listedesadherants.add(A);
        System.out.println("Adhérant "+A.getNom()+" "+A.getPrenom()+" est ajouté à la liste.");
    }
    public String supprimerAdherant(int id){
        adherant A=rechercheradherantparid(id);
        if (listedesadherants.contains(A))
        {   listedesadherants.remove(A);
            return ("l'adherant "+ id+ " est supprimé de la liste.");}

        else
            return ("l'adherant n'existe déjà pas.");
    }
    public void ajouterDocument(document doc){
            listedesdocuments.add(doc);
            System.out.println("Document : " + doc.getTitre()+" ajouté à la base.");
            System.out.println();
        }
    public String supprimerDocument(String titre) {
        /*listedesdocuments.removeIf(doc -> doc.getTitre().equals(titre));
        System.out.println("Document supprimé.");
        System.out.println();*/
        document doc= rechercherdocpartitre(titre);
        if (listedesdocuments.contains(doc)){
            listedesdocuments.remove(doc);
            return "Document supprimé.";
        }
        else return "ce document n'existe déjà pas.";

    }

   public document rechercherdocpartitre (String titre){
        for(document d:listedesdocuments)
        { if (d.getTitre().equals(titre))
            return d;}
        return null;
   }
   public adherant rechercheradherantparid(int id){
        for (adherant a: listedesadherants)
        { if (a.getId()==id)
            return a;}
        return null;
   }
   public String emprunterDocument(String titre,int id){
        adherant a=rechercheradherantparid(id);
        document d=rechercherdocpartitre(titre);
        if (d!= null && a!=null){
            if (d.getQte()>0){
            a.emprunter(d);
            d.setQte(d.getQte()-1);
            return "Document "+titre+" emprunté"+"\nla quantité actuelle :"+ d.getQte();}
            else return "quantité épuisé.";
        }
        else {
            return "introuvable";}

        }
   public String retournerDocument(String titre, int id){
       adherant a=rechercheradherantparid(id);
       document d=rechercherdocpartitre(titre);
       if (d!= null && a!=null){
           a.retourner(d);
            d.setQte(d.getQte()+1);
           return "Le document "+titre+"a été retourné par l'adhérant "+id+"\nQuantité actuelle: "+d.getQte();}
       else
           return "ce document n'a pas été emprunté par cet adherant";
   }
   public String afficherTousLesDocumentsDispos (){
        String s= "Tous les documents dans la bibliothèque :\n";
       for (document doc : listedesdocuments)
           s+=doc.afficherDocument()+"\n\n";
       return s;
   }
    public String afficherTousLesAdherants (){
       String s="Tous les adherants de la bibliothèque :\n";
        for (adherant a : listedesadherants)
           s+=a.afficheradherant()+"\n\n";
        return s ;
    }






}
