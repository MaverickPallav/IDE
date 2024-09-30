package singleton;

// Singleton Pattern - Theme Manager
public class ThemeManager {
    private static ThemeManager instance;

    private ThemeManager() {}

    public static ThemeManager getInstance() {
        if (instance == null) {
            instance = new ThemeManager();
        }
        return instance;
    }

    public void applyTheme(String theme) {
        System.out.println("Applying theme: " + theme);
    }
}
