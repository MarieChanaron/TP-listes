import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class Main {

    public static void afficherPays(ArrayList<Pays> pays) {
        for (Pays chaquePays : pays) {
            System.out.println(chaquePays.getNom());
        }
    }

    public static void afficherNom(ArrayList<String> nomsPays) {
        for (String nomPays : nomsPays) {
            System.out.println(nomPays);
        }
    }


    public static void main(String[] args) {

        // QUESTION a
        Pays france = new Pays("France");
        Pays allemagne = new Pays("Allemagne");
        Pays armenie = new Pays("Arménie");
        Pays liban = new Pays("Liban");
        Pays chine = new Pays("Chine");

        ArrayList<Pays> pays = new ArrayList<>();
        pays.add(france);
        pays.add(allemagne);
        pays.add(armenie);
        pays.add(liban);
        pays.add(chine);
        System.out.println("La collection créée contient " + pays.size() + " pays !");

        // QUESTION b
        // Affiche chaque nom de pays
        afficherPays(pays);

        // QUESTION c
        // Vide la liste
        pays.clear();

        System.out.println(); // Saut de ligne

        // Affiche un message lorsque la liste est vide et lorsqu'elle n'est pas vide
        if (pays.isEmpty()) {
            System.out.println("La liste est vide");
        } else {
            System.out.println("La liste n'est pas vide");
        }

        // QUESTION d
        // Réalimente la liste de pays
        pays.add(france);
        pays.add(allemagne);
        pays.add(armenie);
        pays.add(liban);
        pays.add(chine);

        // Modifie le nom d'un pays
        Pays suisse = new Pays("Suisse");
        pays.set(1, suisse); // Remplace "Allemagne" par "Suisse"

        System.out.println(); // Saut de ligne

        // Affiche la liste de pays
        afficherPays(pays);

        // Transforme la liste de pays en liste de Strings
        ArrayList<String> nomsPays = new ArrayList<String>();
        int i = 0;
        for (Pays chaquePays : pays) {
            nomsPays.add(chaquePays.getNom());
        }

        // QUESTION e
        // Trie la collection de pays en tant que Strings (dans l'ordre croissant)
        Collections.sort(nomsPays);

        // Affiche la liste triée par ordre décroissant
        System.out.println("\nListe triée dans l'ordre croissant : ");
        afficherNom(nomsPays);

        // Trie dans l'ordre décroissant
        Collections.sort(nomsPays, Collections.reverseOrder());

        // Réaffiche la liste triée cette fois par ordre décroissant
        System.out.println("\nListe triée dans l'ordre décroissant : ");
        afficherNom(nomsPays);

        // Si c'est une arraylist de pays, la méthode sort ne fonctionne pas.
        // Utilisation du comparateur
        Collections.sort(pays, new CountryComparator());
        System.out.println("\nListe triée dans l'ordre croissant (avec le comparateur) : ");
        afficherPays(pays);

        // Trie la collection du plus petit mot au plus grand mot
        Collections.sort(pays, new CountryComparatorBySize());

        // Réaffiche la liste
        System.out.println("\nListe triée par longueur des mots : ");
        afficherPays(pays);

        // Ne pas afficher les pays dont la longueur est supérieure à 5 lettres
        // TEST 1 : NE FONCTIONNE PAS
        /*for (Pays chaquePays : pays) {
            if (chaquePays.getNom().length() > 5) {
                pays.remove(chaquePays);
            }
        }*/

        // TEST 2 : NE FONCTIONNE PAS
        /*for (int j = 0; j < pays.size(); j++) {
            String nomPays = pays.get(j).getNom();
            if (nomPays.length() > 5) {
                pays.remove(i);
                System.out.println(nomPays + " " + nomPays.length());
            }
        }*/

        // Afficher uniquement les pays dont le nombre de lettres est inférieur ou égal à 5
        ListIterator iterateur = pays.listIterator();

        while (iterateur.hasNext()) {
            Pays paysObj = (Pays) iterateur.next();
            String nom = paysObj.getNom();
            if (nom.length() > 5) {
                iterateur.remove();
            }
        }

        System.out.println("\nListe triée par longueur des mots " +
                "(sans afficher ceux dont la longueur est supérieure à 5) : ");
        afficherPays(pays);


    }
}