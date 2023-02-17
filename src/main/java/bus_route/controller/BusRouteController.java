package bus_route.controller;

import bus_route.ResponsePojo;
import bus_route.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BusRouteController {
    final
    RouteService routeService;
    public BusRouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/direct")
    public ResponseEntity get_route(@RequestParam(name = "from", defaultValue = "0") final String from,
                                    @RequestParam(name = "to",   defaultValue = "0") final String to){

        int begin = Integer.parseInt(from);
        int end   = Integer.parseInt(to);
        boolean direct = routeService.find_route(String.valueOf(begin),
                String.valueOf(end));
        ResponsePojo resp_body
                = new ResponsePojo(begin, end, direct);

        return new ResponseEntity(resp_body, HttpStatus.OK);
    }
}
