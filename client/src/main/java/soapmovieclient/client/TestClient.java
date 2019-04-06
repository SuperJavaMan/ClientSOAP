package soapmovieclient.client;

import movies.wsdl.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClient.class);
        Client client = context.getBean(Client.class);

        AddMovieResponse addMovieResponse = client.addMovie("Interstellar", "Science fiction");
        System.out.println(addMovieResponse.getServiceStatus().getMessage());

        UpdateMovieResponse updateMovieResponse = client.updateMovieResponse("LA", "musical");
        System.out.println(updateMovieResponse.getServiceStatus().getMessage());

        DeleteMovieResponse deleteMovieResponse = client.deleteMovieResponse(101L);
        System.out.println(deleteMovieResponse.getServiceStatus().getStatusCode() + " "
                + deleteMovieResponse.getServiceStatus().getMessage());

        GetAllMoviesResponse allMoviesResponse = client.getAllMovies();

        System.out.println();
        for(MovieType movieType : allMoviesResponse.getMovieType()) {
            System.out.println("Movie id: " + movieType.getMovieId()
                            + ", Movie title: " + movieType.getTitle()
                            + ", Movie category: " + movieType.getCategory());
        }
    }
}
