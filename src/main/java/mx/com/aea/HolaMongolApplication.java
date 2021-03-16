package mx.com.aea;

import lombok.extern.slf4j.Slf4j;
import mx.com.aea.utils.BeeperControl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class HolaMongolApplication {

	public static void main(String[] args) {
		//BeeperControl beeperControl = new BeeperControl();
		//beeperControl.beepForAnHour();
		SpringApplication.run(HolaMongolApplication.class, args);
	}

}
