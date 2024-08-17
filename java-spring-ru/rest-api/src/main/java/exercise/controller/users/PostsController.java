package exercise.controller.users;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
public class PostsController {
    private final List<Post> posts = Data.getPosts();

    @GetMapping("/api/users/{id}/posts")
    public ResponseEntity<List<Post>> getPosts(@PathVariable int id) {
        List<Post> foundPosts = posts.stream().filter(post -> post.getUserId() == id).toList();
        return ResponseEntity.ok(foundPosts);
    }

    @PostMapping("/api/users/{id}/posts")
    public ResponseEntity<Post> postPosts(@PathVariable int id, @RequestBody Post post) {
        post.setUserId(id);
        posts.add(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
}
// END
