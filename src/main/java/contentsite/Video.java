package contentsite;

import java.util.List;

public class Video implements Content {

    private String title;
    private int length;
    private List<User> users;

    public Video(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public boolean isPremiumContent() {
        return length>15;
    }

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

    public int getLength() {
        return length;
    }






}
