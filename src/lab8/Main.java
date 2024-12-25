package lab8;

import java.util.*;

// Клас "Коментар"
class Comment {
    private String text;
    private int likes;
    private int dislikes;

    // Конструктор
    public Comment(String text, int likes, int dislikes) {
        this.text = text;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    // Геттери
    public String getText() { return text; }
    public int getLikes() { return likes; }
    public int getDislikes() { return dislikes; }
}

// Клас "Відео"
class Video {
    private String name;
    private String url;
    private int views;
    private int likes;
    private int dislikes;
    private Set<Comment> comments; // Заміна списку на множину

    // Конструктор
    public Video(String name, String url, int views, int likes, int dislikes, Set<Comment> comments) {
        this.name = name;
        this.url = url;
        this.views = views;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = comments;
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
    private String bloggerName;
    private Set<Video> videos; // Заміна списку на множину

    // Конструктор
    public VideoBlog(String bloggerName, Set<Video> videos) {
        this.bloggerName = bloggerName;
        this.videos = videos;
    }

    // Метод для отримання множини відео
    public Set<Video> getVideos() { return videos; }
}

// Головний клас
public class Main {
    public static void main(String[] args) {
        // Створення коментарів для першого відео
        Set<Comment> comments1 = new HashSet<>(Set.of(
                new Comment("Очень полезное видео!", 50, 2),
                new Comment("Спасибо за видос. Языки и проблемы у меня были практически те же!", 30, 1),
                new Comment("Все верно среда один из сильнейших методов формирование поведения", 20, 3),
                new Comment("Пойдёт, но много решает сознание и самодисциплина, выдержки и понимания всего вам надо, чудо программисты", 10, 5)
        ));

        // Перше відео
        Video video1 = new Video(
                "Кодинг стал ИЗИ после этого открытия! Вот как я это сделал!",
                "https://www.youtube.com/watch?v=44Y-Mksajo0",
                43080,
                2100,
                60,
                comments1
        );

        // Створення коментарів для другого відео
        Set<Comment> comments2 = new HashSet<>(Set.of(
                new Comment("Метод рабочий для материала, который можно понять за 10 минут. Но для сложнее концепций потребуется больше период активного изучения.", 25, 1),
                new Comment("Отличный контент про обучение!", 15, 0),
                new Comment("Спасибо за то что делитесь этой информацией", 10, 2),
                new Comment("Хороший ролик, пробуйте и у вас всё получиться!", 5, 0)
        ));

        // Друге відео
        Video video2 = new Video(
                "Научный метод, который изменит ваше обучение навсегда",
                "https://www.youtube.com/watch?v=AXK5Zhx3GZM",
                50544,
                4000,
                66,
                comments2
        );

        // Множина відео
        Set<Video> videos = new HashSet<>(Set.of(video1, video2));

        // Створення відеоблогу
        VideoBlog blog = new VideoBlog("TechBlogger", videos);

        // 1. Загальна кількість переглядів
        int totalViews = 0;
        for (Video v : blog.getVideos()) { // Цикл for-each для множини
            totalViews += v.getViews();
        }
        System.out.println("Загальна кількість переглядів: " + totalViews);

        // 2. Чи є коментар, що набрав лайків більше, ніж відповідне відео
        boolean commentMoreLikes = false;
        for (Video v : blog.getVideos()) {
            for (Comment comment : v.getComments()) { // Перебір множини коментарів
                if (comment.getLikes() > v.getLikes()) {
                    commentMoreLikes = true;
                    break;
                }
            }
        }
        System.out.println("Чи є коментар з лайками більше, ніж у відео? " + commentMoreLikes);

        // 3. Відео з найбільшою кількістю дизлайків
        Set<Video> maxDislikesVideos = new HashSet<>();
        int maxDislikes = 0;
        for (Video v : blog.getVideos()) {
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

        // 4. Статистика переглядів відео за назвою (Map)
        Map<String, Integer> videoStats = new TreeMap<>(); // TreeMap для сортування за назвою
        for (Video v : blog.getVideos()) {
            videoStats.put(v.getName(), v.getViews());
        }
        System.out.println("Статистика переглядів відео:");
        for (Map.Entry<String, Integer> entry : videoStats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " переглядів");
        }
    }
}

