public class livre extends document{
    private int ISBN;

    public livre(String titre, String auteur,int qte, int ISBN) {
        super(titre, auteur,qte);
        this.ISBN = ISBN;
    }

    public int getISBN() {
        return ISBN;
    }
    public void afficherdetails(){
        System.out.println("Livre:");
        super.afficherdetails();
        System.out.println("ISBN:"+this.ISBN);
    }
    public String afficherDocument(){
         return super.afficherDocument()+ "\nISBN: "+this.ISBN;
    }
}
