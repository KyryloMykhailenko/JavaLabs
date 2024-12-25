package lab7;

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
    public String getText() {
        return text;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }
}

// Клас "Відео"
class Video {
    private String name;
    private String url;
    private int views;
    private int likes;
    private int dislikes;
    private List<Comment> comments;

    // Конструктор
    public Video(String name, String url, int views, int likes, int dislikes, List<Comment> comments) {
        this.name = name;
        this.url = url;
        this.views = views;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = comments;
    }

    // Геттери
    public String getName() {
        return name;
    }

    public int getViews() {
        return views;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public List<Comment> getComments() {
        return comments;
    }
}

// Клас "Відеоблог"
class VideoBlog {
    private String bloggerName;
    private List<Video> videos;

    // Конструктор
    public VideoBlog(String bloggerName, List<Video> videos) {
        this.bloggerName = bloggerName;
        this.videos = videos;
    }

    // Метод для отримання списку відео
    public List<Video> getVideos() {
        return videos;
    }
}

// Головний клас
public class Main {
    public static void main(String[] args) {
        // Створення коментарів для першого відео
        List<Comment> comments1 = Arrays.asList(
                new Comment("Очень полезное видео!", 50, 2),
                new Comment("Спасибо за видос. Языки и проблемы у меня были практически те же!", 30, 1),
                new Comment("Все верно среда один из сильнейших методов формирование поведения", 20, 3),
                new Comment("Пойдёт, но много решает сознание и самодисциплина, выдержки и понимания всего вам надо, чудо программисты", 10, 5)
        );

        // Перше відео
        Video video1 = new Video(
                "Кодинг стал ИЗИ после этого открытия! Вот как я это сделал!",
                "https://www.youtube.com/watch?v=44Y-Mksajo0",
                43080,
                2100, // 2,1 тыс. лайків
                60,
                comments1
        );

        // Створення коментарів для другого відео
        List<Comment> comments2 = Arrays.asList(
                new Comment("Метод рабочий для материала, который можно понять за 10 минут. Но для сложнее концепций потребуется больше период активного изучения.", 25, 1),
                new Comment("Отличный контент про обучение!", 15, 0),
                new Comment("Спасибо за то что делитесь этой информацией", 10, 2),
                new Comment("Хороший ролик, пробуйте и у вас всё получиться!", 5, 0)
        );

        // Друге відео
        Video video2 = new Video(
                "Научный метод, который изменит ваше обучение навсегда",
                "https://www.youtube.com/watch?v=AXK5Zhx3GZM",
                50544,
                4000, // 4 тыс. лайків
                66,
                comments2
        );

        // Список відео
        List<Video> videos = Arrays.asList(video1, video2);
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
        List<Video> maxDislikesVideos = new ArrayList<>();
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
    }
}


