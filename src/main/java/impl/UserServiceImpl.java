package impl;

import model.User;
import service.UserService;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@WebService(endpointInterface = "service.UserService")
public class UserServiceImpl implements UserService {

    public static EntityManager entityManager;
    public static EntityManagerFactory entityManagerFactory;

   public User addUser(User user) {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return user;
   }

    public User deleteUser(User user) {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();

        User user1 = entityManager.find(User.class, user.getIdUser());
        entityManager.getTransaction().begin();
        entityManager.remove(user1);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return user1;
    }

    public User findUserByEmail(String email){
       entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
       entityManager = entityManagerFactory.createEntityManager();

       Query q = entityManager.createNamedQuery("user.findByEmail");
       q.setParameter("email",email);
       User user = (User) q.getSingleResult();

       entityManager.close();
       entityManagerFactory.close();
       return user;

    }

    public User update(User user){
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        User user1 = entityManager.find(User.class, user.getIdUser());
        entityManager.getTransaction().begin();
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setName(user.getName());
        user1.setAdmin(user.getAdmin());
        entityManager.getTransaction().commit();
        entityManager.close();
        return user1;

    }

    public User[] selectAll(){
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();

        List<User> userList = entityManager.createNamedQuery("user.showAll").getResultList();
        User[] users2 = new User[userList.size()];
        int i=0;
        for(User u:userList ){
            User aux = new User(u.getName(), u.getEmail(), u.getPassword(), u.getAdmin());
            aux.setIdUser(u.getIdUser());
            users2[i++] = aux;
        }
        entityManager.close();
        entityManagerFactory.close();
        return users2;
    }

    public String login(String email, String pass){
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        int a = 0;
        User user = null;
        try {
            user = findUserByEmail(email);
            if ((user.getEmail().compareTo(email) == 0) && (user.getPassword().compareTo(pass) == 0)) {
                a++;
            } else {
                a = 0;
            }
        }catch (Exception e){
            return "fail-fail";
        }

//        entityManager.close();
//        entityManagerFactory.close();

        if (a!=0)
        {
            return String.valueOf(user.getAdmin()) + "-" + String.valueOf(user.getIdUser());
        }

        return "fail-fail";

    }

    public User getById(int id){
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        User user1 = entityManager.find(User.class, id);
        entityManager.close();
        entityManagerFactory.close();
        return user1;
    }


}
