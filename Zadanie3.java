public class Zadanie3 {

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

            if (liczbaProjektow < 0) {
                this.liczbaProjektow = 0;
            } else {
                this.liczbaProjektow = liczbaProjektow;
            }
        }

        void buduj() {
            int ile = skutecznosc.wartosc;

            System.out.println(imie + " " + nazwisko + " buduje " + ile + " projekt(y)");

            for (int i = 0; i < ile; i++) {
                liczbaProjektow++;
                wszystkieProjektyFirmy++;
                awansuj();
            }
        }

        void pokaz() {
            System.out.println(imie + " " + nazwisko + " - " + skutecznosc + " - projekty: " + liczbaProjektow);
        }

        void awansuj() {
            if (skutecznosc == Skutecznosc.SLABY && liczbaProjektow >= 10) {
                skutecznosc = Skutecznosc.DOBRY;
                System.out.println(imie + " awansuje na DOBRY");
            } else if (skutecznosc == Skutecznosc.DOBRY && liczbaProjektow > 20) {
                skutecznosc = Skutecznosc.WYBITNY;
                System.out.println(imie + " awansuje na WYBITNY");
            }
        }

        static void pokazGlobalneProjekty() {
            System.out.println("Wszystkie projekty firmy: " + wszystkieProjektyFirmy);
        }
    }

    public static void main(String[] args) {
        Inzynier inzynier = new Inzynier("Jan", "Kowalski", Skutecznosc.SLABY, 8);

        for (int i = 0; i < 5; i++) {
            inzynier.buduj();
        }

        inzynier.pokaz();
        Inzynier.pokazGlobalneProjekty();
    }
}
