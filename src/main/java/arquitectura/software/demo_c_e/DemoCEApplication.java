package arquitectura.software.demo_c_e;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class DemoCEApplication {

	private Logger logger = Logger.getLogger(DemoCEApplication.class.getName());
	public static void main(String[] args) {

		SpringApplication.run(DemoCEApplication.class, args);

		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(loggerContext);
		loggerContext.reset();
		try {
			configurator.doConfigure("src/main/java/logback.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
