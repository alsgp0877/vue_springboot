package com.folder.app.controller;
import org.springframework.web.bind.annotation.RestController;

import com.folder.app.dto.ResultDTO;
import com.folder.app.dto.UserDTO;
import com.folder.app.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://localhost:8800")
@RestController
public class DataController {

    @Autowired
    UserService uService;


    @GetMapping("/")
    public String home() {
    	return "Data 준비중..";
    }
    @PostMapping("/findAll")
    public ResultDTO findAll(){
        System.out.println(1);
        return uService.findAll();
    }

    @PostMapping("/editById")
    public ResultDTO editById(@RequestBody UserDTO uDto){
        System.out.println(uDto);
        return uService.editById(uDto);
    }

    @DeleteMapping("/delete")
    public ResultDTO delete(@RequestParam("no") int no){
        System.out.println(no);
        return uService.delete(no);
    }

    @PutMapping("/save")
    public ResultDTO save(@RequestBody UserDTO uDto){
        System.out.println(uDto);
        return uService.save(uDto);
    }


}
