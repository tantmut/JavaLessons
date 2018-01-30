package homeworks.HW.libriary;

import java.time.LocalTime;
import java.util.*;


/*
 * 1) Создать класс Книга
 * 2)  В классе Юзер добавить полей(пароль, роль(энам), логин)
 * 3) Вся логика библиотеки должна сосредоточена в одном классе
 * 4) Не использовать deprecated  классы и методы/ LocalTime
 * 5) Удалить лишние коллекции
 * 6) Продумать механизм взятие книги
 */

public class LibriaryService {
    Scanner reader = new Scanner(System.in);
    private final int attempsToEnterLogAndPass = 3;
    private final int OPENING_HOUR = 8;
    private final int CLOSING_HOUR = 17;
    private Map<Genre, List<Book>> libriary = new HashMap<>();
    private List<User> userCredential = new ArrayList<>();

    private List<Book> comedy = new ArrayList<>();
    private List<Book> melodrama = new ArrayList<>();
    private List<Book> triller = new ArrayList<>();


    Book bCom1 = new Book(1, "Тарас Бульба", "Гоголь");
    Book bCom2 = new Book(2, "Станционный смотритель", "Пушкин");

    Book bMel1 = new Book(1, "Дикий помещик", "Салтыков-Щедрин");
    Book bMel2 = new Book(2, "Злоумышленник", "Бунин");

    User su1 = new User("user", "123", Role.USER);
    User au1 = new User("admin", "123", Role.ADMIN);

    public LibriaryService() {

        // add books to list
        comedy.add(bCom1);
        comedy.add(bCom2);
        melodrama.add(bMel1);
        melodrama.add(bMel2);

        // add genre and books to the libriary
        libriary.put(Genre.COMEDY, comedy);
        libriary.put(Genre.MELODRAMA, melodrama);
        libriary.put(Genre.TRILLER, triller);

        // add user credentials
        userCredential.add(su1);
        userCredential.add(au1);
    }

    private int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    // If libriary is open
    public boolean isLibriaryOpen() {

        LocalTime l = LocalTime.now();
        boolean flag = false;

        if (l.getHour() >= OPENING_HOUR && l.getHour() <= CLOSING_HOUR) {//move 8, 17 to constants
            flag = true;
        }
        return flag;
    }

