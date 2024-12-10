import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        bibliotheque bibliotheque = new bibliotheque("Bibliotheque centrale", 001);

        int choix;
        do {
            System.out.println("--- MENU DE LA BIBLIOTHÈQUE ---");
            System.out.println("1. Ajouter un adhérent");
            System.out.println("2. Supprimer un adhérent");
            System.out.println("3. Ajouter un document");
            System.out.println("4. Supprimer un document");
            System.out.println("5. Emprunter un document");
            System.out.println("6. Retourner un document");
            System.out.println("7. Rechercher un document");
            System.out.println("8. Afficher tous les documents");
            System.out.println("9. Afficher tous les adhérents");
            System.out.println("10. Renouveler un abonnement ");
            System.out.println("11. Quitter");
            System.out.print("Choisissez une option : ");
            choix = scanner.nextInt();


            switch (choix) {
                case 1 -> {
                    scanner.nextLine();
                    System.out.print("Nom de l'adhérent : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom de l'adhérent : ");
                    String prenom = scanner.nextLine();
                    adherant adherant = new adherant(nom, prenom);
                    bibliotheque.ajouterAdherant(adherant);
                    adherant.afficherAdherant();
                }
                case 2 -> {
                    System.out.print("ID de l'adhérent à supprimer : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    bibliotheque.supprimerAdherant(id);
                }
                case 3 -> {
                    System.out.print("Type de document (1. Livre, 2. Article, 3. PFE) : ");
                    int type = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Titre du document : ");
                    String titre = scanner.nextLine();
                    System.out.print("Auteur du document : ");
                    String auteur = scanner.nextLine();
                    System.out.print("Quantité disponible: ");
                    int qte=scanner.nextInt();
                    document document;
                    if (type == 1) {
                        System.out.print("entrer l'isbn du livre :");
                        int isbn = scanner.nextInt();
                        document = new livre(titre, auteur,qte, isbn);
                    } else if (type == 2) {
                        System.out.print("Numéro de l'article : ");
                        int num = scanner.nextInt();
                        document = new article(titre, auteur,qte, num);
                    } else {
                        System.out.print("Spécialité du PFE : ");
                        String specialite = scanner.nextLine();
                        System.out.print("L'université :");
                        String universite = scanner.nextLine();
                        document = new pfe(titre, auteur,qte, universite, specialite);
                    }
                    bibliotheque.ajouterDocument(document);
                }
                case 4 -> {
                    scanner.nextLine();
                    System.out.print("Titre du document à supprimer : ");
                    String titre = scanner.nextLine();
                    bibliotheque.supprimerDocument(titre);
                }
                case 5 -> {
                    System.out.print("ID de l'adhérent : ");
                    int idAdherant = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Titre du document à emprunter : ");
                    String titre = scanner.nextLine();
                    bibliotheque.emprunterDocument(titre, idAdherant);
                }
                case 6 -> {
                    System.out.print("ID de l'adhérent : ");
                    int idAdherant = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Titre du document à retourner : ");
                    String titre = scanner.nextLine();
                    bibliotheque.retournerDocument(titre, idAdherant);
                }
                case 7 -> {
                    System.out.print("Titre du document à rechercher : ");
                    String titre = scanner.nextLine();
                    document doc = bibliotheque.rechercherdocpartitre(titre);
                    if (doc != null) {
                        doc.afficherdetails();
                    } else {
                        System.out.println("Document non trouvé.");
                    }
                }
                case 8 -> bibliotheque.afficherTousLesDocumentsDispos();

                case 9 -> bibliotheque.afficherTousLesAdherants();

                case 10 -> {
                    scanner.nextLine();
                    System.out.print("Nom de l'adhérent : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom de l'adhérent : ");
                    String prenom = scanner.nextLine();
                    adherant adherant = new adherant(nom, prenom);
                    adherant.renouvelerInscri();
                }
                case 11 -> System.out.println("Merci d'avoir utilisé la bibliothèque !");
                default -> System.out.println("Choix invalide, veuillez réessayer.");}

            }
            while (choix != 11) ;

        }
    }