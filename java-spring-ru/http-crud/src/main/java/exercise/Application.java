package exercise;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    public List<Post> getPosts(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit) {
        int start = (page * limit) - limit;
        return posts.stream()
                .skip(start)
                .limit(limit)
                .collect(Collectors.toList());
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
        posts.add(post);
        return post;
    }

    @PutMapping("/posts/{id}")
    public Post updatePost(@RequestBody Post data, @PathVariable String id) {
        Optional<Post> maybePage = posts.stream()
                .filter(post1 -> {
                    return post1.getId().equals(id);
                })
                .findFirst();

        if (maybePage.isPresent()) {
            var post = maybePage.get();
            post.setId(data.getId());
            post.setTitle(data.getTitle());
            post.setBody(data.getBody());
        }
        return data;
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> getPost(@PathVariable String id) {

        return posts.stream()
                .filter(post1 -> {
                    return post1.getId().equals(id);
                })
                .findFirst();
    }

    @DeleteMapping("/posts/{id}")
    public void deletePosts(@PathVariable String id) {
        posts.removeIf(post -> {
            return post.getId().equals(id);
        });
    }
    // END
}
