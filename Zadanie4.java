public class Zadanie4 {

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
        static int liczbaInzynierow = 0;

        Inzynier(String imie, String nazwisko, Skutecznosc skutecznosc, int liczbaProjektow) {
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.skutecznosc = skutecznosc;

            if (liczbaProjektow < 0) {
                this.liczbaProjektow = 0;
            } else {
                this.liczbaProjektow = liczbaProjektow;
            }

            liczbaInzynierow++;
        }

        void buduj() {
            int ile = skutecznosc.wartosc;

            for (int i = 0; i < ile; i++) {
                liczbaProjektow++;
                wszystkieProjektyFirmy++;
                awansuj();
            }
        }

        void pokaz() {
            System.out.println(imie + " " + nazwisko + " - projekty: " + liczbaProjektow);
        }

        void awansuj() {
            if (skutecznosc == Skutecznosc.SLABY && liczbaProjektow >= 10) {
                skutecznosc = Skutecznosc.DOBRY;
            } else if (skutecznosc == Skutecznosc.DOBRY && liczbaProjektow > 20) {
                skutecznosc = Skutecznosc.WYBITNY;
            }
        }

        static void pokazGlobalneProjekty() {
            System.out.println("Wszystkie projekty firmy: " + wszystkieProjektyFirmy);
        }

        static double sredniaProjektowNaInzyniera() {
            if (liczbaInzynierow == 0) {
                return 0;
            }

            return (double) wszystkieProjektyFirmy / liczbaInzynierow;
        }
    }

    public static void main(String[] args) {
        Inzynier[] inzynierowie = {
                new Inzynier("Jan", "Kowalski", Skutecznosc.SLABY, 0),
                new Inzynier("Anna", "Nowak", Skutecznosc.DOBRY, 0),
                new Inzynier("Piotr", "Wisniewski", Skutecznosc.WYBITNY, 0)
        };

        for (Inzynier inzynier : inzynierowie) {
            inzynier.buduj();
            inzynier.pokaz();
        }

        Inzynier.pokazGlobalneProjekty();

        System.out.println("Liczba inzynierow: " + Inzynier.liczbaInzynierow);
        System.out.println("Srednia projektow: " + Inzynier.sredniaProjektowNaInzyniera());
    }
}
