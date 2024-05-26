package id.ac.ui.cs.advprog.product_service.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfig {

    @Value("${grpc.server.host}")
    private String grpcServerHost;

    @Value("${grpc.server.port}")
    private int grpcServerPort;

    @Bean
    public GrpcClient grpcClient() {
        return new GrpcClient(grpcServerHost, grpcServerPort);
    }
}
