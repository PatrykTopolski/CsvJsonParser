package com.patryk;

import com.patryk.controller.AppController;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("file:src/main/META-INF/beans.xml");
        AppController controller = (AppController) factory.getBean(AppController.class);
        controller.readAndPrint();
    }
}
