package id.ac.ui.cs.advprog.product_service.service;

import id.ac.ui.cs.advprog.product_service.auth.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final GrpcClient grpcClient;

    @Autowired
    public AuthService(GrpcClient grpcClient) {
        this.grpcClient = grpcClient;
    }

    public boolean verifyAuth(String token) {
        return grpcClient.verifyAuth(token);
    }

    public boolean verifyAccess(String token, String role) {
        return grpcClient.verifyAccess(token, role);
    }
}