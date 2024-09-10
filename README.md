# Movie Ticket Booking Application


The Movie Ticket Booking Application allows users to book movie tickets, view trailers, and check showtimes. We have implemented custom caching mechanisms to optimize performance, using three different cache eviction policies:

- LRU (Least Recently Used): Caches user sessions and removes the session that hasn’t been used for the longest time.
- MRU (Most Recently Used): Caches movie trailers and removes the most recently used trailer when space is required.
- LFU (Least Frequently Used): Caches movie showtimes, removing the least frequently accessed showtime.
#### Manual Cache Implementation:

In this project, we manually implemented caching without using Spring's @Cacheable annotation. Instead, the cache policies are managed programmatically within the service layer, providing greater flexibility for customization and cache eviction strategies. This approach allows us to have finer control over how the cache behaves in different scenarios, depending on the cache eviction policy.
## Endpoints

### 1. Create new User Session (LRU):

- **Endpoint:** 'POST /user/session'
- **URL:** `http://localhost:8080/user/session`
- **Description:** Adds a user session to the LRU cache.
- **Endpoint:** 'GET /user/session'
- **Description:** Fetches a user session from the LRU cache.

### 2. Movie Trailer (MRU):

- **Endpoint**: 'POST /movie/trailer'
- **Description:** Adds a movie trailer to the MRU cache.
- **Endpoint:** 'GET /movie/trailer'
- **Description:** Fetches a movie trailer from the MRU cache.
### 3. Movie Showtime (LFU):

- **Endpoint:** POST /movie/showtime
- **Description:** Adds a movie showtime to the LFU cache.
- **Endpoint:** GET /movie/showtime
- **Description:** Fetches a movie showtime from the LFU cache.

## Note

Ensure your Spring Security project is running locally on port 8080 to use these endpoints.

Happy Testing!

## Tech Stack Used
- Java 8
- Spring Boot
- Spring MVC
- Mockito (for testing)
- JaCoCo (for test coverage)
- Maven
- Postman (for API testing)

## Authors

- [@subhojitbasak](https://https://github.com/subhojitbasak)


## Demo



Please check the github postman collection with attached images for testing the application.
