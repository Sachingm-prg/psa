package com.post.Controller;

import com.post.Entity.Bus;
import com.post.Entity.BusStop;
import com.post.Entity.Stop;
import com.post.exception.ResourceNotFoundException;
import com.post.repository.BusRepository;
import com.post.repository.BusStopRepository;
import com.post.repository.StopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bus")
public class BusStopController {

    private BusStopRepository busStopRepository;
    private BusRepository busRepository;
    private StopRepository stopRepository;

    public BusStopController(BusStopRepository busStopRepository, BusRepository busRepository, StopRepository stopRepository) {
        this.busStopRepository = busStopRepository;
        this.busRepository = busRepository;
        this.stopRepository = stopRepository;
    }


    @PostMapping
    public ResponseEntity<BusStop> allocateBusRoute(@RequestParam Long busId, @RequestParam Long stopId,
                                                    @RequestBody BusStop busStop){
        Bus bus = busRepository.findById(busId).orElseThrow(() ->
                new ResourceNotFoundException("Record Not Found"+ busId));
        Stop stop = stopRepository.findById(stopId).orElseThrow(() ->
                new ResourceNotFoundException("Record Not Found"+ stopId));

        busStop.setBus(bus);
        busStop.setStop(stop);
        BusStop saved =busStopRepository.save(busStop);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

}
