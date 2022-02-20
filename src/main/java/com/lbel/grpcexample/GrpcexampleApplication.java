package com.lbel.grpcexample;

import com.lbel.grpcexample.service.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GrpcexampleApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder
				.forPort(8080)
				.addService(new HelloServiceImpl()).build();

		server.start();
		server.awaitTermination();
	}

}
