public class Zadanie5 {

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
        static int rekordProjektow = 0;

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

            if (this.liczbaProjektow > rekordProjektow) {
                rekordProjektow = this.liczbaProjektow;
            }
        }

        void buduj() {
            int ile = skutecznosc.wartosc;

            System.out.println(imie + " " + nazwisko + " buduje " + ile + " projekt(y)");

            for (int i = 0; i < ile; i++) {
                liczbaProjektow++;
                wszystkieProjektyFirmy++;

                awansuj();

                if (liczbaProjektow > rekordProjektow) {
                    rekordProjektow = liczbaProjektow;
                }
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

        void porownajZ(Inzynier innyInzynier) {
            if (liczbaProjektow > innyInzynier.liczbaProjektow) {
                int roznica = liczbaProjektow - innyInzynier.liczbaProjektow;
                System.out.println(imie + " " + nazwisko + " ma wiecej projektow o " + roznica);
            } else if (liczbaProjektow < innyInzynier.liczbaProjektow) {
                int roznica = innyInzynier.liczbaProjektow - liczbaProjektow;
                System.out.println(innyInzynier.imie + " " + innyInzynier.nazwisko + " ma wiecej projektow o " + roznica);
            } else {
                System.out.println("Obaj inzynierowie maja tyle samo projektow");
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
                new Inzynier("Jan", "Kowalski", Skutecznosc.SLABY, 7),
                new Inzynier("Anna", "Nowak", Skutecznosc.DOBRY, 16),
                new Inzynier("Piotr", "Wisniewski", Skutecznosc.WYBITNY, 0)
        };

        for (Inzynier inzynier : inzynierowie) {
            for (int i = 0; i < 3; i++) {
                inzynier.buduj();
            }
        }

        for (Inzynier inzynier : inzynierowie) {
            inzynier.pokaz();
        }

        Inzynier.pokazGlobalneProjekty();

        System.out.println("Liczba inzynierow: " + Inzynier.liczbaInzynierow);
        System.out.println("Srednia projektow: " + Inzynier.sredniaProjektowNaInzyniera());
        System.out.println("Rekord projektow: " + Inzynier.rekordProjektow);

        inzynierowie[0].porownajZ(inzynierowie[1]);
        inzynierowie[1].porownajZ(inzynierowie[2]);
    }
}
