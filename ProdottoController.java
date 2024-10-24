package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProdottoController {

    // ArrayList di prodotti
    ArrayList<Prodotto> listaProdotti = new ArrayList<>();

    // Rotta per il form di aggiunta prodotto
    @GetMapping("/aggiungiprodotto")
    public String mostraForm() {
        return "FormProdotto"; // Template del form
    }

    // Rotta per gestire l'inserimento del prodotto
    @PostMapping("/inserisciprodotto")
    public String inserisciProdotto(@RequestParam("nome") String nome,
                                     @RequestParam("marca") String marca,
                                     @RequestParam("prezzo") double prezzo,
                                     @RequestParam("url") String url, 
                                     Model model) {
        Prodotto nuovoProdotto = new Prodotto(nome, marca, prezzo, url);
        listaProdotti.add(nuovoProdotto);
        model.addAttribute("prodotto", nuovoProdotto); // Aggiunge il nuovo prodotto al modello per il template
        return "stampa1"; // Ritorna il nome del template per visualizzare i dati del prodotto
    }

    // Rotta per visualizzare la lista dei prodotti
    @GetMapping("/listaprodotti")
    public String getLista(Model model) {
        model.addAttribute("listaProdotti", listaProdotti); // Aggiunge la lista dei prodotti al modello
        return "listaprodotti"; // Ritorna il nome del template per visualizzare la lista dei prodotti
    }

    // Rotta per calcolare il totale
    @PostMapping("/calcolaTotale")
    public String calcolaTotale(@RequestParam("quantita") List<Integer> quantita, Model model) {
        double totale = 0.0;    // Inizializza una variabile per il totale

        for (int i = 0; i < listaProdotti.size(); i++) {
            totale += listaProdotti.get(i).getPrezzo() * quantita.get(i);     // Calcola il totale sommando il prezzo di ciascun prodotto moltiplicato per la quantità
        }

        model.addAttribute("totale", totale);             // Aggiunge il totale al modello per renderlo disponibile nella vista
        return "totale"; // Ritorna il nome  per visualizzare il totale
    }
}
