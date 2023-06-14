package org.example.functions;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.Optional;


public class HttpTriggerFunction extends FunctionInvoker<String, String> {

    @FunctionName("hello")
    public HttpResponseMessage execute(
            @HttpTrigger(name = "request", methods = {HttpMethod.GET, HttpMethod.POST},
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            ExecutionContext context) {
        context.getLogger().info("hello started : ");
        final String name = request.getQueryParameters().get("name");
        if(name!=null) {
            return request.createResponseBuilder(HttpStatus.OK)
                    .body(handleRequest(name, context))
                    .header("Content-Type", "application/json")
                    .build();
        }
        return request.createResponseBuilder(HttpStatus.BAD_GATEWAY)
                .body(handleRequest("No name", context))
                .header("Content-Type", "application/json")
                .build();
    }
}
