public class MovieManager {
    private String[] movies;    // массив для хранения фильмов
    private int limit;          // лимит для findLast()

    // Конструктор по умолчанию (лимит = 5)
    public MovieManager() {
        this.limit = 5;
        this.movies = new String[0];  // пустой массив
    }

    // Конструктор с указанием лимита
    public MovieManager(int limit) {
        this.limit = limit;
        this.movies = new String[0];
    }

    // Добавление фильма
    public void addMovie(String movie) {
        // Создаём новый массив на 1 больше
        String[] newMovies = new String[movies.length + 1];
        // Копируем старые фильмы
        for (int i = 0; i < movies.length; i++) {
            newMovies[i] = movies[i];
        }
        // Добавляем новый фильм в конец
        newMovies[newMovies.length - 1] = movie;
        movies = newMovies;
    }

    // Все фильмы в порядке добавления
    public String[] findAll() {
        return movies;
    }

    // Последние фильмы в обратном порядке
    public String[] findLast() {
        // Вычисляем размер результата
        int resultLength;
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }

        String[] result = new String[resultLength];

        // Заполняем в обратном порядке
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }

        return result;
    }

    // Геттер для лимита (для тестов)
    public int getLimit() {
        return limit;
    }
}