package Archery_trainer.server;

import Archery_trainer.server.databaseOperations.SensorDatabaseOperations;
import Archery_trainer.server.databaseOperations.SensorReadingsDatabaseOperations;
import Archery_trainer.server.databaseOperations.ShotDatabaseOperations;
import Archery_trainer.server.models.MeasuredDataSet;
import Archery_trainer.server.models.Shot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = {"Archery_trainer.server"})
public class Main {

	public static DatabaseCredentials databaseCredentials;

	@RequestMapping( "/test" )
	String test() {
		System.out.println("test() called");
		return "This is a test";
	}

	public static void main( String[] args ) throws Exception {

		if(args.length == 3) {
			databaseCredentials = new DatabaseCredentials(args[0], args[1], args[2]);
		} else {
			System.out.println("Arguments: <database name> <database username> <database password>");
			return;
		}


		System.out.println("Starting server...");

		SpringApplication.run( Main.class, args );


		List<MeasuredDataSet> data = SensorDatabaseOperations.getMeasuredDataSetsOfShot(7);
		System.out.println("Got " + data.size() + " MeasuredDataSets");
		for(MeasuredDataSet set : data) {
			System.out.println(set.toString());
		}


		/*
		ShotDatabaseOperations.insertScoreToShot(50, 10);
		ShotDatabaseOperations.insertScoreToShot(51, 9);
		ShotDatabaseOperations.insertScoreToShot(52, 8);
		ShotDatabaseOperations.insertScoreToShot(53, 7);

		List<Shot> shots = ShotDatabaseOperations.getShotsOfArcher(14);
		for(Shot s : shots) {
			System.out.println(s.toString());
		}
*/
	}
}
