package com.example.remoteapis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/remote")
public class RemoteApiController {

    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/get")
    public Object getMoviesDetails(){

        String url = "https://api.themoviedb.org/3/movie/157336?api_key=99dbb307a83ec8dff8143bcc68bdb756";
        Object responseObject = restTemplate.getForObject(url, Object.class);
        return responseObject;
    }

    @GetMapping("/get_custom_detials")
    public MovieResponse getCustomMovieDetails(){

        String url = "https://api.themoviedb.org/3/movie/157336?api_key=99dbb307a83ec8dff8143bcc68bdb756";
        MovieResponse responseObject = restTemplate.getForObject(url, MovieResponse.class);
        return responseObject;
    }

    @GetMapping("/get_madrid")
    public String getFootballDetails(){

        String url = "http://localhost:9999/football/madrid";
        String responseObject = restTemplate.getForObject(url, String.class);
        return responseObject;
    }
}
