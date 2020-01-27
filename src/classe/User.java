package classe;

import java.util.List;

public class User {
    private String FirstName;

    private String LastName;

    private String Email;

    private int FilmLoue;

    private List<Movie> Movies;

    public User(String firstName, String lastName, String email,int filmLoue) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        FilmLoue = filmLoue;
        Movies = null;
    }

    public User(String firstName, String lastName, String email, List<Movie> movies,int filmLoue) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        FilmLoue = filmLoue;
        Movies = movies;
    }
}
