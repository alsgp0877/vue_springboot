package com.folder.app.dto;
//import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter
public class ResultDTO{

    private String message;
    private Boolean state;
    private Object result;
}