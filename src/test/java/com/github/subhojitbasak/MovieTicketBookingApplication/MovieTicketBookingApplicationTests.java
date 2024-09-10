package com.github.subhojitbasak.MovieTicketBookingApplication;

import com.github.subhojitbasak.MovieTicketBookingApplication.Controller.CacheController;
import com.github.subhojitbasak.MovieTicketBookingApplication.Service.MovieTicketBookingServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CacheController.class)
class MovieTicketBookingApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MovieTicketBookingServiceImpl bookMyShowService;



	// Test case for LRU (User Session) - Add user session
	@Test
	public void testAddUserSession() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/user/session")
						.param("userId", "123")
						.param("session", "sessionData123"))
				.andExpect(status().isOk())
				.andExpect(content().string("User session added for user: 123"));

		verify(bookMyShowService, times(1)).putUserSession("123", "sessionData123");
	}

	// Test case for LRU (User Session) - Get user session
	@Test
	public void testGetUserSession() throws Exception {
		when(bookMyShowService.getUserSession("123")).thenReturn("sessionData123");

		mockMvc.perform(MockMvcRequestBuilders.get("/user/session")
						.param("userId", "123"))
				.andExpect(status().isOk())
				.andExpect(content().string("Session for user 123: sessionData123"));

		verify(bookMyShowService, times(1)).getUserSession("123");
	}

	// Test case for LRU (User Session) - Session not found
	@Test
	public void testGetUserSessionNotFound() throws Exception {
		when(bookMyShowService.getUserSession("123")).thenReturn(null);

		mockMvc.perform(MockMvcRequestBuilders.get("/user/session")
						.param("userId", "123"))
				.andExpect(status().isOk())
				.andExpect(content().string("Session not found for user: 123"));

		verify(bookMyShowService, times(1)).getUserSession("123");
	}

	// Test case for MRU (Movie Trailer) - Add movie trailer
	@Test
	public void testAddMovieTrailer() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/movie/trailer")
						.param("movieId", "789")
						.param("trailer", "trailerData"))
				.andExpect(status().isOk())
				.andExpect(content().string("Trailer added for movie: 789"));

		verify(bookMyShowService, times(1)).putMovieTrailer("789", "trailerData");
	}

	// Test case for MRU (Movie Trailer) - Get movie trailer
	@Test
	public void testGetMovieTrailer() throws Exception {
		when(bookMyShowService.getMovieTrailer("789")).thenReturn("trailerData");

		mockMvc.perform(MockMvcRequestBuilders.get("/movie/trailer")
						.param("movieId", "789"))
				.andExpect(status().isOk())
				.andExpect(content().string("Trailer for movie 789: trailerData"));

		verify(bookMyShowService, times(1)).getMovieTrailer("789");
	}

	// Test case for MRU (Movie Trailer) - Trailer not found
	@Test
	public void testGetMovieTrailerNotFound() throws Exception {
		when(bookMyShowService.getMovieTrailer("789")).thenReturn(null);

		mockMvc.perform(MockMvcRequestBuilders.get("/movie/trailer")
						.param("movieId", "789"))
				.andExpect(status().isOk())
				.andExpect(content().string("Trailer not found for movie: 789"));

		verify(bookMyShowService, times(1)).getMovieTrailer("789");
	}

	// Test case for LFU (Movie Showtime) - Add movie showtime
	@Test
	public void testAddMovieShowtime() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/movie/showtime")
						.param("showtimeId", "456")
						.param("showtime", "2PM"))
				.andExpect(status().isOk())
				.andExpect(content().string("Showtime added for showtime ID: 456"));

		verify(bookMyShowService, times(1)).putMovieShowtime("456", "2PM");
	}

	// Test case for LFU (Movie Showtime) - Get movie showtime
	@Test
	public void testGetMovieShowtime() throws Exception {
		when(bookMyShowService.getMovieShowtime("456")).thenReturn("2PM");

		mockMvc.perform(MockMvcRequestBuilders.get("/movie/showtime")
						.param("showtimeId", "456"))
				.andExpect(status().isOk())
				.andExpect(content().string("Showtime for showtime ID 456: 2PM"));

		verify(bookMyShowService, times(1)).getMovieShowtime("456");
	}

	// Test case for LFU (Movie Showtime) - Showtime not found
	@Test
	public void testGetMovieShowtimeNotFound() throws Exception {
		when(bookMyShowService.getMovieShowtime("456")).thenReturn(null);

		mockMvc.perform(MockMvcRequestBuilders.get("/movie/showtime")
						.param("showtimeId", "456"))
				.andExpect(status().isOk())
				.andExpect(content().string("Showtime not found for showtime ID: 456"));

		verify(bookMyShowService, times(1)).getMovieShowtime("456");
	}

}
