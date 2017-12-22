package com.sample.dicksstores.model;

/**
 * Created by santosh on 12/22/17.
 */

public class Response {

    private Venues[] venues;

    public Venues[] getVenues ()
    {
        return venues;
    }

    public void setVenues (Venues[] venues)
    {
        this.venues = venues;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [venues = "+venues+"]";
    }
}
