package net.rest.ws.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import java.util.*;

@ApplicationPath("/rest")
public class ApplicationConfig extends Application {
    private Set<Object> singletons = new HashSet<Object>();

    public ApplicationConfig() {
        singletons.add(new SampleService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
