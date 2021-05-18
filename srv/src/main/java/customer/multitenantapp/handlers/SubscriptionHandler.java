package customer.multitenantapp.handlers;

import org.springframework.stereotype.Component;

import java.util.Collections;

import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.Before;
import com.sap.cds.services.handler.annotations.ServiceName;
import com.sap.cds.services.mt.MtSubscribeEventContext;
import com.sap.cds.services.mt.MtSubscriptionService;
import com.sap.xsa.core.instancemanager.client.InstanceCreationOptions;

@Component
@ServiceName(MtSubscriptionService.DEFAULT_NAME)
public class SubscriptionHandler implements EventHandler {

  @Before(event = MtSubscriptionService.EVENT_SUBSCRIBE)
    public void beforeSubscription(MtSubscribeEventContext context) {
        context.setInstanceCreationOptions(
        new InstanceCreationOptions().withProvisioningParameters(
            Collections.singletonMap("database_id", "75b8ae6e-949d-4067-9bd8-f6da3529aa1a")));
    }

}