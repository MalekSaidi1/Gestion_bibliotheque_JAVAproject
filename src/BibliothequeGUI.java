
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BibliothequeGUI extends JFrame {
    private bibliotheque bibliotheque;

    public BibliothequeGUI() {
        // Initialisation de la bibliothèque
        bibliotheque = new bibliotheque("Bibliotheque centrale", 1);

        // Configuration de la fenêtre principale
        setTitle("Gestion de la Bibliothèque");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Ajout des boutons du menu
        JButton btnAjouterAdherent = new JButton("Ajouter un adhérent");
        JButton btnSupprimerAdherent = new JButton("Supprimer un adhérent");
        JButton btnAjouterDocument = new JButton("Ajouter un document");
        JButton btnSupprimerDocument = new JButton("Supprimer un document");
        JButton btnEmprunter = new JButton("Emprunter un document");
        JButton btnRetourner = new JButton("Retourner un document");
        JButton btnRechercher = new JButton("Rechercher un document");
        JButton btnRechercherAdherant = new JButton("Rechercher un adhérant");
        JButton btnAfficherDocuments = new JButton("Afficher tous les documents");
        JButton btnAfficherAdherents = new JButton("Afficher tous les adhérents");
        JButton btnRenouvelerInscription = new JButton("Renouveler un abonnement");
        JButton btnQuitter = new JButton("Quitter");

        // Ajout des boutons au panneau
        add(btnAjouterAdherent);
        add(btnSupprimerAdherent);
        add(btnAjouterDocument);
        add(btnSupprimerDocument);
        add(btnEmprunter);
        add(btnRetourner);
        add(btnRechercher);
        add(btnRechercherAdherant);
        add(btnAfficherDocuments);
        add(btnAfficherAdherents);
        add(btnRenouvelerInscription);
        add(btnQuitter);

        // Actions pour chaque bouton
        btnAjouterAdherent.addActionListener(e -> ajouterAdherent());
        btnSupprimerAdherent.addActionListener(e -> supprimerAdherent());
        btnAjouterDocument.addActionListener(e -> ajouterDocument());
        btnSupprimerDocument.addActionListener(e -> supprimerDocument());
        btnEmprunter.addActionListener(e -> emprunterDocument());
        btnRetourner.addActionListener(e -> retournerDocument());
        btnRechercher.addActionListener(e -> rechercherDocument());
        btnRechercherAdherant.addActionListener(e -> rechercherAdherant());
        btnAfficherDocuments.addActionListener(e -> afficherTousLesDocuments());
        btnAfficherAdherents.addActionListener(e -> afficherTousLesAdherents());
        btnRenouvelerInscription.addActionListener(e -> renouvelerInscription());
        btnQuitter.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void ajouterAdherent() {
        String nom = JOptionPane.showInputDialog(this, "Nom de l'adhérent :");
        String prenom = JOptionPane.showInputDialog(this, "Prénom de l'adhérent :");
        adherant adherant = new adherant(nom, prenom);
        bibliotheque.ajouterAdherant(adherant);
        JOptionPane.showMessageDialog(this, "Adhérent ajouté avec succès !");
        JOptionPane.showMessageDialog(this,adherant.afficheradherant());
    }

    private void supprimerAdherent() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "ID de l'adhérent à supprimer :"));

        JOptionPane.showMessageDialog(this,bibliotheque.supprimerAdherant(id) );
    }

    private void ajouterDocument() {
        String titre = JOptionPane.showInputDialog(this, "Titre du document :");
        String auteur = JOptionPane.showInputDialog(this, "Auteur du document :");
        int qte = Integer.parseInt(JOptionPane.showInputDialog(this, "Quantité disponible :"));
        String[] types = {"Livre", "Article", "PFE"};
        int choix = JOptionPane.showOptionDialog(this, "Type de document :", "Choix",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, types, types[0]);
        document doc;
        if (choix == 0) {
            int isbn = Integer.parseInt(JOptionPane.showInputDialog(this, "ISBN du livre :"));
            doc = new livre(titre, auteur, qte, isbn);
        } else if (choix == 1) {
            int num = Integer.parseInt(JOptionPane.showInputDialog(this, "Numéro de l'article :"));
            doc = new article(titre, auteur, qte, num);
        } else {
            String specialite = JOptionPane.showInputDialog(this, "Spécialité du PFE :");
            String universite = JOptionPane.showInputDialog(this, "Université :");
            doc = new pfe(titre, auteur, qte, universite, specialite);
        }
        bibliotheque.ajouterDocument(doc);
        JOptionPane.showMessageDialog(this, "Document ajouté avec succès !");
        JOptionPane.showMessageDialog(this,doc.afficherDocument());
    }

    private void supprimerDocument() {
        String titre = JOptionPane.showInputDialog(this, "Titre du document à supprimer :");

        JOptionPane.showMessageDialog(this,  bibliotheque.supprimerDocument(titre));
    }

    private void emprunterDocument() {
        int idAdherant = Integer.parseInt(JOptionPane.showInputDialog(this, "ID de l'adhérent :"));
        String titre = JOptionPane.showInputDialog(this, "Titre du document à emprunter :");
        JOptionPane.showMessageDialog(this,bibliotheque.emprunterDocument(titre, idAdherant));
        /*document doc=bibliotheque.rechercherdocpartitre(titre);
        JOptionPane.showMessageDialog(this, "Document emprunté avec succès !");
        JOptionPane.showMessageDialog(this,"quantité restante: "+doc.getQte());*/
    }

    private void retournerDocument() {
        int idAdherant = Integer.parseInt(JOptionPane.showInputDialog(this, "ID de l'adhérent :"));
        String titre = JOptionPane.showInputDialog(this, "Titre du document à retourner :");
        JOptionPane.showMessageDialog(this, bibliotheque.retournerDocument(titre, idAdherant));
        /*document doc=bibliotheque.rechercherdocpartitre(titre);
        JOptionPane.showMessageDialog(this, "Document retourné avec succès !");
        JOptionPane.showMessageDialog(this,"quantité actuelle: "+doc.getQte());*/
    }

    private void rechercherDocument() {
        String titre = JOptionPane.showInputDialog(this, "Titre du document à rechercher :");
        document doc = bibliotheque.rechercherdocpartitre(titre);
        if (doc != null) {
            JOptionPane.showMessageDialog(this, doc.afficherDocument());
        } else {
            JOptionPane.showMessageDialog(this, "Document non trouvé.");
        }
    }
    private void rechercherAdherant() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "ID de l'adherant à rechercher :"));
        adherant ad = bibliotheque.rechercheradherantparid(id);
        if (ad != null) {
            JOptionPane.showMessageDialog(this, ad.afficheradherant());
        } else {
            JOptionPane.showMessageDialog(this, "Adhérant non trouvé.");
        }
    }

    private void afficherTousLesDocuments() {
        JOptionPane.showMessageDialog(this, bibliotheque.afficherTousLesDocumentsDispos());
    }

    private void afficherTousLesAdherents() {
        JOptionPane.showMessageDialog(this,bibliotheque.afficherTousLesAdherants());
    }

    private void renouvelerInscription() {
        String nom = JOptionPane.showInputDialog(this, "Nom de l'adhérent :");
        String prenom = JOptionPane.showInputDialog(this, "Prénom de l'adhérent :");
        adherant adherant = new adherant(nom, prenom);
        JOptionPane.showMessageDialog(this,adherant.renouvelerInscri());
        //JOptionPane.showMessageDialog(this, "Inscription renouvelée avec succès !");
        JOptionPane.showMessageDialog(this,adherant.afficheradherant());
    }

    public static void main(String[] args) {
        new BibliothequeGUI();
    }
}



