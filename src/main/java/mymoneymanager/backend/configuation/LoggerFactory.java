package mymoneymanager.backend.configuation;

import java.util.logging.Logger;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerFactory {
  
  @Bean
  public Logger produceLogger(InjectionPoint injectionPoint) {
      Class<?> classOnWired = injectionPoint.getMember().getDeclaringClass();
      return Logger.getLogger(classOnWired.getName());
  }

}
