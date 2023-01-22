package com.example.task3_1_5try2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.Cookie;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    private final String serverUrl;

    public UserService(RestTemplate restTemplate, @Value("http://94.198.50.185:7081/api/users") String serverUrl) {
        this.restTemplate = restTemplate;
        this.serverUrl = serverUrl;
    }

    public List<User> getAllUsersList() {
//        HttpHeaders headers = restTemplate.exchange(serverUrl, HttpMethod.GET, null, new ParameterizedTypeReference<ResponseEntity>() {
//        }).getHeaders();
//        List<String> headerCookie = headers.get("Set-cookie");

//        ResponseEntity responseEntity = restTemplate.exchange(serverUrl, HttpMethod.GET, null, new ParameterizedTypeReference<ResponseEntity>() {
//        }).g

    //      1) Получить список всех пользователей
        List<User> userList = restTemplate.exchange(serverUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        }).getBody();



    //      2)Когда вы получите ответ на свой первый запрос, вы должны сохранить свой session id, который получен через cookie.
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(serverUrl, Object[].class);
        List<String> cookieString = responseEntity.getHeaders().get("Set-Cookie");
        cookieString.get(0).substring(0, cookieString.get(0).indexOf(';'));

            for (String string : cookieString) {
                System.out.println(string);
            }




    //      3)Сохранить пользователя с id = 3, name = James, lastName = Brown, age = на ваш выбор.
        User user = new User(3L, "James", "Brown", (byte)30);
        HttpEntity<User> request = new HttpEntity<>(user);

        ResponseEntity<String> responseEntity2 = restTemplate.exchange(serverUrl, HttpMethod.POST, request, String.class);
        System.out.println(responseEntity2);


//        HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
//        ResponseEntity<Foo> response = restTemplate
//                .exchange(fooResourceUrl, HttpMethod.POST, request, Foo.class);
//
//        Assertions.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
//
//        Foo foo = response.getBody();




//        HttpEntity<User> request2 = new HttpEntity<>(user);
//        User user1 = restTemplate.postForObject(serverUrl, request2, User.class);

        //подсказки
//        responseEntity.get(("Set-Cookie");
//        restTemplate.get
//        HttpHeaders.set

//        List<String> strings = responseEntity.getHeaders().get("Set-Cookie");
//        SESSION_ID = strings.get(0).substring(0, strings.get(0).indexOf(';'));


//        List<User> userLst = responseEntity.getBody();






        return userList;
    }
}
