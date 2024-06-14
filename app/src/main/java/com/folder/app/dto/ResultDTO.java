package com.folder.app.dto;
import lombok.Data;


@Data
public class ResultDTO{

    private String message;
    private Boolean state;
    private Object result;
}