package homeworks.HW.libriary;

/**
 * Created by nazar123 on 26.11.2017.
 */
public class User {
//     * 2)  В классе Юзер добавить полей(пароль, роль(энам), логин)

    private String password;
    private String login;
    //нужно ли ето поле здесь?
    private Role role;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String password, String login, Role role) {
        this(password, login);
        this.role = role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!password.equals(user.password)) return false;
        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        int result = password.hashCode();
        result = 31 * result + login.hashCode();
        return result;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
