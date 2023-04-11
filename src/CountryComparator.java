import java.util.Comparator;

public class CountryComparator implements Comparator<Pays> {

    @Override
    public int compare(Pays pays1, Pays pays2) {
        String nom1 = pays1.getNom();
        String nom2 = pays2.getNom();
        return nom1.compareTo(nom2);
    }
}