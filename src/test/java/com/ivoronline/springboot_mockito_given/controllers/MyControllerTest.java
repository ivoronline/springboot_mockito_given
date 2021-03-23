package com.ivoronline.springboot_mockito_given.controllers;

import com.ivoronline.springboot_mockito_given.entities.Person;
import com.ivoronline.springboot_mockito_given.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyControllerTest {

  @Autowired MyController     myController;          //INSTANTIATE CLASS BEING TESTED
  @Mock      PersonRepository personRepositoryMock;  //MOCK DEPENDENCY CLASS

  @Test
  void getPerson() {

    //MOCK METHOD: getPersonById(1)
    given(personRepositoryMock.getPersonById(1)).willReturn(new Person(1, "John", 20));

    //TEST CONTROLLER'S ENDPOINT
    String result = myController.getPerson(1);

    //TEST RESULT
    assertEquals("Hello John", result);

  }

}
