package org.example.todomanagement.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {

    private Long id;
    private String title;
    private  String descripton;
    private  boolean comleted;

}




