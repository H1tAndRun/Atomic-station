import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.academy.config.AppConfig;
import ru.academy.entity.NuclearStation;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        NuclearStation nuclearStation = context.getBean(NuclearStation.class);
        nuclearStation.start(3);


    }
}
