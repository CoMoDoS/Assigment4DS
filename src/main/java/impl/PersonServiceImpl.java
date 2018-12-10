package impl;

import model.Person;
import model.User;
import service.PersonService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//@HandlerChain(file = "/impl/handler.xml")
@WebService(endpointInterface = "service.PersonService")
public class PersonServiceImpl implements PersonService {

    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();



    public boolean addPerson(Person p) {
        if (persons.get(p.getId()) != null) return false;
        persons.put(p.getId(), p);
        return true;
    }

    public boolean deletePerson(int id) {
        if (persons.get(id) == null) return false;
        persons.remove(id);
        return true;
    }


    public Person getPerson(int id) {
        return persons.get(id);
    }


    public Person[] getAllPersons() {
        System.out.println("Asd");
        Set<Integer> ids = persons.keySet();
        Person[] p = new Person[ids.size()];
        int i = 0;
        for (Integer id : ids) {
            p[i] = persons.get(id);
            i++;
        }
        System.out.println("Asd");
        return p;
    }

}
