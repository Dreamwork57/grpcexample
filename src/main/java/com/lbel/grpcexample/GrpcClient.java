package com.lbel.grpcexample;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class GrpcClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        com.lbel.grpcexample.grpc.HelloServiceGrpc.HelloServiceBlockingStub stub = com.lbel.grpcexample.grpc.HelloServiceGrpc.newBlockingStub(channel);

        com.lbel.grpcexample.grpc.HelloResponse helloResponse = stub.hello(com.lbel.grpcexample.grpc.HelloRequest.newBuilder()
                .setFirstName("Lucas")
                .setLastName("Bellissimo")
                .build());

        channel.shutdown();
    }
}
