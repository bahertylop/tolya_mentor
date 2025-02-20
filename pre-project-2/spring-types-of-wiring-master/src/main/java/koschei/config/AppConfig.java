package koschei.config;

import koschei.models.Egg6;
import koschei.models.Island2;
import koschei.models.Needle7;
import koschei.models.Wood3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "koschei")
public class AppConfig {

    @Bean
    public static Island2 getIsland(Wood3 wood) {
        return new Island2(wood);
    }

    @Bean
    public static Egg6 getEgg() {
        Egg6 egg6 = new Egg6();
        egg6.setNeedle(new Needle7());
        return egg6;
    }

    @Bean
    public static Needle7 getNeedle() {
        return new Needle7();
    }
}
