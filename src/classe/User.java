package classe;

import java.util.List;

public class User {
    private String FirstName;

    private String LastName;

    private String Email;

    private List<Movie> Movies;

    public User(String firstName, String lastName, String email) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Movies = null;
    }

    public User(String firstName, String lastName, String email, List<Movie> movies) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Movies = movies;
    }
}
