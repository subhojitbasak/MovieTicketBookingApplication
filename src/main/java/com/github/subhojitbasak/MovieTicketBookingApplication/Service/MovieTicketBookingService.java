package com.github.subhojitbasak.MovieTicketBookingApplication.Service;

public interface MovieTicketBookingService {
    public String getUserSession(String userId);
    public void putUserSession(String userId, String session);
    public String getMovieTrailer(String movieId);
    public void putMovieTrailer(String movieId, String trailer);
    public String getMovieShowtime(String showtimeId);
    public void putMovieShowtime(String showtimeId, String showtime);
}
