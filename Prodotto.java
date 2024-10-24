package com.example.demo;

public class Prodotto {
    private String nome;     // Nome del prodotto
    private String marca;    // Marca del prodotto
    private double prezzo;   // Prezzo del prodotto
    private String url;      // URL dell'immagine del prodotto

    // Costruttore della classe Prodotto
    public Prodotto(String nome, String marca, double prezzo, String url) {
        this.nome = nome;         // Inizializza il campo nome
        this.marca = marca;       
        this.prezzo = prezzo;     
        this.url = url;          
    }

    // Getter per il nome del prodotto
    public String getNome() {
        return nome;              // Ritorna il // del prodotto
    }

    public String getMarca() {
        return marca;             
    }

    public double getPrezzo() {
        return prezzo;            
    }

    public String getUrl() {
        return url;              
    }
}
