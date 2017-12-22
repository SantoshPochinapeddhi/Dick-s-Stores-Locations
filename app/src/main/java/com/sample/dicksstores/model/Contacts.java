package com.sample.dicksstores.model;

public class Contacts
{
    private String twitter;

    private String phone;

    private String facebookName;

    private String facebook;

    public String getTwitter ()
    {
        return twitter;
    }

    public void setTwitter (String twitter)
    {
        this.twitter = twitter;
    }

    public String getPhone ()
    {
        return phone;
    }

    public void setPhone (String phone)
    {
        this.phone = phone;
    }

    public String getFacebookName ()
    {
        return facebookName;
    }

    public void setFacebookName (String facebookName)
    {
        this.facebookName = facebookName;
    }

    public String getFacebook ()
    {
        return facebook;
    }

    public void setFacebook (String facebook)
    {
        this.facebook = facebook;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [twitter = "+twitter+", phone = "+phone+", facebookName = "+facebookName+", facebook = "+facebook+"]";
    }
}