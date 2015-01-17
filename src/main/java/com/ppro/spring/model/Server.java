package com.ppro.spring.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 4.1.15
 */
public enum Server {
    SEZNAM("Seznam.cz","http://search.seznam.cz/?q=","&count=10&from=", 0, 10, ".info a"),
    //    https://www.google.cz/search?q=auto.cz&start=10
    GOOGLE("Google.com","https://www.google.cz/search?q=", "&start=", 0, 10, ".srg .r a"),
    //http://search.centrum.cz/index.php?q=
    CENTRUM("Centrum.cz","http://search.centrum.cz/index.php?q=", "&from=", 0, 10, "h3 a");

    private String name;
    private String urlPart1;
    private String urlPart2;
    private int start;
    private int increment;
    private String elementSelection;

    Server(String name, String urlPart1, String urlPart2, int start, int increment, String elementSelection) {
        this.name = name;
        this.urlPart1 = urlPart1;
        this.urlPart2 = urlPart2;
        this.start = start;
        this.increment = increment;
        this.elementSelection = elementSelection;
    }

    public int getStart() {
        return start;
    }

    public int getIncrement() {
        return increment;
    }

    public String getElementSelection() {
        return elementSelection;
    }

    public String getName() {
        return name;
    }

    public String getUrl(String subject) {
        return this.urlPart1+subject+this.urlPart2;
    }

    public static Map<String, String> getAll() {
        Map<String, String> result = new HashMap<String, String>(values().length);
        for (Server server : values()) {
            result.put(server.name(), server.getName());
        }
        return result;
    }

    public static Server getServerByName(String name) {
        for (Server server : values()) {
            if (server.getName().equals(name)) {
                return server;
            }
        }
        return null;
    }
}
