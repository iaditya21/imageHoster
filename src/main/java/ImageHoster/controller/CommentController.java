package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.model.UserProfile;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import ImageHoster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private ImageService imageService;


    //This controller method is called when the request pattern is of type 'users/registration'
    //This method declares User type and UserProfile type object
    //Sets the user profile with UserProfile type object
    //Adds User type object to a model and returns 'users/registration.html' file
    @RequestMapping(value = "/image/{id}/{title}/comments",method = RequestMethod.POST)
    public String newComment(Model model, @PathVariable String title, @PathVariable Integer id, HttpSession session, Comment comment) {
        User user = (User) session.getAttribute("loggeduser");
        Image image=imageService.getImage(id);
        comment.setUser(user);
        comment.setImage(image);
        comment.setCreatedDate(new Date());
        commentService.postNewComment(comment);
        return "redirect:/images/" + id+"/"+image.getTitle();
    }


}
