package edu.uph.m24si2.kaloritrakerapp;

public class Food {

    private int id;
    private String namaMakanan;
    private int kalori;
    private int protein;
    private int lemak;
    private int karbohidrat;

    // Constructor
    public Food(int id, String namaMakanan, int kalori, int protein, int lemak, int karbohidrat) {
        this.id = id;
        this.namaMakanan = namaMakanan;
        this.kalori = kalori;
        this.protein = protein;
        this.lemak = lemak;
        this.karbohidrat = karbohidrat;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public int getKalori() {
        return kalori;
    }

    public int getProtein() {
        return protein;
    }

    public int getLemak() {
        return lemak;
    }

    public int getKarbohidrat() {
        return karbohidrat;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }

    public void setKalori(int kalori) {
        this.kalori = kalori;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public void setLemak(int lemak) {
        this.lemak = lemak;
    }

    public void setKarbohidrat(int karbohidrat) {
        this.karbohidrat = karbohidrat;
    }
}