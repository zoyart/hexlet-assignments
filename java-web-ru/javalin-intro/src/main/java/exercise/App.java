package exercise;

// BEGIN
import io.javalin.Javalin;
// END

public final class App {

    public static Javalin getApp() {
        // BEGIN
        return Javalin.create();
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();

        app.get("/welcome", context -> context.result("Welcome to Hexlet!"));

        app.start(7070);
    }
}
