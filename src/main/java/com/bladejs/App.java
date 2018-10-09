package com.bladejs;

import info.talacha.filmweb.connection.FilmwebException;

public class App
{
    public static void main( String[] args )
    {
        ApiHandler handler = new ApiHandler();
        try {
            handler.login(args[0],args[1]);
            handler.getMovies();
        } catch (FilmwebException e) {
            e.printStackTrace();
        }

    }
}
