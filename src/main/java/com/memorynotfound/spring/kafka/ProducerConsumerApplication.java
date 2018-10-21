package com.memorynotfound.spring.kafka;

import com.memorynotfound.spring.kafka.producer.Sender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerConsumerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProducerConsumerApplication.class, args);
    }

    @Autowired
    private Sender sender;

    @Override
    public void run(String... strings) throws Exception {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	   
        sender.send("Spring Kafka Producer and Consumer Example");
        try {
            while (true) {
                sender.send(LocalDateTime.now().format(formatter));
                Thread.sleep(90 * 1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }       
    }
}
