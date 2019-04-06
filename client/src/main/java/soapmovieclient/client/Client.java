package soapmovieclient.client;

import movies.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class Client extends WebServiceGatewaySupport {

    public GetMovieByIdResponse getMovieById(Long id) {
        GetMovieByIdRequest request = new GetMovieByIdRequest();
        request.setMovieId(id);
        return (GetMovieByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    public GetAllMoviesResponse getAllMovies() {
        return (GetAllMoviesResponse) getWebServiceTemplate()
                .marshalSendAndReceive(new GetAllMoviesRequest());
    }

    public AddMovieResponse addMovie(String title, String category) {
        AddMovieRequest request = new AddMovieRequest();
        request.setTitle(title);
        request.setCategory(category);
        return (AddMovieResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    public UpdateMovieResponse updateMovieResponse(String title, String category) {
        UpdateMovieRequest request = new UpdateMovieRequest();
        request.setTitle(title);
        request.setCategory(category);
        return (UpdateMovieResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

    public DeleteMovieResponse deleteMovieResponse(Long id) {
        DeleteMovieRequest request = new DeleteMovieRequest();
        request.setMovieId(id);
        return (DeleteMovieResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }

}
