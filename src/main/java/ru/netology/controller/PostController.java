package ru.netology.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.model.Post;
import ru.netology.model.PostDTO;
import ru.netology.service.PostService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<PostDTO> all() {
        return service.all();
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public PostDTO getById(@PathVariable long id) {
        return service.getById(id);
    }

    @PostMapping
    public PostDTO save(@RequestBody Post post) {
        return service.save(post);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeById(@PathVariable long id) {
        service.removeById(id);
    }
}
