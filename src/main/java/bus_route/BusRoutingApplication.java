package bus_route;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BusRoutingApplication {
	private static final String ROUTE_ID_REGEX = "^\\d+";
	public static List<String> routes_list;

	public static void main(String[] args) {
		Scanner routes = null;
		String datastore = "./data/routes.txt";
		File data = new File(datastore);

		try {
			routes = new Scanner(data);
		} catch (java.io.FileNotFoundException e) {
			throw new RuntimeException("FILE NOT FOUND");
		}

		routes_list = new ArrayList();

		while (routes.hasNextLine()) {
			routes_list.add(routes.nextLine()
					.replaceFirst(ROUTE_ID_REGEX, "") + " ");
		}
		routes.close();
		SpringApplication.run(BusRoutingApplication.class, args);
	}

}
