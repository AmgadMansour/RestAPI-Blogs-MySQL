package me.amgad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
public class BlogController {

    @Autowired
    BlogRepository blogRepository; // inject the blog database instance

    //Handle the get request for the end point <url>/blog to retreive all the availbale blogs in the DB
    @GetMapping("/blog")
    public List<Blog> index(){
        return blogRepository.findAll();
    }

    //retrieve a certian blog with path variales passed in the request url
    @GetMapping("/blog/{id}")
    public Blog getBlog(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogRepository.findOne(blogId);
    }

    // post request to add a blog, this request contains the request body payload,
    // this payload contains the blog data that the user will enter in JSON format
    @PostMapping("/blog")
    public Blog createBlog(@RequestBody Map<String,String> body){
        String title = body.get("title");
        String content = body.get("content");
        return blogRepository.save(new Blog(title, content));
    }

    // update a blog post with a given id
    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String,String> body){
        int blogId = Integer.parseInt(id);
        Blog blog = blogRepository.findOne(blogId);
        blog.setTitle(body.get("title"));
        blog.setContent(body.get("content"));
        return blogRepository.save(blog);
    }

    // delete a blog with the given id
    @DeleteMapping("/blog/{id}")
    public boolean delete(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        blogRepository.delete(blogId);
        return true;
    }


}



