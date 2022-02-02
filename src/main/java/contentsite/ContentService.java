package contentsite;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ContentService {



    private Set<Content> allContent = new HashSet<>();

    private Set<User> allUsers = new HashSet<>();


    public Set<Content> getAllContent() {
        return allContent;
    }

    public Set<User> getAllUsers() {
        return allUsers;
    }

    public void registerUser(String name, String password){
        if (allUsers.stream().anyMatch(u->u.getUserName().equals(name)))
            throw new IllegalArgumentException("Username is already taken: " + name);
        allUsers.add(new User(name, password));
    }

    public void addContent(Content content){
        if (allContent.stream().anyMatch(u->u.getTitle().equals(content.getTitle())))
            throw new IllegalArgumentException("Content name is already taken: " + content.getTitle());
        allContent.add(content);
    }

    public void logIn(String username, String password){
        if (!allUsers.stream().anyMatch(u->u.getUserName().equals(username)))
            throw new IllegalArgumentException("Username is wrong!" );
        User user=allUsers.stream().filter(u->u.getUserName().equals(username)).findFirst().get();
        int passHash=(username + password).hashCode();
        if(passHash!=user.getPassword())
            throw new IllegalArgumentException("Password is Invalid!" );
        user.setLogIn(true);
    }

}
