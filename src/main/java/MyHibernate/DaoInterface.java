package MyHibernate;

public interface DaoInterface {
    void create(User user);
    User readById(int id);
    void update(User user);
    void delete(int id);
}
