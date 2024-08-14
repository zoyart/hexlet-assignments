package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Objects;

import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            String pageHeader = "Пользователи";
            UsersPage usersDTO = new UsersPage(USERS, pageHeader);
            ctx.render("users/show.jte", model("users", usersDTO));
        });

        app.get("/users/{id}", ctx -> {
            Long userId = ctx.pathParamAsClass("id", Long.class).get();

            String pageHeader = "Пользователь";
            User findUser = USERS.stream()
                    .filter(user -> user.getId() == userId)
                    .findFirst()
                    .orElseThrow(() -> new NotFoundResponse("User not found"));

            UserPage userDTO = new UserPage(findUser, pageHeader);

            ctx.render("users/index.jte", model("user", userDTO));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
