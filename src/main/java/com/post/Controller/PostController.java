package com.post.Controller;

import com.post.Entity.Post;
import com.post.repository.CommentRepository;
import com.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping
    public String createPost(@RequestBody Post post){
      postRepository.save(post);
      return "Post created Successfully";
    }

    @DeleteMapping
    public String deletePost(){
        postRepository.deleteById(1L);
        return "Deleted Successfully";
    }
}
