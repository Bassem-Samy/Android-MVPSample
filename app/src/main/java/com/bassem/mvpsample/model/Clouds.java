package com.bassem.mvpsample.model;

/**
 * Created by staff on 2017.01.02.
 */

public class Clouds {
    private String all;

    public String getAll ()
    {
        return all;
    }

    public void setAll (String all)
    {
        this.all = all;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [all = "+all+"]";
    }
}
