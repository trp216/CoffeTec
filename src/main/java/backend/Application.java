package backend;

import backend.model.Registro;
import backend.model.Sensor;
import backend.services.RegistroService;
import backend.services.SensorService;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(SensorService sensorService, RegistroService registroService) {
		return (args) -> {
//			for (int i = 1; i < 6; i++) {
//				sensorService.saveSensor(new Sensor("10232022_A00"+Integer.toString(i)+"_sensor_ph","Active","Colombia"));
//				sensorService.saveSensor(new Sensor("10232022_A00"+Integer.toString(i)+"_sensor_temperature","Active","Colombia"));
//				sensorService.saveSensor(new Sensor("10232022_A00"+Integer.toString(i)+"_sensor_humidity","Active","Colombia"));
//				sensorService.saveSensor(new Sensor("10232022_A00"+Integer.toString(i)+"_sensor_P","Active","Colombia"));
//				sensorService.saveSensor(new Sensor("10232022_A00"+Integer.toString(i)+"_sensor_K","Active","Colombia"));
//				sensorService.saveSensor(new Sensor("10232022_A00"+Integer.toString(i)+"_sensor_N","Active","Colombia"));
//			}

			System.out.println(sensorService.findAll());
			Sensor sensor1 = sensorService.findByRef_sensor("10232022_A002_sensor_ph");
			Sensor sensor2 = sensorService.findByRef_sensor("10232022_A002_sensor_temperature");
			System.out.println(sensor1.getId_sensor());
			System.out.println(sensorService.findByRef_sensor("10232022_A002_sensor_ph"));

			Iterable<Registro> registros = registroService.findAll();

			for (Registro r: registros) {
				System.out.println(r);
				//registroService.delete(r);
			}

//			registroService.saveRegistro(new Registro(sensor1, Date.from(LocalDateTime.parse("2022-11-23T06:30:00").toInstant(OffsetDateTime.now().getOffset())),"5.7"));
//			registroService.saveRegistro(new Registro(sensor1, Date.from(LocalDateTime.parse("2022-11-23T06:30:10").toInstant(OffsetDateTime.now().getOffset())),"5.9"));

			System.out.println(registroService.findLastBySensorId(sensor1.getId_sensor()));

			//System.out.println(registroService.);

		};
	}

}

