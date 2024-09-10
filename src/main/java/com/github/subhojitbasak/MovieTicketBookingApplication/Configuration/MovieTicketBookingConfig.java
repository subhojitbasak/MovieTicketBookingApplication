package com.github.subhojitbasak.MovieTicketBookingApplication.Configuration;

import com.github.subhojitbasak.MovieTicketBookingApplication.cache.LFUCache;
import com.github.subhojitbasak.MovieTicketBookingApplication.cache.LRUCache;
import com.github.subhojitbasak.MovieTicketBookingApplication.cache.MRUCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieTicketBookingConfig {
    @Bean
    public LRUCache<String, String> userSessionCache() {
        return new LRUCache<>(5); // Capacity of 5 sessions
    }

    @Bean
    public MRUCache<String, String> movieTrailerCache() {
        return new MRUCache<>(5); // Capacity of 5 trailers
    }

    @Bean
    public LFUCache<String, String> movieShowtimeCache() {
        return new LFUCache<>(5); // Capacity of 5 showtimes
    }
}