    public void watchListOfBook() {
        libriary.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    //    @SuppressWarnings("unchecked")
    public void watchLictOfBookByGenre(Genre genre) {
        System.out.println(libriary.get(genre));
    }

    public void addBook(String genre, String author, String nameOfBook) {
        Genre genreUp = Genre.valueOf(genre.toUpperCase());
        try {
            libriary.get(genreUp).add(new Book(randomNumber(), author, nameOfBook));
        } catch (Throwable e) {
            System.out.println("java.lang.NullPointerException");
        }
    }

    public void deleteBookByAdmin(String genre, int id) {
        Genre genreUp = Genre.valueOf(genre.toUpperCase());
        List list = (ArrayList) libriary.get(genreUp); // почему я не могу использывать list.get(i).getId
        try {
            for (int i = 0; i < libriary.get(genreUp).size(); i++) {
                if (libriary.get(genreUp).get(i).getId() == id) {
                    libriary.get(genreUp).remove(i);
                }
            }
        } catch (Throwable e) {
            System.out.println("java.lang.NullPointerException");
        }

    }

    public void giveBookToUser(String genre, String nameOfBook) {

        Genre genreUp = Genre.valueOf(genre.toUpperCase());
        List list = (ArrayList) libriary.get(genreUp); // почему я не могу использывать list.get(i).getId
        try {
            for (int i = 0; i < libriary.get(genreUp).size(); i++) {
                if (nameOfBook.contains(libriary.get(genreUp).get(i).getNameOfBook())) {
                    libriary.get(genreUp).remove(i);
                }
            }
        } catch (Throwable e) {
            System.out.println("java.lang.NullPointerException");
        }
    }

    public boolean checkEnterCredentials(String login, String userPassword, Role role) {
        boolean flag = false;
        for (int i = 0; i < userCredential.size(); i++) {
            if (userCredential.get(i).equals(new User(login, userPassword, role))) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    private String enterData(String message) {
        System.out.println(message);
        return reader.nextLine();
    }

    public Boolean userLogin(String login, String password, Role role) {

        Boolean flag = false;

        if (checkEnterCredentials(login, password, role)) {
            flag = true;
        }

        System.out.println("You are blocked for a week.");
        return flag;

    }

    public Role userRole(String login) {
        Role role = Role.NOUSER;
        for (int i = 0; i < userCredential.size(); i++) {
            if (userCredential.get(i).getLogin().equals(login)) {
                role = userCredential.get(i).getRole();
                return role;
            }

        }
        return role;
    }

    private Role loginConvertToRole(String login) {

        Role userRole = Role.NOUSER;
        if (login.toUpperCase().equals(Role.USER.toString())) {
            userRole = Role.USER;
        }
        if (login.toUpperCase().equals(Role.ADMIN.toString())) {
            userRole = Role.ADMIN;
        }

        return userRole;

    }

    public void libriaryMenu() {
        //uncoment
//        if (!isLibriaryOpen()) {
//            System.out.println("The libriary is closed");
//            return;
//        }

        Role convertLoginToRole = null;
        int count = 0;
        for (int i = 0; i < attempsToEnterLogAndPass; i++) {


            String login = enterData("Enter your login: ");
            String password = enterData("Enter your password: ");

            convertLoginToRole = loginConvertToRole(login);

            if (userLogin(login, password, convertLoginToRole)) {
                count++;
                break;
            }

        }

        if (count == 0){
            System.out.println("You are blocked on a next 5 hours");
            return;
        }


        if (convertLoginToRole.equals(Role.ADMIN)) {
            while (true) {
                System.out.println(
                        "1.Delete book from libriary\n"
                                + "2. Give book to user\n"
                                + "3. Add book to libriary\n"
                                + "4. See a list of book in libriary\n"
                                + "5. Close program\n"
                );

                try {
                    switch (Integer.parseInt(enterData("Please enter your variant:"))) {//remove duplications
                        case 1:
                            System.out.println("You have choose between these type of genre"
                                    + java.util.Arrays.asList(Genre.values()));
                            String genre = enterData("Please enter genre of book");
                            int idOfBook = Integer.parseInt(enterData
                                    ("Please enter book id, which you want to delete"));
                            deleteBookByAdmin(genre, idOfBook);
                            break;
                        case 2:
                            System.out.println("You have choose between these type of genre"
                                    + java.util.Arrays.asList(Genre.values()));
                            genre = enterData("Please enter genre of book");
                            String nameOfBook = enterData("Please enter name of book, which you want to give to user");
                            giveBookToUser(genre, nameOfBook);
                            break;
                        case 3:
                            System.out.println("You have choose between these type of genre"
                                    + java.util.Arrays.asList(Genre.values()));
                            genre = enterData("Please enter genre of book");
                            String author = enterData("Please enter author of book, which you want to add");
                            nameOfBook = enterData("Please enter name of book, which you want to add");

                            addBook(genre, author, nameOfBook);
                            break;
                        case 4:
                            watchListOfBook();
                            break;
                        case 5:
                            return;
                        default:
                            System.out.println("You enter invalid value");
                    }
                } catch (Throwable e) {
                    System.out.println("You have entered not integer");
                    return;
                }
            }
        } else if (convertLoginToRole.equals(Role.USER)) {
            while (true) {
                System.out.println(
                        "1. Take a book\n"
                                + "2. See a list of book in libriary\n"
                                + "3. Close program\n"
                );
                try {
                    switch (Integer.parseInt(enterData("Please enter your variant:"))) {
                        case 1:
                            System.out.println("You have choose between these type of genre"
                                    + java.util.Arrays.asList(Genre.values()));
                            String genre = enterData("Please enter genre of book");
                            String nameOfBook = enterData("Please enter name of book, which you want to give to user");
                            giveBookToUser(genre, nameOfBook);
                            break;
                        case 2:
                            watchListOfBook();
                            break;
                        case 3:
                            return;
                        default:
                            System.out.println("You enter invalid value");
                            return;
                    }
                } catch (Throwable e) {
                    System.out.println("You have entered not integer");
                    return;
                }
            }
        }
    }


}

