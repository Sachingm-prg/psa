package com.post.Controller;

import com.post.Entity.Comment;
import com.post.Entity.Post;
import com.post.repository.CommentRepository;
import com.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping
    public String createComment(@RequestBody Comment comment, @RequestParam Long postid){
        Post post = postRepository.findById(postid).get();
        comment.setPost(post);
        commentRepository.save(comment);
        return "Commented Successfully";
    }

}
