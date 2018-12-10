import impl.PersonServiceImpl;
import impl.UserServiceImpl;
import model.User;

public class Start {
    public static void main(String[] args) {
        User user = new User("jon", "i@i.i", "i", "y");
        UserServiceImpl userService = new UserServiceImpl();
//        userService.addUser(user);
        System.out.println(userService.findUserByEmail("i@i.i"));


    }
}
