package com.teknixor.resource;

import com.teknixor.dto.ApiRespnse;
import com.teknixor.dto.MessageRequest;
import com.teknixor.qualifier.AppNotificationQualifier;
import com.teknixor.qualifier.EmailQualifier;
import com.teknixor.qualifier.GoogleAlertsQualifier;
import com.teknixor.qualifier.PushNotificationQualifier;
import com.teknixor.qualifier.SmsNotificationQualifier;
import com.teknixor.service.NotificationService;

import io.smallrye.common.annotation.RunOnVirtualThread;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/notify")
@Produces("application/json")
@Consumes("application/json")
public class NotificationResource {

    private final NotificationService emailService;
    private final NotificationService appService;
    private final NotificationService googleAlertsService;
    private final NotificationService smsService;
    private final NotificationService pushNotificationService;

    @Inject
    public NotificationResource(
            @EmailQualifier NotificationService emailService,
            @AppNotificationQualifier NotificationService appService,
            @GoogleAlertsQualifier NotificationService googleAlertsService,
            @SmsNotificationQualifier NotificationService smsService,
            @PushNotificationQualifier NotificationService pushNotificationService) {
        this.emailService = emailService;
        this.appService = appService;
        this.googleAlertsService = googleAlertsService;
        this.smsService = smsService;
        this.pushNotificationService = pushNotificationService;
    }

    @POST
    @Path("/email")
    @RunOnVirtualThread
    public Uni<ApiRespnse> sendEmailNotification(MessageRequest request) {
        return emailService.send(request.message())
                .map(response -> new ApiRespnse(Response.Status.OK.getStatusCode(), response));

    }

    @POST
    @Path("/app")
    @RunOnVirtualThread
    public Uni<ApiRespnse> sendAppNotification(MessageRequest request) {
        return appService.send(request.message())
                .map(response -> new ApiRespnse(Response.Status.OK.getStatusCode(), response));
    }

    @POST
    @Path("/google-alert")
    @RunOnVirtualThread
    public Uni<ApiRespnse> sendGoogleAlertNotification(MessageRequest request) {
        return googleAlertsService.send(request.message())
                .map(response -> new ApiRespnse(Response.Status.OK.getStatusCode(), response));
    }

    @POST
    @Path("/sms")
    @RunOnVirtualThread
    public Uni<ApiRespnse> sendSmsNotification(MessageRequest request) {
        return smsService.send(request.message())
                .map(response -> new ApiRespnse(Response.Status.OK.getStatusCode(), response));
    }

    @POST
    @Path("/push")
    @RunOnVirtualThread
    public Uni<ApiRespnse> sendPushNotification(MessageRequest request) {
        return pushNotificationService.send(request.message())
                .map(response -> new ApiRespnse(Response.Status.OK.getStatusCode(), response));
    }

}
