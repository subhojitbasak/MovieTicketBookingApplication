package com.github.subhojitbasak.MovieTicketBookingApplication.Service;

import com.github.subhojitbasak.MovieTicketBookingApplication.cache.LFUCache;
import com.github.subhojitbasak.MovieTicketBookingApplication.cache.LRUCache;
import com.github.subhojitbasak.MovieTicketBookingApplication.cache.MRUCache;
import org.springframework.stereotype.Service;

@Service
public class MovieTicketBookingService {
    private final LRUCache<String, String> userSessionCache;
    private final MRUCache<String, String> movieTrailerCache;
    private final LFUCache<String, String> movieShowtimeCache;

    public MovieTicketBookingService(LRUCache<String, String> userSessionCache,
                                     MRUCache<String, String> movieTrailerCache,
                                     LFUCache<String, String> movieShowtimeCache) {
        this.userSessionCache = userSessionCache;
        this.movieTrailerCache = movieTrailerCache;
        this.movieShowtimeCache = movieShowtimeCache;
    }

    // User Sessions (LRU)
    public String getUserSession(String userId) {
        return userSessionCache.get(userId);
    }

    public void putUserSession(String userId, String session) {
        userSessionCache.put(userId, session);
    }

    // Movie Trailers (MRU)
    public String getMovieTrailer(String movieId) {
        return movieTrailerCache.get(movieId);
    }

    public void putMovieTrailer(String movieId, String trailer) {
        movieTrailerCache.put(movieId, trailer);
    }

    // Movie Showtimes (LFU)
    public String getMovieShowtime(String showtimeId) {
        return movieShowtimeCache.get(showtimeId);
    }

    public void putMovieShowtime(String showtimeId, String showtime) {
        movieShowtimeCache.put(showtimeId, showtime);
    }
}
