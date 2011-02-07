package org.onehippo.gogreen.android;

import java.util.Calendar;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Simple representation of an event.
 * @author Jeroen Reijn
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

    @JsonProperty
    private String title;

    @JsonProperty
    private Calendar startDate;

    @JsonProperty
    private Calendar endDate;

    @JsonProperty
    private String localizedName;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(final Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(final Calendar endDate) {
        this.endDate = endDate;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(final String localizedName) {
        this.localizedName = localizedName;
    }
}
