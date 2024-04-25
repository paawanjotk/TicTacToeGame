package models;
public class Symbol {
    private char sym;
    private String imageURL;

    public Symbol(char sym) {
        this.sym = sym;
    }

    public char getSym() {
        return sym;
    }

    public void setSym(char sym) {
        this.sym = sym;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
