package com.github.subhojitbasak.MovieTicketBookingApplication.Controller;

import com.github.subhojitbasak.MovieTicketBookingApplication.Service.MovieTicketBookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/vi/cache")
public class CacheController {
    @Autowired
    private MovieTicketBookingServiceImpl service;

    public CacheController(MovieTicketBookingServiceImpl service) {
        this.service = service;
    }

    // LRU Cache for User Sessions
    @PostMapping("/user/session")
    public String addUserSession(@RequestParam String userId, @RequestParam String session) {
        service.putUserSession(userId, session);
        return "User session added for user: " + userId;
    }

    @GetMapping("/user/session")
    public String getUserSession(@RequestParam String userId) {
        String session = service.getUserSession(userId);
        if (session != null) {
            return "Session for user " + userId + ": " + session;
        } else {
            return "Session not found for user: " + userId;
        }
    }

    // MRU Cache for Movie Trailers
    @PostMapping("/movie/trailer")
    public String addMovieTrailer(@RequestParam String movieId, @RequestParam String trailer) {
        service.putMovieTrailer(movieId, trailer);
        return "Trailer added for movie: " + movieId;
    }

    @GetMapping("/movie/trailer")
    public String getMovieTrailer(@RequestParam String movieId) {
        String trailer = service.getMovieTrailer(movieId);
        if (trailer != null) {
            return "Trailer for movie " + movieId + ": " + trailer;
        } else {
            return "Trailer not found for movie: " + movieId;
        }
    }

    // LFU Cache for Movie Showtimes
    @PostMapping("/movie/showtime")
    public String addMovieShowtime(@RequestParam String showtimeId, @RequestParam String showtime) {
        service.putMovieShowtime(showtimeId, showtime);
        return "Showtime added for showtime ID: " + showtimeId;
    }

    @GetMapping("/movie/showtime")
    public String getMovieShowtime(@RequestParam String showtimeId) {
        String showtime = service.getMovieShowtime(showtimeId);
        if (showtime != null) {
            return "Showtime for showtime ID " + showtimeId + ": " + showtime;
        } else {
            return "Showtime not found for showtime ID: " + showtimeId;
        }
    }
}
