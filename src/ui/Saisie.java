package ui;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Saisie {

    /**
     * Scanner pour saisie User
     */
    public static Scanner sc = new Scanner(System.in);


    /////////////////////////////////////////////////////////////////////////////////
    //Methodes de saisie
    /**
     * Boucle de saisie d'un Entier
     *
     * @return Entier Corespondant au choix de l'utilisateur
     */
    public int saisirInt() {
        int choix = 0;
        Boolean test;
        do {
            test = false;
            try {
                choix = sc.nextInt();
            } catch (InputMismatchException e) {
                // System.out.println("Error: 1 EXPLODE STRING!!!!! " + e.getClass().getName());
                test = true;
            } catch (NoSuchElementException e) {
                // System.out.println("Error: 2 EXPLODE STRING!!!!! " + e.getClass().getName());
                test = true;
            } catch (IllegalStateException e) {
                // System.out.println("Error: 3 EXPLODE STRING!!!!! " + e.getClass().getName());
                test = true;
            } finally {
                sc.nextLine();
                sc.reset();
            }
        } while (test);
        return choix;
    }

    /**
     * Demande de réponse binaire (oui ou non), Boucle de saisie d'un Boolean
     *
     * @return : True si Oui , False si non
     */
    public boolean demandeOuiNon() {

        Boolean ok = false;

        int choix;
        do {
            System.out.println("1 : OUI        0 : NON");
            choix = this.saisirInt();
        } while (choix != 0 && choix != 1);
        ok = (choix == 1);

        return ok;
    }

}
