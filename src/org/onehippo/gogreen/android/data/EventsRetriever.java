package org.onehippo.gogreen.android.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.onehippo.gogreen.android.Event;
import org.springframework.http.client.CommonsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jeroen Reijn
 */
public class EventsRetriever {

    private static final String BASE_URI_RESTAPI = "http://10.0.2.2:8085/site/restapi";

    public static ArrayList<Event> getAllEvents() {
        ArrayList<Event> events = new ArrayList<Event>();
        Calendar cal = Calendar.getInstance();
        Event e1 = new Event();
        e1.setStartDate(cal);
        e1.setTitle("Guelph Organic Conference");
        Event e2 = new Event();
        cal.add(Calendar.MONTH, -2);
        e2.setStartDate(cal);
        e2.setTitle("Ecobuild 2011");
        events.add(e1);
        events.add(e2);
        return events;
    }

    /**
     * Get the upcoming events.
     *
     * @return a list of {@link Event} items
     */
    public static ArrayList<Event> getUpcomingEvents() {
        RestTemplate restTemplate = getRestTemplate();
        ArrayList<Event> events = new ArrayList<Event>();
        String url = BASE_URI_RESTAPI + "/events./?_type=json";

        Event[] eventsFromHippo = restTemplate.getForObject(url, Event[].class);

        for (Event event : eventsFromHippo) {
            events.add(event);
        }

        return events;
    }

    /**
     * Get the past events.
     *
     * @return a list of {@link Event} items
     */
    public static ArrayList<Event> getPastEvents() {
        RestTemplate restTemplate = getRestTemplate();
        ArrayList<Event> events = new ArrayList<Event>();
        String url = BASE_URI_RESTAPI + "/events./?_type=json";

        Event[] eventsFromHippo = restTemplate.getForObject(url, Event[].class);

        for (Event event : eventsFromHippo) {
            events.add(event);
        }

        return events;
    }


    /**
     * Get all events.
     *
     * @return a list of {@link Event} items
     */
    public static ArrayList<Event> getAllEventsFromHippo() {
        RestTemplate restTemplate = getRestTemplate();

        ArrayList<Event> events = new ArrayList<Event>();
        String url = BASE_URI_RESTAPI + "/events./?_type=json";

        Event[] eventsFromHippo = restTemplate.getForObject(url, Event[].class);

        for (Event event : eventsFromHippo) {
            events.add(event);
        }

        return events;
    }

    /**
     * Gets a new {@link RestTemplate}
     *
     * @return the {@link RestTemplate}
     */
    private static RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new CommonsClientHttpRequestFactory());
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        if (!messageConverters.contains(MappingJacksonHttpMessageConverter.class)) {
            messageConverters.add(new MappingJacksonHttpMessageConverter());
        }
        return restTemplate;
    }
}
