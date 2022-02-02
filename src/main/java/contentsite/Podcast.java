package contentsite;

import java.util.List;

public class Podcast implements Content{

    private String title;
    private List<String> speakers;
    private List<User> users;

    @Override
    public boolean isPremiumContent() {
        return false;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<User> clickedBy() {
        return users;
    }

    @Override
    public void click(User user) {
    users.add(user);
    }




}
