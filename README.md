## Yemeksepeti Android Challenge

Please read the following instructions carefully and make sure that you fulfill
all requirements listed.

### Overview

This **private** repository is created automatically. Only you and developers at **Yemeksepeti**
can see the code you push to this repository.

**Instructions**:

1. Read and follow the specified challenge below.
2. Make a local clone of this repository on your machine, and do your work on a branch other than `master`. Do not make any changes to the `master` branch.
3. Push your changes as frequently as you like to `origin/your-branch-name`, and create a pull request to merge your changes back into the `master` branch. Don't merge your pull request.
4. Once you're finished with the assignment, we will do a code review of your pull request. Let's know when the project is ready for review.

### Goal

The goal of this assignment is to implement a sample project, where you list movie search results and show movie details using `TheMovieDb` API. You can use this API key: `35ef0461fc4557cf1d256d3335ed7545`.

### Challenge

[![Challenge](https://i.hizliresim.com/2OD6kO.png)](https://hizliresim.com/2OD6kO)

#### Search Movies Page

- You will use `/search/movie/` endpoint: https://developers.themoviedb.org/3/search/search-movies.
- Users should be able to search for movies by typing a movie name. As long as users write more than 2 characters, you should fetch results from the `/search/movie` endpoint. You should not wait for users to press the search button.
- This page should include infinite scrolling. When users scroll to the end of the current page, the next page should be fetched from the service, if present.
- Users should be able to see movie details by clicking any of the results.

#### Movie Details Page

- You will use `/movie/{movie_id}` endpoint: https://developers.themoviedb.org/3/movies/get-movie-details.
- Users should see the movie title, average note, and poster image as soon as this page opened.
- Users should see movie overview, genres and backdrop image after it's fetched from the endpoint.
- Users should be able to navigate back to the search movies page, **without losing any state (search query, list scroll position, results, etc.)**.

#### Notes

- If any of the image sources (poster or backdrop) is null, then you can use a placeholder or you can leave it empty.

### Requirements

- Production-ready code, written in Kotlin.
- You can use any 3rd party libraries, just make it clear why you need that specific library.
- UI does not matter. If you follow some Material Design principles, that would be fine but not necessarily.
- Make sure to check your code for bugs and edge-cases.
- Unit tests
- Min API >= 21

The project should be submitted to GitHub in **one week**. If you have any questions, don't hesitate to contact us.

_Please do **NOT** publish your solution on a publicly available location._
