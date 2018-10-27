package com.bladejs.kinoList;

import info.talacha.filmweb.models.Film;
import info.talacha.filmweb.models.Vote;

class PersonalFilm implements Comparable<PersonalFilm>{
    private Film film;
    private Vote vote;

    private String title;
    private int userRating;
    private boolean gotUserRating;

    PersonalFilm(Vote vote, Film film){
        this.film=film;
        this.vote=vote;
        gotUserRating=false;
    }

    private Film getFilm(){
      return film;
    }

    private Vote getVote(){
        return vote;
    }

    String getTitle() throws NoTitleException {
        if(title==null)
            return title=ApiHandler.getFilmTitle(film);
        else
            return title;
    }

    int getUserRating(){
        if(!gotUserRating) {
            gotUserRating = true;
            return userRating = ApiHandler.getUserRating(vote);
        }
        else
            return userRating;
    }

    @Override
    public int compareTo(PersonalFilm pfilm){
        return -Integer.compare(vote.getRate(),pfilm.getVote().getRate());
    }

}
