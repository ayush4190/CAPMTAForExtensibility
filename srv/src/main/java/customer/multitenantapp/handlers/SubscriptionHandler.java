package customer.multitenantapp.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(SubscriptionHandler.class);

  @Before(event = MtSubscriptionService.EVENT_SUBSCRIBE)
    public void beforeSubscription(MtSubscribeEventContext context) {

      logger.info("reading results {}",context.getResult());
      logger.info("reading other values {}",context.getSubscriptionPayload());
//        context.setInstanceCreationOptions(
//        new InstanceCreationOptions().withProvisioningParameters(
//            Collections.singletonMap("database_id", "9aad6394-1d9f-46d5-9113-ff90702530f9")));
    }

}