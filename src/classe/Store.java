package classe;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Store {

    private Scanner Scanner;
    private List<User> Users;
    private List<Movie> Movies;

    public Store() {
        Scanner = new Scanner(System.in);
        Users = new ArrayList<User>() {{
            add(new User("admin", "admin", "admin@admin.com", null));
            add(new User("Max", "Dandres", "max.dandres@epsi.fr"));
        }};
        Movies = new ArrayList<Movie>() {{
            add(new Movie("Matrix", "Keanu Reeves", "P. & L. Wachowski", 1999, MediaSupport.DVD));
            add(new Movie("Matrix: Reloaded", "Keanu Reeves", "P. & L. Wachowski", 2003, MediaSupport.BLUERAY));
            add(new Movie("Matrix: Revolution", "Keanu Reeves", "P. & L. Wachowski", 2003, MediaSupport.USB));
        }};
    }

    public int MainMenu() {
        int input = 1;

        do {
            System.out.println("|------------- VIDEOTHEQUE -------------|");
            System.out.println("|   Bienvenue! Que voulez vous gérer?   |");
            System.out.println("| 1 - Films                             |");
            System.out.println("| 2 - Utilisateurs                      |");
            System.out.println("| 0 - Quitter                           |");
            System.out.println("|---------------------------------------|");

            input = GetInput(2);

            switch (input) {
                case 0:
                    System.out.println("Exit");
                    break;
                case 1:
                    MovieMenu();
                    break;
                case 2:
                    UserMenu();
                    break;
            }
        } while (input > 0);

        return (input);
    }

    private void UserMenu() {
        int input = 1;

        do {
            System.out.println("|------------- MEMBRES -------------|");
            System.out.println("| 1 - Lister les membres            |");
            System.out.println("| 2 - Rechercher un membre          |");
            System.out.println("| 3 - Ajouter un membre             |");
            System.out.println("| 4 - Supprimer un membre           |");
            System.out.println("| 0 - Retour                        |");
            System.out.println("|-----------------------------------|");

            input = GetInput(4);
            switch (input) {
                case 0:
                    System.out.println("Exit");
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        } while (input > 0);
    }

    private void MovieMenu() {
        int input = 1;

        do {
            System.out.println("|------------- FILMS ---------------|");
            System.out.println("| 1 - Lister les films              |");
            System.out.println("| 2 - Rechercher un film            |");
            System.out.println("| 3 - Ajouter un film               |");
            System.out.println("| 4 - Supprimer un film             |");
            System.out.println("| 0 - Retour                        |");
            System.out.println("|-----------------------------------|");

            input = GetInput(4);
            switch (input) {
                case 0:
                    System.out.println("Exit");
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        } while (input > 0);
    }

    private int GetInput(int maxValue) {
        Boolean inputCheck = false;
        int input = 0;

        while (!inputCheck) {
            try {
                System.out.print("Choix: ");
                input = Scanner.nextInt();
                if (0 <= input && input <= maxValue) {
                    inputCheck = true;
                } else {
                    System.out.printf("Veuillez entrer une valeur comprise entre %d et %d.\n", 0, maxValue);
                }
            } catch (InputMismatchException ex) {
                System.out.println("Veuillez entrer une valeur numérique.");
                Scanner.nextLine();
            }
        }

        return (input);
    }
}
