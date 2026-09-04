public class Zadanie1 {

    enum Skutecznosc {
        SLABY(1),
        DOBRY(2),
        WYBITNY(3);

        int wartosc;

        Skutecznosc(int wartosc) {
            this.wartosc = wartosc;
        }
    }

    static class Inzynier {
        String imie;
        String nazwisko;
        Skutecznosc skutecznosc;
        int liczbaProjektow;

        static int wszystkieProjektyFirmy = 0;

        Inzynier(String imie, String nazwisko, Skutecznosc skutecznosc, int liczbaProjektow) {
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.skutecznosc = skutecznosc;
            this.liczbaProjektow = liczbaProjektow;
        }

        void buduj() {
            System.out.println(imie + " " + nazwisko + " buduje " + skutecznosc.wartosc + " projekt(y)");

            liczbaProjektow += skutecznosc.wartosc;
            wszystkieProjektyFirmy += skutecznosc.wartosc;
        }

        void pokaz() {
            System.out.println(imie + " " + nazwisko + " - projekty: " + liczbaProjektow);
        }

        static void pokazGlobalneProjekty() {
            System.out.println("Wszystkie projekty firmy: " + wszystkieProjektyFirmy);
        }
    }

    public static void main(String[] args) {
        Inzynier inzynier = new Inzynier("Jan", "Kowalski", Skutecznosc.DOBRY, 0);

        inzynier.buduj();
        inzynier.pokaz();

        Inzynier.pokazGlobalneProjekty();
    }
}
