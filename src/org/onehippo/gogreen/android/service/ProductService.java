package org.onehippo.gogreen.android.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.onehippo.gogreen.android.data.Product;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Service for fetching product information.
 * @author Jeroen Reijn
 */
public class ProductService {

    private static final String RESTAPI_BASE_URI = "http://www.demo.onehippo.com/restapi";
    private static final String RESTAPI_RESPONSE_TYPE = "?_type=json";

    /**
     * Get all products.
     *
     * @return a list of {@link org.onehippo.gogreen.android.data.Product} items
     */
    public static ArrayList<Product> getAllProductsFromHippo() {
        RestTemplate restTemplate = getRestTemplate();

        ArrayList<Product> products = new ArrayList<Product>();
        String url = RESTAPI_BASE_URI + "/topproducts./" + RESTAPI_RESPONSE_TYPE;

        Product[] productsFromHippo = restTemplate.getForObject(url, Product[].class);
        products.addAll(Arrays.asList(productsFromHippo));

        return products;
    }

    /**
     * Get the product by its URL
     * @param url the URL of the product
     * @return the {@link Product}
     */
    public static Product getProductByURL(String url) {
        RestTemplate restTemplate = getRestTemplate();
        return restTemplate.getForObject(url+RESTAPI_RESPONSE_TYPE,Product.class);
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
