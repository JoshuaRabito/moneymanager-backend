package mymoneymanager.backend.configuation;

import java.util.logging.Logger;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainProducer {
  
  @Bean
  @Scope("prototype")
  public Logger produceLogger(InjectionPoint injectionPoint) {
      Class<?> classOnWired = injectionPoint.getMember().getDeclaringClass();
      return Logger.getLogger(classOnWired.getName());
  }

}
