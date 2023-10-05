package com.example.RestClient.service;

import com.example.RestClient.Model.TodoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class TodoService {
    //get single

    private RestClient restClient;

    public TodoService(RestClient restClient) {
        this.restClient = restClient;
    }

    public TodoResponse getTodo(int id){
      //call api
        System.out.println("hiiiiiiiiiiiiiiiiiii"+restClient.get().
                uri("/todos/{id}",id)
                .retrieve()
                .body(TodoResponse.class));
       return restClient.get().
               uri("/todos/{id}",id)
               .retrieve()
               .body(TodoResponse.class);

    }
}
