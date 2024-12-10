public class article extends document{
    private int num;

    public article(String titre, String auteur, int qte,int num) {
        super(titre, auteur,qte);
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void afficherdetails(){
        System.out.println("Article:");
        super.afficherdetails();
        System.out.println("numéro°"+this.num);
    }
    public String afficherDocument(){
        return super.afficherDocument()+ "\nNum°:  "+this.num;
    }
}
