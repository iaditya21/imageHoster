package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import ImageHoster.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    //The method calls the getAllComment() method in the Repository and passes the Image id of the image for which comments are to be fetched.
    public List<Comment> getAllComments(int imageID){
        return commentRepository.getAllComment(imageID);
    }
    //The method calls the postComment() method in the Repository and creates a new entry for comment in database.
    public Comment postNewComment(Comment comment){
        return commentRepository.postComment(comment);
    }

}
