package concurrent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TransactionInection {
    List<Object> list;
    //fix 1. SubInjection
    @Autowired
    TransactionInection transactionInection;

    //fix 2. Injection ApplicationContext
    @Autowired
    ApplicationContext applicationContext;

    @Transactional
    public void allOffer(List<Object> list) {
        for(Object o : list) {
            transactionInection.offer(o);//fix 1
            //fix 2 just: offer(o);
        }

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void offer(Object ob) {
        System.out.println("2222");
    }

    //fix 2
    public void execute() {
        TransactionInection proxy = applicationContext.getBean(TransactionInection.class);
        proxy.allOffer( list);
    }


}
