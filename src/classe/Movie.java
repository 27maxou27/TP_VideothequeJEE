package classe;

public class Movie {
    private String Title;

    private String Actor;

    private String Realisator;

    private int Year;

    private MediaSupport Media;

    public Movie(String title, String actor, String realisator, int year, MediaSupport media) {
        Title = title;
        Actor = actor;
        Realisator = realisator;
        Year = year;
        Media = media;
    }

    public void Display() {
        System.out.printf("------------------------------------------");
        System.out.printf("Titre: %s", Title);
        System.out.printf("Acteur principal: %s", Actor);
        System.out.printf("Réalisateur: %s", Realisator);
        System.out.printf("Année: %i\tSupport: %s", Year, Media.Nom);
    }
}
