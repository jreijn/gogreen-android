package org.onehippo.gogreen.android;

import java.util.Date;

/**
 * Simple representation of an event.
 * @author Jeroen Reijn
 */
public class Event {

    private String title;
    private Date date;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

}
