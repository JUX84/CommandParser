/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.math.BigDecimal;
import javax.json.Json;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.regex.*;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author JUX
 */
@Path("api")
public class ApiResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ApiResource
     */
    public ApiResource() {
    }

    /**
     * Retrieves representation of an instance of api.ApiResource
     * @param str
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson(@QueryParam("str") String str) {
        try {
            Pattern listenPattern = Pattern.compile("^listen to?(( (.+)))");
            Pattern fromPattern = Pattern.compile(" by(.+)?$");
            Matcher listenMatcher = listenPattern.matcher(str);
            listenMatcher.find();
            String str2 = listenMatcher.group(0);
            Matcher fromMatcher = fromPattern.matcher(str2);
            fromMatcher.find();
            String str3 = fromMatcher.group(0);
            str2 = str2.replace("listen to ", "").replace(str3, "");
            str3 = str3.substring(4);
            String command;
            String artist;
            String title;
            command = "listen";
            artist = str3;
            title = str2;
            return Json.createObjectBuilder()
                    .add("command", command)
                    .add("song", Json.createObjectBuilder().add("artist", artist).add("title",title).build())
                    .build()
                    .toString();
        } catch (Exception e) {
            try {
                Pattern listenPattern = Pattern.compile("^add?(( (.+)))");
                Pattern fromPattern = Pattern.compile(" by(.+)?$");
                Matcher listenMatcher = listenPattern.matcher(str);
                listenMatcher.find();
                String str2 = listenMatcher.group(0);
                Matcher fromMatcher = fromPattern.matcher(str2);
                fromMatcher.find();
                String str3 = fromMatcher.group(0);
                str2 = str2.replace("add ", "").replace(str3, "");
                str3 = str3.substring(4);
                String command;
                String artist;
                String title;
                command = "add";
                artist = str3;
                title = str2;
                return Json.createObjectBuilder()
                        .add("command", command)
                        .add("song", Json.createObjectBuilder().add("artist", artist).add("title",title).build())
                        .build()
                        .toString();
            } catch (Exception e1) {
                try {
                    Pattern listenPattern = Pattern.compile("^remove?(( (.+)))");
                    Pattern fromPattern = Pattern.compile(" by(.+)?$");
                    Matcher listenMatcher = listenPattern.matcher(str);
                    listenMatcher.find();
                    String str2 = listenMatcher.group(0);
                    Matcher fromMatcher = fromPattern.matcher(str2);
                    fromMatcher.find();
                    String str3 = fromMatcher.group(0);
                    str2 = str2.replace("remove ", "").replace(str3, "");
                    str3 = str3.substring(4);
                    String command;
                    String artist;
                    String title;
                    command = "remove";
                    artist = str3;
                    title = str2;
                    return Json.createObjectBuilder()
                            .add("command", command)
                            .add("song", Json.createObjectBuilder().add("artist", artist).add("title",title).build())
                            .build()
                            .toString();
                } catch (Exception e2) {
                    return Json.createObjectBuilder()
                            .add("error", "no match found")
                            .build()
                            .toString();
                }
            }
        }
    }

    /**
     * PUT method for updating or creating an instance of ApiResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
