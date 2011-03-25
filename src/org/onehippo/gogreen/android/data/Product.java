package org.onehippo.gogreen.android.data;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Simple representation of a product.
 *
 * @author Jeroen Reijn
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {

    public static Product selected;
    @JsonProperty
    private String localizedName;

    @JsonProperty
    private String smallThumbnail;

    @JsonProperty
    private String price;

    @JsonProperty
    private String image;

    @JsonProperty
    private String productLink;

    @JsonProperty
    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(final String localizedName) {
        this.localizedName = localizedName;
    }

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public void setSmallThumbnail(final String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(final String price) {
        this.price = price;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(final String productLink) {
        this.productLink = productLink;
    }
}
