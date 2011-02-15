package org.onehippo.gogreen.android.service;

import java.util.ArrayList;
import java.util.List;

import org.onehippo.gogreen.android.data.Product;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jeroen Reijn
 */
public class ProductService {

    private static final String RESTAPI_BASE_URI = "http://www.demo.onehippo.com/restapi";
    private static final String RESTAPI_RESPONSE_TYPE = "_type=json";

    /**
     * Get all events.
     *
     * @return a list of {@link org.onehippo.gogreen.android.data.Event} items
     */
    public static ArrayList<Product> getAllProductsFromHippo() {
        RestTemplate restTemplate = getRestTemplate();

        ArrayList<Product> products = new ArrayList<Product>();
        String url = RESTAPI_BASE_URI + "/topproducts./?" + RESTAPI_RESPONSE_TYPE;

        Product[] productsFromHippo = restTemplate.getForObject(url, Product[].class);

        for (Product product : productsFromHippo) {
            products.add(product);
        }

        return products;
    }

    /**
     * Gets a new {@link org.springframework.web.client.RestTemplate}
     *
     * @return the {@link org.springframework.web.client.RestTemplate}
     */
    private static RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        //See if we already have the Jackson converter defined.
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        if (!messageConverters.contains(MappingJacksonHttpMessageConverter.class)) {
            messageConverters.add(new MappingJacksonHttpMessageConverter());
        }
        return restTemplate;
    }
}
