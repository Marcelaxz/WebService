package org.example;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.example.recursos.AlunoResource;

public class Servidor extends Application<Configuration> {
    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.jersey().register(new AlunoResource());
    }
}
