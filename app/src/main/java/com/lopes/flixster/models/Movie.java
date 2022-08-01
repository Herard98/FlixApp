/*
 *
 *  created by coding xp on 7/28/2022 3:32 PM
 *  copyright (c) 2022 all right reserved.
 *  last modified 7/28/22 3:32 PM
 * /
 *
 *
 */

package com.lopes.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel

public class Movie {
    int movieId;
    String posterPath;
    String title;
    String overview;
    String backdropPath;
    double rating;

    public Movie(){}



    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath=jsonObject.getString("backdrop_path");
        posterPath=jsonObject.getString("poster_path");
        title=jsonObject.getString("title");
        overview=jsonObject.getString("overview");
        rating=jsonObject.getDouble("vote_average");
        movieId= Integer.parseInt(jsonObject.getString("id"));

    }
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
            List<Movie> movie=new ArrayList<>();
            for (int i=0; i<movieJsonArray.length(); i++){
                movie.add(new Movie(movieJsonArray.getJSONObject(i)));
            }
            return movie;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w500/%s", backdropPath);
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w500/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }
}
