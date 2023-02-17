package bus_route.service;

import bus_route.BusRoutingApplication;
import org.springframework.stereotype.Service;
@Service
public class RouteService {
    private static final String SEQ1_REGEX = ".*\\s";
    private static final String SEQ2_REGEX = "\\s.*";
    public boolean find_route(final String from, final String to){
        boolean direct = false;
        // Two bus stop points in a route cannot point up to the same value.
        if (from.compareTo(to) == 0) { return direct; }

        String route = "", route_from = "";
        int routes_count = BusRoutingApplication.routes_list.size();

        for (int i = 0; i < routes_count; i++) {
            route = BusRoutingApplication.routes_list.get(i);

            if (route.matches(SEQ1_REGEX + from + SEQ2_REGEX)) {
                //if starting bus stop found search the ending bus stop from where founded starting bus stop
                route_from = route.substring(route.indexOf(from));
                if (route_from.matches(SEQ1_REGEX + to + SEQ2_REGEX)) {
                    direct = true; break;
                }
            }
        }
        return direct;
    }
}
