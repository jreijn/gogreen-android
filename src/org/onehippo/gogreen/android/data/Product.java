package org.onehippo.gogreen.android.data;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Simple representation of a product.
 * @author Jeroen Reijn
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @JsonProperty
    private String title;

    @JsonProperty
    private String localizedName;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(final String localizedName) {
        this.localizedName = localizedName;
    }
}
