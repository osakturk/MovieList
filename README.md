### Goal

The goal of this assignment is to implement a sample project, where you list movie search results and show movie details using `TheMovieDb` API. You can use this API key: `35ef0461fc4557cf1d256d3335ed7545`.

### Challenge

[![Challenge](https://i.hizliresim.com/2OD6kO.png)](https://hizliresim.com/2OD6kO)

#### Search Movies Page

- You will use `/search/movie/` endpoint: https://developers.themoviedb.org/3/search/search-movies.
- Users can be able to search for movies by typing a movie name. As long as users write more than 2 characters, it will fetched results from the `/search/movie` endpoint. You will not wait for users to press the search button.
- This page can include infinite scrolling. When users scroll to the end of the current page, the next page will be fetched from the service, if present.
- Users can be able to see movie details by clicking any of the results.

#### Movie Details Page

- You will use `/movie/{movie_id}` endpoint: https://developers.themoviedb.org/3/movies/get-movie-details.
- Users can see the movie title, average note, and poster image as soon as this page opened.
- Users can see movie overview, genres and backdrop image after it's fetched from the endpoint.
- Users can be able to navigate back to the search movies page, **without losing any state (search query, list scroll position, results, etc.)**.

#### Notes

- If any of the image sources (poster or backdrop) is null, then you can use a placeholder or you can leave it empty.

### Requirements

- Production-ready code, was written in Kotlin.
- I used 3rd party libraries (just make it clear why you need that specific library.)
- UI is matter but If you follow some Material Design principles, that would be fine but not necessarily.
- Make sure to check your code for bugs and edge-cases.
- Unit tests
- Min API >= 21

The project should be submitted to GitHub in **one week**. If you have any questions, don't hesitate to contact me.

_Please do **NOT** publish your solution on a publicly available location._
