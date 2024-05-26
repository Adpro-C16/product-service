package id.ac.ui.cs.advprog.product_service.auth;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import services.AuthServiceGrpc;
import services.Services;

public class GrpcClient {

    private final AuthServiceGrpc.AuthServiceBlockingStub authServiceStub;

    public GrpcClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        authServiceStub = AuthServiceGrpc.newBlockingStub(channel);
    }

    public boolean verifyAuth(String token) {
        Services.VerifyRequest request = Services.VerifyRequest.newBuilder().setToken(token).build();
        Services.VerifyResponse response = authServiceStub.verifyAuth(request);
        return response.getIsValid();
    }

    public boolean verifyAccess(String token, String role) {
        Services.RBACRequest request = Services.RBACRequest.newBuilder().setToken(token).setRole(role).build();
        Services.RBACResponse response = authServiceStub.verifyAccess(request);
        return response.getIsValid();
    }
}
