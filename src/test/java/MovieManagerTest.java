import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    // ---------- ТЕСТЫ КОНСТРУКТОРОВ ----------
    @Test
    public void shouldCreateWithDefaultLimit() {
        MovieManager manager = new MovieManager();
        Assertions.assertEquals(5, manager.getLimit());
        Assertions.assertArrayEquals(new String[0], manager.findAll());
    }

    @Test
    public void shouldCreateWithCustomLimit() {
        MovieManager manager = new MovieManager(7);
        Assertions.assertEquals(7, manager.getLimit());
        Assertions.assertArrayEquals(new String[0], manager.findAll());
    }

    // ---------- ТЕСТЫ ДОБАВЛЕНИЯ ----------
    @Test
    public void shouldAddMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бэтмен");

        String[] expected = {"Бэтмен"};
        Assertions.assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldAddMultipleMovies() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бэтмен");
        manager.addMovie("Супермен");
        manager.addMovie("Человек-паук");

        String[] expected = {"Бэтмен", "Супермен", "Человек-паук"};
        Assertions.assertArrayEquals(expected, manager.findAll());
    }

    // ---------- ТЕСТЫ findAll ----------
    @Test
    public void shouldFindAllWhenEmpty() {
        MovieManager manager = new MovieManager();
        Assertions.assertArrayEquals(new String[0], manager.findAll());
    }

    @Test
    public void shouldFindAllWhenHasMovies() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");

        String[] expected = {"Фильм 1", "Фильм 2", "Фильм 3"};
        Assertions.assertArrayEquals(expected, manager.findAll());
    }

    // ---------- ТЕСТЫ findLast (лимит по умолчанию 5) ----------
    @Test
    public void shouldFindLastWhenLessThanLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");

        String[] expected = {"Фильм 3", "Фильм 2", "Фильм 1"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastWhenExactlyLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");
        manager.addMovie("Фильм 4");
        manager.addMovie("Фильм 5");

        String[] expected = {"Фильм 5", "Фильм 4", "Фильм 3", "Фильм 2", "Фильм 1"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastWhenMoreThanLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");
        manager.addMovie("Фильм 4");
        manager.addMovie("Фильм 5");
        manager.addMovie("Фильм 6");
        manager.addMovie("Фильм 7");

        String[] expected = {"Фильм 7", "Фильм 6", "Фильм 5", "Фильм 4", "Фильм 3"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }

    // ---------- ТЕСТЫ findLast с кастомным лимитом ----------
    @Test
    public void shouldFindLastWithCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");
        manager.addMovie("Фильм 4");
        manager.addMovie("Фильм 5");

        String[] expected = {"Фильм 5", "Фильм 4", "Фильм 3"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastWithCustomLimitWhenLessThanLimit() {
        MovieManager manager = new MovieManager(7);
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");

        String[] expected = {"Фильм 3", "Фильм 2", "Фильм 1"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastWithCustomLimitWhenMoreThanLimit() {
        MovieManager manager = new MovieManager(10);
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");
        manager.addMovie("Фильм 4");
        manager.addMovie("Фильм 5");
        manager.addMovie("Фильм 6");
        manager.addMovie("Фильм 7");
        manager.addMovie("Фильм 8");
        manager.addMovie("Фильм 9");
        manager.addMovie("Фильм 10");
        manager.addMovie("Фильм 11");
        manager.addMovie("Фильм 12");

        String[] expected = {"Фильм 12", "Фильм 11", "Фильм 10", "Фильм 9", "Фильм 8", "Фильм 7", "Фильм 6", "Фильм 5", "Фильм 4", "Фильм 3"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }
}