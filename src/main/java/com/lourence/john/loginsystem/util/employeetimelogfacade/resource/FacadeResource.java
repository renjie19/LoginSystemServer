package com.lourence.john.loginsystem.util.employeetimelogfacade.resource;

import com.lourence.john.loginsystem.timelog.repository.TimeLog;
import com.lourence.john.loginsystem.util.employeetimelogfacade.EmployeeTimeLogFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facade")
public class FacadeResource {
    @Autowired
    private EmployeeTimeLogFacade facade;

    @PostMapping("/save")
    public TimeLog save(@RequestBody Integer id) throws Exception {
        return facade.logIn(id);
    }
}
