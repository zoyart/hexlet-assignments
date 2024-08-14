package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

import java.util.List;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        Javalin app = Javalin.create(config -> config.bundledPlugins.enableDevLogging());

        List<String> phones = Data.getPhones();
        List<String> domains = Data.getDomains();

        app.get("/phones", ctx -> ctx.json(phones));
        app.get("/domains", ctx -> ctx.json(domains));

        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
