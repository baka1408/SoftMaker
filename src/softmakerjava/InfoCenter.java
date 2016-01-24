package softmakerjava;

public class InfoCenter {
    User currentUser = new User();

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
