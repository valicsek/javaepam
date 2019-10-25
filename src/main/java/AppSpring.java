import com.example.sportsbetting.App;
import com.example.sportsbetting.config.AppConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppSpring {
    public static void main(String[] args) {

        // App app = new App(new SportsBettingService(), new View());
        // app.play();

        try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            App app = appContext.getBean(App.class);
            app.play();
        }

    }
}
