package service;

import model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserService {

    @WebMethod
    public User addUser(User user);

    @WebMethod
    public User deleteUser(User user);

    @WebMethod
    public User findUserByEmail(String email);

    @WebMethod
    public User update(User user);

    @WebMethod
    public User[] selectAll();

    @WebMethod
    public String login(String email, String pass);

    @WebMethod
    public User getById(int id);
}
