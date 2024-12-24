package lab8;

import java.util.*;

// Клас "Коментар"
class Comment {
    private String text; // Текст коментаря
    private int likes; // Кількість лайків під коментарем
    private int dislikes; // Кількість дизлайків під коментарем

    // Конструктор
    public Comment(String text, int likes, int dislikes) {
        this.text = text; // Ініціалізація тексту коментаря
        this.likes = likes; // Ініціалізація кількості лайків
        this.dislikes = dislikes; // Ініціалізація кількості дизлайків
    }

    // Геттери
    public String getText() { return text; }
    public int getLikes() { return likes; }
    public int getDislikes() { return dislikes; }
}

// Клас "Відео"
class Video {
    private String name; // Назва відео
    private String url; // URL відео
    private int views; // Кількість переглядів
    private int likes; // Кількість лайків
    private int dislikes; // Кількість дизлайків
    private Set<Comment> comments; // Множина коментарів

    // Конструктор
    public Video(String name, String url, int views, int likes, int dislikes, Set<Comment> comments) {
        this.name = name; // Ініціалізація назви відео
        this.url = url; // Ініціалізація URL
        this.views = views; // Ініціалізація кількості переглядів
        this.likes = likes; // Ініціалізація кількості лайків
        this.dislikes = dislikes; // Ініціалізація кількості дизлайків
        this.comments = comments; // Ініціалізація множини коментарів
    }

    // Геттери
    public String getName() { return name; }
    public int getViews() { return views; }
    public int getLikes() { return likes; }
    public int getDislikes() { return dislikes; }
    public Set<Comment> getComments() { return comments; }
}

// Клас "Відеоблог"
class VideoBlog {
    private String bloggerName; // Ім'я відеоблогера
    private Set<Video> videos; // Множина відео

    // Конструктор
    public VideoBlog(String bloggerName, Set<Video> videos) {
        this.bloggerName = bloggerName; // Ініціалізація імені відеоблогера
        this.videos = videos; // Ініціалізація множини відео
    }

    // Метод для отримання множини відео
    public Set<Video> getVideos() { return videos; }
}

// Головний клас
public class Main {
    public static void main(String[] args) {
        // Створення множини коментарів
        Set<Comment> comments = new HashSet<>(Set.of(
                new Comment("Очень полезное видео!", 50, 2),
                new Comment("Спасибо за видос. Языки и проблемы у меня были практически те же!", 30, 1),
                new Comment("Все верно среда один из сильнейших методов формирование поведения", 20, 3),
                new Comment("Пойдёт, но много решает сознание и самодисциплина, выдержки и понимания всего вам надо, чудо программисты", 10, 5)
        ));

        // Створення відео
        Video video = new Video(
                "Кодинг стал ИЗИ после этого открытия! Вот как я это сделал!",
                "https://www.youtube.com/watch?v=44Y-Mksajo0",
                43080,
                2100, // 2,1 тыс. переведено в 2100
                60,
                comments
        );

        // Створення множини відео
        Set<Video> videos = new HashSet<>(Set.of(video));

        // Створення відеоблогу
        VideoBlog blog = new VideoBlog("TechBlogger", videos);

        // 1. Загальна кількість переглядів (нетипізований ітератор)
        int totalViews = 0;
        Iterator videoIterator = blog.getVideos().iterator();
        while (videoIterator.hasNext()) {
            Video v = (Video) videoIterator.next();
            totalViews += v.getViews();
        }
        System.out.println("Загальна кількість переглядів: " + totalViews);

        // 2. Чи є коментар, що набрав лайків більше, ніж відповідне відео (for-each)
        boolean commentMoreLikes = false;
        for (Video v : blog.getVideos()) {
            for (Comment comment : v.getComments()) {
                if (comment.getLikes() > v.getLikes()) {
                    commentMoreLikes = true;
                    break;
                }
            }
        }
        System.out.println("Чи є коментар з лайками більше, ніж у відео? " + commentMoreLikes);

        // 3. Відео з найбільшою кількістю дизлайків (типізований ітератор)
        Set<Video> maxDislikesVideos = new HashSet<>();
        int maxDislikes = 0;
        Iterator<Video> typedIterator = blog.getVideos().iterator();
        while (typedIterator.hasNext()) {
            Video v = typedIterator.next();
            if (v.getDislikes() > maxDislikes) {
                maxDislikes = v.getDislikes();
                maxDislikesVideos.clear();
                maxDislikesVideos.add(v);
            } else if (v.getDislikes() == maxDislikes) {
                maxDislikesVideos.add(v);
            }
        }
        System.out.println("Відео з найбільшою кількістю дизлайків:");
        for (Video v : maxDislikesVideos) {
            System.out.println(v.getName());
        }

        // Додатковий функціонал: Підрахунок кількості відео для кожного автора
        Map<String, Integer> videoCountByAuthor = new HashMap<>();
        videoCountByAuthor.put("TechBlogger", blog.getVideos().size());
        System.out.println("Кількість відео по авторам:");
        for (Map.Entry<String, Integer> entry : videoCountByAuthor.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

