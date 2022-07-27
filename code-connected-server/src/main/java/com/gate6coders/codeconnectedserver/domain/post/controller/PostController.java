package com.gate6coders.codeconnectedserver.domain.post.controller;

import com.gate6coders.codeconnectedserver.domain.core.exceptions.ProfileNotFoundException;
import com.gate6coders.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.gate6coders.codeconnectedserver.domain.post.model.Post;
import com.gate6coders.codeconnectedserver.domain.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/posts")
@RestController
public class PostController {
    private PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

//    @GetMapping
//    public ResponseEntity<List<Post>> getAllPosts(){
//        List<Post> posts = PostService.getAllPosts();
//        return new ResponseEntity<>(posts, HttpStatus.OK);
//    }
    @GetMapping("{id}")
    public ResponseEntity<Post> getById(@PathVariable("id")Long id) throws ResourceNotFoundException {
        Post post = postService.getById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<List<Post>> getFollowers(){
//        List<Post> posts = PostService.getFollowers();
//        return new ResponseEntity<>(posts, HttpStatus.OK);
//    }



//    @GetMapping
//    public ResponseEntity<List<Post>> getLikes(){
//        List<Post> likes = PostService.getLikes();
//        return new ResponseEntity<>(likes, HttpStatus.OK);
//    }



//    @GetMapping("{id}")
//    public ResponseEntity<List<Post>> getPostContent(){
//        List<Post> postContent = PostService.getPostContent();
//        return new ResponseEntity<>(postContent, HttpStatus.OK);
//    }



    @PostMapping
    public ResponseEntity<Post> create(@RequestBody Post post){
        post = postService.create(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }



    @PutMapping("{id}")
    public ResponseEntity<Post> update(@PathVariable("id")Long id, @RequestBody Post postDetail){
        postDetail = postService.updateContent(id, postDetail);
        return new ResponseEntity<>(postDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        postService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}